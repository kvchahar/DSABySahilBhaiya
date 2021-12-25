package hashmaps;

import java.util.HashMap;

public class CheckIfArrayPairsAreDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        int length = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<length; i++){
            int currentValue = arr[i];

            int currentRem = ((currentValue % k) + k ) % k;

            if(map.containsKey(currentRem)){
                int value = map.get(currentRem);
                int freq = value + 1;
                map.put(currentRem,freq);
            }else{
                map.put(currentRem,1);
            }
        }

        for(int key : map.keySet()){
            if(key == 0){
                if(map.get(key) % 2 != 0){
                    return false;
                }
            }else if(!map.containsKey(k-key)){
                return false;
            }else if(map.get(key).equals(map.get(k-key))==false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        System.out.println(canArrange(arr,k));
    }
}
