# Viikko 4

### Tehty, edistytty ja opittu
Loin alkuun SuuriLuku-tietorakenteen, joka on ohjelmani pääasiallisin tietorakenne. SuuriLuku-tietorakenteseen rakensin sisälle Javan BigInteger toteutuksen, joten sain korvattua kaikissa muissa luokissa BigInteger-luokan käytön omalla SuuriLuku-luokallani. Voin siis keskittyä muokkamaan omaa tietorakennettani, eikä minun tarvitse muuttaa muiden luokkien toimintaa.

Aloitin yksinkertaisesta "vähennä luvusta yksi" metodista, jossa olikin yllättävän paljon työtä. Osittain johtuen tietysti siitä, että minun piti rakentaa paljon erilaisi apumetodeja ja samanaikaisuus oman luokan ja Javan valmiin välillä tuottaa tietysti aavistuksen enemmän ylimääräistä työtä. Päädyin luomaan oman kevyen tietorakenteen taulukoiden käsittelyyn (luokka Taulukko, paketissa apu), sillä kaiken laittaminen samaan luokkaan kasvattaa sen varmasti liian suureksi. Korvasin vain yhden Javan merkittävän valmiin metodin, mutta olen silti jo yli 200 rivin pituudessa. Ehkäpä tarvitsee miettiä josko jakaisin SuuriLuku-olion metodeita jotenki erilaisiin ryhmittymiin ja sitä kautta luokkiin. Toki tietysti Javan omakin toteutus on erittäin pitkä, mutta silti.

Kirjoittelin käyttöohjetta ja toteutusdokumenttia. Testausdokumenttia varten rakensin testipohjaa ja suoritin avainten luonteja kun käytössä on Javan omia metodeja. En tiedä onko testausdokumenttini tarpeeksi laaja, en oikein voi testata omia tietorakenteita suhteessa Javan omiin, koska omani on niin tällä hetkellä niin suppea. Testaisin mieluusti laajoja kokonaisuuksia (avaimen luonti, salaus, purku), mutta tähän on vielä matkaa ennen kuin saan toteutettua ne kokonaan omilla tietorakenteillani. Vai olisiko minun pitänyt testata jotain pienempiä osa-alueita? Yksittäisiä metodeita?

Viikolla työskentelin semmoisen kymmenisen tuntia, mikä on vähiten mitä olen tehnyt. Aiemmin tekemäni pohdinta tietorakenteista ja projektista siis osoitti hyötyään tällä viikolla (tykkään kävellessä pohtia koodia, mikä ei tietenkään ole varsinaista työskentelyä, mutta toisinaan lähes välttämätöntä sujuvan etenemisen kannalta).

### Ongelmia
Tietorakenteen luomisessa on selvästi paljon työtä. Jokainen alkuperäinen toiminto tuntuu vaativan paljon aputoimintoja, jotka itsessäänkin voivat olla laajoja. Olen myös vakuuttunut, että nopeus tulee jossain kohti olemaan ongelma tai vähintäänkin oma toteutukseni selvästi Javan omia hitaampi. Ongelma on sanana sen mielestäni sen verran vahva etten sanoisi minulla olleen mitään isompia ongelmia, ennemmin esteitä ja hidasteita, joista ainakin toistaiseksi olen selvinnyt.

#### Hämmennys
Kysymyksenä: Olen kirjoitellut toteutus- ja testausdokumenttia, mutta nyt olenkin vain hämmentynyt. Taisin ymmärtää testauksen väärin siinä mielessä, että ajattelin sen olevan nimenomaan ajallista suorituskykyä, mutta se onkin JUnit-testejä?

Onko siis testausdokumentissa tarkoitus kertoa koodin (JUnit) testeistä vai suorituskyvystä? Jos haluan kertoa ajallisesta suorituskyvystä, niin laitanko tämän toteutusdokumentin suorituskyky osioon vai onko tämä testausta?

Jos kysessä on JUnit-testejä niin onko missään ohjetta miten näistä kerron? Mikä laajudeen tulisi olla?

Palautukseni testausdokumentin (ja suorituskyvyn) suhteen ei siis ole nyt ehkä tällä viikolla mitä haluttiin. Toivon ymmärrystä ja vetoan siihen, että kirjoitin käyttöohjetta, jos sitä voisi pitää jonkinlaisena korvikkeena.

### Seuraavaksi
Seuraavaksi on tarkoituksena vähentään SuuriLuku-tietorakenteen riippuvuuttaa Javan BigInteger-toteutuksesta. Haluan siis vähitellen korvata kaikki BigInteger-viittaukset omiin metodeihini. Käytännössä siis matemaattisia laskuja (kertolasku, jakojäännös, ja niin edelleen). En osaa arvioida, kuinka paljon saan toteutuksia korvattua omillani viikon aikana. En myöskään ole vielä päättänyt mitään järjestystä missä lähden asioita korvaamaan. Joskus pitää toki myös luoda oma satunnaisuuden tietorakenne, joka varmaan olisi parasta tehdä kun teen metodin alkulukujen luontiin. Katsotaan viikon päästä.