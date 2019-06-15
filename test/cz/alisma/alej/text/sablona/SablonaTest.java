package cz.alisma.alej.text.sablona;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class SablonaTest {

    @Test
    public void leftAlignerTest() {
        String sablona = "Od: Dodavatel elekt�tiny\r\n" + "Pro: {{ zakaznik }}\r\n" + "V�c: �hrada za m�s�c {{ mesic }} {{ rok }}\r\n"
                + " \r\n" + "Dobr� den,\r\n" + "  pos�l�me informace k zaplacen� �hrady za dal�� m�s�c.\r\n" + " \r\n" + "S pozdravem,\r\n"
                + " loupe�n�ci\r\n" + " \r\n" + "Variabiln� symbol: {{ vs }}\r\n" + "��stka: {{ castka }} K�\r\n"
                + "Uhra�te na ��et: 000-123456789/1234";
        String vystup = "Od: Dodavatel elekt�tiny\r\n" + "Pro: Ferda Mravenec\r\n" + "V�c: �hrada za m�s�c duben 2019\r\n" + " \r\n"
                + "Dobr� den,\r\n" + "  pos�l�me informace k zaplacen� �hrady za dal�� m�s�c.\r\n" + " \r\n" + "S pozdravem,\r\n"
                + " loupe�n�ci\r\n" + " \r\n" + "Variabiln� symbol: 9876\r\n" + "��stka: 123 K�\r\n"
                + "Uhra�te na ��et: 000-123456789/1234";
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
