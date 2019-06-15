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

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sablona {

    public static void main( String[] args ) {

        HashMap<String, String> nahrady = new HashMap<>();

        for ( String arg : args ) {
            if ( arg.startsWith( "--var" ) ) {
                String[] argumenty = arg.split( "=" );
                nahrady.put( argumenty[1], argumenty[2] );
            }
        }

        Scanner sc = new Scanner( System.in );

        String text = "";
        while ( sc.hasNextLine() ) {

            text += sc.nextLine() + "\n";
        }

        System.out.println( provedNahrady( text, nahrady ) );
        sc.close();
    }


    public static String provedNahrady( String text, HashMap<String, String> nahrady ) {
        for ( Entry<String, String> nahrada : nahrady.entrySet() ) {
            String coHledam = "\\{\\{ " + nahrada.getKey() + " \\}\\}";
            text = text.replaceAll( coHledam, nahrada.getValue() );
        }
        return text;
    }

}
