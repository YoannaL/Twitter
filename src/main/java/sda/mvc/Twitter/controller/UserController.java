package sda.mvc.Twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.mvc.Twitter.model.dto.UserDTO;

@Controller
public class UserControler {

    @Autowired
    private UserService service;

    @RequestMapping("/users")

    public ModelAndView userView(){
        return new ModelAndView("users", "allUsers", service.getAllUsers());
    }
    @GetMapping("/adduser")
    public ModelAndView createNewUser(){
        return new ModelAndView("adduserform", "userToInsert", new UserDTO());

    }
//    @PostMapping("/adduser")
//    public String addNewUser(@ModelAttribute UserDTO user){
//        System.out.println("Dodajemy użytkownika: " + user.getName() + " " + user.getSurname());
//        service.addUser(user);
//        return "usersavedsuccess";
//
//    }
//    @PostMapping("/deleteuser")
//    public String deleteUser (@ModelAttribute("user") UserDTO user){
//        service.deleteUser(user);
//        return "index";
    //  }
}
}
