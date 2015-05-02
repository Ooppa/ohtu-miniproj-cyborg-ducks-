# Projektiraportti

## Kohdatut ongelmat

### Sprintti 1

Ensimmäisen sprintin työnteko lähti käyntiin kunhan saatiin ensin user storyt
jaettua teknisen tason taskeiksi. Näiden jakaminen karkeasti ensimmäistä sprinttiä varten oli ongelmatonta, koska projektin speksi oli hyvin tiedossa. Kuitenkin jotkut user storyt jäivät liian isoiksi ja nämä jouduttiin pienentämään pienemmiksi ja keskitetymmiksi user storyiksi. User storyihin liittyvien taskien estimointi tuotti alussa myös hieman hankaluuksia, koska kukaan ei osannut hyvin estimoida kuinka paljon aikaa tietyt taskit veisivät, joten varsinkin ensimmäisen sprintin estimointi oli todella hakuammuntaa ajan kohdalta. Paljastui kuitenkin niin, että usein kehittäjän mielestä triviaaleimmat taskit olivat niitä, joihin aikaa sai palamaan paljon.

Päätimme käyttää projektissamme ulkoista jbibtex-kirjastoa, Mavenia riippuvuuksien hallintaan, Swingiä ulkoasuun ja Trelloa/Google Driveä user storyjen/taskien hallintaan. Ulkoinen kirjasto koitui myöhemmissä sprinteissä lieväksi ongelmaksi, koska se oli erittäin minimaalisesti dokumentoitua ja sen rakenne oli hyvin jäykähkö rajapintojen puutteen takia. Tämä ulkoinen kirjasto kuitenkin takasi meille nopean formatoinnin ja tämän kautta saimme käyttöömme useita työtunteja, jotka voitiin käyttää projektin speksin mukaisiin tärkeimpiin osiin, joten ulkoisen kirjaston käyttö oli itsestäänselvyys jo alusta lähtien.

Ensimmäisen sprintin kohdalla ehkä suurin ongelma kaikista oli kuitenkin, että ohjelman rakenne oli vielä hämärän peitossa, joten turhia luokkia tuli ja myöhemmissä sprinteissä jouduttiin turvautumaan refaktorointiin. Tätä refaktorointia kuitenkin tukivat lukuisat yksikkö- ja käyttäytymistestit (easyB), jolloin refaktorointi voitiin tehdä turvallisesti.

Mitään suuria teknisen tason ongelmia ei ensimmäisen sprintin aikana tullut. Javan ja TravisCI:n välinen kommunikaatio sujui ongelmitta Mavenin sekä GitHubin avulla. GitHubin, Mavenin ja Traviksen runsas käyttö takasi myös sen, että ohjelmaa pystyttiin kehittäämään hyvin yhdessä, jolloin suurempia konflikteja/päällekkäisyyksiä ei syntynyt (muutamaa Netbeanssin generoimaa tiedostoa lukuunottamatta). Tämä workflow myös takasi etätyöskentelyn mahdollisuuden jo alusta lähtien.



### Sprintti 2

Toisen sprintin aikana alkoi paljastua millaisiin ongelmiin ulkoinen
huonosti dokumentoitu kirjasto voisi johtaa. Sprintin user storyihin kuului erilaisten refrenssien tallennus myöhempää työskentelyä varten. Osoittautui kuitenkin, että kirjaston käyttämä objekti-struktuuri ei ollut yhteensopiva esimerkiksi JSON tai Javan Serializable tallennustapojen kanssa. Tämä oli ensimmäinen ja yksi suurimmista ongelmista jonka kohtasimme kahden ensimmäisen sprintin aikana ja jouduimme kuluttamaan paljon aikaa tähän. Erityisen hankalaksi tilanteen teki se, että myöskään vaihtoehtoinen toteutus ei toiminut yhteen ulkoisen kirjastomme kanssa.

Ongelmaan kuitenkin löytyi lopulta ratkaisu suuren refaktoroinnin jälkeen, mutta olimme kuluttaneet paljon aikaa yhteen ongelmaan, joten sprintti oli tuomittu epäonnistumaan. Etätyön suuri käyttö johtuen kaikkien aikatauluista oli myös ehkä yksi osasyy, jonka takia aikaa käytettiin "hukkaan". Etätyön ongelma nimittäin oli se, että vaikka taskit ja user storyt olivat helposti kaikkien nähtävillä, niin kysyminen johonkin tiettyyn ongelmaan muilta ryhmän jäseniltä saattoi ajoittain olla vaikeaa ja aikaavievää.  

### Sprintti 3

Kolmannen sprintin lopulla ilmeni ongelma enkoodauseroissa Windows- ja Linux-ympäristöjen välillä. Lokaalisti kaikki testit menevät ongelmitta läpi, ja .bib tiedostojen importtaaminen ja näyttäminen onnistuu Windows ympäristöissä. Linux ympäristöissä kuitenkin ilmeni ongelma .bib tiedoston importtauksen kanssa, kun ISO 8859-1 enkoodattu tiedosto pitäisi näyttää UTF-8 muodossa. Linux muutti skandit erikoismerkeiksi, ja traviksen buildi failasi, kun joissakin testeissä samaiset skandit eivät muuntuneet oikein traviksen servereillä (oletettavasti linux pohjaisia). Lopulta aikaa ei enää ollut ongelman korjaamiseksi yrityksistä huolimatta.

Tämä ongelma oli taas yksi esimerkki ennakoimattomasta ongelmasta, jonka ratkaisuun ei löytynyt suoralta vastausta. Näihin on erittäin vaikeaa ryhmänä varautua varsinkaan, jos sprintin aikana ei ole jätetty aikaa odottamattomille ongelmille. Edes hyvä kommunikaatio ryhmän sisälle ei voi auttaa erittäin teknisissä ongelmissa.

## Mikä sujui hyvin

Projekti sujui kokonaisuudessa erittäin hyvin. Saimme todella suuren osan loppujenlopuksi halutuista toiminnallisuuksista toteutettua ja toteuttamattomat toiminnalisuudet olisi aivan varmasti saatu seuraavissa sprinteissä tehtyä. Projektin sisäinen laatu parani koko ajan loppua kohden ja ryhmä toimi hyvin yhteen.

Päällekkäistä työtä ei tehty paljoa, vaan jokainen ryhmän jäsen pystyi katsomaan Trellosta ja kysymään Skypen avulla muilta, että mitä muut tekivät juuri sillä hetkellä.

## Mitä opitte, mitä jäi oppimatta

Ulkoisen jbibtex-kirjaston käytöstä aiheutuneet ongelmat olisi mahdollisesti voitu välttää, jos kirjaston rakenteeseen olisi perehdytty alussa paremmin. Toisaalta kirjastossa ei ollut minkäänlaista dokumentaatiota, joten alustavakin tutkimus vei hyvin aikaa varatusta 4h/henkilö. Tämä olisi ollut ongelmallista Scrum-workflown kanssa ja uskommekin, että Scrum toimii vielä paremmin, jos aikaa on enemmän kuin 4h/henkilö per sprintti. 

Scrumista emme juuri tästä syystä päässet käyttämään koko potentiaalia ja voimme sanoakkin, että käytimme enemmän "Scrum but..."-tyyliä. Scrum-malli oli siis taustalla työskentelyssämme koko ajan, mutta esimerkiksi mitään Daily Scrumeja emme pystyneet pitämään erittäin tiukan aikataulun takia.

Opimme kuitenkin erittäin paljon Scrum-tyylistä ja yleisestä projektityöskentelystä ohjelmistojen kanssa. Ennen tätä miniprojektia ei nimittäin monikaan ryhmäläinen ollut työskennellyt ohjelmistoprojektin kanssa johon kuuluu enemmän kuin kaksi ihmistä, joten miniprojekti oli erittäin antoisa oppimisen kannalta.

# Osallistujat

* Leo Kiiski
* Kristian Wahlroos
* Olli-Pekka Mehtonen
* Samu Tamminen
