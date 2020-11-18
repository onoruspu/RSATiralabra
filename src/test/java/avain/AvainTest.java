
package avain;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tietorakenteet.SuuriLuku;

/**
 * Testiluokka Avain-luokalle.
 */
public class AvainTest {

    /**
     * Apumetodi testaukseen.
     *
     * @param sL1 Luku, jota verrataan.
     *
     * @param sL2 Luku, johon verrataan.
     *
     * @return Ovatko luvut samat?
     */
    private Boolean onSamatNumerot(final SuuriLuku sL1, final SuuriLuku sL2) {
        return sL1.samaLukuArvo(sL1, sL2);
    }

    /**
     * Testi avain-luokan konstruktrorille.
     */
    @Test
    public void avaimenLuojaTesti() {
        // Testi nollilla.
        Avain avain1 = new Avain(new SuuriLuku("0"), new SuuriLuku("0"), new SuuriLuku("0"));
        assertTrue(onSamatNumerot(new SuuriLuku("0"), avain1.getN()));
        assertTrue(onSamatNumerot(new SuuriLuku("0"), avain1.getE()));
        assertTrue(onSamatNumerot(new SuuriLuku("0"), avain1.getD()));

        // Testi sekalaisella luvulla.
        Avain avain2 = new Avain(new SuuriLuku("24095681039462341"),
                new SuuriLuku("10010101011101010101011"), new SuuriLuku("12312577791723777712"));
        assertTrue(onSamatNumerot(new SuuriLuku("24095681039462341"), avain2.getN()));
        assertTrue(onSamatNumerot(new SuuriLuku("10010101011101010101011"), avain2.getE()));
        assertTrue(onSamatNumerot(new SuuriLuku("12312577791723777712"), avain2.getD()));

        // Testi suurilla luvuilla.
        Avain avain3 = new Avain(new SuuriLuku("4462614641156714134324465427255425474252349820934892034"
                + "8092384902809382093587238471982371923712049872985729857390847598374895361345601"
                + "47645385758310136264749813"),
                new SuuriLuku("487409875248975398457983134789571983479840758912374829375912347285"
                        + "70843729874359823463745245571325903464254325424524652345245665442567245"
                        + "24573171345619384543615"),
                new SuuriLuku("456556456416135468534145614561461455113645541657614947941734158576"
                        + "91136451145198261961418596316986411396543854594119645419681341467965169"
                        + "41329686441962431512312"));
        assertTrue(onSamatNumerot(new SuuriLuku("446261464115671413432446542725542547425234982093"
                + "4892034809238490280938209358723847198237192371204987298572985739084759837489536"
                + "134560147645385758310136264749813"), avain3.getN()));
        assertTrue(onSamatNumerot(new SuuriLuku("487409875248975398457983134789571983479840758912"
                + "3748293759123472857084372987435982346374524557132590346425432542452465234524566"
                + "544256724524573171345619384543615"), avain3.getE()));
        assertTrue(onSamatNumerot(new SuuriLuku("456556456416135468534145614561461455113645541657"
                + "6149479417341585769113645114519826196141859631698641139654385459411964541968134"
                + "146796516941329686441962431512312"), avain3.getD()));
    }

    /**
     * Testi Avain-luokan settereille.
     */
    @Test
    public void avaintenSetteritGetteritTesti() {
        Avain avain = new Avain(new SuuriLuku("0"), new SuuriLuku("0"), new SuuriLuku("0"));

        // Testi pienillä luvuilla.
        avain.setN(new SuuriLuku("12345"));
        avain.setE(new SuuriLuku("67890"));
        avain.setD(new SuuriLuku("23508"));
        assertTrue(onSamatNumerot(new SuuriLuku("12345"), avain.getN()));
        assertTrue(onSamatNumerot(new SuuriLuku("67890"), avain.getE()));
        assertTrue(onSamatNumerot(new SuuriLuku("23508"), avain.getD()));

        // Testi suurilla luvuilla. E:n ei tarvi olla koskaan erityisen suuri, joten jätetään testaamatta.
        SuuriLuku suuriLukuN = new SuuriLuku("279030005713468610836671817997284748197879772424487572958684793"
                + "35299712999062914122836106347163111834902009331922183299921951020563602590566957478880"
                + "64650793479306418349261334629731344849342308267517031727536479188791979099321579410323"
                + "27767531792647643805335939526041306152493647654168518114049730399529659325307194050173"
                + "10509049995283158061998447923647446872921689700731838453291970185866836530539740593713"
                + "13407089863106792999103775744836754822488191170433141514911576065040168248165079048443"
                + "04055211518081034915125053216824217449281991972253161592100965959445612313986821831900"
                + "39694747160146231509374454642994951453");
        SuuriLuku suuriLukuD = new SuuriLuku("269688842209869878331740893959168222608576810422880454307062741"
                + "12881116323598000660433152026311137112748492868333107355645759547973820573024135794814"
                + "17812460310354554793433643887438738068448202276413801985402798438372985215806747403575"
                + "19230034428516406023488936286342592056661200899613904251007096337906941276391525156611"
                + "75356971658462307899734230890573700794990918561958145965317901114192023447175619997997"
                + "08538452662023148248312293880577347563433962103344616944495955999842465120595955258574"
                + "78520711682535692098376154236783660897093926439948781742836146266708514474718914173398"
                + "60730867528647493786153207716937633125");
        avain.setN(suuriLukuN);
        avain.setD(suuriLukuD);
        assertTrue(onSamatNumerot(suuriLukuN, avain.getN()));
        assertTrue(onSamatNumerot(suuriLukuD, avain.getD()));
    }
}
