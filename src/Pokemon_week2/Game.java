package Pokemon_week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    ArrayList<Pokemon> pokemonList = new ArrayList<>();
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<Player> playerList = new ArrayList<>();
    void run() {
        readPokemonAll();
        printPokemonAll();
        readPlayerAll();
//        printPlayerAll();
        pokemon_Search();
        playerSearch();
    }


    void readPokemonAll() {
        Pokemon pk = null;
        int id;
        while (true) {
            id = scan.nextInt();
            if (id == 0)
                break;
            pk = new Pokemon();
            pk.read(scan, id);
            pokemonList.add(pk);
            scan.nextLine();
        }
    }

    private void readPlayerAll() {
        Player pl = null;
        String name;
        while(true){
            name = scan.next();
            if(name.equals("0"))
                break;
            pl = new Player();
            playerList.add(pl.read(scan, name, this));
        }
    }

    void printPlayerAll() {
        for (Player pl : playerList) {
            pl.print();
        }
    }

    void printPokemonAll() {
        for (Pokemon pk : pokemonList) {
            pk.print();
        }
    }

    Pokemon findById(int id) {
        return pokemonList.get(id-1);
    }

    void pokemon_Search() {
        String kwd = null;
        while (true) {
            System.out.println("키워드 : ");
            kwd = scan.next();
            if(kwd.equals("end"))
                break;
            for (Pokemon pk : pokemonList)
                if(pk.matches(kwd))
                    pk.print();
        }
    }

    void playerSearch(){
        String kwd = null;
        while(true){
            System.out.println("키워드 : ");
            kwd = scan.next();
            if(kwd.equals("end"))
                break;
            for(Player pl : playerList)
                if(pl.matches(kwd))
                    pl.print();
        }
    }
}