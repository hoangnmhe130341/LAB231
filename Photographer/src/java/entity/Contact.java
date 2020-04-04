/*
    * Contact.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package entity;

import db.DBContext;

/**
 * Class entity Contact để tượng trưng cho 1 Contact <br>
 *
 * <pre>
 * Class thực hiện xử lí sau.
 * getTelephone
 * setTelephone
 * getEmail
 * setEmail
 * getAbout
 * getAbout
 * getAddress
 * setAddress
 * getCity
 * setCity
 * getCountry
 * setCountry
 * getImgMain
 * setImgMain
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class Contact {

    /**
     * Store telephone.
     */
    private String telephone;
    /**
     * Store email.
     */
    private String email;
    /**
     * Store about.
     */
    private String about;
    /**
     * Store address.
     */
    private String address;
    /**
     * Store city.
     */
    private String city;
    /**
     * Store country.
     */
    private String country;
    
    /**
     * Store imgMain.
     */
    private String imgMain;
    /**
     * Constructor. <br>
     */
    public Contact() {
    }


    /**
     *
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return imgMain
     */
    public String getImgMain() {
        return new DBContext().getImagePath()+imgMain;
    }

    /**
     *
     * @param imgMain
     */
    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    
}
