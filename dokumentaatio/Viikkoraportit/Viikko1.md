# Viikko 1

### Tehty, edistytty ja opittu
Tein käytännön asiat eli ilmoittautumiset, ohjeiden lukemiset ja GitHubin säädöt. Tämän lisäksi mietin ja tutkin aiheita.

Keskiviikkona osallistuin luennolle, jonka jälkeen aloin tutkimaan mahdollisia aiheita ja miettimään näiden toteutuksia. Tässä meni keskiviikko ja torstai. Luin paljon kirjallisuutta ja materiaalia liittyen RSA:han, salauksiin, avaimiin ja tutustuin valmiina oleviin toteuksiin (mm. PuTTY, OpenSSL ja Javan ja Pythonin sisäiset toteutukset). Tämän lisäksi tutustuin myös esimerkiksi 15-peliin, labyrintteihin ja pakkaukseen. Aikaa kului jotain 15-25 tunnin väliltä.

Perjantaina tein käytönnän asioita ja kirjoittelin dokumentteja ja muuta sekalaista. Tähän meni aikaa 3-6 tuntia.

Vähintäänkin minulla on nyt idea siitä mitä teen ja myös jonkinlainen idea siitä miten.

Opin suuren määrän yleisesti salauksesta ja paljon siihen liittyvää matematiikka. Osaan siis puhua salauksesta ja RSA:sta ja miettiä niitä. Tämän taipuminen koodiksi on kuitenkin haaste.

### Ongelmia
Ongelmani ovat pääosin emotionaalisia. Toistuvasti koen, että epäonnistun suuresti ja kaikki tekemäni menee hukkaan. Etenkin pelkään, että saan valtaosan koodista toimimaan, mutta jotain pientä tai isompi kokonaisuus menee pieleen, jonka takia koko koodini on hyödytön. RSA-algoritmi on pitkä prosessi johon sisältyy paljon algoritmeja, jos yksikin epäonnistuu on saavutettu hyöty tietoturvassa olematon. Mikään ei myöskään tunnu erityisen helpolta ja vaikka sinäänsä pidän haasteista, niin haasteiden yhdistäminen aikatauluihin aiheuttaa rasitetta.

Kaikki apu liittyen Javan BigIntegerin toteuttamiseen itse on kullanarvoista. Etenkin potenssilasku kahdella suurella luvulla vaikuttaa haasteelliselta. Hyppään tässä tietysti asioiden edelle, sillä järkevintä on tehdä toteutus ensin Javan omilla luokilla. Silti koen tämän suurimpana haasteena.

Kysymyksinä:
Haluan varmaankin toteuttaa suuret luvut tallentamalla arrayihin yksittäisiä lukuja? Mutta haluanko tallentaa binääri- vai desimaalilukuja? 
Jos sallin tallennuksen kummassakin muodossa, miten teen muutoksen kantaluvusta toiseen? Tiedän yleisesti miten tämä tapahtuu, mutta entäpä kun luvut ovat satoja merkkejä pitkiä?
Kuinka kummassa toteutan potenssin suurilla luvuilla? Exponentiation by squaring?

### Seuraavaksi
Avainten luonti Javan omilla metodeilla olisi jo hyvin paljon. Taidanpa pyrkiä tähän. Dokumentointi, kommentit, testaukset ja checkstyle olisi hyvä myös olla.