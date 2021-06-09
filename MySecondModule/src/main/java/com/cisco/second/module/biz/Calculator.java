package com.cisco.second.module.biz;

import com.cisco.second.module.util.AdHelper;

/**
 * This class is use for Calculator operation
 */
public class Calculator {
    public static  int i;
    public void operation(int a, int b){
        AdHelper.addOperation(a,b);
    }

    public static void main(String[] args) {

        System.out.println("value of i is:"+ ++i);
    }
}
