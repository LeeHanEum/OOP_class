package PP_todoList;

import java.util.ArrayList;
import java.util.Scanner;

public class PPtodoList {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("절차 지향적으로 작성한 투두 리스트 프로그램");

        while (true) {
            System.out.println("1. 투두 리스트 보기");
            System.out.println("2. 투두 리스트 추가");
            System.out.println("3. 투두 리스트 삭제");
            System.out.println("4. 투두 리스트 수정");
            System.out.println("5. 투두 리스트 종료");
            System.out.print("메뉴를 선택하세요: ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("### 투두 리스트 보기 ###");
                    if (todoList.isEmpty()) {
                        System.out.println("할 일이 없습니다.");
                    } else {
                        for (String todo : todoList) {
                            System.out.println(todo);
                        }
                    }
                    break;
                case 2:
                    System.out.println("### 투두 리스트 추가 ###");
                    System.out.print("추가할 할 일을 입력하세요: ");
                    String newTodo = scanner.nextLine();
                    todoList.add(newTodo);
                    break;
                case 3:
                    System.out.println("### 투두 리스트 삭제 ###");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println(i + ". " + todoList.get(i));
                    }
                    System.out.print("삭제할 할 일의 번호를 입력하세요: ");
                    int indexToRemove = Integer.parseInt(scanner.nextLine());
                    if (indexToRemove >= 0 && indexToRemove < todoList.size()) {
                        todoList.remove(indexToRemove);
                    } else {
                        System.out.println("유효하지 않은 번호입니다.");
                    }
                    break;
                case 4:
                    System.out.println("### 투두 리스트 수정 ###");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println(i + ". " + todoList.get(i));
                    }
                    System.out.print("수정할 할 일의 번호를 입력하세요: ");
                    int indexToModify = Integer.parseInt(scanner.nextLine());
                    if (indexToModify >= 0 && indexToModify < todoList.size()) {
                        System.out.print("수정할 내용을 입력하세요: ");
                        String modifiedTodo = scanner.nextLine();
                        todoList.set(indexToModify, modifiedTodo);
                    } else {
                        System.out.println("유효하지 않은 번호입니다.");
                    }
                    break;
                case 5:
                    System.out.println("### 투두 리스트 종료 ###");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("메뉴를 다시 선택하세요.");
                    break;
            }
        }
    }
}
