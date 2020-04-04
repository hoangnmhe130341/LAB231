/*
    * DBContext.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Class entity Article để tượng trưng cho news <br>
 * 
 * 
 * @author hoangnm
 * @version 1.0
 */
public class Article {
    /**
     * Store id
     */
    private int id;
    /**
     * Store title
     */
    private String title;
    /**
     * Store image
     */
    private String image;
    /**
     * Store content
     */
    private String content;
    /**
     * Store date
     */
    private Date date;
    /**
     * Store author
     */
    private String author;
    /**
     * Store shortContent
     */
    private String shortContent;
    /**
     * Store shortDes
     */
    private String shortDes;

    /**
     * Constructor. <br>
     */
    public Article() {
    }
    /**
     * Constructor full @param. <br>
     * 
     * @param id
     * @param title
     * @param image
     * @param content
     * @param date
     * @param author
     * @param shortContent 
     */
    public Article(int id, String title, String image, String content, Date date, String author, String shortContent) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.date = date;
        this.author = author;
        this.shortContent = shortContent;
        if(this.content.length()<=200){
            this.shortDes = content;
        } else {
            this.shortDes= content.substring(0,200);
        }
    }
    /**
     * get Short Content. <br>
     * 
     * @return the shortContent
     */
    public String getShortContent() {
        return shortContent;
    }
    /**
     * set short content. <br>
     * 
     * @param shortContent 
     */
    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }
    /**
     * get getShortDes. <br>
     * 
     * @return the ShortDes.
     */
    public String getShortDes() {
        return shortDes;
    }
    /**
     * Set short description.<br>
     * 
     * @param shortDes 
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }
    /**
     * get get Id. <br>
     * 
     * @return the Id.
     */
    public int getId() {
        return id;
    }
    /**
     * set id.<br>
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * get get title. <br>
     * 
     * @return the title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set title.<br>
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * get image. <br>
     * 
     * @return the image.
     */
    public String getImage() {
        return image;
    }
    /**
     * Set image.<br>
     * 
     * @param image 
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * get get content. <br>
     * 
     * @return the content.
     */
    public String getContent() {
        return content;
    }
    /**
     * Set content.<br>
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * get get date. <br>
     * 
     * @return the date.
     */
    public Date getDate() {
        return date;
    }
    /**
     * Set date.<br>
     * 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * get get author. <br>
     * 
     * @return the author.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Set author .<br>
     * @param author 
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * get get DateFormat. <br>
     * 
     * @return the date after format.
     */
    public String getDateFormat() {
        return new SimpleDateFormat("MMMM dd yyy '-' HH:mmaaa").format(this.date);
    }

}
