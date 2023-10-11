
public class computeRPN {
    public static double evaluateRPN(String[] tokens) {
        ArrayStack stack = new ArrayStack(tokens.length);

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                Double operand2 = stack.pop();
                Double operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException("Invalid RPN expression.");
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] rpnExpression = {"2", "3", "*", "4", "+"};
        double result = evaluateRPN(rpnExpression);
        System.out.println("Result: " + result);
    }
}
