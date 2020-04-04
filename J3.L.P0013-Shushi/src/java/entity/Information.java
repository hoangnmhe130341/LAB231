/*
    * Information.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package entity;

/**
 * Class entity Information để tượng trưng cho 1 Information <br>
 *
 *
 * @author hoangnm
 * @version 1.0
 */
public class Information {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store detail.
     */
    private String detail;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store type.
     */
    private String type;

    /**
     * 
     * Constructor <br>
     * 
     * @param id
     * @param type
     * @param name
     * @param content 
     */
    public Information(int id,String type, String name, String content) {
        this.id = id;
        this.type = type;
        this.detail = name;
        this.content = content;
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
     * get type. <br>
     *
     * @return type
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
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * set detail. <br>
     *
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
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

}
