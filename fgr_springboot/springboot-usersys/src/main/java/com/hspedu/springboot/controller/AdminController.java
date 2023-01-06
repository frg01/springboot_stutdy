package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Admin;
import com.hspedu.springboot.bean.Monster;
import com.hspedu.springboot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Controller
@Slf4j
public class AdminController {

    //响应用户登录请求
    @PostMapping("/login")
    public String login(Admin admin, HttpSession session, Model model) {

        //验证用户是否合法
        if (StringUtils.hasText(admin.getName()) && "666".equals(admin.getPassword())) {
            //合法 重定向到manage.html  不适用请求转发防止刷新页面重复提交
            //重定向 更明确表示取哪个页面
            session.setAttribute("loginAdmin", admin);
            return "redirect:/manage.html";
        } else {
            //不合法 重新登陆
            model.addAttribute("msg", "账号或用户错误");
            return "adminLogin";
        }

    }

    //处理用户请求到manage.html
    @GetMapping("/manage.html")
    public String mainPage(Model model, HttpSession session) {
//        Object loginAdmin = session.getAttribute("loginAdmin");
//        if (!ObjectUtils.isEmpty(loginAdmin)) {//说明成功登录
        log.info("进入到mainPage方法");

//            //可以集合模拟用户数据 放入到request域中
//            ArrayList<User> users = new ArrayList<User>();
//            users.add(new User(1, "关羽", "66666", 20, "gy@sohu.com"));
//            users.add(new User(2, "张飞", "66666", 30, "gy@sohu.com"));
//            users.add(new User(3, "赵云", "66666", 22, "gy@sohu.com"));
//            users.add(new User(4, "马超", "66666", 28, "gy@sohu.com"));
//            users.add(new User(5, "黄忠", "66666", 50, "gy@sohu.com"));
//            model.addAttribute("users", users);
            ArrayList<Monster> monsters = new ArrayList<>();
            monsters.add(new Monster(1,"牛魔王1","芭蕉扇",200,2000.0,new Date()));
            monsters.add(new Monster(2,"牛魔王2","芭蕉扇",200,2000.0,new Date()));
            monsters.add(new Monster(3,"牛魔王3","芭蕉扇",200,2000.0,new Date()));
            monsters.add(new Monster(4,"牛魔王4","芭蕉扇",200,2000.0,new Date()));
            model.addAttribute("monsters",monsters);
            return "manage";//这里是视图解析器到/templates/manage.html
//        }else{
//            //返回登录页面 给出提示 暂时使用再方法验证 后面使用拦截器验证
//            model.addAttribute("msg","请先登录");
//            return "adminLogin";
//        }
    }

}
