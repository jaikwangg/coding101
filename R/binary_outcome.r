if (!require("dplyr")) install.packages("dplyr")
if (!require("caret")) install.packages("caret")
if (!require("xgboost")) install.packages("xgboost")
if (!require("randomForest")) install.packages("randomForest")
if (!require("rpart")) install.packages("rpart")
if (!require("ggplot2")) install.packages("ggplot2")
if (!require("tidyr")) install.packages("tidyr")
if (!require("gridExtra")) install.packages("gridExtra")
if (!require("glmnet")) install.packages("glmnet")
if (!require("ranger")) install.packages("ranger")
if (!require("tidyverse")) install.packages("tidyverse")
if (!require("corrplot")) install.packages("corrplot")
if (!require("gridExtra")) install.packages("gridExtra")
if (!require("xgboost")) install.packages("xgboost")

library(dplyr)
library(caret)
library(xgboost)
library(randomForest)
library(rpart)
library(ggplot2)
library(tidyr)
library(gridExtra)
library(glmnet)
library(ranger)
library(tidyverse)
library(corrplot)
library(gridExtra)
library(xgboost)

data <- read.csv(file.choose())
cat("\nDataset Overview:\n")
cat("Total number of records:", nrow(data), "\n")
cat("Number of features:", ncol(data), "\n\n")

# Class Distribution
cat("Delivery Status Distribution:\n")
table(data$Reached.on.Time_Y.N) %>% print()
prop.table(table(data$Reached.on.Time_Y.N)) %>%
    round(4) %>%
    print()

# Categorical Variables Summary
cat("\nCategorical Variables Summary:\n")
cat("\nWarehouse Block Distribution:\n")
table(data$Warehouse_block) %>% print()
cat("\nShipment Mode Distribution:\n")
table(data$Mode_of_Shipment) %>% print()
cat("\nProduct Importance Distribution:\n")
table(data$Product_importance) %>% print()
cat("\nGender Distribution:\n")
table(data$Gender) %>% print()

# Numerical Variables Summary
cat("\nNumerical Variables Summary:\n")
summary(data %>% select_if(is.numeric)) %>% print()

# Basic Statistics by Delivery Status
cat("\nSummary Statistics by Delivery Status:\n")
data %>%
    group_by(Reached.on.Time_Y.N) %>%
    summarise(
        n = n(),
        avg_weight = mean(Weight_in_gms),
        sd_weight = sd(Weight_in_gms),
        avg_cost = mean(Cost_of_the_Product),
        sd_cost = sd(Cost_of_the_Product),
        avg_discount = mean(Discount_offered),
        sd_discount = sd(Discount_offered),
        avg_calls = mean(Customer_care_calls),
        sd_calls = sd(Customer_care_calls),
        avg_rating = mean(Customer_rating),
        sd_rating = sd(Customer_rating),
        avg_prior = mean(Prior_purchases),
        sd_prior = sd(Prior_purchases)
    ) %>%
    print()
numeric_data <- data %>% select_if(is.numeric)
correlation_matrix <- cor(numeric_data)
corrplot(
    correlation_matrix,
    method = "color",
    type = "lower",
    tl.col = "black",
    tl.srt = 45,
    addCoef.col = "black"
)
p1 <- ggplot(data, aes(x = factor(Customer_care_calls), fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Customer Care Calls Distribution",
        x = "Number of Calls",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
p2 <- ggplot(data, aes(x = factor(Customer_rating), fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Customer Rating Distribution",
        x = "Rating",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
p3 <- ggplot(data, aes(x = factor(Prior_purchases), fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Prior Purchases Distribution",
        x = "Number of Prior Purchases",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
p4 <- ggplot(data, aes(x = factor(Reached.on.Time_Y.N), y = Discount_offered)) +
    geom_violin() +
    labs(
        title = "Discount Offered Distribution",
        x = "Reached on Time",
        y = "Discount Offered"
    ) +
    theme_minimal()
grid.arrange(p1, p2, p3, p4, ncol = 2)
p5 <- ggplot(data, aes(x = factor(Reached.on.Time_Y.N), y = Weight_in_gms)) +
    geom_violin() +
    labs(
        title = "Weight Distribution",
        x = "Reached on Time",
        y = "Weight in gms"
    ) +
    theme_minimal()
p6 <- ggplot(data, aes(x = Product_importance, fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Product Importance Distribution",
        x = "Product Importance",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
p7 <- ggplot(data, aes(x = factor(Reached.on.Time_Y.N), y = Cost_of_the_Product)) +
    geom_violin() +
    labs(
        title = "Cost of the Product Distribution",
        x = "Reached on Time",
        y = "Cost"
    ) +
    theme_minimal()
grid.arrange(p5, p6, p7, ncol = 3)
p8 <- ggplot(data, aes(x = Gender, fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Gender vs Reached on Time",
        x = "Gender",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
print(p8)
p9 <- ggplot(data, aes(x = Warehouse_block, fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Warehouse Block Distribution",
        x = "Warehouse Block",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
p10 <- ggplot(data, aes(x = Mode_of_Shipment, fill = factor(Reached.on.Time_Y.N))) +
    geom_bar(position = "dodge") +
    labs(
        title = "Mode of Shipment Distribution",
        x = "Mode of Shipment",
        y = "Count"
    ) +
    scale_fill_discrete(name = "Reached on Time", labels = c("0", "1")) +
    theme_minimal()
grid.arrange(p9, p10, ncol = 2)
summary_stats <- data %>%
    group_by(Reached.on.Time_Y.N) %>%
    summarise(
        avg_weight = mean(Weight_in_gms),
        avg_cost = mean(Cost_of_the_Product),
        avg_discount = mean(Discount_offered),
        avg_calls = mean(Customer_care_calls),
        avg_rating = mean(Customer_rating),
        avg_prior_purchases = mean(Prior_purchases)
    )
print(summary_stats)

if ("ID" %in% names(data)) {
    data <- data %>% select(-ID)
}
categorical_vars <- c(
    "Warehouse_block",
    "Mode_of_Shipment",
    "Product_importance",
    "Gender",
    "Reached.on.Time_Y.N"
)
data[categorical_vars] <- lapply(data[categorical_vars], as.factor)
write.csv(data, "data_full.csv", row.names = FALSE)
set.seed(123)
trainIndex <- createDataPartition(y = data$Reached.on.Time_Y.N, p = 0.8, list = FALSE)
train_data <- data[trainIndex, ]
test_data <- data[-trainIndex, ]
write.csv(train_data, "train_data.csv", row.names = FALSE)
write.csv(test_data, "test_data.csv", row.names = FALSE)
print_dataset_info <- function(dataset, name) {
    cat("\n", name, ":\n")
    cat("Number of rows:", nrow(dataset), "\n")
    cat("Class distribution:\n")
    print(table(dataset$Reached.on.Time_Y.N))
    cat("Percentage distribution:\n")
    print(round(prop.table(table(dataset$Reached.on.Time_Y.N)) * 100, 2))
    cat("\nSummary of continuous variables:\n")
    print(summary(dataset %>% select_if(is.numeric)))
    cat("\n")
}
cat("\nDATASET INFORMATION:\n====================")
print_dataset_info(data, "Full Preprocessed Dataset")
print_dataset_info(train_data, "Training Set (80%)")
print_dataset_info(test_data, "Test Set (20%)")
if (!dir.exists("rf_original")) {
    dir.create("rf_original")
}

# Analyze Data with the Whole Dataset (Logistic Regression)
logistic_data <- data %>% select(
    Reached.on.Time_Y.N,
    Cost_of_the_Product,
    Discount_offered,
    Customer_rating,
    Weight_in_gms,
    Prior_purchases
)

# Convert target variable to factor
logistic_data$Reached.on.Time_Y.N <- as.factor(
    logistic_data$Reached.on.Time_Y.N
)

# Fit Logistic Regression Model
logistic_model <- glm(Reached.on.Time_Y.N ~ .,
    data = logistic_data,
    family = binomial
)

# Display significant predictors
print(summary(logistic_model))

data$Reached.on.Time_Y.N <- factor(
  data$Reached.on.Time_Y.N,
  levels = c("0", "1"),       # Original levels (e.g., 0 and 1)
  labels = c("No", "Yes")     # Valid levels (e.g., No and Yes)
)


# Ensure consistent levels in train and test datasets
train_data$Reached.on.Time_Y.N <- factor(
  train_data$Reached.on.Time_Y.N,
  levels = levels(data$Reached.on.Time_Y.N)
)

test_data$Reached.on.Time_Y.N <- factor(
  test_data$Reached.on.Time_Y.N,
  levels = levels(data$Reached.on.Time_Y.N)
)

# Split data into training (80%) and test (20%) sets
set.seed(123)
trainIndex <- createDataPartition(data$Reached.on.Time_Y.N, p = 0.8, list = FALSE)
train_data <- data[trainIndex, ]
test_data <- data[-trainIndex, ]

# Handle imbalanced data by oversampling
balanced_train <- upSample(
    x = train_data[, -which(names(train_data) == "Reached.on.Time_Y.N")],
    y = train_data$Reached.on.Time_Y.N
)

print("Logistic Regression")
# Train default Logistic Regression
logistic_default <- train(
    Reached.on.Time_Y.N ~ .,
    data = train_data,
    method = "glm",
    family = "binomial",
    trControl = trainControl(method = "none")
)

# Train tuned Logistic Regression
logistic_tuned <- train(
    Reached.on.Time_Y.N ~ .,
    data = train_data,
    method = "glm",
    family = "binomial",
    trControl = trainControl(method = "cv", number = 5, summaryFunction = twoClassSummary, classProbs = TRUE),
    metric = "ROC"
)

print("Random Forest")
# Train default Random Forest
rf_default <- train(
    Reached.on.Time_Y.N ~ .,
    data = train_data,
    method = "rf",
    trControl = trainControl(method = "none")
)

# Train tuned Random Forest
rf_tuned <- train(
    Reached.on.Time_Y.N ~ .,
    data = train_data,
    method = "rf",
    tuneGrid = expand.grid(.mtry = c(2, 4, 6)),
    trControl = trainControl(method = "cv", number = 5, summaryFunction = twoClassSummary, classProbs = TRUE),
    metric = "ROC"
)

print("XGBoost")
# Train default XGBoost
xgb_default <- train(
    Reached.on.Time_Y.N ~ .,
    data = train_data,
    method = "xgbTree",
    trControl = trainControl(method = "none"),
    tuneGrid = expand.grid(
        nrounds = 100, # Specify exactly one value for each parameter
        max_depth = 6,
        eta = 0.1,
        gamma = 0,
        colsample_bytree = 0.8,
        min_child_weight = 1,
        subsample = 0.8
    )
)

# Train tuned XGBoost
xgb_tuned <- train(
    Reached.on.Time_Y.N ~ .,
    data = train_data,
    method = "xgbTree",
    trControl = trainControl(method = "cv", number = 5, summaryFunction = twoClassSummary, classProbs = TRUE),
    tuneGrid = expand.grid(
        nrounds = 100,
        max_depth = c(3, 6, 9),
        eta = c(0.1, 0.3),
        gamma = 0,
        colsample_bytree = c(0.6, 0.8),
        min_child_weight = 1,
        subsample = 0.8
    )
)
# Predictions and evaluation for Logistic Regression
logistic_predictions <- predict(logistic_tuned, test_data)
logistic_metrics <- confusionMatrix(logistic_predictions, test_data$Reached.on.Time_Y.N, positive = "Yes")

# Predictions and evaluation for Random Forest
rf_predictions <- predict(rf_tuned, test_data)
rf_metrics <- confusionMatrix(rf_predictions, test_data$Reached.on.Time_Y.N, positive = "Yes")

# Predictions and evaluation for XGBoost
xgb_predictions <- predict(xgb_tuned, test_data, type = "prob")
xgb_class <- ifelse(xgb_predictions[, "Yes"] > 0.5, "Yes", "No")
xgb_class <- factor(xgb_class, levels = c("No", "Yes"))
xgb_metrics <- confusionMatrix(xgb_class, test_data$Reached.on.Time_Y.N, positive = "Yes")

# Combine metrics into a dataframe
metrics_df <- data.frame(
    Model = c("Logistic Regression", "Random Forest", "XGBoost"),
    Precision = c(logistic_metrics$byClass["Pos Pred Value"], rf_metrics$byClass["Pos Pred Value"], xgb_metrics$byClass["Pos Pred Value"]),
    Recall = c(logistic_metrics$byClass["Sensitivity"], rf_metrics$byClass["Sensitivity"], xgb_metrics$byClass["Sensitivity"]),
    F1_Score = c(
        2 * (logistic_metrics$byClass["Pos Pred Value"] * logistic_metrics$byClass["Sensitivity"]) /
            (logistic_metrics$byClass["Pos Pred Value"] + logistic_metrics$byClass["Sensitivity"]),
        2 * (rf_metrics$byClass["Pos Pred Value"] * rf_metrics$byClass["Sensitivity"]) /
            (rf_metrics$byClass["Pos Pred Value"] + rf_metrics$byClass["Sensitivity"]),
        2 * (xgb_metrics$byClass["Pos Pred Value"] * xgb_metrics$byClass["Sensitivity"]) /
            (xgb_metrics$byClass["Pos Pred Value"] + xgb_metrics$byClass["Sensitivity"])
    ),
    Balanced_Accuracy = c(logistic_metrics$byClass["Balanced Accuracy"], rf_metrics$byClass["Balanced Accuracy"], xgb_metrics$byClass["Balanced Accuracy"])
)

# Visualize the metrics
metrics_long <- metrics_df %>%
    pivot_longer(cols = c(Precision, Recall, F1_Score, Balanced_Accuracy), names_to = "Metric", values_to = "Value")

ggplot(metrics_long, aes(x = Model, y = Value, fill = Metric)) +
    geom_bar(stat = "identity", position = "dodge") +
    labs(title = "Model Performance Metrics Comparison", x = "Model", y = "Value") +
    theme_minimal()

