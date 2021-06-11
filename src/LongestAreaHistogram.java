import java.util.Scanner;
import java.util.Stack;

public class LongestAreaHistogram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int[] rightSmallNum = new int[arr.length];// for index of right small elements
        Stack<Integer> st;
        st = new Stack<>();
        st.push(arr.length - 1);
        rightSmallNum[arr.length - 1] = arr.length;
        for (int i = arr.length - 2;i >=0 ;i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                rightSmallNum[i] = arr.length;
            } else {
                rightSmallNum[i] = st.peek();
            }
            st.push(i);
        }
        int[] leftSmallNum = new int[arr.length];// for index of left small elements
        st = new Stack<>();
        st.push(0);
        leftSmallNum[0] = -1;
        for (int i = 1;i < arr.length;i++){
            while (st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if (st.size() == 0){
                leftSmallNum[i] = -1;
            }else {
                leftSmallNum[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for (int i = 0;i < arr.length;i++){
            int width = rightSmallNum[i] - leftSmallNum[i] - 1;
            int area = arr[i] * width;
            if (maxArea < area){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
}
