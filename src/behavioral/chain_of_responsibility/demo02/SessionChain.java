package behavioral.chain_of_responsibility.demo02;

import java.util.Map;

public class SessionChain extends AbstractChain {
    @Override
    public void handler(Map<String, String> request) {
        System.out.println("缓存用户信息至Session。");
        Chain next = this.getNext();
        if (next == null) {
            throw new RuntimeException("处理中断!");
        }
        next.handler(request);
    }
}
