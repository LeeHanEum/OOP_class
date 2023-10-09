package OOP_todoList;

import OOP_todoList.Controller.TodoController;

public class TodoListApplication {

    public static void main(String[] args) {
        System.out.println("투두리스트 프로그램 시작");
        TodoController todoController = TodoController.getInstance();
        assert todoController != null;
        todoController.run();
    }
}
