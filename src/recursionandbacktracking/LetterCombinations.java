package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] keypad = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> list = new ArrayList<>();

        if(digits.length()==0){
            return list;
        }
        combinations(digits,list, "",keypad);

        return list;
    }

    private void combinations(String digits, List<String> answers, String str, String[] keypad){

        if(digits.length()==0){
            answers.add(str);
            return;
        }

        char ch = digits.charAt(0);
        int index = ch - '0';

        String string = keypad[index-2];

        for(int i = 0; i<string.length(); i++){
            String substr = digits.substring(1);
            combinations(substr, answers, str + string.charAt(i),keypad);
        }
    }
}
