/*
    * ArticleDAO.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package model;

import db.DBContext;
import entity.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Class chứa method để thao tác với table Article trong DB <br>
 * 
 * <pre>
 * Class thực hiện xử lý thao tác với DB
 * Class thực hiện xử lí sau.
 * ・getArticlesFromTo : thao tác với page, pageSize.
 * ・getArticleById : thao tác với id.
 * ・getTotalRows: return number article (row).
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class ArticleDAO {
    /**
     * Get list article in current page by pageSize;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set String txtSearch vào câu lệnh sql.
     *      1.4 Set int articleFrom vào câu lệnh sql.
     *      1.4 Set int articleTo vào câu lệnh sql.
     *      1.5 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, title, imgLink, content, fullContent được trả về.
     *      2.2 Tạo 1 article với @param được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param pageSize
     * @param page
     * @return listSearch
     * @throws Exception
     */
    public List<Article> getArticlesFromTo(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Article> articles = new ArrayList<>();
        String query = "select * from ("
                + "select *, ROW_NUMBER() over (order by id) as rownumber from Article"
                + ") as articles "
                + "where articles.rownumber >= ? and articles.rownumber <=?";
        DBContext db = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String imgLink = db.getResource() + rs.getString("img");
                String content = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                articles.add(new Article(id, title, imgLink, content, fullContent));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, ps, rs);
        }
        return articles;
    }

     /**
     * Get one article by id article;
     * 
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về 
     *      2.1 Lấy ra id, type, title, content, image, date được trả về.
     *      2.2 Tạo 1 article với data được trả về.
     * 3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     * 
     * @param id
     * @return article
     * @throws SQLException 
     */
    public Article getArticleById(int id) throws Exception {
        String query = "select * from Article where id = ?";
        Article article = new Article();
        DBContext db = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImgLink(db.getResource() + rs.getString("img"));
                article.setContent(rs.getString("shortContent"));
                article.setFullContent(rs.getString("fullContent"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, ps, rs);
        }
        return article;
    }

    /**
     * Get number row as number article.
     * 
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2. Dựa theo kết quả trả về lấy ra number page theo yêu cầu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @return total number article
     * @throws Exception
     */
    public int getTotalRows() throws Exception {
        
        int rows = 0;
        DBContext db = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "select count(*) from Article";

        try {
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, ps, rs);
        }
        return rows;
    }

}
