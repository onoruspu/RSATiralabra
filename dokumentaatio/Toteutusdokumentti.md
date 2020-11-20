# Toteutusdokumentti

Tämä dokumentti kertoo sovelluksen rakenteesta ja suorityskyvystä. Lisäksi mainitaan sovelluksen puutteista, mahdollisista jatkokehitysiddeoista ja ajatuksista sovelluksen takana. Mikäli toteutus kiinnostaa on suositelvaa, vilkaista myös [määrittelydokumenttia.](dokumentaatio/Määrittelydokumentti.md)

### Yleisrakenne
UI sisältää käyttöliittymän.
DataStructures sisältää tietorakenteita, jotka toimivat apuna RSA:n käytössä.
RSA sisältää varsinaisen ohjelman ytimen.

### Aika- ja tilavaativuudet
Näistä en osaa vielä sen kummemmin sanoa.

### Suorituyskyky
(Tässä luki aiemmin kutakuinkin se mitä testausdokumentissa ennen muokkausta, katso hämmenykseni viikkoraportista.)

### Puutteet ja parannusehdotukset
Jotta sovellusta voitaisiin käyttää aidosti oikeisiin merkittävää tietoturvaa vaativiin salauksiin, vaatisi se paljon validointia joltain tietoturvaan erikoistuneelta taholta. Ennen tätä pitäisi tietysti korjata alla mainittuja tietoturvaan liittyviä ongelmia. Kehittäjää ei voida mitenkään pitää riittävän pätevänä siihen, että toteutus olisi aidosti ja varmasti turvallinen ja luotettava. Toteutus onkin enemmin mielenkiintoinen tutustuminen salaukseen ja sellaisten asioiden salaamiseen joilla ei ole tietoturvallisesti isoa merkitystä.

Tietoturvaan liittyen voidaan esimerkiksi mainita, että sovelluksen käyttämä satunnaisuus on parhaimillaan vain pseudolukugeneraattori, eikä tällaista voida pitää yleisesti turvallisena. Viesteihin ei myöskään liitetä minkäänlaista täytettä (padding), mikä on erittäin huono asia tietoturvan kannalta. Sovellus on myös monessa mielessä altis monille erilaisille hyökkäyksille. Todennäköisesti uhkaa voi olla ainakin CCA- ja CPA-hyökkäyksistä ja  suorituksen ajoitukseen liittyvistä hyökkäistä, mitään ei olla nimittäin tehty sen varmistamiseksi, että suoritusaika olisi vakio eri syötteillä. Lähdekoodi on myös julkisesti kaikkien saatavilla, mikä edelleen antaa mahdolliselle pahantekijälle paljon resursseja hyökkäyksen toteuttamiseen.

Osa ihmisistä pitää graafisen käyttöliittymän puuttumista huonena puolena, jotkut taas suosivat perinteisempää tekstipohjaista käyttöliittymää. Sovellus käyttää vain tekstikäyttöliittymää, mikä joidenkin mielestä on siis huono asia. Sovelluksen toiminallisuuden huomioiden ei graafinen käyttöliittymä kuitenkin tarjoaisi (kehittäjän mielestä) mitään muuta kuin visuaalista ilmettä, joten puute ei ole missään nimessä merkittävä.

Yleisemmin käyttöliittymää voi pitää osittain epäintuitiivisena ja turhan työläänä käyttää. Useissa käytössä olevista toteuksissa käyttäjän ei tarvitse tehdä salauksen eteen mitään tai hyvin vähän toimintoja. Harjoitustyön näkökulmasta tämä ei ole kuitenkaan haluttua. Tavoitteena ei ole tehdä varsinaisesti käyttöön tulevaa sovellusta, vaan enemminkin kyseessä on opettava esimerkki salauksen toiminnasta. Siksi myös on (ainakin kehittäjän mielestä) haluttua, että sovellus enemmin näyttää salauksen toimintaa kuin varsinaisesti toteuttaa sitä. Loistava esimerkki tästä on se, että käyttäjä joutuu itse muuttamaan viestinsä luvuksi erillisellä komennolla ja sitten salaamaan tämän. Oikeassa sovelluksessa käyttäjä voisi vain antaa syötteensä ja salaus voisi tapahtua ilman käyttäjän tietoa mistään muutoksista käsiteltäviksi luvuiksi.

Sovellus ei myöskään ole kaikista nopein, tehokkain tai vie muistia mahdollisimman vähän. Kaikkia näitä ominaisuuksia voitaisiin tarvittaessa parantaa. Ja vaikka Java onkin yleisesti toimiva riippuen tietokoneen käyttöjärjestelmästä ja laitteistosta, on varmasti olemassa jokin konfiguraatioiden yhdistelmä, jolla sovellus ei toimi. Mitään tukea myöskään millään tavoin vammaisille tai tietyille käyttäjäryhmille ei ole. Käytettävyyttä voitaisiin siis laajentaa.

### Lähteet
Kaikki lähteet löytyvät [määrittelydokumentaatiosta.](dokumentaatio/Määrittelydokumentti.md)