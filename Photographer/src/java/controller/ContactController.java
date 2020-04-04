/*
    * ContactController.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class Controller for Contact page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang Contact.jsp
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class ContactController extends HttpServlet {

    /**
     * Xử lý request mà server yêu cầu.
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *      1.1 Lấy ra data cần thiết từ class photoDAO.
     *  2. Đẩy dữ liệu lên server và forward qua trang tương ứng.
     *      2.1 set attribute những giá trị cần thiết cho page.
     *      2.2 forward qua gallery.jsp.
     * ◆Xử lí Exception
     *  ・Chuyển hướng qua trang error.jsp.
     * </pre>
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            GalleryDAO photoDao = new GalleryDAO();
            ContactDAO contactDAO = new ContactDAO();
            request.setAttribute("top3", photoDao.getTop3Galery());
            
            request.setAttribute("contact", contactDAO.getContact());
            request.setAttribute("active", "4");
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
