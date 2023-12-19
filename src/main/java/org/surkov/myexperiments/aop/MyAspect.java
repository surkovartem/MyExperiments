package org.surkov.myexperiments.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.surkov.myexperiments.entity.Customer;
import org.surkov.myexperiments.utils.CustomResponse;
import org.surkov.myexperiments.utils.CustomStatus;

import java.util.NoSuchElementException;

@Component
@Aspect
@Slf4j
public class MyAspect {

  @Around("PointCuts.allAddMethods()")
  public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Customer customer = null;

    if (methodSignature.getName().equals("addCustomer")) {
      Object[] arguments = joinPoint.getArgs();
      for (Object arg : arguments) {
        if (arg instanceof Customer) {
          customer = (Customer) arg;
          log.info("Попытка добавить customer {}", customer);
        }
      }
    }

    Object result = null;
    try {
      result = joinPoint.proceed();
    } catch (Throwable e) {
      log.error(e.getMessage(), e);
      result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
    }

    log.info("Customer {} добавлен", customer);
    return result;
  }

  @Around("PointCuts.allPutMethods()")
  public Object aroundPutAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Customer customer = null;

    if (methodSignature.getName().equals("putCustomer")) {
      Object[] arguments = joinPoint.getArgs();
      for (Object arg : arguments) {
        if (arg instanceof Customer) {
          customer = (Customer) arg;
          log.info("Попытка обновить customer {}", customer);
        }
      }
    }

    Object result = null;
    try {
      result = joinPoint.proceed();
    } catch (Throwable e) {
      log.error(e.getMessage(), e);
      result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
    }

    log.info("Customer {} обновлен", customer);
    return result;
  }

  @Around("PointCuts.allGetMethods()")
  public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Long id = null;

    if (methodSignature.getName().equals("getAllCustomers")) {
      log.info("Попытка получить всех сustomers.");
    } else if (methodSignature.getName().equals("getCustomerById")) {
      Object[] arguments = joinPoint.getArgs();
      for (Object arg : arguments) {
        if (arg instanceof Long) {
          id = (Long) arg;
          log.info("Попытка получить customer с id {}", id);
        }
      }
    }

    Object result;
    try {
      result = joinPoint.proceed();
    } catch (NoSuchElementException e) {
      log.error(e.getMessage(), e);
      return new CustomResponse<>(null, CustomStatus.NOT_FOUND);
    } catch (Throwable e) {
      log.error(e.getMessage(), e);
      return new CustomResponse<>(null, CustomStatus.EXCEPTION);
    }

    if (methodSignature.getName().equals("getAllCustomers")) {
      log.info("Все customers получены.");
    } else if (methodSignature.getName().equals("getCustomerById")) {
      log.info("Customer с id {} получен.", id);
    }

    return result;
  }

  @Around("PointCuts.allDeleteMethods()")
  public Object aroundDelateAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Long id = null;

    if (methodSignature.getName().equals("deleteAllCustomers")) {
      log.info("Попытка удалить всех сustomers.");
    } else if (methodSignature.getName().equals("deleteCustomerById")) {
      Object[] arguments = joinPoint.getArgs();
      for (Object arg : arguments) {
        if (arg instanceof Long) {
          id = (Long) arg;
          log.info("Попытка удалить customer с id {}", id);
        }
      }
    }

    Object result;
    try {
      result = joinPoint.proceed();
    } catch (Throwable e) {
      log.error(e.getMessage(), e);
      return new CustomResponse<>(null, CustomStatus.EXCEPTION);
    }

    if (methodSignature.getName().equals("deleteAllCustomers")) {
      log.info("Все customers удалены.");
    } else if (methodSignature.getName().equals("deleteCustomerById")) {
      log.info("Customer с id {} удален.", id);
    }

    return result;
  }
}
