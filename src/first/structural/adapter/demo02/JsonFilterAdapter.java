package first.structural.adapter.demo02;

import com.google.gson.Gson;

import java.util.List;

public class JsonFilterAdapter extends FilterImpl implements JsonFilter { // Adapter
    public JsonFilterAdapter(List<User> users) {
        super(users);
    }
    public String allToJson() {
        List<User> users = super.findAll();
        return new Gson().toJson(users);
    }
    public String findByNameToJson(String name) {
        User user = super.findByName(name);
        return new Gson().toJson(user);
    }
}