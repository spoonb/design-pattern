package structural.adapter.demo03;

import com.google.gson.Gson;

import java.util.List;

public class JsonFilterAdapter implements JsonFilter { // 不在继承FilterImpl
    private Filter filter; // 继承 → 聚合
    public JsonFilterAdapter(List<User> users) {
        this.filter = new FilterImpl(users);
    }
    public String allToJson() {
        List<User> users = filter.findAll();
        return new Gson().toJson(users);
    }
    public String findByNameToJson(String name) {
        User user = filter.findByName(name);
        return new Gson().toJson(user);
    }
}