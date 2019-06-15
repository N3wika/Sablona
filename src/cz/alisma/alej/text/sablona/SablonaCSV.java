package cz.alisma.alej.text.sablona;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SablonaCSV {

    public static void main( String[] args ) throws IOException {

        String template = null;
        String csv = null;
        for ( String arg : args ) {

            if ( arg.startsWith( "--template" ) ) {
                String[] argumenty = arg.split( "=" );
                template = argumenty[1];
            } else if ( arg.startsWith( "--csv" ) ) {
                String[] argumenty = arg.split( "=" );
                csv = argumenty[1];

            }
        }

        String text = "";
        Scanner sc = new Scanner( new FileInputStream( template ) );
        while ( sc.hasNextLine() ) {
            text += sc.nextLine() + "\n";
        }
        sc.close();

        Scanner csvSc = new Scanner( new FileInputStream( csv ) );
        String hlavicka = csvSc.nextLine();
        String[] nazvy = hlavicka.split( "," );
        while ( csvSc.hasNextLine() ) {
            String radek = csvSc.nextLine();
            String[] hodnoty = radek.split( "," );

            HashMap<String, String> nahrady = new HashMap<>();
            for ( int i = 0; i < hlavicka.length(); ++i ) {
                nahrady.put( nazvy[i], hodnoty[i] );
            }
            System.out.println( Sablona.provedNahrady( text, nahrady ) );
        }
        csvSc.close();

    }

}
