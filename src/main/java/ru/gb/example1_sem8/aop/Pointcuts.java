package ru.gb.example1_sem8.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.gb.example1_sem8.service.BookService.get*(..))")
    public void allGetMethods() {} // Исполнение в слчае срабатывания метода с любым модификатором доступа, 
    // любым возвращямым типом который находится в пакете (ru.gb.example1_sem8.service.BookService) 
    // начинается этот метод на get и принимает любое колличество аргументов

    @Pointcut("execution(* ru.gb.example1_sem8.service.BookService.add*(..))")
    public void allAddMethods() {} // реагирует на все методы начинающиеся на add
}
