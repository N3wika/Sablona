package cz.alisma.alej.text.sablona;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sablona {

    public static void main( String[] args ) {

        Scanner sc = new Scanner( System.in );

        String text = "";
        while ( sc.hasNextLine() ) {

            text += sc.nextLine() + "\n";
        }

        
        
        HashMap<String, String> nahrady = new HashMap<>();
        System.out.println( provedNahrady (text, nahrady) );
        sc.close();
    }

    public static String provedNahrady( String text, HashMap<String, String> nahrady ) {
        for (Entry<String, String> nahrada: nahrady.entrySet()) {
            String coHledam = "\\{\\{ " + nahrada.getKey() + " \\}\\}";
            text = text.replaceAll( coHledam, nahrada.getValue() );
        }
        return text;
    }

}
