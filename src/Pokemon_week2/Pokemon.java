package Pokemon_week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pokemon {
    int id;
    String name;
    int attack;
    int defense;
    int HP;
    List<String> typeList = new ArrayList<>();



    Pokemon read(Scanner scan, int id) {
        this.id = id;
        name = scan.next();
        attack = scan.nextInt();
        defense = scan.nextInt();
        HP = scan.nextInt();

        String type = null;
        while(true) {
            type = scan.next();
            if (type.equals("0")) break;
            typeList.add(type);
        }
        return this;
    }


    void print() {
        System.out.format("[%d] %s 공격력[%d] 방어력[%d] 체력[%d]",
                id, name, attack, defense, HP);

        for (String s : typeList)
            System.out.print(" "+s);
        System.out.println();

//        if (myTeam != null)
//            System.out.printf("[%s]", myTeam.name);
//        System.out.println();
    }

    boolean matches(String kwd) {
        if (name.contains(kwd))
            return true;
        for (String type : typeList){
            if(type.contains(kwd))
                return true;
        }
        return false;
    }



}