package Homework_calorie;

import Homework_calorie.manager.Manager;


public class CalorieMgr extends Manager {

    static Manager foodMgr = new Manager();
    static Manager dineMgr = new Manager();

    public static void main(String[] args) {
        new CalorieMgr().run();
    }

    void run() {
        foodMgr.readAll("src/Homework_calorie/input/food.txt");
        foodMgr.printAll();
        System.out.println();
        dineMgr.readAll("src/Homework_calorie/input/eats_input.txt");
        dineMgr.printAll();
    }

}