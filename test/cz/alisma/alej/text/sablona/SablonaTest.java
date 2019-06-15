package cz.alisma.alej.text.sablona;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class SablonaTest {

    @Test
    public void leftAlignerTest() {
        String sablona = "Od: Dodavatel elektøtiny\r\n" + "Pro: {{ zakaznik }}\r\n" + "Vìc: Úhrada za mìsíc {{ mesic }} {{ rok }}\r\n"
                + " \r\n" + "Dobrý den,\r\n" + "  posíláme informace k zaplacení úhrady za další mìsíc.\r\n" + " \r\n" + "S pozdravem,\r\n"
                + " loupežníci\r\n" + " \r\n" + "Variabilní symbol: {{ vs }}\r\n" + "Èástka: {{ castka }} Kè\r\n"
                + "Uhraïte na úèet: 000-123456789/1234";
        String vystup = "Od: Dodavatel elektøtiny\r\n" + "Pro: Ferda Mravenec\r\n" + "Vìc: Úhrada za mìsíc duben 2019\r\n" + " \r\n"
                + "Dobrý den,\r\n" + "  posíláme informace k zaplacení úhrady za další mìsíc.\r\n" + " \r\n" + "S pozdravem,\r\n"
                + " loupežníci\r\n" + " \r\n" + "Variabilní symbol: 9876\r\n" + "Èástka: 123 Kè\r\n"
                + "Uhraïte na úèet: 000-123456789/1234";
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
