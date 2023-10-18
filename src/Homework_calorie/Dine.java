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

		eatMgr.readAll("src/Homework_calorie/input/eats_input.txt", new Eat());
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
