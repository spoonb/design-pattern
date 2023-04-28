package first.behavioral.memento.demo02;

import com.google.gson.Gson;

public class Memento<T> {

    private T snapshot;

    public Memento(T snapshot) {
        Gson gson = new Gson();
        this.snapshot = (T) gson.fromJson(gson.toJson(snapshot), snapshot.getClass());
    }

    public T getSnapshot() {
        return snapshot;
    }
}
