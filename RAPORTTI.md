# Projektiraportti

## Kohdatut ongelmat

### Sprintti 1

Ensimmäisessä sprintissä emme kohdanneet suurempia ongelmia.
Työnteko lähti käyntiin kunhan saatiin ensin User storyt
jaettua teknisen tason taskeiksi.

Ensimmäisellä Sprintillä päätimme käyttää ulkoista jbibtex/jbibtex
kirjastoa, joka koitui myöhemmissä sprinteissä lieväksi ongelmaksi.

### Sprintti 2

Toisen sprintin aikana alkoi paljastua millaisiin ongelmiin ulkoinen
huonosti dokumentoitu kirjasto voisi johtaa. Sprintin tehtäviin storyihin kuului
erilaisten refrenssien tallennus myöhempää työskentelyä varten. Osoittautui kuitenkin,
että kirjaston käyttämä objekti-struktuuri ei ollut yhteensopiva esimerkiksi JSON tai
Javan Serializable tallennustapojen kanssa.

...

### Sprintti 3

Kolmannen sprintin lopulla ilmeni ongelma enkoodauseroissa Windows- ja Linux-ympäristöjen
välillä. Lokaalisti kaikki testit menevät ongelmitta läpi, ja .bib tiedostojen
importtaaminen ja näyttäminen onnistuu Windows ympäristöissä. Linux ympäristöissä
kuitenkin ilmeni ongelma .bib tiedoston importtauksen kanssa, kun ISO 8859-1 enkoodattu
tiedosto pitäisi näyttää UTF-8 muodossa. Linux muutti skandit erikoismerkeiksi, ja
traviksen buildi failasi, kun joissakin testeissä samaiset skandit eivät muuntuneet oikein
traviksen servereillä (oletettavasti linux pohjaisia). Lopulta aikaa ei enää ollut ongelman
korjaamiseksi yrityksistä huolimatta.

...

## Mitä opitte, mitä jäi oppimatta

Ulkoisen jbibtex/jbibtex kirjaston käytöstä aiheutuneet ongelmat olisi mahdollisesti voitu
välttää, jos kirjaston rakenteeseen olisi perehdytty alussa paremmin. Toisaalta
kirjastossa ei ollut minkäänlaista dokumentaatiota, joten alustavakin tutkimus vei
hyvin aikaa varatusta 4h/henkilö.

...

# Osallistujat

Leo Kiiski

...
