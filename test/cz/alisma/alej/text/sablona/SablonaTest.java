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

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class SablonaTest {

    @Test
    public void leftAlignerTest() {
        String sablona = "Od: Dodavatel elektřtiny\r\n" + "Pro: {{ zakaznik }}\r\n" + "Věc: Úhrada za měsíc {{ mesic }} {{ rok }}\r\n"
                + " \r\n" + "Dobrý den,\r\n" + "  posíláme informace k zaplacení úhrady za další měsíc.\r\n" + " \r\n" + "S pozdravem,\r\n"
                + " loupežníci\r\n" + " \r\n" + "Variabilní symbol: {{ vs }}\r\n" + "Částka: {{ castka }} Kč\r\n"
                + "Uhraďte na účet: 000-123456789/1234";
        String vystup = "Od: Dodavatel elektřtiny\r\n" + "Pro: Ferda Mravenec\r\n" + "Věc: Úhrada za měsíc duben 2019\r\n" + " \r\n"
                + "Dobrý den,\r\n" + "  posíláme informace k zaplacení úhrady za další měsíc.\r\n" + " \r\n" + "S pozdravem,\r\n"
                + " loupežníci\r\n" + " \r\n" + "Variabilní symbol: 9876\r\n" + "Částka: 123 Kč\r\n"
                + "Uhraďte na účet: 000-123456789/1234";
        HashMap<String, String> nahrady = new HashMap<>();
        nahrady.put( "zakaznik", "Ferda Mravenec" );
        nahrady.put( "mesic", "duben" );
        nahrady.put( "rok", "2019" );
        nahrady.put( "vs", "9876" );
        nahrady.put( "castka", "123" );
        String result = Sablona.provedNahrady( sablona, nahrady );
        assertEquals( "Je to rozbity", vystup, result );
    }

}
