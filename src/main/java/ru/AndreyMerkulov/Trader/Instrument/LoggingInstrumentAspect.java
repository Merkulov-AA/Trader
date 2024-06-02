package ru.AndreyMerkulov.Trader.Instrument;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
@Slf4j
public class LoggingInstrumentAspect {


    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().toString());
        System.out.println(joinPoint.getSignature());
        for (Object arg : args) {
            log.info(arg.toString());
        }
    }
}
