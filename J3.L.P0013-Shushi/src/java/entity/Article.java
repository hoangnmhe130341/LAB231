/*
    * Article.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package entity;

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
     * Store title.
     */
    private String title;

    /**
     * Store imgLink.
     */
    private String imgLink;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store fullContent.
     */
    private String fullContent;

    /**
     * Constructor. <br>
     */
    public Article() {

    }

    /**
     *
     * Constructor. <br>
     *
     * @param id
     * @param title
     * @param imgLink
     * @param content
     * @param fullContent
     */
    public Article(int id, String title, String imgLink, String content, String fullContent) {
        this.id = id;
        this.title = title;
        this.imgLink = imgLink;
        this.content = content;
        this.fullContent = fullContent;
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
     * get imgLink. <br>
     *
     * @return imgLink
     */
    public String getImgLink() {
        return imgLink;
    }

    /**
     * set imgLink. <br>
     *
     * @param imgLink
     */
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
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
     * get fullContent. <br>
     *
     * @return fullContent
     */
    public String getFullContent() {
        return fullContent;
    }

    /**
     * set fullContent. <br>
     *
     * @param fullContent
     */
    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

}
