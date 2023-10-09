package OOP_todoList.Service;

import OOP_todoList.Entity.Todo;
import OOP_todoList.Repository.TodoMemoryRepository;

import java.util.List;
import java.util.Optional;

public class TodoService {

    private final TodoMemoryRepository todoMemoryRepository;

    private static TodoService instance;

    public TodoService() {
        todoMemoryRepository = TodoMemoryRepository.getInstance();
    }

    public static TodoService getInstance() {
        if(instance == null) {
            instance = new TodoService();
        }
        return instance;
    }

    public void readTodoList() {
        try {
            List<Todo> todoList = todoMemoryRepository.findAll();
            if(todoList.size() == 0) {
                System.out.println("할 일이 없습니다.");
                return;
            }
            for (Todo todo : todoList) {
                System.out.println(todo.getId() + ". " + todo.getText() + " (" + todo.getDone() + ")");
            }

        } catch (Exception e) {
            System.out.println("불러오는데 실패했습니다.");
        }
    }

    public Todo findOneTodo(Long id) {
        Optional<Todo> optionalTodo = todoMemoryRepository.findById(id);

        if(!optionalTodo.isPresent()) {
            System.out.println("존재하지 않는 할 일입니다.");
            return null;
        }
        return optionalTodo.get();
    }

    public void createTodoList(String text) {

        Todo todo = new Todo(text, false);
        try {
            todoMemoryRepository.save(todo);
            System.out.println(todo.getText() + " 이(가) 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("저장하는데 실패했습니다.");
        }
    }

    public void updateTodoList(Todo todo, boolean status) {

        todo.setDone(status);
        try {
            todoMemoryRepository.save(todo);
        }catch (Exception e) {
            System.out.println("수정하는데 실패했습니다.");
        }
        System.out.println(todo.getText() + " 이(가)" + todo.getDone() + "로 수정되었습니다.");
    }

    public void deleteTodoList(Long id) {

        Optional<Todo> optionalTodo = todoMemoryRepository.findById(id);

        if(!optionalTodo.isPresent()) {
            System.out.println("존재하지 않는 할 일입니다.");
            return;
        }

        todoMemoryRepository.delete(id);
        System.out.println(optionalTodo.get().getText() + " 이(가) 삭제되었습니다.");

        List<Todo> todoList = todoMemoryRepository.findAll();
        for (Todo todo : todoList) {
            if(todo.getId() > id) {
                todo.setId(todo.getId() - 1);
            }
        }

    }
}
