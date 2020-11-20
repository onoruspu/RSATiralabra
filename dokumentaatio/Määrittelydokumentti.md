# Määrittelydokumentti

Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
Syksy 2020 - periodi II
Tietojenkäsittelytieteen kandiohjelma
Koodattu Javalla

Varsinainen dokumentaatio, JavaDoc ja koodin sisäinen kommentointi ovat suomenkielisiä. Koodi on siinä mielessä englantia, ettei ole olemassa suomenkielistä Javan koodauskieltä.

### Algoritmit ja tietorakenteet
Toteutan RSA:han liittyviä algoritmeja ja tietorakenteita, jotka mahdollistavat algoritmin toiminnan. RSA-avainparin luonti on oleellisin osa RSA-salausta ja vähintään sen haluan saada toteutettua. Avainten luonti on itsessään algoritmi, mutta kyseinen algoritmi käyttää myös suurta määrä muita algoritmeja apunaan. Haluan saada nämä kaikki toteutettua. Pelkät avaimet eivät kuitenkaan vie pitkälle, joten haluaisin luoda jonkinlaisen edes etäisesti käytännöllisen tavan salata ja purkaa viestejä avaimilla.

Tietorakenteiden tulee tarjota keinoja etenkin suurten lukujen käsittelyyn sekä satunnaisuuteen. Pyrin toteuttamaan nämä molemmat itse, joskin satunnaisuus jää auttamatta vaille todellista satunnaisuutta.

RSA on itsessään deterministinen algoritmi, joten täytteenä (padding) olisi hyvä käyttää jotain epädeterministä algoritmia. En usko, että toteutan kuitenkaan mitään täyte-algoritmeja, sillä nämä ovat itsessään isoja projekteja enkä uskoisi ehtiväni tehdä näitä. Tämä tietysti jättää suuren tietoturvariskin, mutta muutenkaan tarkoituksena ei ole tehdä oikeaan käyttöön ohjelmaa vaan harjoitella asioita. Valmiita RSA-algoritmeja löytyy netistä, mikäli lukija ehdottomasti sellaista tarvitsee.

### Ongelma
Tietoturva on elinehto tietotekniikan ja etenkin Internetin toiminnalle. Tietoturvan keskiössä toimii usein erilaiset salausmetodit. Tavoitteena on luoda tietoturvaa ratkomalla salaukseen liittyviä ongelmia. Tarkemmin sanottuna koitetaan ratkoa salauksen yleistä ongelmaa; salaus on suhteellisesti helppoa, kun turvallinen yhteys on saatu muodostettua, mutta alkuperäinen yhteyden muodostaminen on haasteellista. Symmetrisessä salauksessa, mikäli tunkeutuja pystyy kuuntelemaan viestinvaihdosta sovittaessa salauksesta, voi tunkeutuja purkaa myös myöhemmin kaiken salatun liikkuvan datan. Tarvitaankin tapa sopia salauksesta, joka ei anna tunkeutujalle mahdollisuutta purkaa viestejä, vaikka hänellä olisikin tiedossa mitä alunperin sovittiin. Ratkaisuna toimii epäsymmetrinen salaus, joka on tässä tapauksessa toteutettu RSA-avainparin avulla. RSA:n julkisen avaimen avulla voidaan lähettää salattuja viestejä, jotka vain yksityisen avaimen haltija voi purkaa. Nyt siis vaikka tunkeutuja kuulisikin koko viestinvaihdon, ei hän voi purkaa salattuja viestejä.

Epäsymmetriseksi salauksesi valitsin RSA:n, koska se on ensimmäinen julkisuuteen kerrottu epäsymmetrinen salaus. RSA on myös yksi tunnetuimpia salausmetodeja ja edelleen suuresti käytössä nykypäivänä. Ja mikäli tekijöihinjakoalgoritmit tai kvanttitietokoneet eivät edisty merkittävästi asian suhteen, on RSA myös tulevaisuudessa pätevä salauskeino. Suurten lukujen käsittelyyn en ole löytänyt mitään yleistä algoritmia, vaan se on yhdistelmä omaa ajatusta ja yleisiä tapoja käsitellä lukuja.

### Käyttäjän syöte
Käyttäjä kertoo komentojen kautta mitä ohjelma tekee. Komennot jakautuvat pienempiin osiin, joilla käyttäjältä kysytään vaadittavat tiedot komennot suorittamiseen. Ohjelma ei varsinaisesti tee itse mitään, vaan kaikki toiminallisuus tapahtuu käyttäjän aloitteesta.

### Aika- ja tilavaativuudet
Yleisesti aika- ja tilavaatimuksena on, että ohjelmaa voisi käyttää yleisesti yleisellä tietokoneella järkevässä mielessä. Avainten luonnin pitäisi onnistua alle minuuttissa sekä salauksen ja purun alle puolen minuutin, jotta ohjelmassa olisi juurikaan järkeä.

### Lähteet
Kaikki lähteet on haettu aikavälillä 28.10.2020 - 6.11.2020.

* Baeldung - https://www.baeldung.com/
	* BufferedReader vs Console cs Scanner in Java - https://www.baeldung.com/bufferedreader-vs-console-vs-scanner-in-java
	* Introduction to Javadoc - https://www.baeldung.com/javadoc
	* Java Binary Numbers in Java - https://www.baeldung.com/java-binary-numbers
	* Java Bitwise Operators - https://www.baeldung.com/java-bitwise-operators
	* Unit Testing of System.out.println() with JUnit - https://www.baeldung.com/java-testing-system-out-println
	
* Brian Aspinall - http://brianaspinall.com/	
	* http://brianaspinall.com/wp-content/uploads/2015/11/better_ascii_table.jpg

* GeeksforGeeks - https://www.geeksforgeeks.org/
	* Program to check if input is an integer or a string - https://www.geeksforgeeks.org/program-check-input-integer-string/
	
* Github - https://github.com
	* The JaCoCo Plugin - TiraLabra/Testing-and-rmq - https://github.com/TiraLabra/Testing-and-rmq
	
* Gradle - https://gradle.org/
	* https://docs.gradle.org/current/userguide/jacoco_plugin.html
	
* Codereadability - https://www.codereadability.com/
	* Matt Zeunert - Maximum Line Length - https://www.codereadability.com/maximum-line-length/
	
* Checkstyle - https://checkstyle.sourceforge.io/ - https://checkstyle.org/
	* https://checkstyle.org/config_coding.html
	* https://checkstyle.org/config_naming.html
	* https://checkstyle.sourceforge.io/cmdline.html
	* https://checkstyle.sourceforge.io/config_design.html

* IETF - https://ietf.org/
	* RFC2313 - https://tools.ietf.org/html/rfc2313
	* RFC2437 - https://tools.ietf.org/html/rfc2437
	* RFC3447 - https://tools.ietf.org/html/rfc3447
	* RFC8017 - https://tools.ietf.org/html/rfc8017
	
* Javatpoint - https://www.javatpoint.com/
	* Java Convert int to char - https://www.javatpoint.com/java-int-to-char
	* Unicode System - https://www.javatpoint.com/unicode-system-in-java
	
* Java2Blog - https://java2blog.com/
	* no main manifest attribute - https://java2blog.com/no-main-manifest-attribute/

* JUnit - https://junit.org/junit5/

* Know Program - https://www.knowprogram.com/
	* Unicode Character Set in Java - https://www.knowprogram.com/java/unicode-character-set/

* Medium - https://medium.com/
	* Javinpaul - Does Column Width of 80 Make Sense in 2020? - https://medium.com/@javinpaul/does-column-width-of-80-make-sense-in-2018-50c161fbdcf6
	
* OpenJDK - https://openjdk.java.net/

* OpenSSL - https://www.openssl.org/

* Oracle - https://www.oracle.com/index.html
	* Class Character - https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#unicode
	* Class StringBuilder - https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
	* Primitive Data Types - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	
* Princeton Universty - https://introcs.cs.princeton.edu/java/99crypto/RSA.java.html

* PuTTYgen - https://www.puttygen.com/

* R. L. Rivest, A. Shamir and L. Adleman *A Method for Obtaining Digital Signatures and Public-Key Cryptosystems*
	* https://people.csail.mit.edu/rivest/Rsapaper.pdf
	
* Stackoverflow - https://stackoverflow.com/
	* CheckStyle with warning '100' is a magic number - https://stackoverflow.com/questions/30044804/checkstyle-with-warning-100-is-a-magic-number
	* How to generate javado documentation with umlauts - https://stackoverflow.com/questions/1319489/how-to-generate-javadoc-documentation-with-umlauts
	* JavadocPackage usage in checkstyle - https://stackoverflow.com/questions/1366044/javadocpackage-usage-in-checkstyle
	* java.util.NoSuchElementException in basic Scanner usage - https://stackoverflow.com/questions/58259574/java-util-nosuchelementexception-in-basic-scanner-usage
	* JUnit test for System.out.println() - https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
	* Manually converting a string to an integer in Java - https://stackoverflow.com/questions/8893768/manually-converting-a-string-to-an-integer-in-java
	* Netbeans - fix imports on entire project - https://stackoverflow.com/questions/30321854/netbeans-fix-imports-on-entire-project
	* private final static attribute vs private final attribute - https://stackoverflow.com/questions/1415955/private-final-static-attribute-vs-private-final-attribute
	* Should we keep 80 characters per line in Java? - https://stackoverflow.com/questions/6724945/should-we-keep-80-characters-per-line-in-java
	* What is a magic number, and why is it bad? - https://stackoverflow.com/questions/47882/what-is-a-magic-number-and-why-is-it-bad
	* Why am I getting this warning about utility classes in Java - https://stackoverflow.com/questions/7766277/why-am-i-getting-this-warning-about-utility-classes-in-java
	

* Tutorialspoints - https://www.tutorialspoint.com/index.htm
	* Java - Arrays - https://www.tutorialspoint.com/java/java_arrays.htm
	* JUnit - Exceptions Test - https://www.tutorialspoint.com/junit/junit_exceptions_test.htm
	* JUnit - Quick Guide - https://www.tutorialspoint.com/junit/junit_quick_guide.htm
	
* https://unicode-table.com/en/
	
* Vojtech Ruzicka - https://www.vojtechruzicka.com/
	* Bit Manipulation in Java – Bitwise and Bit Shift operations - https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/
	
* Wikibooks - https://www.wikibooks.org/
	* Cryptography/Generate a keypair using OpenSSL - https://en.wikibooks.org/wiki/Cryptography/Generate_a_keypair_using_OpenSSL

* Wikipedia - https://www.wikipedia.org/
	* Alkuluku - https://fi.wikipedia.org/wiki/Alkuluku
	* Carmichael function - https://en.wikipedia.org/wiki/Carmichael_function
	* Coprime integers - https://en.wikipedia.org/wiki/Coprime_integers
	* Chosen-ciphertext attack - https://en.wikipedia.org/wiki/Chosen-ciphertext_attack
	* Chosen-plaintext attack https://en.wikipedia.org/wiki/Chosen-plaintext_attack
	* Deterministic algorithm - https://en.wikipedia.org/wiki/Deterministic_algorithm
	* Fermat's little theorem - https://en.wikipedia.org/wiki/Fermat%27s_little_theorem
	* Fii - https://fi.wikipedia.org/wiki/Fii
	* Final (Java) - https://en.wikipedia.org/wiki/Final_%28Java%29
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