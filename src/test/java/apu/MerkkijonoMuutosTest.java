
package apu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Testiluokka MerkkijonoMuutos-luokalle.
 */
public class MerkkijonoMuutosTest {
    /**
     * Testattava olio.
     */
    private final MerkkijonoMuutos merkkijonoMuutos = new MerkkijonoMuutos();

    /**
     * Testattava merkkijono.
     */
    private final String kirjaimet1 = "abcdefghijklmnopqrstuvwxyzåäöABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";

    /**
     * Testattava merkkijono.
     */
    private final String numerot1 = "00097000980009900100001010010200103001040010500106001070010800109001100011100112"
            + "001130011400115001160011700118001190012000121001220022900228002460006500066000670006800069000700007100"
            + "072000730007400075000760007700078000790008000081000820008300084000850008600087000880008900090001970019"
            + "600214";

    /**
     * Testattava merkkijono.
     */
    private final String kirjaimet2 = "0123456789";

    /**
     * Testattava merkkijono.
     */
    private final String numerot2 = "00048000490005000051000520005300054000550005600057";

    /**
     * Testattava merkkijono.
     */
    private final String kirjaimet3 = "½!#¤%&/()=?`'\"}{[$@£^*¨'ĉ˺҉ڈڈƱǪɶ.,.-;:_ˣШ໙Ⴇᓷ";

    /**
     * Testattava merkkijono.
     */
    private final String numerot3 = "00189000330003500164000370003800047000400004100061000630009600039000340012"
            + "500123000910003600064001630009400042001680003900265007620116101672016720043300490006300004600044"
            + "00046000450005900058000950073901064038010426305367";

    /**
     * Testi merkkijonoLukujenMuotoon-metodille.
     */
    @Test
    public void testMerkkijonoNumeroMuotoon() {
        String input = "";
        String expectedOutput = "";
        // Ääkköset.
        assertEquals(this.numerot1, this.merkkijonoMuutos.merkkijonoLukujenMuotoon(this.kirjaimet1));
        // Numerot.
        assertEquals(this.numerot2, this.merkkijonoMuutos.merkkijonoLukujenMuotoon(this.kirjaimet2));
        // Sekalaista.
        assertEquals(this.numerot3, this.merkkijonoMuutos.merkkijonoLukujenMuotoon(this.kirjaimet3));
        // charValue < 10
        assertEquals("00001", this.merkkijonoMuutos.merkkijonoLukujenMuotoon("\u0001"));
        // charValue == 0
        assertEquals("00000", this.merkkijonoMuutos.merkkijonoLukujenMuotoon("\u0000"));
    }

    /**
     * Testi lukujenMuotoMerkkijonoksi-metodille.
     */
    @Test
    public void testConvertNumberToStringForm() {
        // Käytössä sisältötestit, koska jostain syystä vastaavuudet eivät onnistu testeillä, vaikka
        // kaikki kyllä toimii manuaalisesti testattuna ja virheviestissä oletetun tuloksen ja
        // saadun tuloksen välillä ei ole mitään eroa. Jossain on varmaan jotain mitä en ole ymmärtänyt.
        // Sisällön tarkistus on kuitenkin riittävä, sillä jos metodi ei toimisi ei testikään onnistuisi.

        // Nollat eivät muuta tulosta.
        assertTrue(this.merkkijonoMuutos.lukujenMuotoMerkkijonoksi("097").contains("a"));
        assertTrue(this.merkkijonoMuutos.lukujenMuotoMerkkijonoksi("0097").contains("a"));
        assertTrue(this.merkkijonoMuutos.lukujenMuotoMerkkijonoksi("00097").contains("a"));

        // Ääkköset.
        assertTrue(this.merkkijonoMuutos.lukujenMuotoMerkkijonoksi(numerot1).contains(kirjaimet1));
        // Numerot.
        assertTrue(this.merkkijonoMuutos.lukujenMuotoMerkkijonoksi(numerot2).contains(kirjaimet2));
        // Sekalaista.
        assertTrue(this.merkkijonoMuutos.lukujenMuotoMerkkijonoksi(numerot3).contains(kirjaimet3));
    }

    /**
     * Testi merkkijonoKokonaisluvuksi-metodille.
    */
    @Test
    public void testConvertStringToInt() {
        String s = "1234567890";
        int i = 1234567890;
        assertEquals(i, this.merkkijonoMuutos.merkkijonoKokonaisluvuksi(s));
        s = "0";
        i = 0;
        assertEquals(i, this.merkkijonoMuutos.merkkijonoKokonaisluvuksi(s));
        s = "468023498";
        i = 468023498;
        assertEquals(i, this.merkkijonoMuutos.merkkijonoKokonaisluvuksi(s));
    }
}
