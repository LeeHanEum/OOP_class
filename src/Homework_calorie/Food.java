package Homework_calorie;

import Homework_calorie.manager.Calorie;

import java.util.Scanner;

public class Food implements Calorie {
	static int serialNo=0;
	int id;
	String type;
	String name;
	String unit;
	double cal;

	@Override
	public Calorie create(Scanner scanner) {
		int check = scanner.nextInt();
		switch (check) {
			case 1:
				return new Food();
			case 2:
				return new FoodWeight();
			default:
				return null;
		}
	}

	@Override
	public void read(Scanner scan) {
		id = ++serialNo;
		type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
	}
	@Override
	public String toString() {
		return String.format("[%2d] %s-%s (%dkcal/%s)", id, type, name, (int)cal, unit);
	}
	@Override
	public double getKcal(int n) {
		return cal;
	}
	String getDetail(int n, String unit) {
		return String.format("%dkcal/%d%s", (int)cal, 1, this.unit);
	}


}