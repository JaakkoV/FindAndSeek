
###Aiheen kuvaus ja rakenne

**Aihe**: Vuoropohjainen peli, jossa pelaajan ohjaaman hahmon tulee kulkea pelin antamaan pisteeseen kartalla alle annettujen siirtojen lukumäärän.

**Rakenne:**

Pyrin rakentamaan pelin helposti laajennettavaksi, siispä pyrin käyttämään olemassa olevia suunnittelumalleja:

**Strategy pattern:**
*Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.*
* MoveBehaviour
  * MoveCardinal
  * MoveDiagonally
  * MoveNoWay
  
Tällä rakenteella pystyn muuttamaan kartalla olevien objektien liikkumisalgoritmeja, esimerkiksi muuttamaan pelaaja-hahmon liikkumaan vaakasuoraan tai diagonaalisti. Liikkumattomat kohteet voi lukita tai vaihtaa vaikka automaattisesti liikkuviksi ajon aikana (tätä ei ole vielä alettukaan implementoida).

**Observer pattern:**
*Defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically*

Tämän suunnittelumallin käyttämistä pohdin karttaobjektien ja kartan välisen suhteen luomiseen (loose coupling). Haen apua pajasta ennen varsinaisen toteutuksen aloittamista.

Käyttäjät: Pelaaja
Pelaajan toiminnot:
* päävalikon näkeminen
* pelimuodon valitseminen
* vaikeusasteen valitseminen
* pelikentän valitseminen
* pelin käynnistäminen
* pelin pelaaminen

## Määrittelyvaiheen luokkakaavio
Tästä piirroksesta puuttuu vielä muutama todennäköisesti implementoitava luokka selkeyden vuoksi. Koitan ensin saada "pelistä" version, jossa toteutan pelikartan merkistöllä ja saan sinne renderöityä karttaobjekteja, joita sitten yritän saada liikkumaan. Tämän jälkeen lisäilen laskureita ja voittologiikkaa yms.

![Ensimmäinen versio luokkakaaviosta](javaLabra-luokkakaavio.png "Luokkakaavio, ver 1.0.")
