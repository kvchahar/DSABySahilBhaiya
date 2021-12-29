package hashmaps;

import java.util.HashMap;

public class EqualZeroOneTwoInString {
    static long getSubstringWithEqual012(String str)
    {

        HashMap<String,Integer> memo = new HashMap<>();
        long ans = 0;

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        String key = Integer.toString(ones - zeros) + "#" + Integer.toString(twos-ones);
        memo.put(key,1);

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='0'){
                zeros++;
            }else if(str.charAt(i)=='1'){
                ones++;
            }else{
                twos++;
            }

            String currentKey = Integer.toString(ones-zeros) + "#" + Integer.toString(twos-ones);

            if(memo.containsKey(currentKey)){
                int value = memo.get(currentKey);
                ans += value;
                memo.put(currentKey,value+1);
            }else{
                memo.put(currentKey,1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "0102010";
        System.out.println(getSubstringWithEqual012(str));
    }
}
