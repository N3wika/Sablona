package cz.alisma.alej.text.sablona;

import java.util.HashMap;
import java.util.Scanner;

public class Sablona {

    public static void main( String[] args ) {

        Scanner sc = new Scanner( System.in );

        String text = "";
        while ( sc.hasNextLine() ) {

            text += sc.nextLine() + "\n";
        }

        
        
        HashMap<String, String> nahrady = new HashMap<>();
        System.out.println( provedNahradu (text, nahrady) );
        sc.close();
    }

    public static String provedNahradu( String text, HashMap<String, String> nahrady ) {
        // TODO Auto-generated method stub
        return text;
    }

}
