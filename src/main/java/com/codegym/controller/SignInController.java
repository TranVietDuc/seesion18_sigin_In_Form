package com.codegym.controller;

import com.codegym.model.SignIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignInController {

    @GetMapping("/")
    public ModelAndView showSignInForm(){
        ModelAndView modelAndView =new ModelAndView("index");
        modelAndView.addObject("signin",new SignIn());
        return modelAndView;
    }

    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("signin") SignIn signIn, BindingResult bindingResult, Model model){
        new SignIn().validate(signIn,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "index";
        }
        else {
            model.addAttribute("signin",signIn);
            return "result";

        }
    }
}
