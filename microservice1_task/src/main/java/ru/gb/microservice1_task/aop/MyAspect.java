package ru.gb.microservice1_task.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ru.gb.microservice1_task.model.Task;
import ru.gb.microservice1_task.util.CustomResponse;
import ru.gb.microservice1_task.util.CustomStatus;

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Around("Pointcuts.allAddMethods()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Task task = null;

        if (methodSignature.getName().equals("addTask")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof Task) {
                    task = (Task) arg;
                    log.info("Попытка добавить задачу {}", task.getName());
                }
            }
        }

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        log.info("Заача {} добавлена", task.getName());
        return result;
    }

    @Around("Pointcuts.allGetMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String name = null;

        if (methodSignature.getName().equals("getAll")) {
            log.info("Попытка получить список всех заачь");
        } else if (methodSignature.getName().equals("getById")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof String) {
                    name = (String) arg;
                    log.info("Пытаемся получить задачу {}", name);
                }
            }
        } /*else if (methodSignature.getName().equals("getByStatus")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof String) {
                    name = (String) arg;
                    log.info("Пытаемся получить заачи со статусом {}", name);
                }
            }
        }*/ 

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        if (methodSignature.getName().equals("getAll")) {
            log.info("Список заач получен");
        } else if (methodSignature.getName().equals("getById")) {
            log.info("Книга с названием {} получена", name);
        } /*else if (methodSignature.getName().equals("getByStatus")) {
            log.info("Книга с названием {} получена", name);
        }*/

        return result;
    }
}
