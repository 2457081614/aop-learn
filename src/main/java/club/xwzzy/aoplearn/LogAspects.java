package club.xwzzy.aoplearn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author by yangliu@tiduyun.com
 * @Description say something
 */
@Aspect
@Component
public class LogAspects {

    // 抽取公共的切⼊点表达式
    // 1、本类引⽤
    // 2、其他的切⾯引⽤

    /**
     * execution表达式详解
     * execution(* com.sample.service.impl..*.*(..))
     *
     * execution()，表达式的主体
     * 第一个“*”符号，表示返回值类型任意；
     * com.sample.service.impl，AOP所切的服务的包名，即我们的业务部分
     * 包名后面的“..”，表示当前包及子包
     * 第二个“*”，表示类名，*即所有类
     * .*(..)，表示任何方法名，括号表示参数，两个点表示任何参数类型
     *
     */
    @Pointcut("execution(public * club.xwzzy.aoplearn.AopController.*(..)))")
    public void pointCut() {
    }

    // @Before在⽬标⽅法之前切⼊；切⼊点表达式（指定在哪个⽅法切⼊）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运⾏。。。 @Before:参数列表是：{" + Arrays.asList(args) + "}");

    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "结束。。。 @After");

    }
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "正常返回。。@AfterReturning:运⾏结果：{" + result + "}");

    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "异常。。。异常信息：{" + exception + "}");

    }
}
