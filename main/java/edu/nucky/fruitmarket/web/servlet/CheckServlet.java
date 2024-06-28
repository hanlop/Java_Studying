package edu.nucky.fruitmarket.web.servlet;

import edu.nucky.fruitmarket.web.tools.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "CheckServlet",urlPatterns = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        OutputStream os=response.getOutputStream();
        String checkCode= CheckCodeUtil.outputVerifyImage(100,35,os,4);
        System.out.println(checkCode);
        session.setAttribute("check_Code",checkCode);
    }
}
