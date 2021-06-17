<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="com.demo3.chart.*,java.util.ArrayList" %>
<HTML><BODY bgcolor=cyan><FONT Size=5>
ID号<%= (String)session.getId()%><br>
<% 
   String name=(String)session.getAttribute("name");
  FoodList foods=(FoodList)session.getAttribute("foods");
 %>
欢迎你，<%=name %>
<P>这里是食品柜台，请选择您要购买的食品：
   <FORM action="../foodCount.do " method=post name=form>
   <%if (foods==null)  {
	   foods=new FoodList();
	   session.setAttribute("foods", foods);
   }
   else{
	   foods.setNumber(0);
     for(Food food:foods.getChart()){ %>
   
       <input type="checkbox" name="choice" 
       value="<%=food.getId()%>" ><%=food.getName() %>
    <%
     }
     }
   %>
        </BR> 
       <INPUT TYPE="submit" value="提交" name="submit">
  </FORM> 
</FONT> 
   
 </BODY></HTML>
