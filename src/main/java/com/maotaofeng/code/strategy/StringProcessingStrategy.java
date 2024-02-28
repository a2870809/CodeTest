package com.maotaofeng.code.strategy;

/**
 * String processing tools
 */
public interface StringProcessingStrategy {

    /**
     * Get the count condition that satisfies consecutive characters
     * @param result Current processing results
     * @param count current count
     * @param index current index
     * @return
     */
    default boolean getCountCondition(StringBuilder result,int count,int index){
        return index + count < result.length() && result.charAt(index) == result.charAt(index + count);
    }


    /**
     * process String
     * @param input String to be processed
     * @return String Processed string
     */
    String processString(String input);
}
