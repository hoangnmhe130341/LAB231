/*
    * Article.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package entity;

import java.sql.Date;

/**
 * Class entity Article để tượng trưng cho 1 article <br>
 * 
 * 
 * @author hoangnm
 * @version 1.0
 */
public class Article {
    /**
     * Store id.
     */
    private int id;
    /**
     * Store type.
     */
    private int type;
    /**
     * Store title.
     */
    private String title;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store image.
     */
    private String image;
    /**
     * Store date.
     */
    private Date date;
    /**
     * Store description.
     */
    private String description;
    
    /**
     * Constructor. <br>
     */
    public Article() {
    }
    /**
     * Constructor full @param. <br>
     * 
     * @param id
     * @param type
     * @param title
     * @param content
     * @param image
     * @param date 
     */
    public Article(int id, int type, String title, String content, String image, Date date) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.content = content;
        this.image = image;
        this.date = date;
        if (content.length() <= 100) {
            this.description = content + "...";
        } else {
            this.description = content.substring(0, 100) + "...";
        }
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
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * get type. <br>
     * 
     * @return type 
     */
    public int getType() {
        return type;
    }
    /**
     * set type. <br>
     * 
     */
    public void setType(int type) {
        this.type = type;
    }
    /**
     * get title. <br>
     * 
     * @return title 
     */
    public String getTitle() {
        return title;
    }
    /**
     * set title. <br>
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * get content. <br>
     * 
     * @return content. 
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
     * get image. <br>
     * 
     * @return image.
     */
    public String getImage() {
        return image;
    }
    /**
     * set image. <br>
     * 
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * get date. <br>
     * 
     * @return date 
     */
    public Date getDate() {
        return date;
    }
    /**
     * set date. <br>
     * 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * get description. <br>
     * 
     * @return description 
     */
    public String getDescription() {
        return description;
    }
    /**
     * set description. <br>
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
