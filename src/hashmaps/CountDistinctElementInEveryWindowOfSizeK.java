package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementInEveryWindowOfSizeK {
    static ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        int release = 0;
        int answer = 0;
        int distinct = 0;

        for(int acquire = 0; acquire<k-1; acquire++){
            int currentValue = arr[acquire];

            if(map.containsKey(currentValue)){
                map.put(currentValue,map.get(currentValue)+1);
            }else{
                map.put(currentValue,1);
                distinct+=1;
            }
        }

        for(int acquire = k-1; acquire<n; acquire++){
            int value = arr[acquire];

            if(map.containsKey(value)){
                map.put(value,map.get(value)+1);
            }else{
                map.put(value,1);
                distinct+=1;
            }

            list.add(distinct);

            int discard = arr[release];
            int freq = map.get(discard);
            freq-=1;
            map.put(discard,freq);

            if(freq==0){
                map.remove(discard);
                distinct-=1;
            }
            release++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        System.out.println(countDistinct(arr,7,4)); // [3,4,4,3]
    }
}
