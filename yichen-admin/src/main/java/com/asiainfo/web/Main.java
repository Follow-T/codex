package com.asiainfo.web;

public class Main {

    public static void main(String[] args) {

        Ghz ghz = new Ghz();

        ghz.setId("1234567890");
        ghz.setName("张三");

        System.out.println("身份证号："+ghz.getId());
        System.out.println("名字："+ghz.getName());

        Ghz ghz1 = new Ghz();

        ghz1.setId("0987654321");
        ghz1.setName("李四");

        System.out.println("身份证号："+ghz1.getId());
        System.out.println("名字："+ghz1.getName());

        ghz.eat("苹果");
        ghz1.eat("梨");

        String shiwu = "香蕉";
        ghz.eat(shiwu);

    }
}
