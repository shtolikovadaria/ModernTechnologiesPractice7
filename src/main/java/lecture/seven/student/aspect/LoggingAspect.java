package lecture.seven.student.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* lecture.seven.student.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // ЗАДАНИЕ part6_2: записывайте в лог метод service перед выполнением.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        log.info(">>> {}", joinPoint.getSignature().toShortString());
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    @AfterReturning(pointcut = "execution(* lecture.seven.student.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        // ЗАДАНИЕ part6_2: записывайте в лог имя метода и возвращаемое значение.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        log.info("<<< {} => {}", joinPoint.getSignature().getName(), result);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}
