package edu.ncuky.fruitmarket.web.servlet;

import edu.ncuky.fruitmarket.web.bean.Fruit;
import edu.ncuky.fruitmarket.web.service.FruitService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="FruitInfoServlet",urlPatterns = "/FruitInfoServlet")
public class FruitInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FruitService service=new FruitService();
        String number=request.getParameter("number");
        Fruit fruit=new Fruit();
        fruit.setNumber(number);
        ArrayList<Fruit> fruits =service.queryFruitByCond(fruit);
        if(fruits!=null&&fruits.size()>0){
            fruit=fruits.get(0);
            request.setAttribute("fruit",fruit);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }else{
            request.setAttribute("msg", "找不到水果编号");
            request.getRequestDispatcher("msg.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doGet(request, response);
    }
}
