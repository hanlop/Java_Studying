package edu.nucky.fruitmarket.web.servlet;

import edu.nucky.fruitmarket.web.bean.Fruit;
import edu.nucky.fruitmarket.web.service.FruitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet",urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        FruitService service=new FruitService();
        String number,name,price,unit;
        number=request.getParameter("number");
        name=request.getParameter("name");
       price=request.getParameter("price");
        unit=request.getParameter("unit");
        try {
            if (number!=null&&number.length()>0) {
                Fruit fruit=new Fruit(number,name,Double.parseDouble(price),unit);
                if (service.addFruit(fruit)){
                    request.setAttribute("msg","添加成功");
                request.getRequestDispatcher("msg.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","水果编号不能重复，请重新输入");
                    request.getRequestDispatcher("msg.jsp").forward(request,response);
                }
            }else {
                request.setAttribute("msg","水果编号不能为空，请输入");
                request.getRequestDispatcher("msg.jsp").forward(request,response);
            }
        }catch (NumberFormatException e){
            request.setAttribute("msg","水果单价格式错误，请重新输入");
            request.getRequestDispatcher("msg.jsp").forward(request,response);

    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
