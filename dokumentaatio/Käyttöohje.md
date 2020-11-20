# Käyttöohje

### Suoritustavat

#### Rakennus lähdekoodista
Voit siirtää tiedostot ohjelmointiympäristöön ja käyttää tämän sisäistä rakennusmetodia tai suorittaa rakennuksen konsolilla. Kyseessä on Gradle-projekti, joten tarvitset Gradle ohjelmiston tähän (varmista, että Gradle on PATH-muuttujassasi). Suorita komento `build gradle`. Mikäli suoritus kaatuu virheellisiin merkkeihin tai johonkin tuntemattomaan varmista, että käytössä on UTF-8 merkistö. (build.gradle tiedostossa tulisi olla rivit `compileJava.options.encoding = "UTF-8"` `compileTestJava.options.encoding = "UTF-8"`.)

Voit myös luoda erilaisia testiraportteja (JavaDoc, JaCoCo, Checkstyle) Gradlen avulla.

#### Jar-tiedostosta
Lataa RSATiralabra.jar ja suorita se konsolista komennolla `java -jar RSATiralabra.jar`. Varmista, että olet samassa hakemistossa kuin tiedosto ja olet määritellyt Javan osoitteen PATH-muuttujaasi.

#### Ohjelmointiympäristössä
Lataa tiedostot ja luo uusi projekti ohjelmointiympäristöösi näistä tiedostoista.

Mikäli käyttöliittymä kaatuu alussa Scanner-olion virheeseen varmista, että sinulla on käytössä vähintään Apache NetBeans versio 11.2. Olen itse kehittänyt sovellusta Apache NetBeansilla, enkä osaa sanoa mitään siitä toimiiko suoritus millään muulla suoritusympäöristöllä. Suosittelen kuitenkin käyttämään ohjelmaa ohjelmointiympäristön ulkopuolella, sillä näin se on tarkoitettu käytettäväksi.

### Käyttöesimerkki
Kuvitellaan, että haluat viestitellä ystäväsi kanssa ja kumallakin on sama sovellus käytössä.

Avaa sovellus.

Komennolla 1 saat luotua julkisen ja yksityisen avaimen. Yksityinen avain koostuu lukuparista (n,e) ja julkinen avain lukuparista (e,d). Lähetä kaverillesi lukuparin (n,e) arvot ja kaverisi lähettää omat arvonsa sinulle. Ei hätää, vaikka joku salakuuntelisi teidän keskustelua ei näiden lukujen tieto vielä anna salakunteelijalle kykyä purkaa tulevaa salattua viestintää.

Haluat lähettää ystävällesi viestin "Moi kaveri! Miten menee?". Käytä komentoa 2 ja anna syötteeksi viestisi "Moi kaveri! Miten menee?". Ohjelma muuttaa tämän luvuksi  (000770011100105000320010700097001180010100114001050003300032000770010500116001010011000032001090010100110001010010100063), jotta voimme sitten salata sen.

Komennolla 4 saat salattua viestisi. Käytä salaukseen aiemmin luomaasi lukua viestistä ja kaverisi sinulle lähettämää julkista avainta.

Lähetä viesti ystävällesi, joka nyt voi purkaa viestin hänen salaisella avaimellaan. Salakuuntelija ei kuitenkaan voi viestiä purkaa, sillä siihen tarvitaan yksityinen avain, joka vain ystäväsi hallussa.

Vastaavasti kaverisi voi lähettää sinun julkisella avaimella salatun viestin, jonka voit purkaa yksityisellä avaimellasi komennolla 5.
