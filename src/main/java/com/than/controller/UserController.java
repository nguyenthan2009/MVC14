package com.than.controller;

import com.than.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/error");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/error");
        }
        return new ModelAndView("/result");
    }


}
