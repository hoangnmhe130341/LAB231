/*
    * InfoDAO.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package model;

import db.DBContext;
import entity.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Class chứa method để thao tác với table Infomation trong DB <br>
 *
 * <pre>
 * Class thực hiện xử lý thao tác với DB
 * Class thực hiện xử lí sau.
 * ・getContact : lấy ra contact theo type contact.
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class InfoDAO {


    /**
     * Get list information by type information;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set type muốn lấy để thực hiện câu lếnh sql.
     *      1.4 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, type, detail, content được trả về.
     *      2.2 Tạo 1 contact với data được trả về.
     * 3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param type
     * @return article
     * @throws Exception
     */
    public List<Information> getContact(String type) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Information WHERE type = (?)";

        List<Information> listInfo = new ArrayList<>();
        try {
            db = new db.DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String typeContact = rs.getString("type");
                String detail = rs.getString("detail");
                String content = rs.getString("content");

                Information contact = new Information(id, typeContact, detail, content);
                listInfo.add(contact);
            }
            rs.close();
            ps.close();
            con.close();
            return listInfo;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
