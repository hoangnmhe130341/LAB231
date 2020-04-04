/*
  * Image.java
  *
  * All Rights Reserved.
  * Copyright (c)  2020 FPT University
 */
package entity;

import db.DBContext;

/**
 * Class entity Image để tượng trưng cho 1 Image <br>
 *
 * <pre>
 * Class thực hiện xử lí sau.
 * getId
 * setId
 * getGalery_id
 * setGalery_id
 * getImage_url
 * setImage_url
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class Image {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store galery_id.
     */
    private int galery_id;
    /**
     * Store image_url.
     */
    private String image_url;

    /**
     * Constructor. <br>
     */
    public Image() {
    }

    /**
     * Constructor <br>
     *
     * @param id
     * @param galery_id
     * @param image_url
     */
    public Image(int id, int galery_id, String image_url) {
        this.id = id;
        this.galery_id = galery_id;
        this.image_url = image_url;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return galery_id
     */
    public int getGalery_id() {
        return galery_id;
    }

    /**
     *
     * @param galery_id
     */
    public void setGalery_id(int galery_id) {
        this.galery_id = galery_id;
    }

    /**
     *
     * @return image_url
     * @throws Exception
     */
    public String getImage_url() throws Exception {
        DBContext db = new DBContext();
        return db.getImagePath() + image_url;
    }

    /**
     *
     * @param image_url
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
