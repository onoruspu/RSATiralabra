
package avain;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Testiluokka Avain-luokalle.
 */
public class AvainTest {

    /**
     * Apumetodi testaukseen.
     *
     * @param bI1 Luku, jota verrataan.
     *
     * @param bI2 Luku, johon verrataan.
     *
     * @return Ovatko luvut samat?
     */
    private Boolean onSamatNumerot(final BigInteger bI1, final BigInteger bI2) {
        return bI1.equals(bI2);
    }

    /**
     * Testi key-luokan konstruktrorille.
     */
    @Test
    public void avaimenLuojaTesti() {
        // Testi nollilla.
        Avain key1 = new Avain(new BigInteger("0"), new BigInteger("0"), new BigInteger("0"));
        assertTrue(onSamatNumerot(new BigInteger("0"), key1.getN()));
        assertTrue(onSamatNumerot(new BigInteger("0"), key1.getE()));
        assertTrue(onSamatNumerot(new BigInteger("0"), key1.getD()));

        // Testi sekalaisella luvulla.
        Avain key2 = new Avain(new BigInteger("24095681039462341"),
                new BigInteger("10010101011101010101011"), new BigInteger("12312577791723777712"));
        assertTrue(onSamatNumerot(new BigInteger("24095681039462341"), key2.getN()));
        assertTrue(onSamatNumerot(new BigInteger("10010101011101010101011"), key2.getE()));
        assertTrue(onSamatNumerot(new BigInteger("12312577791723777712"), key2.getD()));

        // Testi suurilla luvuilla.
        Avain key3 = new Avain(new BigInteger("4462614641156714134324465427255425474252349820934892034"
                + "8092384902809382093587238471982371923712049872985729857390847598374895361345601"
                + "47645385758310136264749813"),
                new BigInteger("487409875248975398457983134789571983479840758912374829375912347285"
                        + "70843729874359823463745245571325903464254325424524652345245665442567245"
                        + "24573171345619384543615"),
                new BigInteger("456556456416135468534145614561461455113645541657614947941734158576"
                        + "91136451145198261961418596316986411396543854594119645419681341467965169"
                        + "41329686441962431512312"));
        assertTrue(onSamatNumerot(new BigInteger("446261464115671413432446542725542547425234982093"
                + "4892034809238490280938209358723847198237192371204987298572985739084759837489536"
                + "134560147645385758310136264749813"), key3.getN()));
        assertTrue(onSamatNumerot(new BigInteger("487409875248975398457983134789571983479840758912"
                + "3748293759123472857084372987435982346374524557132590346425432542452465234524566"
                + "544256724524573171345619384543615"), key3.getE()));
        assertTrue(onSamatNumerot(new BigInteger("456556456416135468534145614561461455113645541657"
                + "6149479417341585769113645114519826196141859631698641139654385459411964541968134"
                + "146796516941329686441962431512312"), key3.getD()));
    }

    /**
     * Testi Avain-luokan settereille.
     */
    @Test
    public void avaintenSetteritTesti() {
        Avain key = new Avain(new BigInteger("0"), new BigInteger("0"), new BigInteger("0"));

        // Testi pienillä luvuilla.
        key.setN(new BigInteger("12345"));
        key.setE(new BigInteger("67890"));
        key.setD(new BigInteger("23508"));
        assertTrue(onSamatNumerot(new BigInteger("12345"), key.getN()));
        assertTrue(onSamatNumerot(new BigInteger("67890"), key.getE()));
        assertTrue(onSamatNumerot(new BigInteger("23508"), key.getD()));

        // Testi suurilla luvuilla. E:n ei tarvi olla koskaan erityisen suuri, joten jätetään testaamatta.
        BigInteger bigN = new BigInteger("279030005713468610836671817997284748197879772424487572958684793"
                + "35299712999062914122836106347163111834902009331922183299921951020563602590566957478880"
                + "64650793479306418349261334629731344849342308267517031727536479188791979099321579410323"
                + "27767531792647643805335939526041306152493647654168518114049730399529659325307194050173"
                + "10509049995283158061998447923647446872921689700731838453291970185866836530539740593713"
                + "13407089863106792999103775744836754822488191170433141514911576065040168248165079048443"
                + "04055211518081034915125053216824217449281991972253161592100965959445612313986821831900"
                + "39694747160146231509374454642994951453");
        BigInteger bigD = new BigInteger("269688842209869878331740893959168222608576810422880454307062741"
                + "12881116323598000660433152026311137112748492868333107355645759547973820573024135794814"
                + "17812460310354554793433643887438738068448202276413801985402798438372985215806747403575"
                + "19230034428516406023488936286342592056661200899613904251007096337906941276391525156611"
                + "75356971658462307899734230890573700794990918561958145965317901114192023447175619997997"
                + "08538452662023148248312293880577347563433962103344616944495955999842465120595955258574"
                + "78520711682535692098376154236783660897093926439948781742836146266708514474718914173398"
                + "60730867528647493786153207716937633125");
        key.setN(bigN);
        key.setD(bigD);
        assertTrue(onSamatNumerot(bigN, key.getN()));
        assertTrue(onSamatNumerot(bigD, key.getD()));

    }

    // Getterit tulee testatuksi samalla kuin konstruktori ja setterit.
}
