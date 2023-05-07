package domain;

import org.aspectj.lang.annotation.*;

import java.security.SecureRandom;

@Aspect
public class CriticismEngine {

    //injected by setter
    private String[] criticismPool;
    private SecureRandom random = new SecureRandom();

    @Pointcut("execution(* *.perform(..))")
    private void performance() {
    }

    @After("performance()")
    public void critiquePerformance() {
        int i = random.nextInt(criticismPool.length);
        String criticism = criticismPool[i];
        System.out.println(criticism);
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
