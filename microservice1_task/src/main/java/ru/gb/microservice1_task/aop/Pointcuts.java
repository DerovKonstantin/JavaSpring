package ru.gb.microservice1_task.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.gb.homeword_sem9.service.TaskService.get*(..))")
    public void allGetMethods() {}

    @Pointcut("execution(* ru.gb.homeword_sem9.service.TaskService.add*(..))")
    public void allAddMethods() {}
}
