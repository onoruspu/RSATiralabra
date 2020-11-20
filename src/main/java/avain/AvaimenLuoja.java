
package avain;

import tietorakenteet.SuuriLuku;

/**
 * Avainten luonti.
 */
public class AvaimenLuoja {
    /**
     * Tämänhetkinen alkulukujen p ja q koko bitteinä. Koko ei ole lopullinen.
     */
    private static final int ALKULUVUN_KOKO = 1024;

    /**
     * Luo uusi avain (n,e,d).
     *
     * @return Avaimen, joka sisältää julkisen ja yksityisen avaimen tiedot (n,e,d).
     */
    public Avain luoAvaimet() {
        SuuriLuku suuriLuku = new SuuriLuku(); // Olio SuuriLuku-luokan metodien käyttämiseen.

        // Alkuluku p.
        SuuriLuku p = suuriLuku.uusiAlkuluku(ALKULUVUN_KOKO);

        // Alkuluku q.
        SuuriLuku q = suuriLuku.uusiAlkuluku(ALKULUVUN_KOKO);

        // Jakonäännös n.
        SuuriLuku n = suuriLuku.kertolasku(p, q);

        // Fii (engl. phi).
        p.yhdenPienempi();
        q.yhdenPienempi();
        SuuriLuku fii = suuriLuku.kertolasku(p, q);

        // e - julkinen avain
        SuuriLuku e = suuriLuku.e();

        // d - yksityinen avain.
        SuuriLuku d = suuriLuku.jakojäännösKäänteisluku(e, fii);

        // Avain-luokka toimii toistaiseksi BigInteger-oliolla.
        // return new Avain(n.getBigInt(), e.getBigInt(), d.getBigInt());

        return new Avain(n, e, d);
    }

}
