package edu.nucky.fruitmarket.web.service;

import edu.nucky.fruitmarket.web.bean.User;
import edu.nucky.fruitmarket.web.dao.UserDao;

import java.util.ArrayList;

public class UserService {
   /* UserDao dao=new UserDao();
    public  String login(User user) {
        if (user.getUsername()!=null&&user.getUsername().length()>0)
            return dao.login(user);
        else
            return "err4";//err4表示接收的登录用户名为空
    }*/
   UserDao dao=new UserDao();
    public String login(String name, String password){
        {
            if (name!=null&&name.length()>0){
                return dao.login(name, password);
            }else{
                return "5";
            }
        }
    }
}
