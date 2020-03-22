package com.adelChelabi.userManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // return list of users
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("users",userService.getUsers());
        return "/index";
    }

    @RequestMapping("/newUser")
    public String showNewForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "add_new";
    }

    @RequestMapping(value = "/addNewUser" ,method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user")@Valid User user , Errors errors){
        if(errors.hasErrors()) return "add_new";

        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value="/edit/{id}")
    public ModelAndView showEditUserForm(@PathVariable(name = "id") int id){
        ModelAndView mav  = new ModelAndView("edit");
        User user = userService.getUserById(id);
        mav.addObject("user",user);
        return mav;

    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteUserById(@PathVariable(name = "id" ) int id){
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
