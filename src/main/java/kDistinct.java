import java.util.HashMap;
import java.util.HashSet;

public class kDistinct {
    public static void main(String[] args){
        System.out.println(kDistinct("abacda", 2));
    }
    public static int kDistinct(String str, int distinct) {
        char[] array = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int count=  0;
        int distinctCount = 0;
        while(j<array.length){
            map.put(array[j], map.getOrDefault(array[j], 0) + 1);
            if(map.get(array[j])==1){distinctCount++;}
            if(distinctCount>distinct){
                map.put(array[i], map.get(array[i])-1);
                if(map.get(array[i])==0){
                    map.remove(array[i]);
                    distinctCount--;
                }
                i+=1;
            }
            if(distinctCount==distinct){
                count+=1;
            }
            j += 1;
        }
        return count;

    }
}
