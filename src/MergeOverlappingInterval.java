import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingInterval {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0;i < arr.length;i++){
            for (int j = 0;j < 2;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        mergeOverlapping(arr);
    }
    public static void mergeOverlapping(int[][] arr){
        Pair[] pairs = new Pair[arr.length];

        for (int i = 0;i <pairs.length;i++){
            pairs[i] = new Pair(arr[i][0],arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for (int i = 0;i < pairs.length;i++){
            if (i == 0){
                st.push(pairs[i]);
            }else {
                Pair top = st.peek();
                if (pairs[i].startTime > top.endTime){
                    st.push(pairs[i]);
                }else {
                    top.endTime = Math.max(top.endTime,pairs[i].endTime);
                }
            }
        }
        Stack<Pair> rs = new Stack<>();
        while (st.size() > 0){
            rs.push(st.pop());
        }
        while (rs.size() > 0){
            Pair p = rs.pop();
            System.out.println(p.startTime + " " + p.endTime);
        }
    }
    public static class Pair implements Comparable<Pair>{
        int startTime;
        int endTime;

        Pair(int st, int et){
            this.startTime = st;
            this.endTime = et;
        }
        @Override
        public int compareTo(Pair Other) {
            if (this.startTime != Other.startTime){
                return this.startTime - Other.startTime;
            }else return this.endTime - Other.endTime;
        }
    }
}
