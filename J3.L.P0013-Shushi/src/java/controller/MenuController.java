/*
    * MenuController.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package controller;

import model.MenuDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class Controller for menu page <br>
 *
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang menu.jsp.
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class MenuController extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *      1.1 Khởi tạo biến đại diện cho menu DAO.
     *      1.2 Khởi tạo giá trị ban đầu của page là 1 và pageSize = 2.
     *      1.3 Lấy ra number of article qua method getTotalRows.
     *      1.4 Lấy giá trị của parameter "page" trên server về.
     *          1.4.1 Nếu null thì vẫn mặc định page = 1.
     *          1.4.2 Nếu không null thì gán page = giá trị được lấy về.
     *      1.5 Tính toán giá trị của total page.
     *   2. setAttribute cho các giá trị.
     *      2.1 Kiểm tra điều kiện đúng của page.
     *          2.1.1 Nếu đúng yêu cầu thì setAttribute cho content là menus trong page đó.
     *          2.1.2 Nếu sai thì setAttribute cho content là No article here!
     *      2.2 setAttribute cho page, totalPage, active rồi forward tới menu.jsp.
     * ◆Xử lí Exception
     *  ・Chuyển hướng qua trang error.jsp.
     * </pre>
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            MenuDAO model = new MenuDAO();
            int page = 1;
            int pageSize =Integer.parseInt(getInitParameter("pageSize"));
            int totalPage = model.getTotalRows();
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            if (totalPage % pageSize == 0) { // calculator total page to show information
                totalPage = totalPage / pageSize;
            } else {
                totalPage = totalPage / pageSize + 1;
            }
            
            if(page > totalPage || page <=0){
                request.setAttribute("noContent", "No menu here!");
            }else{
                request.setAttribute("menus", model.getMenusFromTo(page, pageSize));
            }          
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("active", "MenuColor");     
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
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
