package structural.adapter.demo01;

import java.util.List;

public interface Filter {
    List<User> findAll();
    User findByName(String name);
}