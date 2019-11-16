package sda.mvc.Twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.mvc.Twitter.model.dto.LoginUserDTO;
import sda.mvc.Twitter.model.service.LoginUserService;

import javax.validation.Valid;

@Controller
public class UserLoginController {

    @Autowired
    private LoginUserService service;

    @GetMapping("/addloginuser")
    public ModelAndView getLoginUserView() {
        return new ModelAndView("addloginuser", "loginUser", new LoginUserDTO());
    }

//    @PostMapping("/addloginuser")
//    public String addLoginUser(@ModelAttribute @Valid LoginUserDTO loginUSer, BindingResult result) {
//        service.addLoginUser(loginUSer, result);
//        return "usersavedsuccess";
//    }
}