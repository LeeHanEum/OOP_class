package Homework_calorie;

import Homework_calorie.manager.Calorie;
import Homework_calorie.manager.Manager;

import java.util.ArrayList;
import java.util.Scanner;

public class Eat implements Calorie{
	Food food;
	int quantity;
	String unit;
	double kcal;

	@Override
	public String toString() {
		return String.format("%s %d%s(%dkcal) - %s",
				food.name, quantity, unit, (int)food.cal, food.getDetail(quantity, unit));
	}
	@Override
	public Calorie create(Scanner scanner) {
		return new Eat();
	}

	@Override
	public void read(Scanner scan) {
		String name = scan.next();
		food = (Food)CalorieMgr.foodMgr.find(name);
		quantity = scan.nextInt();
		kcal = food.cal;
		unit = scan.next();
	}

	@Override
	public double getKcal(int n) {
		return food.getKcal(quantity)*quantity;
	}

}