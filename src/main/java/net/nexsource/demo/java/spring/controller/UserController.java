package net.nexsource.demo.java.spring.controller;

import net.nexsource.demo.java.spring.model.User;
import net.nexsource.demo.java.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

	    List<User> list = userService.findAll();
        model.addAttribute("userList", list);

        User user = new User();
        model.addAttribute("userForm", user);

		return "register";
	}

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("userForm") User user,
                           BindingResult result, Model model) {


        userService.register(user);

        model.addAttribute("userModel", user);
        model.addAttribute("userForm", null);
        System.out.println(  result );


        return "register";
    }

}