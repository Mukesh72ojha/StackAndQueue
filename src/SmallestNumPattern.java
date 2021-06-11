import java.util.Scanner;
import java.util.Stack;

public class SmallestNumPattern {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            st.push(num);
            num++;
            if (ch != 'd') {

                while (st.size() > 0) {
                    System.out.println(st.pop());
                }
            }
        }
        st.push(num);
        while (st.size() > 0){
            System.out.println(st.pop());
        }
    }
}
