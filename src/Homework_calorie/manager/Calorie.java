package Homework_calorie.manager;

import Homework_calorie.Dine;

import java.util.Scanner;

public interface Calorie {

    Calorie create(Scanner scanner);

    void read(Scanner scan);

    double getKcal(int n);

}
