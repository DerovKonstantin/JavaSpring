package ru.geekbrains.homework_sem4.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.geekbrains.homework_sem4.model.User;
import ru.geekbrains.homework_sem4.service.UserService;

/* 
    2. Добавление Thymeleaf в проект
	Добавьте Thymeleaf в свое веб-приложение Spring MVC. Создайте простую страницу с некоторыми переменными, 
    которые заполняются с помощью модели Spring MVC и отображаются на странице с использованием Thymeleaf.
*/

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    // Добавление пользователя через переменную пути - http://localhost:8080/user-create/Konstantin/Pavlovich
    @GetMapping("/user-create/{firstName}/{lastName}")
    public String createUserFromPathVariable(@PathVariable(name = "firstName") String firstName, @PathVariable(name = "lastName") String lastName) {
        userService.saveUser(firstName, lastName);
        return "redirect:/users";
    }

    // Добавление пользователя через запрос параметров - http://localhost:8080/user-create/?firstName=Kos&lastName=Der
    @GetMapping("/user-create/")
    public String createUserFromRequestParam(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        userService.saveUser(firstName, lastName);
        return "redirect:/users";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String getOne(@PathVariable("id") int id, Model model) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
