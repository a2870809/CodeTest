package com.maotaofeng.code.utils;

import com.maotaofeng.code.strategy.StringProcessingStrategy;

/**
 * Get the string strategy class
 */
public class StringProcessor {

    private StringProcessingStrategy strategy;

    public StringProcessor(StringProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public String processString(String input) {

        if(input == null || input.isBlank()){
            return "";
        }
        if(input.length() < 3){
            return input;
        }

        return strategy.processString(input);
    }
}
