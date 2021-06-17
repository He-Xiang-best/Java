<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.net.*"%>
<HTML>
<BODY bgcolor=cyan>
	<Font size=8> <a href="index.jsp">回到首页</a> <%  request.setCharacterEncoding("utf-8");
     // String yourName=new String((request.getParameter("name")).getBytes("iso-8859-1"),"utf-8");     // 获取text提交的值

       String yourName=request.getParameter("name");
      //String tt=URLEncoder.encode("林","utf-8");
      //out.println("中文编码:"+tt);


	 //String yourName=URLDecoder.decode(request.getParameter("name"),"utf-8");
      

	   String yourSex=request.getParameter("R");         //获取radio提交的值
       String secretMess=request.getParameter("secret"); //获取hidden提交的值
       String personName[]=request.getParameterValues("superstar");  //获取checkbox提交的值
       out.println("<P> 您的姓名:"+yourName+"</P>");
       out.println("<P> 您的性别:"+yourSex+"</P>");
       out.println("<P> 您喜欢的歌手:");
       if(personName==null)
       {  out.print("一个都不喜欢");
       } 
       else
       {  for(int k=0;k<personName.length;k++)
          {  out.println(" "+personName[k]);
          }
       }
      out.println("<P> hidden提交的值:"+secretMess);  
 %>
   <p>姓名：${param.name}
   <p>ttt${paramValues.superstar}
</FONT>

</BODY>
</HTML>
