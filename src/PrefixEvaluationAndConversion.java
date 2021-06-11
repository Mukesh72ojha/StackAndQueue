import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluationAndConversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Integer> value = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();

        for (int i = str.length() - 1;i >=0;i--){
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v1 = value.pop();
                int v2 = value.pop();
                int val = operation(v1,v2,ch);
                value.push(val);

                String pVal1 = postfix.pop();
                String pVal2 = postfix.pop();
                String pVal = pVal1 + pVal2 + ch;
                postfix.push(pVal);

                String iVal1 = infix.pop();
                String iVal2 = infix.pop();
                String iVal = "(" + iVal1 + ch + iVal2 + ")";
                infix.push(iVal);
            }else {
                value.push(ch - '0');
                postfix.push(ch + "");
                infix.push(ch + "");
            }
        }
        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
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
