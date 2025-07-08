import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public static void main(String[] args){
        String[] words = new String[]{"act", "tac", "cat", "toe",  "eto", "lakshya", "akshyal"};
        List<List<String>> result = groupAnagrams(words);
        for(List<String > res : result){
            System.out.println(res);
        }
    }
    public static String getHash(String word){
        char[] wordArr = word.toCharArray();
        StringBuilder hash = new StringBuilder();
        int[] hashArr = new int[26];
        for(Character ch : wordArr){
            hashArr[ch-'a']+=1;
        }
        for(int i=0;i<hashArr.length;i++){
            hash.append(hashArr[i]);
        }
        return hash.toString();
    }
    public static List<List<String>> groupAnagrams(String[] words){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : words){
            String hash = getHash(word);
            if(!map.containsKey(hash)){
                map.put(hash, new ArrayList<>(Arrays.asList(word)));
            }
            else {
                List<String> value = map.get(hash);
                value.add(word);
                map.put(hash, value);
            }

        }
        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
