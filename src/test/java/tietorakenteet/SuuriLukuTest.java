
/**
 * Testiluokka SuuriLuokka-luokalle.
 */
package tietorakenteet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SuuriLukuTest {
    /**
     * Testiolio "tyhjälle". Tämän pitäisi olla vastaava SuuriLuku("0") kanssa.
     */
    private final SuuriLuku suuriLukuTyhjä = new SuuriLuku("");

    /**
     * Testiolio luvulle nolla.
     */
    private final SuuriLuku suuriLukuNolla = new SuuriLuku("0");

    /**
     * Testiolio usealle nollalle.
     */
    private final SuuriLuku suuriLukuNollia = new SuuriLuku("0000000");

    /**
     * Testiolio luvulle yksi.
     */
    private final SuuriLuku suuriLukuYksi = new SuuriLuku("1");

    /**
     * Testiolio mielivaltaiselle luvulle 1234567890.
     */
    private final SuuriLuku suuriLukuMielivaltainen1 = new SuuriLuku("1234567890");

    /**
     * Testioli Mielivaltainen1 neliölle (toinen potenssi).
     */
    private final SuuriLuku suuriLukuMielivaltainen1Neliö = new SuuriLuku("1524157875019052100");

    /**
     * Testiolio mielivaltaiselle luvulle 1000010000.
     */
    private final SuuriLuku suuriLukuMielivaltainen2 = new SuuriLuku("1000010000");

    /**
     * Testiolio 1000010000 arvo desimaaliksi, mikäli tulkitaan luku binääriniä.
     */
    private final SuuriLuku suuriLukuMielivaltainen2Binääristä = new SuuriLuku("528");

    /**
     * Testiolio Mielivaltainen1 kerrottuna Mielivaltainen2:lla.
     */
    private final SuuriLuku suuriLukuMielivaltainenKertolasku1ja2 = new SuuriLuku("1234580235678900000");

    /**
     * Testiolio mielivaltaiselle luvulle 01000010000.
     */
    private final SuuriLuku suuriLukuMielivaltainen3 = new SuuriLuku("01000010000");

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
     * suuriLukuValtava kerrottuna seitsemällä tulos.
     */
    private final SuuriLuku suuriLukuValtavaKertolasku7 = new SuuriLuku("1201448165422067498338581643340"
            + "40484822053220875777081219057636214514450616235344088152420624097786015153524152001848489"
            + "25022273458657698165606129903204449669065718885647461765311862762762815907440907522573429"
            + "41603493498670234159143207606178204029951005652112487098773561986679682345570530849259484"
            + "51405975918634403286858092600757506590159542240705931578593061611159187547723737975847331"
            + "27595819737602497213248312665799148555537042707694793595061953113470227152934988524536250"
            + "11176404737918533584184194162927051271230906637661066045503693736538171575010761504039644"
            + "11495317431078798793239393453808111075022057555348971");

    /**
     * SuuriLukuValtavan neliö (kerrotuna itsellään).
     */
    private final SuuriLuku suuriLukuValtavaNeliö = new SuuriLuku("2945872845298064628465714084371053813"
            + "80568872952846943154834598886534943090479196611167169873711747019720073451203702419629754"
            + "01335874918139158016845161788631558707199613181296108888966240612632465039664527539834145"
            + "47354555777939831367472841394077335509322586120801775165641960716991030772865990908134679"
            + "35672142877774316214731976195887269949792459936380035926394228603906296624434682033003456"
            + "64920059392017176497283225275596483173564733905067904994799471844385565566660690813505186"
            + "66911134600193204326507946215595216306734466512697873333095453144569545618111204108213574"
            + "30395181939306934019217253450422989183678851653945107929899058686571937832120817309317967"
            + "78147254164995605996879133049074416316372211958025795301230349493665667969797084835485418"
            + "49229091721393952743990685030055240739339750558690152026796270783175968003386322211710513"
            + "37144975709467316891729589741713858896967960837394756435198136474773572715605544243018086"
            + "62137026450348440630206736450266041591728779683670767497579248093167334536773274173723066"
            + "09809330813225755621500139393050026058090618956095113594870210033044713776452852437038455"
            + "34092820434245920066940338754844164092082822030180472771364353954273706338997237283066317"
            + "253811614487838172360318835085175321609");

    /**
     * Valtavan desimaalipituus.
     */
    private final int suuriLukuValtavaDesimaaliPituus = 617;

    /**
     * Valtavan binääripituus.
     */
    private final int suuriLukuValtavaBinääriPituus = 2048;

    /**
     * Varmistetaan, että yhdenPienempi-metodi pienentää arvoa yhdellä, mutta ei anna negatiivisia lukuja.
     */
    @Test
    public void yhdenPienempiTest() {
        // Luodaan uudet oliot, sillä haluamme pitää testiluokan oliot muuttumattomina.
        SuuriLuku tyhjä = this.suuriLukuTyhjä.kopio();
        SuuriLuku nolla = this.suuriLukuNolla.kopio();
        SuuriLuku nollia = this.suuriLukuNollia.kopio();
        SuuriLuku yksi = this.suuriLukuYksi.kopio();
        SuuriLuku mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();
        SuuriLuku mielivaltainen2 = this.suuriLukuMielivaltainen2.kopio();
        SuuriLuku mielivaltainen3 = this.suuriLukuMielivaltainen3.kopio();
        SuuriLuku valtava = this.suuriLukuValtava.kopio();

        // Vähennetään yksi.
        tyhjä.yhdenPienempi();
        nolla.yhdenPienempi();
        nollia.yhdenPienempi();
        yksi.yhdenPienempi();
        mielivaltainen1.yhdenPienempi();
        mielivaltainen2.yhdenPienempi();
        mielivaltainen3.yhdenPienempi();
        valtava.yhdenPienempi();

        // Testaukset.
        assertTrue(tyhjä.samaLukuArvo(new SuuriLuku("0"))); // Tarkistetaan "tyhjä" nollaksi.
        assertTrue(nolla.samaLukuArvo(new SuuriLuku("0"))); // Emme halua negatiivista.
        assertTrue(nollia.samaLukuArvo(new SuuriLuku("0"))); // Emme halua negatiivista.
        assertTrue(yksi.samaLukuArvo(new SuuriLuku("0")));
        assertTrue(mielivaltainen1.samaLukuArvo(new SuuriLuku("1234567889")));
        assertTrue(mielivaltainen2.samaLukuArvo(new SuuriLuku("1000009999")));
        assertTrue(mielivaltainen3.samaLukuArvo(new SuuriLuku("1000009999")));
        assertTrue(valtava.samaLukuArvo(new SuuriLuku("1716354522031524997626545204"
                + "772006926029331726796815445986537660207349294517647772687891723201396943073621773600026"
                + "406989288896208379671166515161414743492809866531269378208823615980394680402272491558217"
                + "510489916576419283814620227347439437397434328501436645874981569676517123828117636529329"
                + "784656406448656798837634332669401322867964379859422032010084736837043737302274107824624"
                + "828226390446799402819657499601892616095114164079362434672527827656437421873352889593276"
                + "426932076607158823435339883619405977420232752930387472723768087237207862419623625959392"
                + "8725164343423487356473918725542684748484779115444439288865365049852")));
    }

    /**
     * Varmistetaan, että ylimääriset nollat saadaan poistetuksi.
     */
    @Test
    public void poistaAlunNollatTest() {
        int[] tyhjä = this.suuriLukuTyhjä.poistaAlunNollat(this.suuriLukuTyhjä.getNumerot());
        int[] nolla = this.suuriLukuNolla.poistaAlunNollat(this.suuriLukuNolla.getNumerot());
        int[] nollia = this.suuriLukuNollia.poistaAlunNollat(this.suuriLukuNollia.getNumerot());
        int[] mielivaltainen2 = this.suuriLukuMielivaltainen2.poistaAlunNollat(
                this.suuriLukuMielivaltainen2.getNumerot());
        int[] mielivaltainen3 = this.suuriLukuMielivaltainen3.poistaAlunNollat(
                this.suuriLukuMielivaltainen3.getNumerot());

        assertTrue(tyhjä.length == 1);
        assertTrue(nolla.length == 1);
        assertTrue(nollia.length == 1);
        assertTrue(mielivaltainen2.length == 10);
        assertTrue(mielivaltainen3.length == 10);

        assertTrue(tyhjä[0] == 0);
        assertTrue(nolla[0] == 0);
        assertTrue(nollia[0] == 0);
        assertTrue(mielivaltainen2[0] == 1);
        assertTrue(mielivaltainen3[0] == 1);
    }

    /**
     * Yksinkertainen testaus getterille.
     */
    @Test
    public void getNumerotTest() {
        assertTrue(this.suuriLukuMielivaltainen1.getNumerot()[0] == 1);
        assertTrue(this.suuriLukuMielivaltainen1.getNumerot()[1] == 2);
        assertTrue(this.suuriLukuMielivaltainen1.getNumerot()[2] == 3);
    }

    /**
     * Tarkistus, että luvussa on vain nollia.
     */
    @Test
    public void vainNolliaTest() {
        assertTrue(this.suuriLukuNolla.vainNollia(this.suuriLukuNolla.getNumerot()));
        assertTrue(this.suuriLukuNollia.vainNollia(this.suuriLukuNollia.getNumerot()));
        assertFalse(this.suuriLukuMielivaltainen1.vainNollia(this.suuriLukuMielivaltainen1.getNumerot()));
    }

    /**
     * Testi jakolasku kahdella, jakojäännös.
     */
    @Test
    public void kahdenJakojäännösTest() {
        assertTrue(this.suuriLukuNolla.kahdenJakojäännös(this.suuriLukuNolla.getNumerot()) == 0);
        assertTrue(this.suuriLukuYksi.kahdenJakojäännös(this.suuriLukuYksi.getNumerot()) == 1);
        assertTrue(this.suuriLukuMielivaltainen1.kahdenJakojäännös(
                this.suuriLukuMielivaltainen1.getNumerot()) == 0);
    }

    /**
     * Testi jakolasku kahdella, osamäärä.
     */
    @Test
    public void kahdenOsamääräTest() {

    }

    /**
     * Muutetataan luku desimaalista binääriksi.
     */
    @Test
    public void binäärinäTest() {
        assertTrue(this.suuriLukuNolla.binäärinä()[0] == 0);
        assertTrue(this.suuriLukuYksi.binäärinä()[0] == 1);

        int[] mielivaltainen1 = this.suuriLukuMielivaltainen1.binäärinä();
        assertTrue(mielivaltainen1.length == 31);
        assertTrue(mielivaltainen1[0] == 1);
        assertTrue(mielivaltainen1[1] == 0);
        assertTrue(mielivaltainen1[2] == 0);
        assertTrue(mielivaltainen1[3] == 1);
        assertTrue(mielivaltainen1[30] == 0);

        int summa = 0;
        for (int i = 0; i < mielivaltainen1.length; i++) {
            summa += mielivaltainen1[i];
        }
        assertTrue(summa == 12);

        int[] valtava = this.suuriLukuValtava.binäärinä();
        assertTrue(valtava.length == this.suuriLukuValtavaBinääriPituus);
        int summa2 = 0;
        for (int i = 0; i < valtava.length; i++) {
            summa2 += valtava[i];
        }
        assertTrue(summa2 == 1042);
    }

    /**
     * Testi bittiPituus-metodille.
     */
    @Test
    public void bittiPituusTest() {
        assertTrue(this.suuriLukuNolla.bittiPituus() == 1);
        assertTrue(this.suuriLukuYksi.bittiPituus() == 1);
        assertTrue(this.suuriLukuValtava.bittiPituus() == this.suuriLukuValtavaBinääriPituus);
    }

    /**
     * Varmistetaan, että pluslasku toimii.
     */
    @Test
    public void pluslaskuTest() {
        // Luodaan uudet oliot, sillä haluamme pitää testiluokan oliot muuttumattomina.
        SuuriLuku nolla = this.suuriLukuNolla.kopio();
        SuuriLuku mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();
        SuuriLuku valtava = this.suuriLukuValtava.kopio();

        // Pluslaskut ja testit.
        nolla.pluslasku(nolla);
        assertTrue(nolla.getNumerot()[0] == 0);

        mielivaltainen1.pluslasku(nolla);
        assertTrue(mielivaltainen1.samaLukuArvo(this.suuriLukuMielivaltainen1));

        valtava.pluslasku(valtava);
        assertTrue(valtava.getNumerot().length == this.suuriLukuValtavaDesimaaliPituus);
        assertTrue(valtava.getNumerot()[0] == 3);
        assertTrue(valtava.getNumerot()[1] == 4);
        assertTrue(valtava.getNumerot()[2] == 3);
        assertTrue(valtava.getNumerot()[this.suuriLukuValtavaDesimaaliPituus - 1] == 6);
    }

    /**
     * Testit yhdenKertolasku-metodille.
     */
    @Test
    public void yhdenKertolaskuTest() {
        // Luodaan uudet oliot, sillä haluamme pitää testiluokan oliot muuttumattomina.
        SuuriLuku nolla = this.suuriLukuNolla.kopio();
        SuuriLuku yksi = this.suuriLukuYksi.kopio();
        SuuriLuku valtava = this.suuriLukuValtava.kopio();

        int nollaSumma = 0;
        int yksiSumma = 0;
        for (int i = 0; i <= 9; i++) {
            // Kertolasku.
            nolla.yhdenKertolasku(i);
            yksi.yhdenKertolasku(i);

            // Summaus tarkistukseen.
            nollaSumma += nolla.getNumerot()[0];
            yksiSumma += yksi.getNumerot()[0];

            // Luku on muuttunut, joten asetetaan se alkutilaan.
            nolla = new SuuriLuku(this.suuriLukuNolla.merkkijonoksi());
            yksi = new SuuriLuku(this.suuriLukuYksi.merkkijonoksi());
        }
        assertEquals(0, nollaSumma);
        assertEquals(45, yksiSumma);

        valtava.yhdenKertolasku(7);
        assertTrue(valtava.samaLukuArvo(this.suuriLukuValtavaKertolasku7));
    }

    /**
     * Kertolaskun testaus.
     */
    @Test
    public void kertolaskuTest() {
        // Luodaan uudet oliot, sillä haluamme pitää testiluokan oliot muuttumattomina.
        SuuriLuku nolla = this.suuriLukuNolla.kopio();
        SuuriLuku yksi = this.suuriLukuYksi.kopio();
        SuuriLuku mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();
        SuuriLuku mielivaltainen2 = this.suuriLukuMielivaltainen2.kopio();
        SuuriLuku valtava = this.suuriLukuValtava.kopio();

        mielivaltainen1.kertolasku(nolla);
        assertTrue(mielivaltainen1.samaLukuArvo(this.suuriLukuNolla));

        // Palautetaan mielivaltainen1 arvo.
        mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();

        mielivaltainen1.kertolasku(yksi);
        assertTrue(mielivaltainen1.samaLukuArvo(this.suuriLukuMielivaltainen1));

        // Palautetaan mielivaltainen1 arvo.
        mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();

        // Neliöinti.
        mielivaltainen1.kertolasku(mielivaltainen1);
        assertTrue(mielivaltainen1.samaLukuArvo(this.suuriLukuMielivaltainen1Neliö));

        // Palautetaan mielivaltainen1 arvo.
        mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();

        // Tarkistetaan, että järjetyksellä ei ole merkitystä.
        mielivaltainen1.kertolasku(mielivaltainen2);
        assertTrue(mielivaltainen1.samaLukuArvo(this.suuriLukuMielivaltainenKertolasku1ja2));

        // Palautetaan mielivaltainen1 arvo.
        mielivaltainen1 = this.suuriLukuMielivaltainen1.kopio();

        // Järjetys tarkistus 2.
        mielivaltainen2.kertolasku(mielivaltainen1);
        assertTrue(mielivaltainen2.samaLukuArvo(this.suuriLukuMielivaltainenKertolasku1ja2));

        // Kertolasku valtavalle luvulle.
        valtava.kertolasku(valtava);
        assertTrue(valtava.samaLukuArvo(this.suuriLukuValtavaNeliö));
    }

    /**
     * Varmistetaan, että muutos binääristä desimaaliksi toimii oikein.
     */
    @Test
    public void desimaaliksiTest() {
        assertTrue(this.suuriLukuNolla.desimaaliksi(this.suuriLukuNolla.getNumerot())[0] == 0);
        int[] mielivaltainen2 = this.suuriLukuMielivaltainen2.desimaaliksi(
                (this.suuriLukuMielivaltainen2.getNumerot()));
        assertTrue(mielivaltainen2[0] == 5);
        assertTrue(mielivaltainen2[1] == 2);
        assertTrue(mielivaltainen2[2] == 8);

        // Tarkistetaan, että luku muutettuna desimaalista binääriksi ja takaisin desimaaliksi
        // ei muuta luvun arvoa.
        SuuriLuku s = this.suuriLukuValtava.kopio();
        int[] binääri = s.binäärinä();
        int[] desimaali = s.desimaaliksi(binääri);
        SuuriLuku sUusi = new SuuriLuku(desimaali);
        assertTrue(sUusi.getNumerot().length == this.suuriLukuValtavaDesimaaliPituus);
        assertTrue(sUusi.getNumerot()[0] == 1);
    }

    /**
     * Varmistetaan, että luotavat luvut ovat alkulukuja.
     * Koska luonnissa ei luoda täysin varmasti alkulukuja - vaan todennäköisiä alkulukuja -
     * saattaa tämä testi toisinaan epäonnistua, mutta todennäköisyys tähän on pieni.
     */
    @Test
    public void uusiAlkulukuTest() {
        // Pohja. Ei vielä testejä.
    }


}
