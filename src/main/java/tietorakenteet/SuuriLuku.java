
/*
 * SuuriLuku-olion tarkoituksena on tarjota toiminallisuus suurien lukujen käsittelyyn.
 * Tavoitteena olisi, että SuuriLuku-olio voisi korvata Javan BigInteger-toteutuksen.
 * Tällä hetkellä BigInteger on leivottu SuuriLuku-luokan sisään, jotta voidaan varmistua
 * että kaikki toimnallisuudet ovat aina olemassa, mutta luodessa uusia toiminallisuuksia
 * ei jatkuvasti tarvitse korvata BigInteger toteutuksia muissa luokissa.
 */

package tietorakenteet;

import apu.Taulukko;
import java.math.BigInteger; // Katso ylempää, miksi näin tehdään.
                             // Tavotteena olisi niin laaja toteutus, että importtia ei tarvita.
import java.util.Random; // Satunnaisuus tarvitaan alkulukujen luontiin.
                         // Myöhemmin tarkoitus korvata omalla toteutuksella.

public class SuuriLuku {
    /**
     * Numerot, joista luku muodstoo. Kantalukuna on 10.
     */
    private int[] numerot;

    /**
     * SuuriLuku-olion sisään leivottu BigInteger-olio. Riittävän laajalla toteutuksella tämä käy tarpeettomaksi.
     */
    private BigInteger bigInt;

    /**
     * Tämänhetkinen alkuluku e:n arvo.
     */
    private static final int ALKULUKU_E = 65537;

    /**
     * Konstruktori, jossa kokonaislukutaulukko antaa SuuriLuku-olion numeerisen arvon.
     * Tyhjä taulukko tulkitaan nollana.
     *
     * @param numerotTaulukko Sisältää numeerisen arvon yksittäisinä numeroina.
     */
    public SuuriLuku(final int[] numerotTaulukko) {
        this.numerot = numerotTaulukko;
        päivitäBigInt();
    }

    /**
     * Konstruktori, jossa merkkijono antaa SuuriLuku-olion numeerisen arvon.
     * Tyhjä merkkijono tulkitaan nollana.
     *
     * @param lukuMerkkijonona Sisältää numeerisen arvon merkkijonon muodossaa.
     */
    public SuuriLuku(final String lukuMerkkijonona) {
        if (lukuMerkkijonona.length() == 0) {
            this.numerot = new int[]{0};
        } else {
            this.numerot = new int[lukuMerkkijonona.length()];
            for (int i = 0; i < lukuMerkkijonona.length(); i++) {
                this.numerot[i] = lukuMerkkijonona.charAt(i) - '0'; // charAt antaa ASCII-arvoja(?), joten
                                                                    // Vähennetään '0' saadaksemme numeerisia arvoja.
            }
        }
        päivitäBigInt();
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Luo uusi todennäköinen alkuluku, jonka pituus saadaan parametrina.
     *
     * @param alkuluvunKoko Alkuluvun bittipituus.
     *
     * @return SuuriLuku, joka on todennäköinen alkuluku.
     */
    public SuuriLuku uusiAlkuluku(final int alkuluvunKoko) {
        return new SuuriLuku(BigInteger.probablePrime(alkuluvunKoko, new Random()).toString());
    }

    /**
     * Kertolasku kahdelle SuurelleLuvulle.
     *
     * @param kerrottava SuuriLuku, jolla kerrotaan.
     */
    // Kertolasku binäärin kautta voisi olla tehokkaampi, mutta vaatisi muutoksen desimaaliin.
    // Oleellisesti toteutus kertolaskulla on vain summauksen toistoa. Tämä ei ole nopein
    // tapa toteuttaa kertolasku, mutta se on intuitiviisin.
    public void kertolasku(final SuuriLuku kerrottava) {
        // Tarkistus nollalle ja tyhjälle.
        if (this.onNolla() || kerrottava.onNolla()) {
            this.numerot = new int[]{0};
        } else {
            SuuriLuku tulos = new SuuriLuku("0");
            for (int i = 0; i <= kerrottava.getNumerot().length - 1; i++) {
                SuuriLuku välitulos = this.kopio();
                välitulos.yhdenKertolasku(kerrottava.numerot[kerrottava.numerot.length - 1 - i]);
                välitulos.lisääNollia(i);
                tulos.pluslasku(välitulos);
            }
            this.numerot = tulos.numerot;
        }
    }

    /**
     * Kerro SuuriLuku yhdellä numerolla [0-9].
     *
     * @param kerroin Numero, jolla kerrotaan.
     */
    public void yhdenKertolasku(final int kerroin) {
        if (kerroin < 0 || kerroin > 9) {
            throw new IllegalArgumentException();
        }
        SuuriLuku uusiSuuriLuku = new SuuriLuku("0");
        for (int i = this.numerot.length - 1; i >= 0; i--) {
            int luku = this.numerot[i] * kerroin; // Apumuuttuja.
            int ykköset = luku % 10; // Apumuuttuja.
            SuuriLuku suuriLuku;
            if (luku >= 10) {
                int kymmenet = (luku - ykköset) / 10; // Apumuuttuja.
                suuriLuku = new SuuriLuku("" + kymmenet + ykköset);
            } else {
                suuriLuku = new SuuriLuku("" + ykköset);
            }
            suuriLuku.lisääNollia(this.numerot.length - 1 - i);
            uusiSuuriLuku.pluslasku(suuriLuku);
        }
        this.numerot = uusiSuuriLuku.numerot;
    }

    /**
     * Lisätään luvun loppuun nollia.
     *
     * @param montakoNollaa Lisättävien nollien määrä.
     */
    public void lisääNollia(final int montakoNollaa) {
        int[] uudetNumerot = new int[this.numerot.length + montakoNollaa];
        for (int i = 0; i < this.numerot.length; i++) {
            uudetNumerot[i] = this.numerot[i];
        }
        this.numerot = uudetNumerot;
    }

    /**
     * Kopioi SuuriLuku-olion numeerinen arvo.
     *
     * @return Uusi olio samalla numeerisella arvolla.
     */
    public SuuriLuku kopio() {
        return new SuuriLuku(this.numerot);
    }

    /**
     * Vähennetään SuuriLuku-olion arvosta yksi (1).
     * Negatiiviset luvut eivät kuitenkaan ole sallittuja.
     */
    public void yhdenPienempi() {
        // Mikäli ollaan jo nollassa, ei mitään tarvitse tehdä.
        if (!this.samaLukuArvo(new SuuriLuku("0"))) {
            int viimeinenIndeksi = this.numerot.length - 1; // Tarpeeton muuttuja, mutta helpottaa koodin lukua.
            if (this.numerot[viimeinenIndeksi] == 0) { // Mikäli viimeinen numero on nolla, tulee miettiä sen
                                                       // vähentämisen vaikutuksia muihinkin numeroihin.
                int eiNollatLaskuri = 1; // Pidetään kirjaa muista kuin nollien määräst.
                for (int i = 1; i < this.numerot.length; i++) { // i=1, sillä viimeinen arvo on jo tarkistettu yllä.
                    if (this.numerot[this.numerot.length - 1 - i] != 0) {
                        break; // Jos löytyy yksikin ei-nolla, ei tarkistusta tarvitse enään jatkaa.
                    } else {
                        eiNollatLaskuri++;
                    }
                }
                if (eiNollatLaskuri != this.numerot.length) { // Mikäli tämä olisi tosi, olisi kaikki luvut nollia,
                                                              // jolloin emme halua vähentää mitään.
                    for (int i = 0; i < eiNollatLaskuri; i++) { // Asetetaan kaikki nollat yhdeksään (10-1=9).
                        this.numerot[this.numerot.length - 1 - i] = 9;
                    }
                    this.numerot[this.numerot.length - 1 - eiNollatLaskuri] -= 1; // Korjataan nollien jälkeinen numero.
                }
            } else {
                this.numerot[viimeinenIndeksi] -= 1; // Triviaali tapaus, kun viimeinen luku ei ole nolla.
            }
            if (this.numerot[0] == 0) {
                this.numerot = poistaAlunNollat(this.numerot); // Siivotaan nollat alusta.
            }
        }
        päivitäBigInt(); // Pidetään bigInt ajan tasalla.
    }

    /**
     * Palauta SuuriLuku-olion sisäinen BigInteger-olio.
     *
     * @return BigInteger-olio, jonka arvo vastaa SuuriLuku-olion arvoa.
     */
    // Metodi on yksityinen, sillä muilla luokilla ei tarvitse olla pääsyä BigInteger-olioon.
    private BigInteger getBigInt() {
        return this.bigInt;
    }

    /**
     * Palautetaan alkuluku e.
     *
     * @return alkuluku e.
     */
    public SuuriLuku e() {
        return new SuuriLuku("" + ALKULUKU_E);
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palautetaan SuuriLuku-olion käänteisluvun jakojäännös.
     *
     * @param käsiteltäväLuku Luku, josta halutaan jakojäännösKäänteisluku.
     *
     * @param jakojäännös Luku, joka toimii jakojäännöksen laskussa.
     *
     * @return Käänteisluvun jakojäännös.
     */
    public SuuriLuku jakojäännösKäänteisluku(final SuuriLuku käsiteltäväLuku, final SuuriLuku jakojäännös) {
        return new SuuriLuku(käsiteltäväLuku.getBigInt().modInverse(jakojäännös.getBigInt()).toString());
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palautetaan luvun potenssin jakojäännös.
     *
     * @param eksponentti Laskun potenssi.
     *
     * @param jakojäännös Laskun jakaja.
     *
     * @return Luvun potenssin jakojäännös.
     */
    public SuuriLuku jakojäännösPotenssi(final SuuriLuku eksponentti, final SuuriLuku jakojäännös) {
        return new SuuriLuku(this.getBigInt().modPow(eksponentti.getBigInt(), jakojäännös.getBigInt()).toString());
    }

    /**
     * Palautetaan SuuriLuku-olion binäärisen arvon pituus.
     *
     * @return Kokonaisluku bittipituus.
     */
    public int bittiPituus() {
        return this.binäärinä().length;
    }

    /**
     * Tieto siitä, onko lukujen numeerinen arvo identtinen.
     *
     * @param verrattava Luku, jota verrataan.
     *
     * @return Totuusarvo siitä ovatko lukujen arvot samat.
     */
    public boolean samaLukuArvo(final SuuriLuku verrattava) {
        int[] tämäNumerot = this.getNumerot(); // Tarpeeton muuttuja, mutta selkiyttää.
        int[] verrattavaNumerot = verrattava.getNumerot(); // Tarpeeton muuttuja, mutta selkiyttää.
        // Jos pituus on eri.
        if (tämäNumerot.length != verrattavaNumerot.length) {
            return false;
        }
        // Jos numeerinen arvo on eri.
        for (int i = 0; i < tämäNumerot.length; i++) {
            if (tämäNumerot[i] != verrattavaNumerot[i]) {
                return false;
            }
        }
        // Muulloin.
        return true;
    }

    /**
     * Palauta SuuriLuku-olion numeerinen arvo merkkijonona. Kantalukuna on 10.
     *
     * @return Merkkijono numeerisesta arvosta.
     */
    public String merkkijonoksi() {
        String s = ""; // StringBuilder olisi nopeampi, mutta haluamme välttää valmiita luokkia.
        for (int i = 0; i < numerot.length; i++) {
            s += this.numerot[i];
        }
        return s;
    }

    /**
     * oistetaan luvun alussa olevat numeerisesti tarpeettomat nollat (00001 = 1).
     *
     * @param luvut Käsiteltävät luvut.
     *
     * @return Luku ilman alkun nollia.
     */
    public int[] poistaAlunNollat(final int[] luvut) {
        int nollaLaskuri = 0; // Pidetään kirjaa nollien määrästä.
        for (int i = 0; i < luvut.length; i++) {
            if (luvut[i] == 0) {
                nollaLaskuri++;
            } else {
                break; // Silmukka voidaan lopettaa, mikäli löydetään yksikin ei-nolla.
            }
        }
        if (nollaLaskuri == luvut.length) {
            // Poikkeustilanteessa kaikki luvut ovat nollia, jolloin palautamme nollan.
            return  new int[]{0};
        } else {
            Taulukko taulukko = new Taulukko(); // Apuolio.
            return taulukko.kopioiTaulukkoVälillä(luvut, nollaLaskuri, luvut.length - 1);
        }
    }

    /**
     * Päivitetään BigInteger samaan numeriseen arvoon kuin SuuriLuvun numerot.
     * Mikäli muutetaan numeroita, tulee pitää myös BigInteger-olion arvo samana,
     * jotta voidaan pitää kumpikin tietorakenne samassa arvossa.
     */
    // Metodi on puhtaasti luokan sisäinen, joten se on määritetty yksityiseksi.
    private void päivitäBigInt() {
        this.bigInt = new BigInteger(this.merkkijonoksi());
    }

    /**
     * SuuriLuvun numerot taulukkona.
     *
     * @return Taulukku lukuarvoista.
     */
    public int[] getNumerot() {
        return this.numerot;
    }

    /**
     * Muutetaan SuuriLuku binäärimuotoon.
     *
     * @return Palautetaan binääri taulukkona.
     */
    public int[] binäärinä() {
        // Triviaali tapaus, kun luku on nolla.
        if (this.onNolla()) {
            return new int[]{0};
        }

        // Kopioidaan numerot, jotta voimme muokata taulukkoa.
        int[] numerotTilapäinen = this.numerot;
        // Alustetaan koko niin, että se on aina riittävän suuri, jotta siitä ei tarvitse
        // välittää alussa. Pienennetään koko myöhemmin.
        int[] binääriNumerot = new int[numerotTilapäinen.length * 10];
        int indeksi = 0; // Indeksi.
        Boolean silmukka = true; // Asetetaan silmukka.

        while (!vainNollia(numerotTilapäinen)) { // Varsinainen muunnos.
            binääriNumerot[indeksi] = kahdenJakojäännös(numerotTilapäinen); // Uusi numero.
            numerotTilapäinen = kahdenOsamäärä(numerotTilapäinen); // Jaetaan koko luku kahdella.
            if (vainNollia(numerotTilapäinen)) {
                silmukka = false;
            }
            indeksi++;
        }

        // Käännä numeroiden järjetys.
        Taulukko taulukko = new Taulukko(); // Apuolio.
        // Käännetään taulukko ympäri ja poistetaan tarpeettomat nollat.
        return poistaAlunNollat(taulukko.taulukkoTakaperin(binääriNumerot));
    }

    /**
     * Palautetaan tieto siitä onko luvussa vain nollia.
     *
     * @param luvut Tarkistettavat luvut.
     *
     * @return Totuusarvo onko luku vain nollia.
     */
    public boolean vainNollia(final int[] luvut) {
        for (int i = 0; i < luvut.length; i++) {
            if (luvut[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tulos joka saadaan jaettaessa luku kahdella, kun jakojäännös jätetään huomiotta.
     *
     * @param luvut Halutun luvun kahden osamärää.
     *
     * @return Jakolaskun tulos jaettassa kahdella ilman jakojäännöstä.
     */
    public int[] kahdenOsamäärä(final int[] luvut) {
        for (int i = luvut.length - 1; i >= 0; i--) { // Lopusta alkuun.
            int numero = luvut[i]; // Tarpeeton, mutta helpottaa elämää.
            if (numero != 0) { // Mikäli numero on nolla ei mitään tarvitse tehdä.
                if (numero % 2 == 0) { // Mikäli jakojäännös on tasan, ei tarvitse miettiä
                                       // jaoen vaikutusta muihin numeroihin.
                    luvut[i] = numero / 2;
                } else { // Jakojäännös ei ole tasan, luku on pariton.
                    luvut[i] = (numero - 1) / 2;
                    if (i != luvut.length - 1) { // Tarkistetaan ettei olla luvun lopussa.
                        luvut[i + 1] += 5; // Korjataan seuraava luku lisäämällä siihen 5 (10/2=5).
                    }
                }
            }
        }
        return poistaAlunNollat(luvut); // Palautetaan ilman ylimääräisiä nollia.
    }

    /**
     * Mikä on jakojäännös, jos luku jaetaan kahdella.
     *
     * @param luvut Jaettava luku.
     *
     * @return Jakojäännös.
     */
    public int kahdenJakojäännös(final int[] luvut) {
        if (luvut[luvut.length - 1] % 2 == 0) {
            return 0;
        }
        return 1;
    }

    /**
     * Kahden SuuriLuku-olion pluslasku.
     *
     * @param lisättävä arvo, joka halutaan lisätä.
     */
    public void pluslasku(final SuuriLuku lisättävä) {
        int[] tämäNumerot = this.getNumerot(); // Ei välttämätön, mutta helpottaa.
        int[] lisättäväNumerot = lisättävä.getNumerot(); // Ei välttämätön, mutta helpottaa.
        int[] summaNumerot;
        int tämäNumerotPituus = tämäNumerot.length; // Ei välttämätön, mutta helpottaa.
        int lisättäväNumerotPituus = lisättäväNumerot.length; // Ei välttämätön, mutta helpottaa.
        // Pluslaskun tulos on numerona vähintään yhtä pitkä kuin pidempi summattava,
        // ja enintään niin pitkä kuin pidempi summattava + 1.
        // Mahdollinen ylimääräinen pituus käsitellään lopussa.
        if (tämäNumerotPituus > lisättäväNumerotPituus) {
            summaNumerot = new int[tämäNumerotPituus + 1];
        } else {
            summaNumerot = new int[lisättäväNumerotPituus + 1];
        }

        Boolean ylitseMenevä = false; // Muuttuja, joka kertoo onko summan tulos 10 tai yli.
        int tämäNumerotIndeksi = tämäNumerot.length - 1;
        int lisättäväNumerotIndeksi = lisättäväNumerot.length - 1;
        for (int i = summaNumerot.length - 1; i >= 0; i--) {
            int summa = 0; // Kahden numeron summa, seuraava luku.
            if (tämäNumerotIndeksi >= 0) {
                summa += tämäNumerot[tämäNumerotIndeksi];
            }
            if (lisättäväNumerotIndeksi >= 0) {
                summa += lisättäväNumerot[lisättäväNumerotIndeksi];
            }
            if (ylitseMenevä) {
                summa++;
            }

            if (summa >= 10) {
                ylitseMenevä = true; // Pidetään kirjaa summauksen vaikutuksesta muualle.
                summa -= 10; // Halutaan vain viimeisin numero.
            } else {
                ylitseMenevä = false;
            }
            summaNumerot[i] = summa; // Lisätään saatu numero tuloksiin.
            tämäNumerotIndeksi--;
            lisättäväNumerotIndeksi--;
            summa = 0; // Jatketaan nollasta, jotta saadaan uusi numero.
        }
        // Asetetaan saadut tulokset.
        this.numerot = poistaAlunNollat(summaNumerot); // Ylimääräisten nollien poisto ja koon pienennys.
        päivitäBigInt();
    }

    /**
     * Onko SuuriLuku-olion arvo nolla.
     *
     * @return Onko arvo nolla vai ei.
     */
    public boolean onNolla() {
        if (this.numerot.length == 0 || (this.numerot.length == 1 && this.numerot[0] == 0)) {
            return true;
        }
        return false;
    }

    /**
     * Muutos binäärinumeroista desimaalinumeroiksi.
     *
     * @param binäärit Muutettava binääri.
     *
     * @return Desimaali, jolla on sama arvo parametrin binäärien kanssa.
     */
    public int[] desimaaliksi(final int[] binäärit) {
        // Muutos binääristä desimaaliksi on toteuttu käymällä binäärit
        // yksitellen läpi ja ja lisäämällä näiden kerroin summaan, mikäli
        // binääri on yhden. Tapa ei ole tehokkain, mutta se on selkeä.
        SuuriLuku desimaalit = new SuuriLuku("0");
        SuuriLuku kerroin = new SuuriLuku("1");
        // Läpikäynti vähiten merkitsevästä numerosta eniten merkitsevään.
        for (int i = binäärit.length - 1; i >= 0; i--) {
            if (binäärit[i] == 1) { // Mikäli binäärissä on nolla, ei mitään tarvitse lisätä.
                SuuriLuku luku = new SuuriLuku("1");
                luku.kertolasku(kerroin);
                desimaalit.pluslasku(luku);
            }
            kerroin.yhdenKertolasku(2); // Kasvatetaan potenssia.
        }
        return desimaalit.getNumerot();
    }

}
