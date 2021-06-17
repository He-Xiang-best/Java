package servlet;

/*
 * @ClassName ${NAME}
 * @description: TODO
 * @author: 何翔
 * @Date 2021/4/24 14:28
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "TranslationServlet", value = "/translationServlet")
public class TranslationServlet extends BaseServlet {
   public void transTOEnglish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String content = readToString(new File("C:\\StudyProject\\Project_Java\\IntelliJ-IDEA\\JavaWeb\\ex07_04191315\\src" +
              "\\main\\java\\file\\english.txt"));
      System.out.println(content);
      request.setAttribute("content", content);
      request.getRequestDispatcher("/index.jsp").forward(request, response);

   }

   public void transTOComplexChinese(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String content =  readToString(new File("C:\\StudyProject\\Project_Java\\IntelliJ-IDEA\\JavaWeb\\ex07_04191315\\src\\main\\java\\file\\complexChinese.txt"));
      System.out.println(content);
      request.setAttribute("content", content);
      request.getRequestDispatcher("/index.jsp").forward(request, response);

   }
   public void transTOSimplifiedChinese(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String content =  readToString(new File("C:\\StudyProject\\Project_Java\\IntelliJ-IDEA\\JavaWeb\\ex07_04191315\\src\\main\\java\\file\\simplifiedChinese.txt"));
      System.out.println(content);
      request.setAttribute("content", content);
      request.getRequestDispatcher("/index.jsp").forward(request, response);

   }

   public String readToString(File file) {
      if(!file.exists()){
         try {
            file.createNewFile();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      String encoding = "UTF-8";
      long filelength = file.length();
      byte[] filecontent = new byte[(int) filelength];
      try {
         FileInputStream in = new FileInputStream(file);
         in.read(filecontent);
         in.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      try {
         return new String(filecontent, encoding);
      } catch (UnsupportedEncodingException e) {
         System.err.println("The OS does not support " + encoding);
         e.printStackTrace();
         return null;
      }
   }
}
