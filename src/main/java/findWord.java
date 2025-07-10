import java.util.HashMap;

public class findWord {
    public static void main(String[] args){
        String [] words = new String[]{"cat", "art", "frame", "game"};
        System.out.println(findWords(words, "tarte"));
    }
    public static String findWords(String[] words, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (String w : words) {
            if(contains(w, map)){
                return w;
            }
        }
        return "-";
    }
    public static boolean contains(String w, HashMap<Character, Integer> map){
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (Character c : w.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }
        System.out.print(wordMap);
        for(Character c : wordMap.keySet()){
            if(!map.containsKey(c) || map.get(c)<wordMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
