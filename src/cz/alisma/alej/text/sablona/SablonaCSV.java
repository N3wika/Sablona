package cz.alisma.alej.text.sablona;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SablonaCSV {

    public static void main( String[] args ) throws IOException {

        String template = null;
        String csv = null;
        String nazevSouboruVzor = null;
        for ( String arg : args ) {

            if ( arg.startsWith( "--template" ) ) {
                String[] argumenty = arg.split( "=" );
                template = argumenty[1];
            } else if ( arg.startsWith( "--csv" ) ) {
                String[] argumenty = arg.split( "=" );
                csv = argumenty[1];
            } else if ( arg.startsWith( "--out" )) {
                String[] argumenty = arg.split( "=" );
                nazevSouboruVzor = argumenty[1];
            }
        }

        String text = "";
        Scanner sc = new Scanner( new FileInputStream( template ) );
        while ( sc.hasNextLine() ) {
            text += sc.nextLine() + "\n";
        }
        sc.close();

        int cisloSouboru = 1;
        Scanner csvSc = new Scanner( new FileInputStream( csv ) );
        String hlavicka = csvSc.nextLine();
        String[] nazev = hlavicka.split( "," );
        while ( csvSc.hasNextLine() ) {
            String radek = csvSc.nextLine();
            String[] hodnoty = radek.split( "," );

            HashMap<String, String> nahrady = new HashMap<>();
            for ( int i = 0; i < nazev.length; ++i ) {
                nahrady.put( nazev[i], hodnoty[i] );
            }
            
            String nazevSouboru = String.format( nazevSouboruVzor, cisloSouboru );
            FileWriter soubor = new FileWriter(nazevSouboru);
            soubor.write( Sablona.provedNahrady( text, nahrady ) );
            soubor.close();
            
            ++cisloSouboru;
        }
        csvSc.close();
        
        
        
    }

}
