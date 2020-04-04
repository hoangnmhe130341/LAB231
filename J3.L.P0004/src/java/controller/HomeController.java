/*
    * HomeController.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package controller;

import entity.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ArticleDAO;

/**
 * Class Controller for home page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang index.jsp
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class HomeController extends HttpServlet {

    /**
     * Xử lý request
     * 
     * <pre>
     * Method sẽ xử lý request và gửi dữ liệu lên jsp
     * trường hợp thất bại thì xử lý exception
     * 
     * ◆Trình tự xử lí
     *  1.Lấy dữ liệu 5 recent news trong DB qua method getAllRecentNews(int num)
     *  2.Set attribute 5 recent news lấy ở bước 1 qua lời gọi request
     *  3.Chuyển hướng qua index.jsp
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException 
     * 
     * </pre>

     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<Article> listFiveRecentNews = new ArticleDAO().getAllRecentNews(5);
            request.setAttribute("listFiveRecentNews", listFiveRecentNews);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
