package edu.nucky.fruitmarket.web.servlet;

import edu.nucky.fruitmarket.web.service.FruitService;
import edu.nucky.fruitmarket.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordServlet",urlPatterns = "/PasswordServlet")
public class PasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FruitService fruitService=new FruitService();
        String oldpassword=request.getParameter("mpass");
        String newpassword=request.getParameter("newpass");
        if(fruitService.UpdateUser(newpassword,oldpassword))
        {
            request.setAttribute("msg", "修改成功");
            request.getRequestDispatcher("msg.jsp").forward(request, response);
        }
        else { request.setAttribute("msg", "密码错误，请重新输入");
            request.getRequestDispatcher("errpage.jsp").forward(request, response);}

    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doPost(request, response);
        }
    }
