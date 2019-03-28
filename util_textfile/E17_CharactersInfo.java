package file_class.util_textfile;

import java.util.*;

public class E17_CharactersInfo {
    public static void main(String[] args) {
        //stat统计
        Map<Character, Integer> charsStat = new HashMap<>();
        for (String word : new TextFile("./src/file_class/util_textfile/E17_CharactersInfo.java", "\\W+")) {
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Integer integer = charsStat.get(ch);
                charsStat.put(ch, integer == null ? 1 : integer + 1);
            }
        }
        charsStat.keySet().toArray();


        List<Character> keys = Arrays.asList(charsStat.keySet().toArray(new Character[0]));
        List keys2 = new ArrayList<>(Arrays.asList(charsStat.keySet().toArray()));
        Collections.sort(keys);
        Collections.sort(keys2);
        for (Character key : keys) {
            System.out.println(key + " => " + charsStat.get(key));
        }
        for (Object key : keys2) {
            System.out.println(key + " => " + charsStat.get((Character) key));
        }

    }
}
