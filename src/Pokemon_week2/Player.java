package Pokemon_week2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    String name;
    List<Pokemon> own_Pokemon = new ArrayList<>();

    Player read(Scanner scan, String name, Game game) {
        this.name = name;
        int id;
        for (int i = 0; i < 5; i++) {
            id = scan.nextInt();
            if (id == 0)
                break;
            own_Pokemon.add(game.findById(id));
        }

        return this;
    }

    void print() {
        System.out.print(name + " : ");
        for (Pokemon pk : own_Pokemon) {
            System.out.print(pk.name + " ");
        }
        System.out.println();
    }

    boolean matches(String kwd) {
        for(Pokemon pk : own_Pokemon){
            if(pk.matches(kwd))
                return true;
        }
        return false;
    }

}