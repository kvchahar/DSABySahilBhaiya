package otherproblems;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

    static Comparator<String> customComp = new Comparator<String>() {
        @Override
        public int compare(String log1, String log2) {

            String[] log1Array = log1.split(" ", 2);
            String[] log2Array = log2.split(" ", 2);

            String idLog1 = log1Array[0];
            String idLog2 = log2Array[0];

            String log1WithoutId = log1Array[1];
            String log2WithoutId = log2Array[1];

            if (Character.isDigit(log1WithoutId.charAt(0)) && Character.isDigit(log2WithoutId.charAt(0))) {
                return 0;
            } else if (!Character.isDigit(log1WithoutId.charAt(0)) && Character.isDigit(log2WithoutId.charAt(0))) {
                return -1;
            }
            if (Character.isDigit(log1WithoutId.charAt(0)) && !Character.isDigit(log2WithoutId.charAt(0))) {
                return 1;
            } else {
                if (log1WithoutId.equals(log2WithoutId)) {
                    return idLog1.compareTo(idLog2);
                }
            }
            return log1WithoutId.compareTo(log2WithoutId);
        }
    };

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, customComp);

        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogFiles(logs);

        for(String s : logs){
            System.out.println(s+", ");
        }
    }


}
