/*
 * lokesh
 */

package com.cisco.first.module;

public class SortingClass {
    public static void main(String[] args) {
        bubbleSort();
    }

    private static void bubbleSort(){
        var lst = new int[]{43, 56, 21, 45, 78, 98, 12};
        System.out.println("Before sorting ");
        for(int k :lst){
            System.out.print(k +" ");
        }
        for(int i= lst.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(lst[j] > lst[j+1]){
                    int temp = lst[j];
                    lst[j]= lst[j+1];
                    lst[j+1]= temp;
                }
            }

        }
        System.out.println("");
        System.out.println("After sorting ");
        for(int k :lst){
            System.out.print(k +" ");
        }
    }

}
