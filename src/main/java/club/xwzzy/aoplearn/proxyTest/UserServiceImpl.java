package club.xwzzy.aoplearn.proxyTest;

/**
 * @author by yangliu@tiduyun.com
 * @Description say something
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("this is add method");
    }
}
