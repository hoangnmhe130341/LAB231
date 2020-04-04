/*
    * About.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ArticleDAO;

/**
 * Class Controller for view page <br>
 *
 * <pre>
 * Class là 1 servlet nhận request để gửi đến trang article.jsp hoặc about.jsp
 * Class thực hiện xử lí sau.
 * doGet : lấy dữ liệu gửi đến jsp
 * </pre>
 *
 * @author hoangnm
 * @version 1.0
 */
public class About extends HttpServlet {

    /**
     * Xử lý request mà server yêu cầu.
     * <pre>
     * Method sẽ xử lý tham số truyền về từ server và đẩy dữ liệu cần thiết lên lại. <br>
     * Trường hợp thất bại thì xử lý exception
     * ◆Trình tự xử lí
     *  1.Nhận dữ liệu từ sever.
     *     1.1 Gán giá trị pageSize mong muốn.
     *     1.2 Lấy giá trị page current và article id khi click vào sản phẩm về
     *     1.3 Tạo 1 biến articleDAO để sử dụng function trong ArticleDAO
     *     1.4 Kiểm tra xem lấy về người dùng nhấn vào about shop hay detail sản phẩm có null không
     *          1.4.1 Nếu page current Không null là nhấn vào about shop để xem tất cả sản phẩm
     *              1.4.1.1 Tạo @param intPageCurrent gán giá trị = page current qua phương thức Integer.parseInt và set attribute lên server.
     *              1.4.1.2 Lấy ra list article theo phương thức articleDAO.getListAticle(pageSize, intPageCurrent) và set attribute lên server.
     *              1.4.1.3 Lấy tổng số page qua phương thức articleDAO.getNumberPage(pageSize) và set attribute lên server.
     *              1.4.1.4 setAttribute boldAbout để set kiểu chữ khi click vào trang được chọn.
     *              1.4.1.5 request dispatcher tới about.jsp để xem được list sản phẩm theo page mong muốn.
     *          1.4.2 Nếu article id ko null là nhấn vào detail sản phải theo id
     *              1.4.2.1 lấy ra article mong muốn theo phương thức articleDAO.getArticleById(intArticle) và set article đó lên server
     *              1.4.2.2 setAttribute boldAbout để set kiểu chữ khi click vào trang được chọn.
     *              1.4.2.3 request dispatcher tới article.jsp để xem được sản phẩm theo id mong muốn.
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int pageSize = Integer.parseInt(getInitParameter("pageSize"));
            String rawPageCurrent = request.getParameter("page");
            String rawArticleId = request.getParameter("article");

            ArticleDAO articleDAO = new ArticleDAO();

            if (rawPageCurrent != null && !rawPageCurrent.isEmpty()) {
                int pageCurrent = Integer.parseInt(rawPageCurrent);

                request.setAttribute("listArticle", articleDAO.getListAticle(pageSize, pageCurrent));
                request.setAttribute("numberPage", articleDAO.getNumberPage(pageSize));
                request.setAttribute("pageCurrent", pageCurrent);

                request.setAttribute("boldAbout", "font-bold");
                if (pageCurrent < 0 || pageCurrent > articleDAO.getNumberPage(pageSize)) {
                    request.setAttribute("error", "Error");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/about.jsp").forward(request, response);
                }

            } else if (rawArticleId != null && !rawArticleId.isEmpty()) {
                int articleId = Integer.parseInt(rawArticleId);
                if (articleDAO.getArticleById(articleId) == null) {
                    request.setAttribute("error", "Error");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                } else {
                    request.setAttribute("article", articleDAO.getArticleById(articleId));
                    request.setAttribute("boldAbout", "font-bold");
                    request.getRequestDispatcher("/article.jsp").forward(request, response);
                }
            }
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
