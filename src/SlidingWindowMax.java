import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        // find greater elements on right and store it's index value
        int[] arr1 = new int[arr.length];
        st.push(arr.length - 1);
        arr1[arr.length - 1] = arr.length;
        for (int i = arr.length - 2;i >= 0;i--){
            while (st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if (st.size() == 0){
                arr1[i] = arr.length;
            }else {
                arr1[i] = st.peek();
            }
            st.push(i);
        }
        // find max sliding window
        int j = 0;
        for (int i = 0;i < arr.length - k;i++){
            if (j < i){
                j = i;
            }
            while (arr1[j] < i+k){
                j = arr1[j];
            }
            System.out.println(arr[j]);
        }

    }

}
