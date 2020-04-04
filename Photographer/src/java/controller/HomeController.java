/*
    * HomeController.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import entity.Galery;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class Controller for home page <br>
 * 
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang HomePage.jsp
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class HomeController extends HttpServlet {

    /**
     * Xử lý request mà server yêu cầu.
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *      1.1 Set page size mặc định = 3, page index = 1.
     *      1.2 Kiểm tra xem page index null không
     *          1.2.1 Null thì mặc định = 1.
     *          1.2.2 Không null thì set giá trị page index.
     *      1.3 Sử lý và tính toán pagging.
     *          1.3.1 Nếu không có gallery nào thì set content là no result.
     *          1.3.2  Nếu có thì tính toán tổng số page.
     *      1.4 Lấy ra list gallery theo page index và page size.
     *      1.5 Lấy ra contact được lưu trong DB.
     *  2. Đẩy dữ liệu lên server và forward qua trang tương ứng.
     *      2.1 set attribute những giá trị cần thiết cho page.
     *      2.2 forward qua homepage.jsp.
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
      try{
           GalleryDAO photoDao = new GalleryDAO();
               int pageSize =Integer.parseInt(getInitParameter("pageSize"));
            String pageIndex = request.getParameter("index");
              int index = 0;

            if (pageIndex != null) {
                try {
                    index = Integer.parseInt(pageIndex);
                } catch (Exception e) {
                    request.setAttribute("error", "This page is invalid!!");
                }
            }else{
                index = 1;
            }

            int totalRecord = photoDao.countGallery();
            if(totalRecord <= 0){
                request.setAttribute("error", "No result!!");
            }
            int maxPage = totalRecord / pageSize;
            if ((totalRecord % pageSize) != 0) {
                maxPage++;
            }

            List<Galery> digitalList = photoDao.getListGaleryFromTo(index, pageSize);
            request.setAttribute("listGalery", digitalList);
            request.setAttribute("index", index);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("totalRecord", totalRecord);

           request.setAttribute("top3", photoDao.getTop3Galery());   
           request.setAttribute("contact", new ContactDAO().getContact());
           request.setAttribute("active", "0");
           request.getRequestDispatcher("HomePage.jsp").forward(request, response);
       }catch(Exception ex){
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
