/*
    * GalleryDAO.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package dao;

import db.DBContext;
import entity.Contact;
import entity.Galery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class chứa method để thao tác với các table trong DB <br>
 *
 * <pre>
 * Class thực hiện xử lý thao tác với DB
 * Class thực hiện xử lí sau.
 * ・getContact
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class ContactDAO {

    public ContactDAO() {
    }
      
    /**
     * Get one contact;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set type muốn lấy để thực hiện câu lếnh sql.
     *      1.4 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra data contact cần thiết được trả về.
     *      2.2 Tạo 1 contact với data được trả về.
     * 3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @return Contact
     * @throws Exception
     */
    public Contact getContact() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> listGalery = new ArrayList<>();
        try {
            String query = "SELECT top 1 * from contact";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setTelephone(rs.getString("telephone"));
                contact.setEmail(rs.getString("email"));
                contact.setAbout(rs.getString("about"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setImgMain(rs.getString("image_main"));
                return contact;
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return null;
    }
}
