/*
    * Menu.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package entity;

/**
 * Class entity Menu để tượng trưng cho 1 Menu <br>
 *
 *
 * @author hoangnm
 * @version 1.0
 */
public class Menu {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store name.
     */
    private String name;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store price.
     */
    private double price;

    /**
     * Constructor. <br>
     */
    public Menu() {

    }

    /**
     * 
     * Constructor <br>
     * 
     * @param id
     * @param name
     * @param content
     * @param price 
     */
    public Menu(int id, String name, String content, double price) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
    }

    /**
     * get id. <br>
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id. <br>
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /**
     * get name. <br>
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name. <br>
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get content. <br>
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * set content. <br>
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get price. <br>
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * set price. <br>
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + '}';
    }

    
}
