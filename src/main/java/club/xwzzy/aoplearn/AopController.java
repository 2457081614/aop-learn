package club.xwzzy.aoplearn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by yangliu@tiduyun.com
 * @Description say something
 */
@RestController
@RequestMapping("/")
public class AopController {



    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("调用了测试方法");
    }
}
