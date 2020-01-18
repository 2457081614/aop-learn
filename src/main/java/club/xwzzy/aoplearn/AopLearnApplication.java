package club.xwzzy.aoplearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AopLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLearnApplication.class, args);
    }

}
