package alku;

import kayttoliittyma.Kayttoliittyma;

/**
 * Sovelluksen käynnistys.
 */
public final class Alku {

    /**
     * Vaikkakin epätodennäköistä, saattaisi joku tai jokin koittaa luoda uuden Main-objektin
     * mitä emme tietenkään halua.
     */
    protected Alku() {
        throw new UnsupportedOperationException(); // Virheen heitto estää erilaiset kiertomenetelmät.
    }

    /**
     * Käynnistä ohjelman käyttöliittymä.
     *
     * @param args parametreja ei huomioida. Sovelluksen käyttö tapahtuu käyttöliittymän kautta.
     */
    public static void main(final String[] args) {
        //new Kayttoliittyma().käynnistä(); // Käynnistetään käyttöliittymä.
    }
}
