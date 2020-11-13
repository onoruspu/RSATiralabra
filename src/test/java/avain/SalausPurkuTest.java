
package avain;

import java.math.BigInteger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Testiluokka SalausPurku-luokalle.
 */
public class SalausPurkuTest {
    /**
     * Testaukseen käytettävä luokka.
     */
    private final SalausPurku salausPurku = new SalausPurku();

    /**
     * Testaukseen käytettävä avain.
     */
    private final Avain key = new Avain(new BigInteger("20287588197917022692777001729893044731602908844137722"
            + "8496882840395933124874002868747457557369812619471204630156874129171487454323132162466699532943"
            + "4628551552086347251794362627261566024251617349197561370938343354322747610985963686841137385307"
            + "3401193304526667978400863661267249859844260608131935642616033056755511252844196397579115245796"
            + "7378436085119609328955886659333253287574176340606942532984136029482839603958855384526214510083"
            + "5291781234009632282711933960752912315323422138360715026017665776978473800715545473814121724305"
            + "6244214636402043332626603989456955512537532415826129276463308343824355150435637297443628857283"),
                new BigInteger("65537"),
                new BigInteger("16031766867295187271865177572812775891557182143354876308993492868555137"
                        + "7147256276142668712919804473042620452434416501757208352105538727161571358341"
                        + "2270596095808472127548991349974048901078276559769176279651584051406392969244"
                        + "1227608498354219400008764515436037779169054551678740299242785184468999420105"
                        + "3105265162637278911671398787586435678183929608114783438281996050386669868638"
                        + "1492060219793598354275397493311685267259896727437118392493637665177307036290"
                        + "7853425211675556845006293444859298234124669271970589773988473503203992554407"
                        + "9563200250024297557783770344974305325464589589115909445678004909380738314660"
                        + "93346714319833"));
    /**
     * Testaukseen käytettävä purettu arvo.
     */
    private final String purettu = "840010100115001160009700117001150011600097";

    /**
     * Testaukseen käytettävä salattu arvo.
     */
    private final String salattu = "6771565252887131284639353210977472109049799680232276674551146856887020106352609638"
            + "30016583498181442287376274656796899613608229518748973183191172737486445747205330456171022"
            + "48609078346673514371083943664043107687964005460221378411330928334235982994884485388180767"
            + "25657185764517118695128888994529896946238425475881139707333880672258790775794230133744907"
            + "74005771513455731261943528941864540724212683554764433695883140358326678914984377115361473"
            + "50107419131711311558613680792189842541487964803875564341057719627241433865397338257593670"
            + "52200414264922132742660639389786934224248988526005861594445955658133223177065992094208639";

    /**
     * Salauksen testaus.
     */
    @Test
    public void salausTesti() {
        assertEquals(this.salattu, this.salausPurku.salaus(this.key, new BigInteger(this.purettu)));
    }

    /**
     * Purun testaus.
     */
    @Test
    public void purkuTesti() {
        assertEquals(this.purettu, this.salausPurku.purku(this.key, new BigInteger(this.salattu)));
    }
}
