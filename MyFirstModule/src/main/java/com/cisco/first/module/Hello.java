package com.cisco.first.module;

import com.cisco.second.module.biz.Calculator;

public class Hello {

    public static void main(String[] args) {
        verifyAddOperation(34,57);
    }
    public static void verifyAddOperation(int a, int b){
        var cal = new Calculator();
        cal.operation(a,b);


    }

}
