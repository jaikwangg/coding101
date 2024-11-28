#include <iostream>
#include <string>
#include <sstream>
#include <map>
#include <stack>
#include <cctype>
#include <cmath>

std::map<std::string, double> variables;

double evaluateExpression(const std::string& expression);
double parseExpression(std::istringstream& stream);

bool isValidVariable(const std::string& var) {
    return !var.empty() && std::isalpha(var[0]) && var.size() == 1;
}

double getVariableValue(const std::string& var) {
    if (variables.find(var) != variables.end()) {
        return variables[var];
    }
    std::cerr << "Error: Variable " << var << " is not initialised.\n";
    return NAN;
}

void setVariableValue(const std::string& var, double value) {
    variables[var] = value;
}

double parseTerm(std::istringstream& stream) {
    double result = parseExpression(stream);
    char op;
    while (stream >> op) {
        if (op == '*') result *= parseExpression(stream);
        else if (op == '/') {
            double divisor = parseExpression(stream);
            if (divisor == 0) {
                std::cerr << "Error: Division by zero.\n";
                return NAN;
            }
            result /= divisor;
        } else {
            stream.putback(op);
            break;
        }
    }
    return result;
}

double parseExpression(std::istringstream& stream) {
    double result = parseTerm(stream);
    char op;
    while (stream >> op) {
        if (op == '+') result += parseTerm(stream);
        else if (op == '-') result -= parseTerm(stream);
        else {
            stream.putback(op);
            break;
        }
    }
    return result;
}

double evaluateExpression(const std::string& expression) {
    std::istringstream stream(expression);
    double result = parseExpression(stream);
    if (stream.fail() || !stream.eof()) {
        std::cerr << "Error: Invalid expression.\n";
        return NAN;
    }
    return result;
}

void handleInput(const std::string& input) {
    std::istringstream stream(input);
    std::string token;
    stream >> token;

    if (token == "exit") {
        std::cout << "Goodbye.\n";
        exit(0);
    }

    if (isValidVariable(token) && stream.peek() == '=') {
        char equals;
        double value;
        stream >> equals >> value;
        setVariableValue(token, value);
    } else {
        double result = evaluateExpression(input);
        if (!std::isnan(result)) {
            std::cout << result << std::endl;
        }
    }
}

int main() {
    std::string input;
    std::cout << "Enter expressions or type 'exit' to quit:\n";

    while (true) {
        std::cout << "> ";
        std::getline(std::cin, input);
        if (input.empty()) continue;
        handleInput(input);
    }

    return 0;
}
