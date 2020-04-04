/*
    * DBContext.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package modal;

import db.DBContext;
import entity.Article;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class chứa method để thao tác với table Article trong DB <br>
 *
 * <pre>
 * Class thực hiện xử lý thao tác với DB
 * Class thực hiện xử lí sau.
 * ・getAllRecentNews : thao tác với numberNews.
 * ・getOne : thao tác với id.
 * ・search : thao tác với pageIndex, pageSize, txtSearch.
 * ・getNumberPage: thao tác với numberArticleInPage, keyword.
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class ArticleDAO {

    /**
     * Get all recent news by number news;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, title, image, content, date, author, shortContent được trả về.
     *      2.2 Tạo 1 article với @param được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param numberNews
     * @return listNews
     * @throws SQLException
     */
    public ArrayList<Article> getAllRecentNews(int numberNews) throws SQLException {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select TOP (?) * from Article \n"
                + "order by Date DESC";

        ArrayList<Article> listNews = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberNews);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String image = rs.getString("image");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                String shortContent = rs.getString("shorDes");
                Article n = new Article(id, title, image, content, date, author, shortContent);
                listNews.add(n);
            }
            return listNews;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    /**
     * Get one news by id news;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, title, image, content, date, author, shortContent được trả về.
     *      2.2 Tạo 1 article với @param được trả về.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param id
     * @return article
     * @throws SQLException
     */
    public Article getOne(int id) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from Article\n"
                + "where id = (?)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String image = rs.getString("image");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                String shortContent = rs.getString("shorDes");
                return new Article(id, title, image, content, date, author, shortContent);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Tìm kiếm news theo yêu cầu;
     *
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set String txtSearch vào câu lệnh sql.
     *      1.4 Set int start vào câu lệnh sql.
     *      1.4 Set int end vào câu lệnh sql.
     *      1.5 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2.  Dựa theo kết quả trả về
     *      2.1 Lấy ra id, title, image, content, date, author, shortContent được trả về.
     *      2.2 Tạo 1 article với @param được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param txtSearch
     * @param pageIndex
     * @param pageSize
     * @return listSearch
     * @throws Exception
     */
    public ArrayList<Article> search(String txtSearch, int pageIndex, int pageSize) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM (SELECT ROW_NUMBER()\n"
                + "                OVER(ORDER BY id) as Number,\n"
                + "                * FROM Article \n"
                + "                WHERE title LIKE ?) as DataSearch where Number between ? and ?";
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;

        ArrayList<Article> listSearch = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, start);
            ps.setInt(3, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String image = rs.getString("image");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                String shortContent = rs.getString("shorDes");
                Article n = new Article(id, title, image, content, date, author, shortContent);
                listSearch.add(n);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Get number page by numberArticleInPage and keyword.
     * <pre>
     * ◆Trình tự xử lí
     *  1. Kết nối và xử lý câu lệnh SQL với DB
     *      1.1 Lấy ra đối tượng Connection kết nối vào DB.
     *      1.2 Tạo đối tượng Statement.
     *      1.3 Set String keyword vào câu lệnh sql.
     *      1.4 Thực thi câu lệnh SQL trả về đối tượng ResultSet.
     *  2. Dựa theo kết quả trả về lấy ra number page theo yêu cầu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param numberArticleInPage
     * @param keyword
     * @return
     * @throws Exception
     */
    public int getNumberPage(int numberArticleInPage, String keyword) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(id) FROM Article \n"
                + "WHERE title LIKE ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            keyword = "%" + keyword + "%";
            ps.setString(1, keyword);
            rs = ps.executeQuery();

            while (rs.next()) {
                int numberArticle = rs.getInt(1);
                if (numberArticle % numberArticleInPage == 0) {
                    return numberArticle / numberArticleInPage;
                } else {
                    return numberArticle / numberArticleInPage + 1;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return -1;
    }
}
