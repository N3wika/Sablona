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
