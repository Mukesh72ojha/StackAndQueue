import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblems {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0;i < arr.length;i++){
            for (int j = 0;j < arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        findCelebrity(arr);
    }
    public static void findCelebrity(int[][] arr){
        Stack<Integer> st = new Stack<>();
        for (int i = 0;i < arr.length;i++){
            st.push(i);
        }
        while (st.size() >= 2){
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1){
                st.push(j);
            }else st.push(i);
        }
        int pot = st.pop();
        for (int i = 0;i < arr.length;i++){
            if (i != pot){
                if (arr[i][pot] == 0 || arr[pot][i] == 1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}
