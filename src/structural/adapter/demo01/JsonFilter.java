package structural.adapter.demo01;

public interface JsonFilter { // Target
    String allToJson();
    String findByNameToJson(String id);
}