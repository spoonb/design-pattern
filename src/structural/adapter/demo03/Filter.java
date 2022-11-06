package structural.adapter.demo03;

import java.util.List;

public interface Filter {
    List<User> findAll();
    User findByName(String name);
}