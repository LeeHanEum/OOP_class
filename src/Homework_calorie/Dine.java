package Homework_calorie;

import Homework_calorie.manager.Calorie;
import Homework_calorie.manager.Manager;

import java.util.Scanner;

public class Dine extends Manager implements Calorie {

	Manager eatMgr = new Manager();

	int month;
	int day;
	String eatType;
	int totalCal;

	@Override
	public Calorie create(Scanner scanner) {
		return new Dine();
	}

	@Override
	public void read(Scanner scan) {
		this.month = scan.nextInt();
		this.day = scan.nextInt();
		this.eatType = scan.next();
		int cc = scan.nextInt();

		for (int i = 0; i < cc; i++) {
			Eat eat = new Eat();
			eat.read(scan);
			eatMgr.cList.add(eat);
		}
	}

	@Override
	public String toString() {
		String result = String.format("%d/%d %s 총칼로리: %dkcal\n", month, day, eatType, (int)getKcal(1));

		for (Calorie c : eatMgr.cList) {
			result += c.toString() + "\n";
		}

		return result;
	}

	@Override
	public double getKcal(int n) {
		for (Calorie c : eatMgr.cList) {
			totalCal += c.getKcal(n);
		}
		return totalCal;
	}


}
