package org.surkov.myexperiments.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

  /*
    Обработчик вызовов методов get()
   */
  @Pointcut("execution(* org.surkov.myexperiments.services.CustomerService.get*(..))")
  public void allGetMethods() {
  }

  /*
    Обработчик вызовов методов add()
   */
  @Pointcut("execution(* org.surkov.myexperiments.services.CustomerService.add*(..))")
  public void allAddMethods() {
  }

  /*
    Обработчик вызовов методов put()
   */
  @Pointcut("execution(* org.surkov.myexperiments.services.CustomerService.put*(..))")
  public void allPutMethods() {
  }

  /*
    Обработчик вызовов методов delete()
   */
  @Pointcut("execution(* org.surkov.myexperiments.services.CustomerService.delete*(..))")
  public void allDeleteMethods() {
  }
}
