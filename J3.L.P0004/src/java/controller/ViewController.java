/*
    * View.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package controller;

import entity.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ArticleDAO;

/**
 * Class Controller for view page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang view.jsp
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class ViewController extends HttpServlet {

    /**
     * Xử lý request
     * 
     * <pre>
     * Method sẽ xử lý request và gửi dữ liệu lên jsp
     * trường hợp thất bại thì xử lý exception
     * 
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *      1.1 Tạo biến raw_id để nhận và xử lý id từ sever qua method request.getParameter("id");.
     *          1.1.1 set id = -1;.
     *          1.1.2 kiểm tra id nhận về null không
     *              1.1.2.1 nếu null thì gán id=1;.
     *              1.1.2.2 không null thì gán id = raw_id đã qua xử lý
     *      1.2 Tạo array list listFiveRecentNews để lấy ra 5 recent news qua method getAllRecentNews(5);.
     *  2. Set attribute cho dữ liệu lên sever.
     *      2.1 set attribute listFiveRecentNews qua lời gọi request.
     *      2.1 set attribute article từ method ArticleDAO().getOne(id)); qua lời gọi request.
     *  3. Chuyển hướng sang view.jsp.
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String raw_id =request.getParameter("id");
            int id=-1;
            if(raw_id==null){
                id=1;
            } else {
                try {
                    id = Integer.parseInt(raw_id);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("error.jsp");
                    return;
                }
            }
            ArrayList<Article> listFiveRecentNews = new ArticleDAO().getAllRecentNews(5);
            
            request.setAttribute("listFiveRecentNews", listFiveRecentNews);
            request.setAttribute("article", new ArticleDAO().getOne(id));
            request.getRequestDispatcher("view.jsp").forward(request, response);
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
        } catch (Exception ex) {           
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            
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
        } catch (Exception ex) {
            
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
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
