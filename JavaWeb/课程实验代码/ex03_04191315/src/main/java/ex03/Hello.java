package ex03;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hello")
public class Hello extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html ; Charset=UTF-8");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        out.print("<DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Hello</title>");
        out.print("</head>");
        out.println("<body>");
        out.printf("<h1> Hello!  %s ! %n</h1>",name);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}