import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for (int i = 0;i < exp.length();i++){
            char ch = exp.charAt(i);
            if (ch == '('){
                operators.push(ch);
            }else if (Character.isDigit(ch)){
                operands.push(ch - '0');
            }else if (ch == ')'){
                while (operators.peek() != '('){
                    char opt = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int opValue = operation(v1,v2,opt);
                    operands.push(opValue);
                }
                operators.pop();
            }else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while (operators.size() > 0 && operators.peek() != '(' && precedences(ch) <= precedences(operators.peek())){
                    char opt = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int opValue = operation(v1,v2,opt);
                    operands.push(opValue);
                }
                operators.pop();
            }
        }
        while (operators.size() != 0){
            char opt = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int opValue = operation(v1,v2,opt);
            operands.push(opValue);
        }
        System.out.println(operands.peek());
    }
    public static int precedences(char operators){
        if (operators == '+'){
            return 1;
        }else if (operators == '-'){
            return 1;
        }else if (operators == '*'){
            return 2;
        }else return 2;
    }
    public static int operation(int v1, int v2,char operators){
        if (operators == '+'){
            return v1 + v2;
        }else if (operators == '-'){
            return v1 - v2;
        }else if (operators == '*'){
            return v1 * v2;
        }else {
            return v1 / v2;
        }
    }
}
