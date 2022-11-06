package behavioral.chain_of_responsibility.demo02;

import java.util.Map;

public interface Chain {
    void setNext(Chain next);
    void handler(Map<String, String> request);
}
