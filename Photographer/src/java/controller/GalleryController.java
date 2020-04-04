/*
    * GalleryController.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package controller;

import dao.GalleryDAO;
import dao.ImgDAO;
import entity.Image;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class Controller for GaLery page <br>
 *
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang GaLery.jsp
 * Class thực hiện xử lí sau.
 * processRequest : lấy dữ liệu gửi đến jsp
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class GalleryController extends HttpServlet {

    /**
     * Xử lý request mà server yêu cầu.
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *      1.1 Lấy gallery id và img id từ server.
     *      1.2 kiểm tra gallery id null không
     *          1.2.1 Không null thì láy giá trị gán vào biến gallery
     *          1.2.2 Null thif set mặc định = 1.
     *      1.3 Set mặc định page size = 8
     *      1.4 Lấy ra tổng số ảnh bằng method countImage và tính toán số page cần có.
     *      1.5 Lấy ra page index trong trang gallery từ server.
     *      1.6 kiểm tra page index null không
     *          1.6.1 Không null thì láy giá trị gán vào biến pageIndex.
     *          1.6.2 Null thi set pageIndex mặc định = 1.
     *      1.7 Kiểm tra điều kiện của pageIndex.
     *          1.7.1 Nếu trong khoảng cho phép thì kiểm tra imgID được lấy về ở trên.
     *              1.7.1.1 Không null thì gán vào biến imgID.
     *              1.7.1.2 Null thì mặc định lấy top 1 img của gallery đó.
     *              1.7.1.3 get image theo id lấy về nếu không null thì set attribute
     *              1.7.1.4 get image theo id lấy về nếu null thì truyền messege error lên server.
     *          1.7.2 Không trong khoảng cho phép thì truyền messege error lên server.
     *      1.8 Lấy ra list image theo gallery id tương ứng.
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
            GalleryDAO galleryDAO = new GalleryDAO();
            ImgDAO imgDAO = new ImgDAO();
            String galeryID_raw = request.getParameter("galeryID");
            String imgID_raw = request.getParameter("imgID");
            int galleryID = 1;
            if (galeryID_raw != null) {
                galleryID = Integer.parseInt(galeryID_raw);

            }
            int pageSize = Integer.parseInt(getInitParameter("pageSize"));

            int totalRecord = imgDAO.countImage(galleryID);
            if (totalRecord <= 0) {
                request.setAttribute("error", "No image in galery!!");
            }
            int maxPage = totalRecord / pageSize;
            if ((totalRecord % pageSize) != 0) {
                maxPage++;
            }

            int imageID = -1;

            String pageIndex_raw = request.getParameter("index");
            int pageIndex = 1;

            if (pageIndex_raw != null) {

                pageIndex = Integer.parseInt(pageIndex_raw);
            }

            if (pageIndex > 0 && pageIndex <= maxPage) {

                if (imgID_raw != null) {
                    imageID = Integer.parseInt(imgID_raw);
                } else {
                    imageID = imgDAO.getTop1ImageGalery(galleryID).getId();
                }

                if (imgDAO.getImageByID(imageID, galleryID) != null) {
                    request.setAttribute("top1Galery", imgDAO.getImageByID(imageID, galleryID));
                } else {
                    request.setAttribute("error", "This image not found!!");
                }
            } else {
                request.setAttribute("error", "This page is invalid!!");
            }

            List<Image> imagelList = imgDAO.getListImageFromTo(galleryID, pageIndex, pageSize);
            request.setAttribute("listImage", imagelList);

            request.setAttribute("index", pageIndex);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("galeryID", galleryID);
            request.setAttribute("totalRecord", totalRecord);
            request.setAttribute("galery", galleryDAO.getGaleryByID(galleryID));

            request.setAttribute("top3", galleryDAO.getTop3Galery());

            request.setAttribute("active", galleryID);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
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
