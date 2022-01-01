package hashmaps;

import java.util.HashMap;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        // char[] ch2 = t.toCharArray();
        // char[] ch1 = s.toCharArray();
        // Arrays.sort(ch1);
        // Arrays.sort(ch2);
        // if(s.length()!=t.length()){
        //     return false;
        // }else{
        //     for(int i = 0; i<s.length(); i++){
        //         if(ch1[i]!=ch2[i]){
        //             return false;
        //         }
        //     }
        // }
        // return true;

        HashMap<Character,Integer> map = new HashMap<>();

        if(s.length()!=t.length()){
            return false;
        }else{
            for(int i = 0; i<s.length(); i++){
                char ch = s.charAt(i);

                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else{
                    map.put(ch,1);
                }
            }

            for(int i = 0; i<t.length(); i++){
                char ch = t.charAt(i);
                if(map.containsKey(ch)){
                    int value = map.get(ch);
                    value-=1;;
                    map.put(ch,value);
                }else{
                    return false;
                }
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }

        }

        if(map.size()==0){
            return true;
        }else{
            return false;
        }
    }
}