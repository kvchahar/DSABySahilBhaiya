package hashmaps;

import java.util.HashMap;

public class RabbitInForest {
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {

            if (map.containsKey(answers[i])) {
                map.put(answers[i], map.get(answers[i]) + 1);
            } else {
                map.put(answers[i], 1);
            }
        }

        int ans = 0;
        for (int key : map.keySet()) {
            int groupSize = key + 1;
            int reportees = map.get(key);
            int numberOfGroups = (int) (Math.ceil(reportees * 1.0 / groupSize * 1.0));

            ans += (numberOfGroups * groupSize);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1,1,2}));
    }
}
