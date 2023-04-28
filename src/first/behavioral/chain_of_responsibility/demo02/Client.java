package first.behavioral.chain_of_responsibility.demo02;

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
        Chain auth = new AuthChain();
        Chain session = new SessionChain();
        Chain process = new ProcessChain();
        auth.setNext(session);
        session.setNext(process);
        auth.handler(request);
    }
}
