package wnsdud_week4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Lecture> lectureList = new ArrayList<>();

	void run() {
		readAllLecture();
		readAll();
		printAllLecture();
		printAll();
		//search();
	}

	void readAllLecture()
	{
		Scanner filein = openFile("src/wnsdud_week4/week4_input.txt");
		Lecture lec = null;
		int type;
		while (filein.hasNext()) {
			type = filein.nextInt();
			switch (type) {
				case 1:
					lec = new Lecture();
					break;
				case 2:
					lec = new ELecture();
					break;
				default :
					break;
			}
			if (type == 0) break;
			lec.read(filein);
			lectureList.add(lec);
		}
		filein.close();
	}

	void printAllLecture() {
		for (Lecture lec : lectureList)
			lec.print();
	}


	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.printf("파일 오픈 실패: %s\n", filename);
			System.exit(0);
		}
		return filein;
	}

	void readAll() {
		Scanner filein = openFile("src/wnsdud_week4/week4_input.txt");
		Student st = null;

		while (filein.hasNextLine()){
			String line = filein.nextLine();
			if (line.equals("0")) break;
		}

		while(true){
			int id = filein.nextInt();
			if (id == 0) break;
			st = new Student(id);
			st.read(filein, this);
			studentList.add(st);
		}
		filein.close();
	}

	void printAll() {
		for (Student st : studentList) {
			st.print();
		}
	}

	void search() {
		String line = null;
		String[] kwdArr;
		scan.nextLine();
		while (true) {
			System.out.print("키워드(통합검색, -면 제외) : ");
			line = scan.nextLine();
			if (line.equals("end"))
				break;
			kwdArr = line.trim().split(" ");
			for (Student st : studentList) {
				if (st.matches(kwdArr))
					st.print();
			}
		}
	}

	public Lecture findLecture(String code) {
		for (Lecture lec : lectureList) {
			if(lec.matches(code))
				return lec;
		}
		return null;
	}

	public static void main(String args[]) {
		Department my = new Department();
		my.run();
	}
}