/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2016-05-25 01:13:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.owasp.webgoat.session.WebSession;

public final class webgoat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.owasp.webgoat.session.WebSession");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

WebSession webSession = ((WebSession) session.getAttribute("websession"));

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />\r\n");
      out.write("<title>WebGoat V5.2</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/webgoat.css\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"wrap\">\r\n");
      out.write("<div id=\"top\"></div>\r\n");
      out.write("<div id=\"start\">\r\n");
      out.write("<p>Thank you for using WebGoat! This program is a demonstration of common web application flaws.\r\n");
      out.write("The exercises are intended to provide hands on experience with\r\n");
      out.write("application penetration testing techniques. </p>\r\n");
      out.write("<p>The WebGoat project is lead\r\n");
      out.write("by Bruce Mayhew. Please send all comments to Bruce at ");
      out.print(webSession.getWebgoatContext().getFeedbackAddress());
      out.write(".</p>\r\n");
      out.write("<p>Thanks to <a href=\"http://www.ouncelabs.com\"><img align=\"top\" height=\"20\" width=\"160\" border = \"0\" src=\"images/logos/ounce.jpg\" alt=\"Ounce Labs\"/></a> for supporting Bruce on the WebGoat Project.</p>\r\n");
      out.write("\r\n");
      out.write("<div id=\"team\">\r\n");
      out.write("<table border=\"0\" align=\"center\" class=\"lessonText\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"50%\">\r\n");
      out.write("\t\t<div align=\"center\"><a href=\"http://www.owasp.org\"><img\r\n");
      out.write("\t\t\tborder=\"0\" src=\"images/logos/owasp.jpg\" alt=\"OWASP Foundation\"\r\n");
      out.write("\t\t\tlongdesc=\"http://www.owasp.org\" /></a></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"50%\">\r\n");
      out.write("\t\t<div align=\"center\"><a href=\"http://www.aspectsecurity.com\"><img\r\n");
      out.write("\t\t\tborder=\"0\" src=\"images/logos/aspect.jpg\" alt=\"Aspect Security\"\r\n");
      out.write("\t\t\tlongdesc=\"http://www.aspectsecurity.com\" /></a></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"50%\">\r\n");
      out.write("\t\t<div align=\"center\"><span class=\"style1\"><br />\r\n");
      out.write("\t\tWebGoat Design Team </span></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"50%\">\r\n");
      out.write("\t\t<div align=\"center\"><span class=\"style1\"><br />\r\n");
      out.write("\t\tLesson Contributers </span></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td valign=\"top\">\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Bruce Mayhew</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">David Anderson</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Rogan Dawes</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Laurence Casey (Graphics)</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td valign=\"top\">\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Aspect Security</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Sherif Koussa</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Romain Brechet</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"25\" valign=\"bottom\">\r\n");
      out.write("\t\t<div align=\"center\"><span class=\"style1\">Special Thanks\r\n");
      out.write("\t\tfor V5.2</span></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td height=\"25\" valign=\"bottom\">\r\n");
      out.write("\t\t<div align=\"center\"><span class=\"style1\">Documentation\r\n");
      out.write("\t\tContributers</span></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Reto Lippuner</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Marcel Wirth\t</div>\r\n");
      out.write("\t\t<br/><div align=\"center\" class=\"style2\">To all who have sent comments</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Sherif Koussa<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Aung Khant<br />\r\n");
      out.write("\t\t(http://yehg.org/)</div>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">Erwin Geirnaert<br />\r\n");
      out.write("\t\t(http://www.zionsecurity.com/)</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">\r\n");
      out.write("\t\t<form id=\"form\" name=\"form\" method=\"post\" action=\"attack\"><input\r\n");
      out.write("\t\t\ttype=\"submit\" name=\"start\" value=\"Start WebGoat\" /></form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div align=\"center\" class=\"style2\">&nbsp;</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div align=\"center\" class=\"style2\">&nbsp;</div>\r\n");
      out.write("<div align=\"center\" class=\"style2\">&nbsp;</div>\r\n");
      out.write("<div align=\"center\" class=\"style2\">&nbsp;</div>\r\n");
      out.write("<div id=\"warning\">WARNING<br />\r\n");
      out.write("While running this program, your machine is extremely vulnerable to\r\n");
      out.write("attack. You should disconnect from the network while using this program.\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("This program is for educational purposes only. Use of these techniques\r\n");
      out.write("without permission could lead to job termination, financial liability,\r\n");
      out.write("and/or criminal penalties.</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
