package Homework_calorie.manager;


import Homework_calorie.CalorieMgr;
import Homework_calorie.Dine;
import Homework_calorie.Food;
import Homework_calorie.FoodWeight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public ArrayList<Calorie> cList = new ArrayList<>();

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e)
        {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }

    public void readAll(String fileName){
        Scanner fileIn = openFile(fileName);
        while (fileIn.hasNext()) {
            Calorie calorie;
            int type = fileIn.nextInt();
            switch (type) {
                case 1 : calorie = new Food(); break;
                case 2 : calorie = new FoodWeight(); break;
                default: calorie = new Dine(type); break;
            }
            calorie.read(fileIn);
            cList.add(calorie);
        }
        fileIn.close();
    }

    public void printAll() {
        for (Calorie c : cList)
            System.out.println(c);
    }

    public Calorie find(String name) {
        for (Calorie c : cList) {
            if (c.toString().contains(name))
                return c;
        }
        return null;
    }

}
