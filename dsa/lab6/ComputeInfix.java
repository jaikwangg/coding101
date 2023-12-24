// import java.util.*;

// public class ComputeInfix {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter an infix expression: ");
//         String infixExpression = scanner.nextLine();

//         Queue<String> rpnExpression = convertToRPN(infixExpression);
//         int result = calculateRPN(rpnExpression);

//         System.out.println("Result: " + result);
//         scanner.close();
//     }

//     public static Queue<String> convertToRPN(String infixExpression) {
//         //Queue<String> outputQueue = new LinkedList<>();
//         Stack<String> operatorStack = new Stack<>();

//         Map<String, Integer> precedence = new HashMap<>();
//         precedence.put("+", 1);
//         precedence.put("-", 1);
//         precedence.put("*", 2);
//         precedence.put("/", 2);

//         StringTokenizer tokenizer = new StringTokenizer(infixExpression, " +-*/()", true);

//         while (tokenizer.hasMoreTokens()) {
//             String token = tokenizer.nextToken().trim();

//             if (token.isEmpty()) {
//                 continue; // Ignore empty tokens
//             }

//             if (Character.isDigit(token.charAt(0))) {
//                 // If the token is a number, enqueue it directly
//                 outputQueue.add(token);
//             } else if (token.equals("(")) {
//                 // If the token is an opening parenthesis, push it onto the stack
//                 operatorStack.push(token);
//             } else if (token.equals(")")) {
//                 // If the token is a closing parenthesis, pop operators from the stack and enqueue them
//                 while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
//                     outputQueue.add(operatorStack.pop());
//                 }
//                 operatorStack.pop(); // Pop the "("
//             } else {
//                 // The token is an operator
//                 while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(") &&
//                        precedence.get(token) <= precedence.getOrDefault(operatorStack.peek(), 0)) {
//                     outputQueue.add(operatorStack.pop());
//                 }
//                 operatorStack.push(token);
//             }
//         }

//         while (!operatorStack.isEmpty()) {
//             outputQueue.add(operatorStack.pop());
//         }

//         return outputQueue;
//     }

//     public static int calculateRPN(Queue<String> rpnExpression) {
//         Stack<Integer> operandStack = new Stack<>();

//         while (!rpnExpression.isEmpty()) {
//             String token = rpnExpression.poll();

//             if (Character.isDigit(token.charAt(0))) {
//                 operandStack.push(Integer.parseInt(token));
//             } else {
//                 int operand2 = operandStack.pop();
//                 int operand1 = operandStack.pop();

//                 switch (token) {
//                     case "+":
//                         operandStack.push(operand1 + operand2);
//                         break;
//                     case "-":
//                         operandStack.push(operand1 - operand2);
//                         break;
//                     case "*":
//                         operandStack.push(operand1 * operand2);
//                         break;
//                     case "/":
//                         if (operand2 != 0) {
//                             operandStack.push(operand1 / operand2);
//                         } else {
//                             throw new ArithmeticException("Division by zero");
//                         }
//                         break;
//                     default:
//                         throw new IllegalArgumentException("Invalid operator: " + token);
//                 }
//             }
//         }

//         if (operandStack.size() != 1) {
//             throw new IllegalArgumentException("Invalid RPN expression");
//         }

//         return operandStack.pop();
//     }
// }
