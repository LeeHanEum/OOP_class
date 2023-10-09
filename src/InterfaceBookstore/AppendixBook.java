package InterfaceBookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendixBook extends Book{

    // member variables
    List<String> appendix = new ArrayList<>();

    // Override method

    @Override
    public Manageable read(Scanner scanner) {
        super.read(scanner);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            appendix.add(scanner.next());
        }
        return this;
    }

    @Override
    public void printBookType() {
        System.out.print("[부록책] ");
    }

    @Override
    public void print() {
        super.print();
        System.out.print("\t\t별책 "+ appendix.size() + "권: ");
        for(String s : appendix){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        super.matches(kwd);
        for(String s : appendix){
            if(s.contains(kwd)) return true;
        }
        return false;
    }
}
