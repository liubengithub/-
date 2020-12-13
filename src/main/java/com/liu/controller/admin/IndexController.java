package com.liu.controller.admin;

import com.liu.exception.MyException;
import com.liu.pojo.User;
import com.liu.pojo.dto.ResultEnum;
import com.liu.service.UserService;
import com.liu.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author root
 * @create 2020-12-01 13:27
 */
@Controller
@RequestMapping("/admin")
public class IndexController {
    @Autowired
    UserService userService;
    @RequestMapping({"/toLogin","","/"})
    public String toLogin(){
        return "admin/login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        User user = userService.queryUserByUsername(username);
//        Session session = subject.getSession();
//        session.setAttribute("nickname",user.getNickName());
        try {
            subject.login(token);
            return "redirect:/admin/index";
        } catch (UnknownAccountException e) {//用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "admin/login";
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("msg","密码错误");
            return "admin/login";
        }
    }
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "redirect:admin/login";
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "admin/index";
    }







}
