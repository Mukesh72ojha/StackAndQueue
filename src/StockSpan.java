import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int[] arr1 = new int[arr.length];
        st.push(0);
        arr1[0] = 1;
        for (int i = 1;i < arr.length;i++){
            while (st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if (st.size() == 0){
                arr1[i] = i + 1;
            }else {
                arr1[i] = i - st.peek();
            }
            st.push(i);
        }
        for (int res : arr1){
            System.out.println(res);
        }
    }
}
