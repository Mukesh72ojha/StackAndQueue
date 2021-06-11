import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationAndConversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Integer> valueStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();

        for (int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v2 = valueStack.pop();
                int v1 = valueStack.pop();
                int val = operation(v1,v2,ch);
                valueStack.push(val);

                String preVal2 = prefixStack.pop();
                String preVal1 = prefixStack.pop();
                String preVal = ch + preVal1 + preVal2;
                prefixStack.push(preVal);

                String inVal2 = infixStack.pop();
                String inVal1 = infixStack.pop();
                String inVal = "(" + inVal1 +ch + inVal2 + ")";
                infixStack.push(inVal);
            }else {
                valueStack.push(ch - '0');
                prefixStack.push(ch +"");
                infixStack.push(ch + "");
            }
        }
        System.out.println(valueStack.pop());
        System.out.println(infixStack.pop());
        System.out.println(prefixStack.pop());
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
