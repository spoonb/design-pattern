package behavioral.chain_of_responsibility.demo02;

import java.util.Map;

public class ProcessChain extends AbstractChain {
    @Override
    public void handler(Map<String, String> request) {
        System.out.println("正在处理请求的业务。");
    }
}
