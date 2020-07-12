package com.springboot.exercise.controllers;

import com.springboot.exercise.dtos.UserDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class registrationController {

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto,
                                            BindingResult result, WebRequest request, Errors errors) {
//        User registered = new User();
//        if (!result.hasErrors()) {
//            registered = createUserAccount(accountDto, result);
//        }
//        if (registered == null) {
//            result.rejectValue("email", "message.regError");
//        }
        return null;
    }

//    private User createUserAccount(UserDto accountDto, BindingResult result) {
//        User registered = null;
//        try {
//            registered = service.registerNewUserAccount(accountDto);
//        } catch (EmailExistsException e) {
//            return null;
//        }
//        return registered;
//    }

    // To validate
//    public ModelAndView registerUserAccount(
//            @ModelAttribute("user") @Valid UserDto accountDto,
//            BindingResult result, WebRequest request, Errors errors) {
//    ...
//    }
}
