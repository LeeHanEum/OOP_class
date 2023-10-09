package OOP_todoList.Controller;

import OOP_todoList.Entity.Todo;
import OOP_todoList.Service.TodoService;

import java.util.Scanner;

public class TodoController {

    private final TodoService todoService;

    private static TodoController instance;

    Scanner scanner = new Scanner(System.in);

    public TodoController(){
        todoService = TodoService.getInstance();
    }

    public static TodoController getInstance() {
        if (instance == null) {
            instance = new TodoController();
        }
        return instance;
    }

    public void run() {

        while(true){
            int menu = showMenu();
            switch (menu){
                case 1 :
                    todoService.readTodoList();
                    break;
                case 2 :
                    System.out.println("할 일을 입력해주세요.");
                    String text = scanner.nextLine();
                    todoService.createTodoList(text);
                    break;
                case 3 :
                    System.out.println("삭제할 할 일의 번호를 입력해주세요.");
                    todoService.readTodoList();
                    todoService.deleteTodoList((long) scanner.nextInt());
                    break;
                case 4 :
                    System.out.println("수정할 할 일의 번호를 입력해주세요.");
                    todoService.readTodoList();
                    Todo todo = todoService.findOneTodo((long) scanner.nextInt());
                    System.out.println("완료로 수정하시겠습니까? (완료: true, 미완료: false)");
                    todoService.updateTodoList(todo, scanner.nextBoolean());
                    break;
                case 5 :
                    System.out.println("투두리스트 프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }

        }
    }

    public int showMenu(){

        System.out.println("-----------------------------------");
        System.out.println("1. 투두 리스트 보기");
        System.out.println("2. 투두 리스트 추가");
        System.out.println("3. 투두 리스트 삭제");
        System.out.println("4. 투두 리스트 수정");
        System.out.println("5. 투두 리스트 종료");
        System.out.println();

        System.out.print("메뉴를 선택하세요: ");
        int menu = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        return menu;
    }

}
