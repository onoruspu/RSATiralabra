
/**
 * Testiluokka SuuriLuokka-luokalle.
 */
package tietorakenteet;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SuuriLukuTest {
    /**
     * Testiolio luvulle nolla.
     */
    private final SuuriLuku suuriLukuNolla = new SuuriLuku("0");

    /**
     * Testiolio luvulle yksi.
     */
    private final SuuriLuku suuriLukuYksi = new SuuriLuku("1");

    /**
     * Testiolio mielivaltaiselle luvulle 1234567890.
     */
    private final SuuriLuku suuriLukuMielivaltainen1 = new SuuriLuku("1234567890");

    /**
     * Testiolio mielivaltaiselle luvulle 1000000010000000000.
     */
    private final SuuriLuku suuriLukuMielivaltainen2 = new SuuriLuku("1000010000");

    /**
     * Testiolio valtavalle luvulle.
     */
    private final SuuriLuku suuriLukuValtava = new SuuriLuku("171635452203152499762654520477200692602933"
            + "17267968154459865376602073492945176477726878917232013969430736217736000264069892888962083"
            + "79671166515161414743492809866531269378208823615980394680402272491558217510489916576419283"
            + "81462022734743943739743432850143664587498156967651712382811763652932978465640644865679883"
            + "76343326694013228679643798594220320100847368370437373022741078246248282263904467994028196"
            + "57499601892616095114164079362434672527827656437421873352889593276426932076607158823435339"
            + "88361940597742023275293038747272376808723720786241962362595939287251643434234873564739187"
            + "25542684748484779115444439288865365049853");

    /**
     * Varmistetaan, että yhdenPienempi-metodi pienentää arvoa yhdellä, mutta ei anna negatiivisia lukuja.
     */
    @Test
    public void yhdenPienempiTest() {
        // Emme halua negatiivisia lukuja.
        suuriLukuNolla.yhdenPienempi();
        suuriLukuYksi.yhdenPienempi();
        suuriLukuMielivaltainen1.yhdenPienempi();
        suuriLukuMielivaltainen2.yhdenPienempi();
        suuriLukuValtava.yhdenPienempi();
        assertTrue(suuriLukuNolla.samaLukuArvo(new SuuriLuku("0"))); // Emme halua negatiivista.
        assertTrue(suuriLukuYksi.samaLukuArvo(new SuuriLuku("0")));
        assertTrue(suuriLukuMielivaltainen1.samaLukuArvo(new SuuriLuku("1234567889")));
        assertTrue(suuriLukuMielivaltainen2.samaLukuArvo(new SuuriLuku("1000009999")));
        assertTrue(suuriLukuValtava.samaLukuArvo(new SuuriLuku("1716354522031524997626545204"
                + "772006926029331726796815445986537660207349294517647772687891723201396943073621773600026"
                + "406989288896208379671166515161414743492809866531269378208823615980394680402272491558217"
                + "510489916576419283814620227347439437397434328501436645874981569676517123828117636529329"
                + "784656406448656798837634332669401322867964379859422032010084736837043737302274107824624"
                + "828226390446799402819657499601892616095114164079362434672527827656437421873352889593276"
                + "426932076607158823435339883619405977420232752930387472723768087237207862419623625959392"
                + "8725164343423487356473918725542684748484779115444439288865365049852")));
    }


}
