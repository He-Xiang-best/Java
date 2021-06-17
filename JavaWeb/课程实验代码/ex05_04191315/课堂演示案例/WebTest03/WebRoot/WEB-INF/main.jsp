<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<HTML><BODY bgcolor=yellow><FONT Size=7>
  <P>请输入用户名进行登录 
   <FORM action="../login.view" method=post name=form>
       <INPUT type="text" name="name"> 
       <INPUT TYPE="submit" value="提交" name=submit>
  </FORM> 
   
   <% 
   String ID=(String)session.getId();
   String name=(String)session.getAttribute("customerName");
   if ((name!=null) &&(name.length()>0))
      {
   %>   <P>登录成功的ID号<%=ID%>
   		<p>session
         <A HREF="food.jsp">欢迎选购商品</A>
   <% }
   %>    
<FONT></BODY></HTML>
