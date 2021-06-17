package servlet;

import bean.TaxMoney;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/taxServlet")
public class TaxServlet extends BaseServlet {

public void tax(HttpServletRequest request, HttpServletResponse response){

    TaxMoney taxMoney = WebUtils.copyParamToBean(new TaxMoney(), request.getParameterMap());
    double money = taxMoney.getMoney()-1600;
    double dr=0;
    if(money<=0) dr=0;
    else if(money>0&&money<=500) dr=money*0.05-0;
    else if(money>500&&money<=3000) dr=money*0.1-25;
    else if(money>3000&&money<=5000) dr=money*0.15-125;
    else if(money>5000&&money<=20000) dr=money*0.2-375;
    else if(money>20000&&money<=40000) dr=money*0.25-1375;
    else if(money>40000&&money<=60000) dr=money*0.30-3375;
    else if(money>60000&&money<=80000) dr=money*0.35-6375;
    else if(money>80000&&money<=100000) dr=money*0.40-10375;
    else if(money>100000) dr=money*0.45-15375;
    taxMoney.setDr(dr);
    request.setAttribute("taxMoney", taxMoney);
    try {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    } catch (ServletException | IOException e) {
        e.printStackTrace();
    }
}

}