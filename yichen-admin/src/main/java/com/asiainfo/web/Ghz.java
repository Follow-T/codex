package com.asiainfo.web;

/**
 * 人的类
 */
public class Ghz {

    /**
     * 属性
     * @param id 身份证号
     */
    private String id ;

    /**
     * @param name 名字
     */
    private String name ;

    /**
     * 吃的方法
     * @param shiwu
     * @return
     */
    public int eat(String shiwu) {

        System.out.println(name+"吃了"+shiwu);
        return 10;
    }

    /**
     * 拉的方法
     * @return
     */
    public int la() {

        return 1;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
