# Testausdokumentti

### Testien luonteesta
Suorituskykyä on mitattu Javan System.nanoTime-metodilla, joka mittaa aikaa. Tätä ei ole lähdekoodissa, vaan se on lisätty sinne testauksen yhteydessä. Jokainen mittaus on tehty kolmeen kertaan ja otettu tulosten keskiarvo. Ohjelmointiympäristönä on toiminut Apache Netbeans 12.0 Java 1.8:lla. Käyttöjärjestelmänä on ollut Windows 10 ja suorittimena Intel i5-3570k 1333Mhz keskusmuistin nopeudella.

Tulee pitää mielessä, että testausasetelma on kaikesta huolimatta varsin rajallinen ja tulokset ovat enemmin suuntaa antavia kuin tarkkoja totuuksia.

Tällä hetkellä ei ole kauhesti mitä testata.


Ennen muokkausta kirjoitin ylemmäs:



Muokkaus: Olin mittaamassa avainten luontiin liittyvää aikaa ja olin kirjoittamassa ajallisia testauksia, mutta testaus onkin siis koodin sisäistä JUnit testausta? Mikäli näin, löytyy JaCoCo-raportti dokumentaatiosta. (Katso hämmenykseni viikkoraportista.)



Muokkauksen jälkeen kirjoitin alemmas:

(JUnit?)
Mitä on testattu, miten tämä tehtiin?s
Yleisesti olen testannut, että asiat toimivat ja onnistuvat. Joitain virheisiin perustuvia testejä on käytössä, mutta nämä on vähäisiä. Jokaiselle luokalle ja paketille olen luonut testejä painottaen etenkin käyttöliittymään ja RSA-avaimiin liittyviä testejä.

Minkälaisilla syötteillä testaus tehtiin?
Yleisesti olen pyrkinyt tekemään testejä monilla erilaisilla luvuilla, sillä suurin osa koodista käsittelee numeroita. Yleisesti käytössäni on ollut nolla, yksi, jokin hyvin suuri luku ja jokin sekalainen luku.

Miten testit voidaan toistaa?
Testit voidaan suorittaa Gradlella komennolla `Gradle test`. Varmista, että Gradle on PATH-muuttujassasi. Olen myös lisännyt itse luomani testit dokumentaatio osioon.

Graafinen muoto
Ei ole tällä hetkellä. Tiedän kuitenkin miten teen tämä.