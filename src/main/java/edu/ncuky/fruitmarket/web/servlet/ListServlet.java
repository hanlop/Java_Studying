package edu.ncuky.fruitmarket.web.servlet;

import edu.ncuky.fruitmarket.web.bean.Fruit;
import edu.ncuky.fruitmarket.web.service.FruitService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="ListServlet",urlPatterns = "/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FruitService service = new FruitService();
        ArrayList<Fruit> fruits=service.queryAllFruit();
        request.setAttribute("fruits",fruits);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
