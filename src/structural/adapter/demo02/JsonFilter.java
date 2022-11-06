package structural.adapter.demo02;

public interface JsonFilter { // Target
    String allToJson();
    String findByNameToJson(String id);
}