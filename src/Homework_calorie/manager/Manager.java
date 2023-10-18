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
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(filename));
        } catch (IOException e)
        {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return fileIn;
    }

    public void readAll(String fileName, Calorie calorie){
        Scanner fileIn = openFile(fileName);
        while (fileIn.hasNext()) {
            calorie = calorie.create(fileIn);
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
