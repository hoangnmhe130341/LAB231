/*
    * Galery.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package entity;

/**
 * Class entity Galery để tượng trưng cho 1 Galery <br>
 *
 * <pre>
 * Class thực hiện xử lí sau.
 * getId
 * setId
 * getTitle
 * setTitle
 * getDescription
 * setDescription
 * getName
 * setName
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class Galery {

    /**
     * Store ID.
     */
    private int ID;
    /**
     * Store title.
     */
    private String title;
    /**
     * Store description.
     */
    private String description;
    /**
     * Store name.
     */
    private String name;

    /**
     *
     */
    public Galery() {
    }

    /**
     *
     * @param ID
     * @param title
     * @param description
     */
    public Galery(int ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Galery{" + "ID=" + ID + ", title=" + title + ", description=" + description + '}';
    }

}
