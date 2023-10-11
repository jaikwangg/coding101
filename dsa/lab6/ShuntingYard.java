import java.util.*;

public class ShuntingYard {
    public static Queue<String> convertToRPN(String infixExpression) {
        Queue<String> outputQueue = new LinkedList<>();
        Stack<String> operatorStack = new Stack<>();

        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        StringTokenizer tokenizer = new StringTokenizer(infixExpression, " +-*/()", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (token.isEmpty()) {
                continue;
            }

            if (Character.isDigit(token.charAt(0))) {
                outputQueue.add(token); // Operand, enqueue it
            } else if (token.equals("(")) {
                operatorStack.push(token); // Opening parenthesis, push onto stack
            } else if (token.equals(")")) {
                // Closing parenthesis, pop operators until matching "("
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop(); // Remove the matching "("
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses.");
                }
            } else if (precedence.containsKey(token)) {
                // Operator
                while (!operatorStack.isEmpty() &&
                        precedence.containsKey(operatorStack.peek()) &&
                        precedence.get(token) <= precedence.get(operatorStack.peek())) {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek().equals("(") || operatorStack.peek().equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses.");
            }
            outputQueue.add(operatorStack.pop());
        }

        return outputQueue;
    }
}
