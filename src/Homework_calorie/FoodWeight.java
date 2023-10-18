package Homework_calorie;

import Homework_calorie.manager.Calorie;

import java.util.Scanner;

public class FoodWeight extends Food {

    double weight;
    String wUnit;

    @Override
    public void read(Scanner scan) {
        super.read(scan);
        this.weight = scan.nextInt();
        this.wUnit = scan.next();
    }

    @Override
    public String toString() {
        return String.format("[%2d] %s-%s (%dkcal/%s) %d%s", id, type, name, (int)cal, unit, (int)weight, wUnit);
    }

    @Override
    public double getKcal(int n) {
        if (weight == n*weight) {
            return cal;
        }else{
            return cal/weight;
        }
    }

    @Override
    public String getDetail(int n, String unit) {
        if (weight == n*weight){
            return super.getDetail(n, unit);
        }else {
               return super.getDetail(n, unit)
                       + String.format("-> %dKcal*%d/%d%s = %dkcal", (int)cal, n, (int)weight, wUnit, (int)(cal*n/weight));

        }
    }

}
