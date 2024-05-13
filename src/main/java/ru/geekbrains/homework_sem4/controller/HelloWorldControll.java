package ru.geekbrains.homework_sem4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    1. Создание базового веб-приложения Spring MVC
	Начните с создания простого веб-приложения с использованием Spring MVC. 
    Это может быть простой сайт, который выводит "Привет, мир!" на главной странице. 
    Используйте аннотацию @Controller и @RequestMapping для маршрутизации запросов на эту страницу.
*/

@Controller
public class HelloWorldControll {
    @RequestMapping("/hello")
    public String getAbout() {
        return "hello.html";
    } 
}
