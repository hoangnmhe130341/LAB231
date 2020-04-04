/*
   * GalleryDAO.java
   *
   * All Rights Reserved.
   * Copyright (c)  2020 FPT University
 */
package dao;

import db.DBContext;
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
 Class thực hiện xử lý thao tác với DB
 Class thực hiện xử lí sau.
 ・getTop3Galery
 ・getGaleryByID : thao tác với id.
 ・getContact
 ・countGallery
 ・getListGaleryFromTo
 </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class GalleryDAO {

    /**
     * Constructor <br>
     */
    public GalleryDAO() {
    }

    /**
     * Get top 3 Gallery <br>
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, title, description, name được trả về.
     *      2.2 Tạo 1 Galery với data được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @return listGalery
     * @throws java.lang.Exception
     */
    public List<Galery> getTop3Galery() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> listGalery = new ArrayList<>();
        try {
            String query = "SELECT top 3 * from galery";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                listGalery.add(galery);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return listGalery;
    }

    /**
     * Get one gallery by id gallery;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, title, description, name được trả về.
     *      2.2 Tạo 1 Galery với data được trả về.
     * 3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param id
     * @return Gallery
     * @throws java.lang.Exception
     */
    public Galery getGaleryByID(int id) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from galery where ID = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                return galery;
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return null;
    }

    /**
     * Get amount of gallery.
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set String keyword vào câu lệnh sql.
     *      1.4 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2. Dựa theo kết quả trả về lấy ra number galery theo yêu cầu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @return total number gallery
     * @throws Exception
     */
    public int countGallery() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) as count from galery";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt("count");
            }
            return cout;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
    }

    /**
     * Get list Galery in pageIndex by pageSize;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set int From vào câu lệnh sql.
     *      1.4 Set int To vào câu lệnh sql.
     *      1.5 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra data được trả về theo nhu cầu.
     *      2.2 Tạo 1 Galery với @param được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param pageSize
     * @param pageIndex
     * @return listGalery
     * @throws Exception
     */
    public List<Galery> getListGaleryFromTo(int pageIndex, int pageSize) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> list = new ArrayList<>();
        int size = countGallery();
        try {
            int from = pageIndex * pageSize - (pageSize - 1);
            int to = pageIndex * pageSize;
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as newRow , * from  galery )"
                    + "as tb where newRow between ? and ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, from);
            pr.setInt(2, to);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                list.add(galery);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return list;
    }

}
