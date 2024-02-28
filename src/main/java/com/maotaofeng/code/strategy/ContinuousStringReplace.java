package com.maotaofeng.code.strategy;

import java.util.Stack;

/**
 * Replace consecutive strings
 */
public class ContinuousStringReplace implements StringProcessingStrategy {

    /**
     * replace String
     * @param input String to be processed
     * @return String Processed string
     */
    @Override
    public String processString(String input) {

        //Loop end flag
        boolean changesMade;

        StringBuilder result = new StringBuilder(input);
        do {
            //Reset the identifier every loop
            changesMade = false;
            //Use stack to store indices of consecutive strings
            Stack<Integer> stack = new Stack<>();

            //Push qualified characters onto the stack
            for (int i = 0; i < result.length() - 1; i++) {
                int count = 1;
                while (getCountCondition(result,count,i)) {
                    count++;
                }
                if (count >= 3) {
                    stack.push(i);
                    stack.push(i + count - 1);
                    changesMade = true;
                    //After pushing into the stack, move the next loop index back
                    i = i + count - 1;
                }
            }

            //Replace matching string
            while (!stack.isEmpty()) {
                int end = stack.pop();
                int start = stack.pop();
                if(result.charAt(start) == 'a'){
                    result.delete(start, end + 1);
                }else{
                    char replacement = (char) (result.charAt(start) - 1);
                    result.replace(start, end + 1, String.valueOf(replacement));
                }
            }
        } while (changesMade);
        return result.toString();
    }
}
