library(tidyverse) 
library(corrplot) 
library(gridExtra) 
data <- read.csv(file.choose()) 
cat("\nDataset Overview:\n") 
cat("Total number of records:", nrow(data), "\n") 
cat("Number of features:", ncol(data), "\n\n") 
# Class Distribution 
cat("Delivery Status Distribution:\n") 
table(data$Reached.on.Time_Y.N) %>% print() 
prop.table(table(data$Reached.on.Time_Y.N)) %>% round(4) %>% print() 
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

if (!require("dplyr")) install.packages("dplyr") 
if (!require("caret")) install.packages("caret") 
library(dplyr)
library(caret) 
data <- read.csv(file.choose()) 
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

# Listing 1: Libraries and Utility Functions 
# Load required libraries 
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
# Function to calculate performance metrics 
calculate_metrics <- function(predicted_classes, actual_classes) { 
    confusion <- confusionMatrix(predicted_classes, actual_classes, positive = "1") 
accuracy <- confusion$overall["Accuracy"] 
precision <- confusion$byClass["Pos Pred Value"] 
recall <- confusion$byClass["Sensitivity"] 
f1_score <- 2 * ((precision * recall) / (precision + recall)) 
rmse <- RMSE(as.numeric(predicted_classes), as.numeric(actual_classes)) 
r_squared <- cor(as.numeric(predicted_classes), as.numeric(actual_classes))^2 
return(c(accuracy, precision, recall, f1_score, rmse, r_squared)) 
} 
# Logistic Regression 
run_logistic <- function(train_data, test_data) { 
if (identical(train_data, test_data)) { 
# For Whole Dataset Analysis 
param_grid <- expand.grid( 
alpha = seq(0, 1, 0.2), 
lambda = seq(0.0001, 0.00001, length.out = 5) 
) 
best_metrics <- c(accuracy = 0, precision = 0, recall = 0, f1 = 0, rmse = Inf, r2 = 0) 
for (i in 1:nrow(param_grid)) { 
model <- glmnet( 
x = as.matrix(train_data %>% select(-Reached.on.Time_Y.N)), 
y = train_data$Reached.on.Time_Y.N, 
alpha = param_grid$alpha[i], 
lambda = param_grid$lambda[i], 
family = "binomial" 
)
pred_probs <- predict( 
model, 
newx = as.matrix(train_data %>% select(-Reached.on.Time_Y.N)), 
type = "response" 
) 
pred_classes <- factor(ifelse(pred_probs > 0.5, 1, 0)) 
metrics <- calculate_metrics(pred_classes, train_data$Reached.on.Time_Y.N) 
if (metrics[1] > best_metrics[1]) { 
best_metrics <- metrics 
} 
} 
return(best_metrics) 
} else { 
control <- trainControl(method = "cv", number = 5) 
model <- train( 
Reached.on.Time_Y.N ~ ., 
data = train_data, 
method = "glmnet", 
trControl = control 
) 
test_pred <- predict(model, test_data) 
return(calculate_metrics(test_pred, test_data$Reached.on.Time_Y.N)) 
} 
} 
# Random Forest 
run_rf <- function(train_data, test_data) { 
    if (identical(train_data, test_data)) { 
param_grid <- expand.grid( 
mtry = seq(2, 6, by = 1), 
min.node.size = c(1, 3, 5, 7) 
) 
best_metrics <- c(accuracy = 0, precision = 0, recall = 0, f1 = 0, rmse = Inf, r2 = 0) 
for (i in 1:nrow(param_grid)) { 
model <- ranger( 
formula = Reached.on.Time_Y.N ~ ., 
data = train_data, 
mtry = param_grid$mtry[i], 
min.node.size = param_grid$min.node.size[i], 
probability = TRUE 
) 
pred_probs <- predict(model, data = train_data)$predictions 
pred_classes <- factor(ifelse(pred_probs[, 2] > 0.5, 1, 0)) 
metrics <- calculate_metrics(pred_classes, train_data$Reached.on.Time_Y.N) 
if (metrics[1] > best_metrics[1]) { 
best_metrics <- metrics 
} 
} 
return(best_metrics) 
} else { 
control <- trainControl(method = "cv", number = 5) 
model <- train( 
Reached.on.Time_Y.N ~ ., 
data = train_data,
method = "ranger", 
trControl = control 
) 
test_pred <- predict(model, test_data) 
return(calculate_metrics(test_pred, test_data$Reached.on.Time_Y.N)) 
} 
} 
# Listing 2: Model Execution and Results Visualization 
# XGBoost 
run_xgb <- function(train_data, test_data) { 
dummies <- dummyVars("~ .", data = train_data %>% select(-Reached.on.Time_Y.N)) 
train_matrix <- predict(dummies, train_data %>% select(-Reached.on.Time_Y.N)) 
if (identical(train_data, test_data)) { 
param_grid <- expand.grid( 
max_depth = c(3, 5, 7), 
eta = c(0.01, 0.1, 0.3), 
nrounds = c(50, 100), 
gamma = c(0, 0.1), 
subsample = c(0.7, 0.8, 0.9) 
) 
best_metrics <- c(accuracy = 0, precision = 0, recall = 0, f1 = 0, rmse = Inf, r2 = 0) 
dtrain <- xgb.DMatrix( 
data = train_matrix, 
label = as.numeric(train_data$Reached.on.Time_Y.N) - 1 
)
for (i in 1:nrow(param_grid)) { 
params <- list( 
objective = "binary:logistic", 
max_depth = param_grid$max_depth[i], 
eta = param_grid$eta[i], 
gamma = param_grid$gamma[i], 
subsample = param_grid$subsample[i] 
) 
model <- xgb.train( 
params = params, 
data = dtrain, 
nrounds = param_grid$nrounds[i] 
) 
pred_probs <- predict(model, train_matrix) 
pred_classes <- factor(ifelse(pred_probs > 0.5, 1, 0)) 
metrics <- calculate_metrics(pred_classes, train_data$Reached.on.Time_Y.N) 
if (metrics[1] > best_metrics[1]) { 
best_metrics <- metrics 
} 
} 
return(best_metrics) 
} else { 
test_matrix <- predict(dummies, test_data %>% select(-Reached.on.Time_Y.N)) 
control <- trainControl(method = "cv", number = 5) 
model <- train( 
x = train_matrix, 
y = train_data$Reached.on.Time_Y.N,
method = "xgbTree", 
trControl = control 
) 
test_pred <- predict(model, newdata = test_matrix) 
return(calculate_metrics(test_pred, test_data$Reached.on.Time_Y.N)) 
} 
} 
# Decision Tree 
run_tree <- function(train_data, test_data) { 
if (identical(train_data, test_data)) { 
param_grid <- expand.grid( 
maxdepth = c(20, 30), 
cp = c(0.00001, 0.0001, 0.001), 
minsplit = c(2, 5, 10), 
minbucket = c(1, 3, 5) 
) 
best_metrics <- c(accuracy = 0, precision = 0, recall = 0, f1 = 0, rmse = Inf, r2 = 0) 
for (i in 1:nrow(param_grid)) { 
model <- rpart( 
formula = Reached.on.Time_Y.N ~ ., 
data = train_data, 
method = "class", 
control = rpart.control( 
maxdepth = param_grid$maxdepth[i], 
cp = param_grid$cp[i], 
minsplit = param_grid$minsplit[i], 
minbucket = param_grid$minbucket[i] 
) 
) 
pred_classes <- predict(model, train_data, type = "class") 
metrics <- calculate_metrics(pred_classes, train_data$Reached.on.Time_Y.N) 
if (metrics[1] > best_metrics[1]) { 
best_metrics <- metrics 
} 
} 
return(best_metrics) 
} else { 
control <- trainControl(method = "cv", number = 5) 
model <- train( 
Reached.on.Time_Y.N ~ ., 
data = train_data, 
method = "rpart2", 
trControl = control 
) 
test_pred <- predict(model, test_data) 
return(calculate_metrics(test_pred, test_data$Reached.on.Time_Y.N)) 
} 
} 
# Run whole dataset analysis 
cat("\nRunning Whole Dataset Analysis...\n") 
logistic_whole <- run_logistic(data, data) 
rf_whole <- run_rf(data, data)
xgb_whole <- run_xgb(data, data) 
tree_whole <- run_tree(data, data) 
# Run train-test analysis 
cat("\nRunning Train-Test Analysis...\n") 
logistic_test <- run_logistic(train_data, test_data) 
rf_test <- run_rf(train_data, test_data) 
xgb_test <- run_xgb(train_data, test_data) 
tree_test <- run_tree(train_data, test_data) 
# Display results function 
display_results <- function(results_whole, results_test, model_name) { 
cat("\nResults for", model_name, ":\n") 
cat("Metric           
   |
 Whole Dataset   | Test Set\n") 
cat("-----------------------------------------------\n") 
cat("Accuracy:           ", results_whole[1], "   |", results_test[1], "\n") 
cat("Precision:          ", results_whole[2], "   |", results_test[2], "\n") 
cat("Recall:        
     ", results_whole[3], "   |", results_test[3], "\n") 
cat("F1-Score:           ", results_whole[4], "   |", results_test[4], "\n") 
cat("RMSE:              
 ", results_whole[5], "   |", results_test[5], "\n") 
cat("R-squared:          ", results_whole[6], "   |", results_test[6], "\n") 
} 
# Display all results 
cat("\n=== Model Performance Comparison ===\n") 
display_results(logistic_whole, logistic_test, "Logistic Regression") 
display_results(rf_whole, rf_test, "Random Forest") 
display_results(xgb_whole, xgb_test, "XGBoost") 
display_results(tree_whole, tree_test, "Decision Tree") 
# Create visualization dataframes 
metrics_df <- data.frame( 
Model = rep(c("Logistic Regression", "Random Forest", "XGBoost", "Decision Tree"), each = 2), 
Dataset = rep(c("Whole Dataset", "Test Set"), 4), 
RMSE = c( 
logistic_whole[5], logistic_test[5], 
rf_whole[5], rf_test[5], 
xgb_whole[5], xgb_test[5], 
tree_whole[5], tree_test[5] 
), 
R_squared = c( 
logistic_whole[6], logistic_test[6], 
rf_whole[6], rf_test[6], 
xgb_whole[6], xgb_test[6], 
tree_whole[6], tree_test[6] 
) 
) 
# Create plots 
p1 <- ggplot(metrics_df, aes(x = Model, y = RMSE, fill = Dataset)) + 
geom_bar(stat = "identity", position = "dodge") + 
theme_minimal() + 
theme(axis.text.x = element_text(angle = 45, hjust = 1)) + 
labs(title = "RMSE Comparison Across Models") 
p2 <- ggplot(metrics_df, aes(x = Model, y = R_squared, fill = Dataset)) + 
geom_bar(stat = "identity", position = "dodge") + 
theme_minimal() + 
theme(axis.text.x = element_text(angle = 45, hjust = 1)) + 
labs(title = "R-squared Comparison Across Models") 
grid.arrange(p1, ncol = 1) 
grid.arrange(p2, ncol = 1) 
# Add feature importance analysis at the end 
# Function to get feature importance from Random Forest 
get_rf_importance <- function(data) { 
rf_model <- ranger( 
formula = Reached.on.Time_Y.N ~ ., 
data = data, 
importance = 'impurity', 
num.trees = 100 
) 
importance_scores <- ranger::importance(rf_model) 
return( 
data.frame( 
Feature = names(importance_scores), 
Importance = as.numeric(importance_scores) 
) %>% arrange(desc(Importance)) 
) 
}
# Function to get feature importance from XGBoost 
get_xgb_importance <- function(data) { 
# Prepare data for XGBoost 
dummies <- dummyVars("~ .", data = data %>% select(-Reached.on.Time_Y.N)) 
train_matrix <- predict(dummies, data %>% select(-Reached.on.Time_Y.N)) 
dtrain <- xgb.DMatrix( 
data = train_matrix, 
label = as.numeric(data$Reached.on.Time_Y.N) - 1 
) 
model <- xgb.train( 
params = list( 
objective = "binary:logistic", 
max_depth = 5, 
eta = 0.1 
), 
data = dtrain, 
nrounds = 100 
) 
importance <- xgb.importance( 
feature_names = colnames(train_matrix), 
model = model 
) 
return(importance %>% select(Feature, Importance = Gain)) 
} 
# Analyze and visualize top 5 important features 
cat("\n=== Feature Importance Analysis ===\n") 
# Get importance from both models 
rf_importance <- get_rf_importance(data) 
xgb_importance <- get_xgb_importance(data) 
# Create a combined importance score 
combined_importance <- full_join( 
rf_importance %>% mutate(RF_Importance = scale(Importance)[, 1]) %>% select(-Importance), 
xgb_importance %>% mutate(XGB_Importance = scale(Importance)[, 1]) %>% select(
Importance), 
by = "Feature" 
) %>% 
mutate( 
RF_Importance = replace_na(RF_Importance, 0), 
XGB_Importance = replace_na(XGB_Importance, 0), 
Average_Importance = (RF_Importance + XGB_Importance) / 2 
) %>% 
arrange(desc(Average_Importance)) 
# Display top 5 features 
cat("\nTop 5 Most Important Features:\n") 
print(head(combined_importance %>% select(Feature, Average_Importance), 5)) 
# Visualize top 5 features importance 
p_importance <- combined_importance %>% head(5) %>% 
ggplot(aes(x = reorder(Feature, Average_Importance), y = Average_Importance)) + 
geom_bar(stat = "identity", fill = "steelblue") + 
coord_flip() + 
theme_minimal() + 
labs( 
title = "Top 5 Most Important Features", 
x = "Feature", 
y = "Normalized Importance Score" 
) 
# Display the plot 
grid.arrange(p_importance, ncol = 1) 
cat("\nFeature Importance Summary:\n") 
cat("1. The analysis combines importance scores from both Random Forest and XGBoost 
models\n") 
cat("2. Scores are normalized to make them comparable between models\n") 
cat("3. Final importance is the average of normalized scores from both models\n")