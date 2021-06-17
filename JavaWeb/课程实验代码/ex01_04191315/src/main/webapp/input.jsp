<%@ page contentType="text/html;charset=utf-8" %>
<HTML><BODY bgcolor=cyan><Font size=8>
    <FORM action="receive.jsp" method=get name=form>
    </P>
        请输入下列信息：
       <BR>输入您的姓名:<INPUT type="text" name="name" value="张三"></BR> 
       <BR>选择性别:<INPUT type="radio" name="R" value="男" checked="default">男 
                     <INPUT type="radio" name="R" value="女">女 
       </BR>
       <BR>选择您喜欢的歌手: 
          <input type="checkbox" name="superstar" value="张歌手" >张歌手
          <input type="checkbox" name="superstar" value="李歌手" >李歌手
          <input type="checkbox" name="superstar" value="刘歌手" >刘歌手
          <input type="checkbox" name="superstar" value="王歌手" >王歌手
       </BR> 
       <INPUT TYPE="hidden" value="这是隐藏信息" name="secret">
       <INPUT TYPE="submit" value="提交" name="submit">
   </FORM> 
</FONT></BODY></HTML>
