package edu.ncuky.fruitmarket.web.servlet;

import edu.ncuky.fruitmarket.web.service.FruitService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="DeleteServlet",urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        FruitService service=new FruitService();
        String number;
        boolean succ=false;
        number=request.getParameter("number");
        String[] numbers=number.split(",");
        for(String delNum:numbers){
            succ=service.delFruit(delNum);
        }
        if(succ){
            request.setAttribute("msg", "删除成功");
            request.getRequestDispatcher("msg.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "水果信息不存在，无法删除");
            request.getRequestDispatcher("msg.jsp").forward(request, response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }
}
