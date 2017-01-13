
###Aiheen kuvaus ja rakenne

**Aihe**: Vuoropohjainen peli, jossa pelaajan ohjaaman hahmon tulee kulkea pelin antamaan pisteeseen kartalla mahdollisimman vähillä siirroilla.

**Rakenne:**

Pyrin rakentamaan pelin helposti laajennettavaksi, siispä pyrin käyttämään olemassa olevia suunnittelumalleja.

- [x] **Strategy pattern:**
*Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.*
* MoveBehaviour
  * MoveCardinal
  * MoveDiagonally
  * MoveNoWay
  
Tällä rakenteella pystyn muuttamaan kartalla olevien objektien liikkumisalgoritmeja, esimerkiksi muuttamaan pelaaja-hahmon liikkumaan vaakasuoraan tai diagonaalisti. Liikkumattomat kohteet voi lukita tai vaihtaa vaikka automaattisesti liikkuviksi ajon aikana (tätä ei ole vielä alettukaan implementoida).

- [ ] ~~**Observer pattern:**~~ Ei järkeä, tarjottu toiminnallisuus käyttöön
~~*Defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically*~~

~~Tämän suunnittelumallin käyttämistä pohdin karttaobjektien ja kartan välisen suhteen luomiseen (loose coupling). Haen apua pajasta ennen varsinaisen toteutuksen aloittamista.~~

Käyttäjät: Pelaaja
Pelaajan toiminnot:
* pelin käynnistäminen
* Halutun tason valinta
* Pelin pelaaminen
 * Siirtojen tekeminen eri algoritmeilla ja niiden vaihtaminen
* Maalien arpominen kartalle OnOff
* Tekoälyn päättämät siirrot OnOff
* PopUpit OnOff
* Pelin tilastojen tarkastelu
* Pelin lopettaminen

## Luokkakaavio

![luokkakaavio](assets/javaLabra-luokkakaavio.png "Luokkakaavio, ver 1.1")

## Sekvenssikaavio pelaajan ohjaamisesta ylöspäin näppäimellä 'w'

![Sekvenssikaavio1](assets/ExecuteCommand('w').png "sekve1")

## Sekvenssikaavio pelistatuksen tarkistamisesta

![Sekvenssikaavio2](assets/checkGameStatus.png "sekve2")

## Rakenne
