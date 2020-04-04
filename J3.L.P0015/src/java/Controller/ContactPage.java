/*
    * Contact.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package Controller;

import entity.Contact;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ContactDAO;

/**
 * Class Controller for contact page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang contact.jsp hoặc about.jsp
 * Class thực hiện xử lí sau.
 * doGet : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class ContactPage extends HttpServlet {
    /**
     * Xử lý request mà server yêu cầu.
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *     1.1 Lấy các thông tin contact qua phương thức contactDAO.getContact(string contactType).
     *     1.2 setAttribute các dữ liệu được lấy từ database.
     *     1.3 set font để người dùng biết khi chuyển tới trang contact.jsp
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
            ContactDAO contactDAO = new ContactDAO();

            request.setAttribute("contactPhone", contactDAO.getContact("phone").get(0));
            request.setAttribute("contactEmail", contactDAO.getContact("email").get(0));
            request.setAttribute("listWork", contactDAO.getContact("work"));

            request.setAttribute("boldContact", "font-bold");

            request.getRequestDispatcher("/contact.jsp").forward(request, response);
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
