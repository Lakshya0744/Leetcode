import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args){
        System.out.println(trappingRainWater(new int[]{1,0,0,2,0,4,1,1,5}));
    }
    public static int trappingRainWater(int[] array){
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        left[0]= array[0];
        right[array.length-1] = array[array.length-1];
        for(int i=1;i< array.length;i++){
            left[i] = Math.max(left[i-1], array[i]);
        }
        for(int i= array.length-2; i>=0;i--){
            right[i] = Math.max(array[i], right[i+1]);
        }
        System.out.println(Arrays.asList(left));
        int max_volume = 0;
        for(int i=0;i< array.length;i++){
            max_volume+=Math.min(left[i], right[i])- array[i]>=0?Math.min(left[i], right[i])- array[i]:0;
        }
        return max_volume;
    }
}
