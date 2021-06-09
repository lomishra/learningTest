/*
 * lokesh
 */

package com.cisco.first.module;

public class PersonInfo {

    public static void main(String[] args) {
        Person person = new Person.BuilderHelper("Lokesh","Mishra")
                        .age(32)
                        .sal(5000)
                        .build();

        Person person1 = new Person.BuilderHelper("Mahesh","Sutar")
                          .build();

        System.out.println(person);
        System.out.println(person1);

    }
}
