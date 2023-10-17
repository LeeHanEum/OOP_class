package Homework_calorie;

import Homework_calorie.manager.Calorie;
import Homework_calorie.manager.Manager;

import java.util.Scanner;

public class Dine extends Manager implements Calorie {

	static Manager eatMgr = new Manager();

	int month;
	int day;
	String eatType;
	int totalCal;

	public Dine(int month) {
		this.month = month;
	}

	@Override
	public Calorie create() {
		return new Dine(month);
	}

	@Override
	public void read(Scanner scan) {
		this.day = scan.nextInt();
		this.eatType = scan.next();

		int cc = scan.nextInt();
		Eat eat;
		for (int i = 0; i < cc; i++) {
			eat = new Eat();
			eat.read(scan);
			eatMgr.cList.add(eat);
			totalCal += eat.getKcal();
		}
	}

	public void print() {
		System.out.printf("%d/%d %s ", month, day, eatType);
		System.out.printf("총칼로리: %dkcal\n", totalCal);
		for (Calorie c : eatMgr.cList) {
			System.out.println(c);
		}
	}

	@Override
	public String toString() {
		String result = String.format("%d/%d %s 총칼로리: %dkcal\n", month, day, eatType, totalCal);

		for (Calorie c : eatMgr.cList) {
			result += c.toString() + "\n";
		}

		return result;
	}


	@Override
	public int getKcal() {
		return totalCal;
	}

}
