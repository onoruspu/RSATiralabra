
package apu;

/**
 * Työkaluja merkkijonojen käsittelyyn.
 */
public class MerkkijonoMuutos {
    /**
     * Muuta merkkijonona oleva viesti Unicode-merkkien arvoiksi.
     * Arvot palautetaan merkkijonon muodossa eikä yksittäisinä lukuina.
     *
     * @param message merkkijono, joka halutaan luvuksi.
     *
     * @return merkkijono, joka sisältää alkuperäisen merkkijonon merkit arvoina.
     */
    public String merkkijonoLukujenMuotoon(final String message) {
        String numberForm = "";
        for (int i = 0; i < message.length(); i++) {
            int charValue = (int) message.charAt(i); // Muutetaan merkki luvuksi.
            // Jotta voidaan tietää milloin merkki vaihtuu toiseen, muutetaan kaikki merkit 5 numeron mittaisiksi
            // lisäämällä alkuun tarvittava määrä nollia. 5 numeroa, koska UTF-16 suurin arvo on 65535.
            // StringBuilder olisi nopeampi, mutta tätä ei haluta käyttää.
            if (charValue == 0) {
                numberForm += "00000";
            } else if (charValue < 10) {
                numberForm += "0000" + charValue;
            } else if (charValue < 100) {
                numberForm += "000" + charValue;
            } else if (charValue < 1000) {
                numberForm += "00" + charValue;
            } else if (charValue < 10000) {
                numberForm += "0" + charValue;
            }
        }
        return numberForm;
    }

    /**
     * Muuta merkkijonona oleva luku, joka sisältää Unicode-arvoja, merkkijonoksi.
     * Luku ei ole varsinainen luku vaan se on merkkijonon muodossa.
     *
     * @param message luku (merkkijono), joka halutaan merkeiksi.
     *
     * @return merkkijono, joka sisältää arvot muutettuina merkeiksi.
     */
    public String lukujenMuotoMerkkijonoksi(final String message) {
        // Jos merkkijonossa ei ole 5:llä jaollinen määrä merkkejä, puuttuu alusta joitain nollia.
        String messageAndZeroes = "";
        for (int i = 0; i < (5 - message.length() % 5); i++) { // Vähennetään viidestä jakojäännös viidellä,
                                                               // jotta saadaan puuttuvien nollien määrä.
            messageAndZeroes += "0";
        }
        messageAndZeroes = messageAndZeroes + message; // Lisätään mahdolliset puuttuvat nollat.

        // Muutetaan lukuja merkeiksi viiden paloissa.
        String stringForm = "";
        for (int i = 0; i < messageAndZeroes.length(); i += 5) {
            int num1 = messageAndZeroes.charAt(i) - '0'; // '0' vähennys jotta saadaan lukuja ('0' = 48).
            int num2 = messageAndZeroes.charAt(i + 1) - '0';
            int num3 = messageAndZeroes.charAt(i + 2) - '0';
            int num4 = messageAndZeroes.charAt(i + 3) - '0';
            int num5 = messageAndZeroes.charAt(i + 4) - '0';
            String str = "" + num1 + num2 + num3 + num4 + num5; // Muutetaan merkkijonoksi.
            int value = merkkijonoKokonaisluvuksi(str); // Muutetaan luvuksi.
            char oneChar = (char) value; // Muutetaan merkiksi.
            stringForm += oneChar; // Lisätään merkki palauttetavaan merkkijonoon.
        }

        return stringForm;
    }

    /**
     * Muuta merkkijonona oleva luku kokonaisluvuksi.
     * Muutokset negatiivisista, erityisen suurista tai liukuluku muotoisista luvuista eivät onnistu.
     *
     * @param string merkkijono, joka sisältää arvoksi muutettavan luvun merkkijonona.
     *
     * @return kokonaisluku, jonka arvo on sama merkkijonon sisällön kanssa.
     */
    public int merkkijonoKokonaisluvuksi(final String string) {
        int number = 0;
        int multiply = 1;
        // Käydään numero kerrallaan merkkijono läpi ja lisätään saatu numero tulokseen.
        // Lopusta alkuun, jotta voidaan kasvattaa kerrointa sen pienentämisen sijaan (mielestäni intuitiivisempi tapa).
        for (int i = string.length() - 1; i > -1; i--) {
            number += (string.charAt(i) - '0') * multiply; // charAt antaa Unicode arvoja, mutta haluamme lukuja joten
                                                           // vähennetään '0' eli 48.
            multiply *= 10; // Kysessä on desimaali luku, joten kerroin kasvaa aina kymmenellä.
        }
        return number;
    }
}
