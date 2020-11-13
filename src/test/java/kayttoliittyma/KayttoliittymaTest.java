
package kayttoliittyma;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testiluokka Kayttoliittyma-luokalle.
 */
public class KayttoliittymaTest {
    /**
     * Yleinen käyttöliittymä erilaisiin testeihin.
     */
    private final Kayttoliittyma uI = new Kayttoliittyma(new Scanner("0"));

    /**
     * Muuttuja syötteiden käsittelyyn.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    /**
     * Muuttuja syötteiden käsittelyyn.
     */
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    /**
     * Muuttuja syötteiden käsittelyyn.
    */
    private final PrintStream originalOut = System.out;
    /**
     * Muuttuja syötteiden käsittelyyn.
     */
    private final PrintStream originalErr = System.err;

    /**
     * Testien apumetodi. Suoritetaan ennen testejä.
     */
    @Before
    public void alustus() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Testien apumetodi. Suoritetaan testien jälkeen.
     */
    @After
    public void lopetus() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Parametrittoman konstruktorin testi.
     */
    public void paremetritonKonstruktoriTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma();
    }

    /**
     * Testi sulje-metodille.
     */
    @Test
    public void sulkuTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("0")); // Syötteenä "0".
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
    }

    /**
     * Erilaisia testejä päätason virheellisillä syötteillä.
     */
    @Test
    public void virheellisetPäätasonKomennotTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("1\n0")); // Syötteenä "a" "0".
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI2 = new Kayttoliittyma(new Scanner("9\n0")); // Syötteenä "9" "0".
        uI2.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
    }

    /**
     * Testi luoAvaimet-metodille.
     */
    @Test
    public void avaintenLuontiTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("1\n0")); // Syötteenä "1" "0".
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Luodun avaimen arvot:"));
        assertTrue(outContent.toString().contains("d:"));
        assertTrue(outContent.toString().contains("e:"));
        assertTrue(outContent.toString().contains("n:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
    }

    /**
     * Testi viestiLukujenMuotoon-metodille.
    */
    @Test
    public void vietiNumeroMuotoonTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("2\nViesti\n0")); // Syötteenä "2" "Viesti" "0".
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Luvuksi muutettava viesti:"));
        assertTrue(outContent.toString().contains("Viesti lukuna:"));
        assertTrue(outContent.toString().contains("000860010500101001150011600105"));
        assertTrue(outContent.toString().contains("Tarkistus:"));
        assertTrue(outContent.toString().contains("Viesti"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI2 = new Kayttoliittyma(new Scanner("2\nViesti\n0")); // Syötteenä "2" "0" "0".
        uI2.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Luvuksi muutettava viesti:"));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

    }

    /**
     * Testi lukuViestinMuotoon-metodille.
     */
    @Test
    public void numeroViestiMuotoonTesti() {
        // Syötteenä "3" "001000010100102" "0".
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("3\n001000010100102\n0"));
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Viestiksi muutettava luku:"));
        assertTrue(outContent.toString().contains("Luku viestinä:"));
        assertTrue(outContent.toString().contains("def"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI2 = new Kayttoliittyma(new Scanner("3\na\n0\n0")); // Syötteenä "3" "a" "0" "0".
        uI2.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Viestiksi muutettava luku:"));
        assertTrue(outContent.toString().contains("Virheellinen syöte."));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
    }

    /**
     * Tseti salaus-metodille.
    */
    @Test
    public void salausTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("4\n"
                + "83000970010800097001050011000101001100003200118001050010100115001160010500046\n"
                + "65537\n"
                + "957146238815418622098946191618592342900191866783108314140513756810137924059762"
                + "811833853884034841524143557704602999857577320479998078553730537425456681123475"
                + "927681609888102486385574190500941046522362648684825190357816209079025323300879"
                + "256163091826335033181544121389190251161143572776230428469968232122731441196488"
                + "047504987623136274739124801026518290003269320478104659198349110576059052406260"
                + "147831742331247074983960075843409126113975845377982008881621136572454548206365"
                + "768876138451622724495721053903783960137624677175735326082704675916421021836006"
                + "7251256736882878282456493815592296793321364200348248829972504056735891\n"
                + "0")); // Syötteenä "4" <luku> "65537" <luku> "0".
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("0 - Palaa takaisin."));
        assertTrue(outContent.toString().contains("Salataan viesti."));
        assertTrue(outContent.toString().contains("Anna viesti (numeroina):"));
        assertTrue(outContent.toString().contains("Anna julkinen avain (e):"));
        assertTrue(outContent.toString().contains("Anna osamäärä (n):"));
        assertTrue(outContent.toString().contains("Viesti salatussa muodossa:"));
        assertTrue(outContent.toString().contains("47136946353148249988924838084264102618723874905365"
                + "1299258253194726377745697337110967341585162213523613750992290404552009078959138092"
                + "0487157131670120624619568103797260664330249929939999857398525287867370387438672131"
                + "8288179412299332122853999317673825249212887848110514246284375315114949719986541034"
                + "8946208575822335482342567159891760465672214274306647394162811666309042423183014549"
                + "5253701800621969947575082237230582553728673229273493768332621730574023784496857434"
                + "6116812452105240000941561987425014461959133199050537038962185679366091710262656268"
                + "46422034115921748198047254335145878054754931560557887627499264379128380617"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI2 = new Kayttoliittyma(new Scanner("4\n0\n0")); // Syötteenä "4" "0" "0".
        uI2.käynnistä();
        assertTrue(outContent.toString().contains("Anna viesti (numeroina):"));
        assertTrue(outContent.toString().contains("Palataan takaisin."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI3 = new Kayttoliittyma(new Scanner("4\n1\n0\n0")); // Syötteenä "4" "1" "0" "0".
        uI3.käynnistä();
        assertTrue(outContent.toString().contains("Anna osamäärä (n):"));
        assertTrue(outContent.toString().contains("Palataan takaisin."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI4 = new Kayttoliittyma(new Scanner("4\n1\n1\n0\n0")); // Syötteenä "4" "1" "1" "0" "0".
        uI4.käynnistä();
        assertTrue(outContent.toString().contains("Anna julkinen avain (e):"));
        assertTrue(outContent.toString().contains("Palataan takaisin."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        // Syötteenä "4" "a" "1" "1" "0" "0".
        Kayttoliittyma uI5 = new Kayttoliittyma(new Scanner("4\nabcx\n1\n1\n0\n0"));
        uI5.käynnistä();
        assertTrue(outContent.toString().contains("Anna osamäärä (n):"));
        assertTrue(outContent.toString().contains("Virheellinen syöte."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
    }

    /**
     * Testi purku-metodille.
     */
    @Test
    public void purkuTesti() {
        Kayttoliittyma uI1 = new Kayttoliittyma(new Scanner("5\n"
                + "47136946353148249988924838084264102618723874905365"
                + "1299258253194726377745697337110967341585162213523613750992290404552009078959138092"
                + "0487157131670120624619568103797260664330249929939999857398525287867370387438672131"
                + "8288179412299332122853999317673825249212887848110514246284375315114949719986541034"
                + "8946208575822335482342567159891760465672214274306647394162811666309042423183014549"
                + "5253701800621969947575082237230582553728673229273493768332621730574023784496857434"
                + "6116812452105240000941561987425014461959133199050537038962185679366091710262656268"
                + "46422034115921748198047254335145878054754931560557887627499264379128380617\n"
                + "95714623881541862209894619161859234290019186678310831414051375681013792405976281183"
                + "38538840348415241435577046029998575773204799980785537305374254566811234759276816098"
                + "88102486385574190500941046522362648684825190357816209079025323300879256163091826335"
                + "03318154412138919025116114357277623042846996823212273144119648804750498762313627473"
                + "91248010265182900032693204781046591983491105760590524062601478317423312470749839600"
                + "75843409126113975845377982008881621136572454548206365768876138451622724495721053903"
                + "78396013762467717573532608270467591642102183600672512567368828782824564938155922967"
                + "93321364200348248829972504056735891\n"
                + "698585166261164211832383129891391542761262760941703465069856638685007359530503907387"
                + "410666265446612209267981205659279300181126993119786694429050335984683144239876626116"
                + "203155946734978015953020100159796367567074025137292352060947090207935365506070297444"
                + "835326608761602412130414582855569069151837747335499229836798875478671631763811080742"
                + "851330796309380770570607497653029887222031923293574456445786521276095885076239043676"
                + "794453629085887878789306265176981108796824947375569681080793007098177411964515235197"
                + "016691581456932169299800329008020816064937538426006757372861924180592215437627041824"
                + "3886384218744434286017669841\n"
                + "0")); // Syötteenä "5" <luku> <luku> <luku>"0".
        uI1.käynnistä();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("0 - Palaa takaisin."));
        assertTrue(outContent.toString().contains("Puretaan viesti."));
        assertTrue(outContent.toString().contains("Anna viesti (numeroina):"));
        assertTrue(outContent.toString().contains("Anna osamäärä (n):"));
        assertTrue(outContent.toString().contains("Anna yksityinen avain (d):"));
        assertTrue(outContent.toString().contains("Viesti puretussa muodossa:"));
        assertTrue(outContent.toString().contains("830009700108000970010500110001010011000032001180010500"
                + "10100115001160010500046"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI2 = new Kayttoliittyma(new Scanner("5\n0\n0")); // Syötteenä "5" "0" "0".
        uI2.käynnistä();
        assertTrue(outContent.toString().contains("Anna viesti (numeroina):"));
        assertTrue(outContent.toString().contains("Palataan takaisin."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI3 = new Kayttoliittyma(new Scanner("5\n1\n0\n0")); // Syötteenä "5" "1" "0" "0".
        uI3.käynnistä();
        assertTrue(outContent.toString().contains("Anna osamäärä (n):"));
        assertTrue(outContent.toString().contains("Palataan takaisin."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI4 = new Kayttoliittyma(new Scanner("5\n1\n1\n0\n0")); // Syötteenä "5" "1" "1" "0" "0".
        uI4.käynnistä();
        assertTrue(outContent.toString().contains("Anna yksityinen avain (d):"));
        assertTrue(outContent.toString().contains("Palataan takaisin."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));

        Kayttoliittyma uI5 = new Kayttoliittyma(new Scanner("5\na\n1\n1\n0\n0")); // Syötteenä "5" "a" "1" "1" "0" "0".
        uI5.käynnistä();
        assertTrue(outContent.toString().contains("Anna yksityinen avain (d):"));
        assertTrue(outContent.toString().contains("Virheellinen syöte."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
    }

    /**
     * Testi onPääkomento-metodille.
     */
    @Test
    public void onPääkomentoTesti() {
        assertFalse(this.uI.onPääkomento("-1"));
        assertFalse(this.uI.onPääkomento("00"));
        assertFalse(this.uI.onPääkomento("-0"));
        assertTrue(this.uI.onPääkomento("0"));
        assertTrue(this.uI.onPääkomento("1"));
        assertTrue(this.uI.onPääkomento("2"));
        assertTrue(this.uI.onPääkomento("3"));
        assertTrue(this.uI.onPääkomento("4"));
        assertTrue(this.uI.onPääkomento("5"));
        assertFalse(this.uI.onPääkomento("6"));
        assertFalse(this.uI.onPääkomento("7"));
        assertFalse(this.uI.onPääkomento("8"));
        assertFalse(this.uI.onPääkomento("9"));
        assertFalse(this.uI.onPääkomento("10"));
        assertFalse(this.uI.onPääkomento(""));
        assertFalse(this.uI.onPääkomento(null));
        assertFalse(this.uI.onPääkomento("a"));
        assertFalse(this.uI.onPääkomento("\n"));
        assertFalse(this.uI.onPääkomento("\t"));
        assertFalse(this.uI.onPääkomento("0\n"));
    }

    /**
     * testi komennonArvo-metodille.
     */
    @Test
    public void komennonArvoTesti() {
        assertEquals(-1, this.uI.komennonArvo("-1"));
        assertEquals(0, this.uI.komennonArvo("0"));
        assertEquals(1, this.uI.komennonArvo("1"));
        assertEquals(2, this.uI.komennonArvo("2"));
        assertEquals(3, this.uI.komennonArvo("3"));
        assertEquals(4, this.uI.komennonArvo("4"));
        assertEquals(5, this.uI.komennonArvo("5"));
        assertEquals(6, this.uI.komennonArvo("6"));
        assertEquals(7, this.uI.komennonArvo("7"));
        assertEquals(8, this.uI.komennonArvo("8"));
        assertEquals(9, this.uI.komennonArvo("9"));
        assertEquals(10, this.uI.komennonArvo("10"));
        assertEquals(100, this.uI.komennonArvo("100"));
        assertEquals(1234, this.uI.komennonArvo("1234"));
    }

    /**
     * testi malformedInput-metodille.
     */
    @Test
    public void eiPääkomentoTesti() {
        this.uI.eiPääkomento();
        assertTrue(outContent.toString().contains("Virheellinen komento."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("0 - Sulje ohjelma."));
    }
}
