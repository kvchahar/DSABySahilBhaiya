package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> path = new ArrayList<>();

        totalWays(0, s, path, answer);

        return answer;
    }

    private void totalWays(int currentIndex, String str, List<String> path, List<List<String>> answer) {

        if (currentIndex == str.length()) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = currentIndex; i < str.length(); i++) {
            if (isPalindrome(str, currentIndex, i)) {
                path.add(str.substring(currentIndex, i + 1));
                totalWays(i + 1, str, path, answer);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
