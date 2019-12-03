package ru.its67.fcrm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.its67.fcrm.domain.User;
import ru.its67.fcrm.service.UserService;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {

        if (user.getPassword() != null && !user.getPassword().equals(user.getPassword2())) {
            model.getAttribute("passwordError");
        }


        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }


        return "redirect:/login";
    }

    private void getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage);
        Map<String, String> errorsMap = bindingResult.getFieldErrors().stream()
                .collect(collector);
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Пользователь активирован!");
        } else {
            model.addAttribute("message", "Код активации не найден!");
        }

        return "login";
    }
}
