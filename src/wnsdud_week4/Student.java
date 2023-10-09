package wnsdud_week4;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	String phone;
	int year;
	ArrayList<Lecture> registerList = new ArrayList<>();


	public Student(int id) {
		this.id = id;
	}

	void read(Scanner scan, Department department) {
//		id = scan.nextInt();
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String code = null;
		Lecture lec = null;
		while (true) {
			code = scan.next();
			if (code.contentEquals("0"))
				break;
			lec = department.findLecture(code);
			registerList.add(lec);		}
	}

	void print() { // Student
		System.out.format("%d %s %s (%d학년)\n",	id, name, phone, year);
		System.out.println();
		for (Lecture mylec: registerList) {
			System.out.print("\t");
			mylec.print();
		}
	}

	boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.length() >= 4 && phone.contains(kwd))
			return true;
		if (kwd.contentEquals(""+year))
			return true;
		return (kwd.length() > 4 && (""+id).contains(kwd));
	}

	boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if (kwd.charAt(0) == '-') {
				if(matches(kwd.substring(1)))
					return false;
			}
			else if (!matches(kwd))
				return false;
		}
		return true;
	}

}