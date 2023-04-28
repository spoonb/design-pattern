package first.behavioral.chain_of_responsibility.demo02;

import java.util.Map;

public class AuthChain extends AbstractChain {
    @Override
    public void handler(Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        if (!"admin".equals(username) || !"admin".equals(password)) {
            throw new RuntimeException("用户名或密码不正确！");
        }
        System.out.println("用户认证通过。");
        Chain next = this.getNext();
        if (next == null) {
            throw new RuntimeException("处理中断!");
        }
        next.handler(request);
    }
}
