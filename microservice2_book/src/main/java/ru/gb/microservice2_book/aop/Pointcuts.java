package ru.gb.microservice2_book.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.gb.example1_sem8.service.BookService.get*(..))")
    public void allGetMethods() {}

    @Pointcut("execution(* ru.gb.example1_sem8.service.BookService.add*(..))")
    public void allAddMethods() {}
}

