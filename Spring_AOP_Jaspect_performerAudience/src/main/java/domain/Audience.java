package domain;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

  @Pointcut("execution(* *.perform(..))")
  private void performance(){}

  @Before("performance()")
  public void takeSeats() {
    System.out.println("The audience is taking their seats.");
  }

  @Before("performance()")
  public void turnOffCellPhones() {
    System.out.println("The audience is turning off their cellphones");
  }

  @AfterReturning("performance()")
  public void applaud() {
    System.out.println("CLAP CLAP CLAP CLAP CLAP");
  }

  @AfterThrowing("performance()")
  public void demandRefund() {
    System.out.println("Boo! We want our money back!");
  }


  //Around Advices: example
  //-----------------------
/*
   @Around("execution(* *.perform(..))")
   public void watchPerformance(ProceedingJoinPoint joinpoint)
  {
    try
    {System.out.println("The audience is taking their seats.");
    System.out.println("The audience is turning off their cellphones");

    long start = System.currentTimeMillis();

    joinpoint.proceed();
    Thread.sleep(new Random().nextInt(2000));
    long end = System.currentTimeMillis();

    System.out.println("CLAP CLAP CLAP CLAP CLAP");
    System.out.println("The performance took " + (end-start) + " milliseconds.");
    }
    catch(Throwable e)
    {
    System.out.println("Boo! We want our money back!");
    }
  }

  */

  }