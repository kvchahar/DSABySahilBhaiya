package slidingwindow;

import java.util.HashMap;

public class CountOccurenceOfAnagrams {
    static int search(String pat, String txt) {

        HashMap<Character,Integer> map = new HashMap<>();
        for(int acquire = 0; acquire<pat.length(); acquire++){
            char ch = pat.charAt(acquire);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        int distinct = map.size(), count = 0;
        int acquire = 0, release=0, size = txt.length(), k = pat.length();

        while(release<size){

            char ch = txt.charAt(release);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    distinct--;
                }
            }


            if(release-acquire+1<k){
                release++;
            }else if(release-acquire+1==k){
                if(distinct==0){
                    count++;
                }

                char chr = txt.charAt(acquire);

                if(map.containsKey(chr)){
                    if(map.get(chr)==0){
                        distinct++;
                    }
                    map.put(chr,map.get(chr)+1);
                    acquire++;
                    release++;
                }else{
                    acquire++;
                    release++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String pat = "for";
        String txt = "forxxorfxdofr";

        System.out.println(search(pat,txt));
    }
}
