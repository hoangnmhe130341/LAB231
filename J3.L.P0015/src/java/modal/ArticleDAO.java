/*
    * ArticleDAO.java
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
import java.util.ArrayList;
import java.util.List;

/**
 * Class chứa method để thao tác với table Article trong DB <br>
 * 
 * <pre>
 * Class thực hiện xử lý thao tác với DB
 * Class thực hiện xử lí sau.
 * ・getArticle : thao tác với numberArticle, typeArticle.
 * ・getArticleById : thao tác với id.
 * ・getListAticle : thao tác với pageIndex, pageSize.
 * ・getNumberPage: thao tác với numberArticleInPage.
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class ArticleDAO {
    /**
     * Get articles by number Article and type Article;
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
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     * 
     * @param numberArticle
     * @param typeArticle
     * @return listNews 
     * @throws java.lang.Exception 
     */
    public List<Article> getArticle(int numberArticle, int typeArticle) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT TOP (?) * FROM Article WHERE type = (?) ORDER BY Date DESC";

        List<Article> listArticle = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberArticle);
            ps.setInt(2, typeArticle);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int type = rs.getInt("type");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String image = rs.getString("image");
                Date date = rs.getDate("date");

                Article article = new Article(id, type, title, content, image, date);
                listArticle.add(article);
            }
            return listArticle;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new ArticleDAO().getArticle(1, 1);
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
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Article WHERE id = (?)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int type = rs.getInt("type");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String image = rs.getString("image");
                Date date = rs.getDate("date");
                return new Article(id, type, title, content, image, date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }
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
     *      2.1 Lấy ra id, type, title, content, image, date được trả về.
     *      2.2 Tạo 1 article với @param được trả về.
     *      2.3 add vào list.
     *      2.4 lặp lại cho tới khi lấy hết dữ liệu.
     *  3. Đóng kết nối.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     *
     * @param pageSize
     * @param pageCurrent
     * @return listSearch
     * @throws Exception
     */
    public List<Article> getListAticle(int pageSize, int pageCurrent) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> listArticle = new ArrayList<>();

        String sql = "SELECT * FROM (\n"
                + "SELECT ROW_NUMBER()\n"
                + "OVER(ORDER BY id) as Number,\n"
                + "* FROM Article \n"
                + ") as DataSearch where Number between ? and ?";
        try {
            db = new DBContext();
            int articleFrom = (pageCurrent-1)*pageSize + 1;
            int articleTo = articleFrom + pageSize - 1;

            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, articleFrom);
            ps.setInt(2, articleTo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int type = rs.getInt("type");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String image = rs.getString("image");
                Date date = rs.getDate("date");
                Article article = new Article(id, type, title, content, image, date);
                listArticle.add(article);
            }
            return listArticle;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    /**
     * Get number page by numberArticleInPage.
     * 
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
     * @param pageSize
     * @return total number page
     * @throws Exception
     */
    public int getNumberPage(int pageSize) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> listArticle = new ArrayList<>();
        String sql = "SELECT COUNT(id) FROM Article";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int numberArticle = rs.getInt(1);
                int numberPage = numberArticle / pageSize;
                if(numberArticle % pageSize !=0){
                    numberPage++;
                }
                return numberPage;
                
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
