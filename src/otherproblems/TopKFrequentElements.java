package otherproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int str = nums[i];
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }


        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (list[frequency] == null) {
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(key);
        }

        int[] arr = new int[k];
        int count = 0;

        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null) {
                for (int j = 0; j < list[i].size(); j++) {
                    arr[count++] = list[i].get(j);
                }
                if (count == k) {
                    break;
                }
            }
        }
        return arr;
    }
}
