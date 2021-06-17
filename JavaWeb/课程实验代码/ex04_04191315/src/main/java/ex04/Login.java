package ex04;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            Student stu = getEntity03(request, response);
            String ucheckC = request.getParameter("checkcode");
            HttpSession session = request.getSession();
            /*
             将用户输入的验证码与session中取出的验证码进行比较，
             相等的话就进行登录操作不成功则返回得到登录界面
             */
            if(session.getAttribute("checkCode").toString().equalsIgnoreCase(ucheckC)){
            request.setAttribute("stu", stu);
            if (stu.isExistStudent(stu)) {
                request.getRequestDispatcher("relay.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("redirect.jsp").forward(request, response);
//                response.sendRedirect("redirect.jsp");
            }
        }else{
                response.getWriter().write("<script>alert('验证码输入错误！');history.back();</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /*
     * @author: 何翔
     * @param: [request,response]
     * @return: void
     * @date: 2021/3/25 17:01
     * @description：使用beanutils实现请求正文封装到javabean中
     */
    private Student getEntity03(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = new Student();
        try{
            BeanUtils.populate(student, request.getParameterMap());
            student.setS_name(student.getS_name().replace("\\s*",""));
            student.setS_id(student.getS_id().replace("\\s*",""));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(student.toString());
        return student;
    }

/*
 * @author: 何翔
 * @param: [request,response]
 * @return: void
 * @date: 2021/3/25 16:58
 * @description：封装请求参数到实体类中
 */
    public void getEntity01(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String s_id = request.getParameter("s_id");
        String s_name = request.getParameter("s_name");
        String academy = request.getParameter("academy");
        String specialize_course = request.getParameter("specialize_course");
        Student stu = new Student(s_id, s_name, academy, specialize_course);
        System.out.println(stu);
}

    /*
     * @author: 何翔
     * @param: [request, response]
     * @return: void
     * @date: 2021/3/25 16:56
     * @description：封装请求正文到javabean。使用的是反射+内省
     */
    private void getEntity02(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取请求正文的映射关系
        Map<String,String[]> map = request.getParameterMap();
        Student student = new Student();
        System.out.println("封装前："+student.toString());
        //2.遍历集合
        for(Map.Entry<String,String[]> me : map.entrySet()){
            String name = me.getKey();
            String[] value = me.getValue();
            try{
                //1.拿到User对象中的属性描述器。是谁的属性描述器：是由构造函数的第一个参数决定的。第二个参数是指定javabean的字节码
                PropertyDescriptor pd = new PropertyDescriptor(name, Student.class);//参数指的就是拿哪个类的哪个属性的描述器
                //2.设置javabean属性的值
                Method method = pd.getWriteMethod();
                //3.执行方法
                //判断参数到底是几个值
                if(value.length > 1){//最少有2个元素
                    method.invoke(student, (Object)value);//第一个参数是指的给哪个对象，第二个参数指的是赋什么值
                }else{
                    method.invoke(student, (Object) value);//第一个参数是指的给哪个对象，第二个参数指的是赋什么值
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(student.toString());
    }

}