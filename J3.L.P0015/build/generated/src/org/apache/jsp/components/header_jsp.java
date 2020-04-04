package org.apache.jsp.components;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        <!--Header-->\n");
      out.write("        <div class=\"header text-white\">\n");
      out.write("            <div class=\"top bg-orange pt-2 pl-3\">\n");
      out.write("                <h1 class=\"header-big mb-0\">Maria Bagnarelli's Cafe</h1>\n");
      out.write("                <p class=\"header-small pb-3 mb-0 text-5 mt-1 \">Wellcome to my website</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"navigation bg-red pl-3 font-sans\">\n");
      out.write("                <ul class=\"list-reset flex ma-0 py-2\">\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"text-white in-underline mr-2 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${boldHome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" href=\"Home\">Home</a>\n");
      out.write("                    <li>\n");
      out.write("\n");
      out.write("                        <a class=\"text-white in-underline mr-2 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${boldAbout}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" href=\"About?page=1\">About my Cakes</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"text-white in-underline mr-2 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${boldContact}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" href=\"Contact\">Find Maria's Cafe</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
