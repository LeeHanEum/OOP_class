package Homework_calorie;

import Homework_calorie.manager.Calorie;

import java.util.Scanner;

public class Food implements Calorie {
	static int serialNo=0;
	int id;
	String type;
	String name;
	String unit;
	int cal;

	@Override
	public Calorie create() {
		return new Food();
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
		return String.format("[%2d] %s-%s (%dkcal/%s)", id, type, name, cal, unit);
	}
	@Override
	public int getKcal() {
		return cal;
	}
	String getDetail(int n, String unit) {
		return String.format("%dkcal/%d%s", cal, 1, this.unit);
	}
}