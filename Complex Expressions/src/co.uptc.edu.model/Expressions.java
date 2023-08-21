import java.util.Stack;

public class Expressions {
    private Stack<Double> values;
    private Stack<Character> operators;

    public Expressions() {
        values = new Stack<>();
        operators = new Stack<>();
    }

    public void evaluateExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                values.push(Double.parseDouble(numStr.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateOperation();
                }
                operators.pop(); 
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    evaluateOperation();
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            evaluateOperation();
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private void evaluateOperation() {
        double rightOperand = values.pop();
        double leftOperand = values.pop();
        char operator = operators.pop();

        double result = 0;
        switch (operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
        }
        values.push(result);
    }

    public double getFinalResult() {
        return values.pop();
    }
}