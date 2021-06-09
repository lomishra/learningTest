/*
 * lokesh
 */

package com.cisco.first.module;

public class Person {

    private String fName;
    private String lName;
    private int age;
    private int sal;

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
    }

    private Person(){
        System.out.println("Inside the Default Const");
    }
    private Person(BuilderHelper builder){
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.age = builder.age;
        this.sal = builder.sal;
    }

    public String getfName(){
        return fName;
    }
    public String getlName(){
        return lName;
    }
    public int getAge(){
        return age;
    }
    public int getSal(){
        return sal;
    }


    public static class BuilderHelper{
        private String fName;
        private String lName;
        private int age;
        private int sal;

        public BuilderHelper(String fName, String lName){
            this.fName = fName;
            this.lName = lName;
        }
        public BuilderHelper fName(String fName){
            this.fName = fName;
            return this;
        }
        public BuilderHelper lName(String lName){
            this.lName = lName;
            return this;
        }
        public BuilderHelper age(int age){
            this.age = age;
            return this;
        }
        public BuilderHelper sal(int sal){
            this.sal = sal;
            return this;
        }

        public Person build(){
            return  new Person(this);
        }


    }



}
