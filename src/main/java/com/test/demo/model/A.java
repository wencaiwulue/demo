package com.test.demo.model;

/**
 * @author naison
 * @since 2/27/2020 10:54
 */

public class A {
    private Integer id;
    private String name;

    public A() {
    }

    public A(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
