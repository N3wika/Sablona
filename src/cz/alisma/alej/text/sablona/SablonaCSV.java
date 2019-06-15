/*
 * MIT License
 * Copyright (c) 2017 Gymnazium Nad Aleji
 * Copyright (c) 2019 Vojtech Travnicek, Michaela Arnostova
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
            } else if ( arg.startsWith( "--out" ) ) {
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
            FileWriter soubor = new FileWriter( nazevSouboru );
            soubor.write( Sablona.provedNahrady( text, nahrady ) );
            soubor.close();

            ++cisloSouboru;
        }
        csvSc.close();

    }

}
