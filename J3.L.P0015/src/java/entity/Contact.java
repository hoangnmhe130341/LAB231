/*
    * Contact.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package entity;

/**
 * Class entity Contact để tượng trưng cho contact <br>
 *
 *
 * @author hoangnm
 * @version 1.0
 */
public class Contact {

    /**
     * Store id
     */
    private int id;
    /**
     * Store type
     */
    private String type;
    /**
     * Store key
     */
    private String detail;
    /**
     * Store value
     */
    private String value;

    /**
     * Constructor. <br>
     */
    public Contact() {
    }

    /**
     * Constructor full @param.<br>
     *
     * @param id
     * @param type
     * @param detail
     * @param value
     */
    public Contact(int id, String type, String detail, String value) {
        this.id = id;
        this.type = type;
        this.detail = detail;
        this.value = value;
    }

    /**
     * get id. <br>
     *
     * @return id.
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
     * get type. <br>
     *
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * set type. <br>
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * get detail. <br>
     *
     * @return detail.
     */
    public String getDetail() {
        return detail;
    }

    /**
     * set key. <br>
     *
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * get value. <br>
     *
     * @return value.
     */
    public String getValue() {
        return value;
    }

    /**
     * set value. <br>
     *
     * @param value.
     */
    public void setValue(String value) {
        this.value = value;
    }

}
