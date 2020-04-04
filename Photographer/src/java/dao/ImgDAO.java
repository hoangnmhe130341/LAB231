/*
    * ImgDAO.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package dao;

import db.DBContext;
import entity.Image;
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
 * ・countImage
 * ・getListImageFromTo
 * ・getImageByID
 * ・getTop1ImageGalery
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class ImgDAO {

    /**
     * Constructor <br>
     */
    public ImgDAO() {
    }

    /**
     * Get amount of images by gallery id.
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
     * @param id
     * @return total amount of images.
     * @throws Exception
     */
    public int countImage(int id) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) as count from image where galery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                return rs.getInt("count");
            }
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return 0;
    }

    /**
     * Get list image by pageIndex, pageSize and gallery id;
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
     *      2.2 Tạo 1 image với @param được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param pageSize
     * @param pageIndex
     * @param galeryID
     * @return listGalery
     * @throws Exception
     */
    public List<Image> getListImageFromTo(int galeryID, int pageIndex, int pageSize) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            int from = pageIndex * pageSize - (pageSize - 1);
            int to = pageIndex * pageSize;
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rowNumber , * from  image where galery_id = ?)\n"
                    + "as tb where rowNumber between ? and ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            pr.setInt(2, from);
            pr.setInt(3, to);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalery_id(rs.getInt("galery_id"));
                image.setImage_url(rs.getString("image_url"));
                list.add(image);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return list;
    }

    /**
     * Get one Image by image id and gallery id;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra data được trả về theo nhu cầu sử dụng.
     *      2.2 Tạo 1 Image với data được trả về.
     * 3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param id
     * @param galeryId
     * @return Image
     * @throws java.lang.Exception
     */
    public Image getImageByID(int id, int galeryId) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from image where id = ? and galery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            pr.setInt(2, galeryId);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalery_id(rs.getInt("galery_id"));
                image.setImage_url(rs.getString("image_url"));
                return image;
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return null;
    }

    /**
     * Get top 1 Image by gallery id;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra data được trả về theo nhu cầu sử dụng.
     *      2.2 Tạo 1 Image với data được trả về.
     * 3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param galeryID
     * @return Image
     * @throws java.lang.Exception
     */
    public Image getTop1ImageGalery(int galeryID) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from image where galery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalery_id(rs.getInt("galery_id"));
                image.setImage_url(rs.getString("image_url"));
                return image;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pr, rs);
        }
        return null;
    }
}
