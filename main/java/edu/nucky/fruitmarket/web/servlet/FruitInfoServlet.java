package edu.nucky.fruitmarket.web.servlet;

import edu.nucky.fruitmarket.web.bean.Fruit;
import edu.nucky.fruitmarket.web.service.FruitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FruitInfoServlet",urlPatterns ="/FruitInfoServlet" )
public class FruitInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
        FruitService service=new FruitService();
        String number=request.getParameter("number");
        Fruit fruit=new Fruit();
        fruit.setNumber(number);
       ArrayList<Fruit> fruits= service.queryFruitByCond(fruit);
       if (fruits!=null&&fruits.size()>0){
           fruit=fruits.get(0);
           request.setAttribute("fruit",fruit);
           request.getRequestDispatcher("update.jsp").forward(request,response);
       }else {
           request.setAttribute("msg","找不到水果编号");
           request.getRequestDispatcher("msg.jsp").forward(request,response);
       }
    }
}
