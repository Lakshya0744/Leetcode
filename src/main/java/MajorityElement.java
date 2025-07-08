public class MajorityElement {
    public static void main(String[] args){
        majorityElement(new int[]{1, 2,2,2,2,2,2, 3,3});
    }
    public static void majorityElement(int[] input){
        int n = input.length;
        int candidate = -1;
        int count = 0;

        for(int num : input){
            if(count==0){
                candidate = num;
                count+=1;
            }
            else if(num==candidate){
                count+=1;
            }
            else {
                count-=1;
            }
        }
        count = 0;
        for (int num : input){
            if(candidate==num){
                count+=1;
            }
        }
        if(count>(n/2)){
            System.out.print(candidate);
        }
    }
}
