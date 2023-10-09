package OOP_todoList.Repository;

import OOP_todoList.Entity.Todo;

import java.util.*;

public class TodoMemoryRepository {

    private static Map<Long, Todo> store = new HashMap<>();

    private static TodoMemoryRepository instance;

    private static long sequence = 0L;

    public static TodoMemoryRepository getInstance() {
        if(instance == null) {
            instance = new TodoMemoryRepository();
        }
        return instance;
    }

    public Todo save(Todo todo) {

        if(store.containsKey(todo.getId())) {
            store.replace(todo.getId(), todo);
            return todo;
        }
        todo.setId(++sequence);
        store.put(todo.getId(), todo);
        return todo;
    }

    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public void delete(Long id) {
        store.remove(id);
    }

}
