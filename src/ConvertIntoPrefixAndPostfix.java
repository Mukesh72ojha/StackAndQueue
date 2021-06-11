import java.io.*;
import java.util.*;

public class ConvertIntoPrefixAndPostfix{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> operators = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for(int i = 0;i < exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <=            'Z')){
                postfix.push(ch + "");
                prefix.push(ch + "");
            }else if(ch == ')'){
                while(operators.peek() != '('){
                    char opt = operators.pop();

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preValue = opt + prev1 + prev2;
                    prefix.push(preValue);

                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postValue = postv1 + postv2 + opt;
                    postfix.push(postValue);
                }
                operators.pop();
            }else if(ch =='+' || ch =='-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    char opt = operators.pop();

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preValue = opt + prev1 + prev2;
                    prefix.push(preValue);

                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postValue = postv1 + postv2 + opt;
                    postfix.push(postValue);
                }
                operators.push(ch);
            }
        }
        while(operators.size() > 0){
            char opt = operators.pop();

            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            String preValue = opt + prev1 + prev2;
            prefix.push(preValue);

            String postv2 = postfix.pop();
            String postv1 = postfix.pop();
            String postValue = postv1 + postv2 + opt;
            postfix.push(postValue);
        }
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
    }
    public static int precedence(char operator){
        if(operator == '+' || operator == '-'){
            return 1;
        }else if(operator == '*' || operator == '/'){
            return 2;
        }else return 0;
    }
}
