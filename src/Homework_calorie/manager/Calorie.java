package Homework_calorie.manager;

import Homework_calorie.Dine;

import java.util.Scanner;

public interface Calorie {

    Calorie create();

    void read(Scanner scan);

    int getKcal();

}
