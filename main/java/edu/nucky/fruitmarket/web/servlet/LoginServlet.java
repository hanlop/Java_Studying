package edu.nucky.fruitmarket.web.servlet;

import edu.nucky.fruitmarket.web.bean.User;
import edu.nucky.fruitmarket.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name").trim();
        String password = request.getParameter("password");
        String code = request.getParameter("code").trim();
        String checkCode = (String) request.getSession().getAttribute("check_Code");
        UserService service=new UserService();
        if (checkCode.equals(code)) {
            if (service.login(name, password).equals("1")) {
                response.sendRedirect("succpage.jsp");
            } else if (service.login(name, password).equals("2")) {
                request.setAttribute("msg", "用户名输入错误");
                request.getRequestDispatcher("errpage.jsp").forward(request, response);
            } else if (service.login(name, password).equals("3")) {
                request.setAttribute("msg", "数据库连接错误，请联系管理员");
                request.getRequestDispatcher("errpage.jsp").forward(request, response);
            } else if (service.login(name, password).equals("4")) {
                request.setAttribute("msg", "数据库访问错误，请联系管理员");
                request.getRequestDispatcher("errpage.jsp").forward(request, response);
            } else if (service.login(name, password).equals("5")) {
                request.setAttribute("msg", "用户名不能为空，请重新输入");
                request.getRequestDispatcher("errpage.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("msg", "验证码错误，请重新输入");
            request.getRequestDispatcher("errpage.jsp").forward(request, response);
        }
    }
}