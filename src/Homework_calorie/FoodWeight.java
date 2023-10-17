package Homework_calorie;

import Homework_calorie.manager.Calorie;

import java.util.Scanner;

public class FoodWeight extends Food implements Calorie{

    int weight;
    String wUnit;

    @Override
    public void read(Scanner scan) {
        super.read(scan);
        this.weight = scan.nextInt();
        this.wUnit = scan.next();
    }

    @Override
    public Calorie create() {
        return new FoodWeight();
    }

    @Override
    public String toString() {
        return String.format("[%2d] %s-%s (%dkcal/%s) %d%s", id, type, name, cal, unit, weight, wUnit);
    }

    @Override
    public int getKcal() {
        return super.getKcal() / weight;
    }

    @Override
    String getDetail(int n, String unit) {
        return super.getDetail(n, unit);
    }
}
