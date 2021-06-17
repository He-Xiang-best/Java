package ex03;
/*
  @ClassName ${NAME}
 * @description: TODO
 * @author: 何翔
 * @Date 2021/3/18 22:28
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/*")
public class Path extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Path Servlet</title>");
        out.print("</head>");
        out.println("<body>");
        out.printf("%s<br>",request.getRequestURI());
        out.printf("%s<br>",request.getContextPath());
        out.printf("%s<br>",request.getServletPath());
        out.printf(request.getPathInfo());
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
