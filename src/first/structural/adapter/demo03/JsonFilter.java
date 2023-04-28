package first.structural.adapter.demo03;

public interface JsonFilter { // Target
    String allToJson();
    String findByNameToJson(String id);
}