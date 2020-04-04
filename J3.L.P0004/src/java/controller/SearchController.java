/*
    * SearchController.java
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
import javax.servlet.http.HttpSession;
import modal.ArticleDAO;

/**
 * Class Controller for search page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang search.jsp
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class SearchController extends HttpServlet {

    /**
     * Xử lý request.
     * 
     * <pre>
     * Method sẽ xử lý request và gửi dữ liệu lên jsp
     * Trường hợp thất bại thì xử lý exception.
     * 
     * ◆Trình tự xử lí
     *  1. Nhận dữ liệu từ sever.
     *      1.1 Tạo biến txtSearch để nhận dữ liệu muốn search từ text input của sever.
     *      1.2 Tạo biếnt page_raw để nhận dữ liệu page từ server và phán đoán xem có null không.
     *          1.2.1 Tạo biến pageIndex =-1 để nhận page_raw sau khi xử lý
     *              1.2.1.1 nếu null thì set page_raw = 1.
     *              1.2.1.2 gán biến pageIndex = page index đã qua xử lý.
     *      1.3 Tạo biến pageSize và gán giá trị bằng với số news muốn hiển thị trong 1 page từ xml.
     *      1.4 Tạo biến totalPage lấy tổng số page qua method getNumberPage(pageSize, txtSearch);.
     *      1.5 Tạo array list listSearch để lấy ra list news theo search input, page index, và page size
     *          qua method search(txtSearch, pageIndex, pageSize);.
     *      1.6 Tạo array list listFiveRecentNews để lấy ra 5 recent news qua method getAllRecentNews(5);.
     *  2. Set attribute cho dữ liệu lên sever.
     *      2.1 set attribute txtSearch qua lời gọi request.
     *      2.2 set attribute totalPage qua lời gọi request.
     *      2.3 set attribute listSearch qua lời gọi request.
     *      2.4 set attribute listFiveRecentNews qua lời gọi request.
     *  3. Chuyển hướng qua search.jsp
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra.
     * </pre>
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String txtSearch="";
            String page_raw = request.getParameter("page");
            int pageIndex =-1;
            if(page_raw==null){
                page_raw="1";
                txtSearch = request.getParameter("txtSearch");
                session.setAttribute("txtSearched", txtSearch);
            } else {
                txtSearch =(String) session.getAttribute("txtSearched");
            }
            try {
                pageIndex = Integer.parseInt(page_raw);   
            } catch (NumberFormatException ex) {                
                response.sendRedirect("error.jsp");
                return;
            }
                             
            
            int pageSize=Integer.parseInt(getInitParameter("pageSize"));
            int totalPage = new ArticleDAO().getNumberPage(pageSize, txtSearch);
            
            ArrayList<Article> listSearch = new ArticleDAO().search(txtSearch, pageIndex, pageSize);
            
            ArrayList<Article> listFiveRecentNews = new ArticleDAO().getAllRecentNews(5);
            
            request.setAttribute("txtSearch", txtSearch);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("listSearch", listSearch);
            request.setAttribute("listFiveRecentNews", listFiveRecentNews);
            
            request.getRequestDispatcher("search.jsp").forward(request, response);
            
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
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);            
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
            
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
