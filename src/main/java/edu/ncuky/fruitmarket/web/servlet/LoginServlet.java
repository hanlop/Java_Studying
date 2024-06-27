package edu.ncuky.fruitmarket.web.servlet;

import edu.ncuky.fruitmarket.web.bean.User;
import edu.ncuky.fruitmarket.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("name").trim();
        String password=request.getParameter("password");
        String code=request.getParameter("code").trim();
        String checkCode=(String) request.getSession().getAttribute("check_code");
        if (checkCode.equals(code)){
            User user=new User(username,password);
            UserService service=new UserService();
            String msg=service.login(user);
            if ("ok".equals(msg)){
                response.sendRedirect("succpage.jsp");
            }else if ("err1".equals(msg)){
                request.setAttribute("msq","用户名或密码错误，登录失败");
                request.getRequestDispatcher("errpage.jsp").forward(request,response);
            }else if ("err2".equals(msg)){
                request.setAttribute("msq","数据库操作错误，请联系管理员");
                request.getRequestDispatcher("errpage.jsp").forward(request,response);
            }else if ("err3".equals(msg)){
                request.setAttribute("msq","数据库连接错误，请联系管理员");
                request.getRequestDispatcher("errpage.jsp").forward(request,response);
            }else if ("err4".equals(msg)){
                request.setAttribute("msq","用户名不能为空，请重新输入");
                request.getRequestDispatcher("errpage.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msq","验证码错误，请重新输入");
            request.getRequestDispatcher("errpage.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
