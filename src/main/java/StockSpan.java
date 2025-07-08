import java.util.*;

public class StockSpan {
    Stack<int[]> stack = new Stack<>();
    public int[] res;
    public static void main(String[] args){
        StockSpan stockSpan = new StockSpan();
        int[] result = stockSpan.stockSpan(new int[]{100,80,60,70,60,85,90});
        for(int res: result){
            System.out.println(res);
        }
    }
    public int[] stockSpan(int[] arr){
        res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int[] pair = new int[]{arr[i],i};
            if(stack.isEmpty()){
                res[i]=1;
                stack.push(pair);
            }
            else {
                while(arr[i]>stack.peek()[0]){
                    stack.pop();
                }
                res[i] = !stack.isEmpty()?i-stack.peek()[1]:1;
                stack.push(pair);
            }
        }
        return res;
    }
}

