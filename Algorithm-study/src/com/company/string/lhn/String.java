package com.company.string.lhn;

public class String {

    //dev-master
    public int solution1(java.lang.String str, char c){
        int solution = 0;
        for (char find : str.toCharArray()) {
            if(find == c) solution++;
        }
        return solution;
    }
}
