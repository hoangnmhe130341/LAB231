/*
    * Home.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package Controller;

import entity.Article;
import entity.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ArticleDAO;
import modal.ContactDAO;

/**
 * Class Controller for home page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang index.jsp hoặc about.jsp
 * Class thực hiện xử lí sau.
 * doGet : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class Home extends HttpServlet {
    /**
     * Xử lý request mà server yêu cầu.
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *      1.1 Lấy ra các article theo yêu cầu vị trí của đề bài qua method articleDAO.getArticle(numberArticle, typeArticle).
     *      1.2 setAttribute dữ liệu article lấy được từ DB lên server.
     *      1.3 Lấy ra contact cần thiết cho home page qua method contactDAO.getContact(typeContact).
     *      1.4 setAttribute dữ liệu contact lấy được từ DB lên server.
     *      1.5 Set font để báo hiệu khi đang ở home page.
     *      1.6 Chuyển hướng đến jsp.
     * ◆Xử lí Exception
     *  ・Chuyển hướng qua trang error.jsp.
     * </pre>
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArticleDAO articleDAO = new ArticleDAO();
            ContactDAO contactDAO = new ContactDAO();

            request.setAttribute("articleIntroduction", articleDAO.getArticle(1, 1).get(0));
            request.setAttribute("articleLeft", articleDAO.getArticle(2, 2).get(0));
            request.setAttribute("articleRight", articleDAO.getArticle(2, 2).get(1));

            request.setAttribute("contactAddress", contactDAO.getContact("address").get(0));
            request.setAttribute("contactPhone", contactDAO.getContact("phone").get(0));

            request.setAttribute("boldHome", "font-bold");

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
