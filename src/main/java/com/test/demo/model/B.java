package com.test.demo.model;

/**
 * @author naison
 * @since 3/1/2020 11:06
 */
public class B {
    private String id;
    private Integer age;

    public B() {
    }

    public B(String id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
