# Määrittelydokumentti

Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
Syksy 2020 - periodi II
Tietojenkäsittelytieteen kandiohjelma
Koodi Javalla

Varsinainen dokumentaatio on suomenkielinen. Koodi, sen sisäiset kommentoinnit ja JavaDoc ovat englanninkielisiä.

### Algoritmit ja tietorakenteet
Toteutan RSA:han liittyviä algoritmeja ja tietorakenteita, jotka mahdollistavat algoritmin toiminnan. RSA-avainparin luonti on oleellisin osa RSA-salausta ja vähintään sen haluan saada toteutettua. Avainten luonti on itsessään algoritmi, mutta kyseinen algoritmi käyttää myös suurta määrä muita algoritmeja apunaan. Haluan saada nämä kaikki toteutettua. Pelkät avaimet eivät kuitenkaan vie pitkälle, joten haluaisin luoda jonkinlaisen edes etäisesti käytännöllisen tavan salata ja purkaa viestejä avaimilla.

Tietorakenteiden tulee tarjota keinoja etenkin suurten lukujen käsittelyyn sekä satunnaisuuteen. Pyrin toteuttamaan nämä molemmat itse, joskin satunnaisuus jää auttamatta vaille todellista satunnaisuutta.

RSA on itsessään deterministinen algoritmi, joten täytteenä (padding) olisi hyvä käyttää jotain epädeterministä algoritmia. En usko, että toteutan kuitenkaan mitään täyte-algoritmeja, sillä nämä ovat itsessään isoja projekteja enkä uskoisi ehtiväni tehdä näitä. Tämä tietysti jättää suuren tietoturvariskin, mutta muutenkaan tarkoituksena ei ole tehdä oikeaan käyttöön ohjelmaa vaan harjoitella asioita. Valmiita RSA-algoritmeja löytyy netistä, mikäli lukija ehdottomasti sellaista tarvitsee.

### Ongelma
Tietoturva on elinehto tietotekniikan ja etenkin Internetin toiminnalle. Tietoturvan keskiössä toimii usein erilaiset salausmetodit. Tavoitteena on luoda tietoturvaa ratkomalla salaukseen liittyviä ongelmia. Tarkemmin sanottuna koitetaan ratkoa salauksen yleistä ongelmaa; salaus on suhteellisesti helppoa, kun turvallinen yhteys on saatu muodostettua, mutta alkuperäinen yhteyden muodostaminen on haasteellista. Symmetrisessä salauksessa, mikäli tunkeutuja pystyy kuuntelemaan viestinvaihdosta sovittaessa salauksesta, voi tunkeutuja purkaa myös myöhemmin kaiken salatun liikkuvan datan. Tarvitaankin tapa sopia salauksesta, joka ei anna tunkeutujalle mahdollisuutta purkaa viestejä, vaikka hänellä olisikin tiedossa mitä alunperin sovittiin. Ratkaisuna toimii epäsymmetrinen salaus, joka on tässä tapauksessa toteutettu RSA-avainparin avulla. RSA:n julkisen avaimen avulla voidaan lähettää salattuja viestejä, jotka vain yksityisen avaimen haltija voi purkaa. Nyt siis vaikka tunkeutuja kuulisikin koko viestinvaihdon, ei hän voi purkaa salattuja viestejä.

Epäsymmetriseksi salauksesi valitsin RSA:n, koska se on ensimmäinen julkisuuteen kerrottu epäsymmetrinen salaus. RSA on myös yksi tunnetuimpia salausmetodeja ja edelleen suuresti käytössä nykypäivänä. Ja mikäli tekijöihinjakoalgoritmit tai kvanttitietokoneet eivät edisty merkittävästi asian suhteen, on RSA myös tulevaisuudessa pätevä salauskeino. Suurten lukujen käsittelyyn en ole löytänyt mitään yleistä algoritmia, vaan se on yhdistelmä omaa ajatusta ja yleisiä tapoja käsitellä lukuja. (TODO Satunnaisuudesta päivitän kun etenee...)

### Käyttäjän syöte
Käyttäjä kertoo komentojen kautta mitä ohjelma tekee. Komentoihin voi liittyä myös erilaisia parametreja, joilla käyttäjä voi hienosäätää suoritusta. Ohjelma ei tee itsenäisesti mitään, vaan kaikki tapahtuu käyttäjän kautta.

### Aika- ja tilavaativuudet
Yleisesti aika- ja tilavaatimuksena on, että ohjelmaa voisi käyttää yleisesti PC:llä järkevässä mielessä. Vaatimukset tarkentuvat ajan kuluessa. Avainten luonnin pitäisi onnistua alle minuuttissa sekä salauksen ja purun alle puolen minuutin, jotta ohjelmassa olisi juurikaan järkeä. (TODO Iso-O -notaation vaatimuksia tulee tarkastella myöhemmin...)

### Lähteet
(TODO muista lisätä lähteet...)
Kaikki lähteet on haettu aikavälillä 28.10.2020 - 19.12.2020.

* Baeldung - https://www.baeldung.com/
	* Java Bitwise Operators - https://www.baeldung.com/java-bitwise-operators

* IETF - https://ietf.org/
	* RFC2313 - https://tools.ietf.org/html/rfc2313
	* RFC2437 - https://tools.ietf.org/html/rfc2437
	* RFC3447 - https://tools.ietf.org/html/rfc3447
	* RFC8017 - https://tools.ietf.org/html/rfc8017
	
* OpenJDK - https://openjdk.java.net/

* OpenSSL - https://www.openssl.org/

* PuTTYgen - https://www.puttygen.com/

* R. L. Rivest, A. Shamir and L. Adleman *A Method for Obtaining Digital Signatures and Public-Key Cryptosystems*
	* https://people.csail.mit.edu/rivest/Rsapaper.pdf
	
* Wikibooks - https://www.wikibooks.org/
	* Cryptography/Generate a keypair using OpenSSL - https://en.wikibooks.org/wiki/Cryptography/Generate_a_keypair_using_OpenSSL

* Wikipedia - https://www.wikipedia.org/
	* Carmichael function - https://en.wikipedia.org/wiki/Carmichael_function
	* Coprime integers - https://en.wikipedia.org/wiki/Coprime_integers
	* Chosen-ciphertext attack - https://en.wikipedia.org/wiki/Chosen-ciphertext_attack
	* Chosen-plaintext attack https://en.wikipedia.org/wiki/Chosen-plaintext_attack
	* Deterministic algorithm - https://en.wikipedia.org/wiki/Deterministic_algorithm
	* Fermat's little theorem - https://en.wikipedia.org/wiki/Fermat%27s_little_theorem
	* Greatest common divisor - https://en.wikipedia.org/wiki/Greatest_common_divisor
	* Integer factorization - https://en.wikipedia.org/wiki/Integer_factorization
	* Known plaintext attack - https://en.wikipedia.org/wiki/Known-plaintext_attack
	* Least common multiple - https://en.wikipedia.org/wiki/Least_common_multiple
	* Modular exponentiation - https://en.wikipedia.org/wiki/Modular_exponentiation
	* Optimal asymmetirc encryption padding - https://en.wikipedia.org/wiki/Optimal_asymmetric_encryption_padding
	* PKCS - https://en.wikipedia.org/wiki/PKCS
	* PKCS 1 - https://en.wikipedia.org/wiki/PKCS_1
	* Public-key cryoptography https://en.wikipedia.org/wiki/Public-key_cryptography
	* RSA numbers - https://en.wikipedia.org/wiki/RSA_numbers
	* RSA problem - https://en.wikipedia.org/wiki/RSA_problem
	* RSA - https://en.wikipedia.org/wiki/RSA_(cryptosystem)
	
* Youtube - https://www.youtube.com/
	* Numberphile - *Encryption and HUGE numbers - Numberphile* - https://www.youtube.com/watch?v=M7kEpw1tn50
	* Numberphile - *RSA-129 - Numberphile* - https://www.youtube.com/watch?v=YQw124CtvO0
	