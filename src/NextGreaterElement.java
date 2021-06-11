import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int[] arr1 = new int[n];
        st.push(arr[arr.length-1]);
        arr1[arr.length-1] = -1;
        for(int i = arr.length - 2;i >= 0;i--){
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size() == 0){
                arr1[i] = -1;
            }else{
                arr1[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for (int res : arr1){
            System.out.println(res);
        }
    }
}
