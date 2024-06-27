package edu.ncuky.fruitmarket.web.service;

import edu.ncuky.fruitmarket.web.bean.User;
import edu.ncuky.fruitmarket.web.dao.UserDao;

public class UserService {
    UserDao dao=new UserDao();
    public String login(User user){
        if (user.getUsername()!=null && user.getUsername().length()>0)
            return dao.login(user);
        else
            return "err4";       //err4表示接收的用户名为空
    }
}
