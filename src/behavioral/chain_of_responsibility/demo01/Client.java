package behavioral.chain_of_responsibility.demo01;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Map<String, String> request = new HashMap<>();
        request.put("username", "admin");
        request.put("password", "admin");
        service(request);
    }
    public static void service(Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        if (!"admin".equals(username) || !"admin".equals(password)) {
            throw new RuntimeException("用户名或密码不正确！");
        }
        System.out.println("用户认证通过。");
        System.out.println("缓存用户信息至Session。");
        System.out.println("正在处理请求的业务。");
    }
}
