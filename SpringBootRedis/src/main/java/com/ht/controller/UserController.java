package com.ht.controller;

import com.ht.pojo.User;
import com.ht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//https://www.jianshu.com/p/c2444ddd2de9
import javax.annotation.Resource;
import java.util.List;

@Controller
//@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userlist")
    public ModelAndView list(){

        List<User> userList=userService.getUserAll();
        ModelAndView model=new ModelAndView("list");
        model.addObject("userList",userList);
        return model;
    }
    @RequestMapping("userAdd")
    public String add(User user){
        userService.addUser(user);
        return "redirect:userlist";
    }
    @RequestMapping("/openAdd")
    public String openAdd(){
        return "addUser";
    }
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer id){
        userService.delete(id);
        return "redirect:userlist";
    }
    @RequestMapping("getById")
    public ModelAndView getById(@RequestParam("id") Integer id){
        User user=userService.selectUser(id);
        ModelAndView model=new ModelAndView("update");
        model.addObject("user",user);
        return model;
    }
    @RequestMapping("update")
    public  String update(User user){
        userService.update(user);
        return "redirect:userlist";
    }
}
