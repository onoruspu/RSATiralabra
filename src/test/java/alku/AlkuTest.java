
package alku;

import java.util.NoSuchElementException;
import org.junit.Test;

/**
 * Testiluokka Alku-luokalle.
 */
public class AlkuTest {
    /**
     * Varmistetaan, että uutta Alku-oliota voida luoda.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void konstruktoriHeittääVirheen() {
        Alku m = new Alku();
    }

    /**
     * Varmistetaan, että mainin kutsuminen käynnistää käyttöliittymään.
     */
    // Koska ohjelmointiympäristössä ei ole liitettynä konsolia, tiedetään käyttöliittymän käynnistyneen
    // kun Scanner-olio koittaa lukea "tyhjää" ja päättyy virheeseen.
    @Test(expected = NoSuchElementException.class)
    public void alkuKäynnistääKäyttöliittymän() {
        Alku.main(new String[0]);
    }
}
