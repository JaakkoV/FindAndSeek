
#Aiheen kuvaus ja rakenne

##Aihe: Vuoropohjainen peli, jossa pelaajan ohjaaman hahmon tulee kulkea pelin antamaan pisteeseen kartalla mahdollisimman vähillä siirroilla.

##Käyttäjät:
* Pelaaja

###Pelaajan toiminnot:
* Pelin käynnistäminen
* Halutun tason valinta
* Pelin pelaaminen
 * Siirtojen tekeminen eri algoritmeilla ja niiden vaihtaminen
* Maalien arpominen kartalle OnOff
* Tekoälyn päättämät siirrot OnOff
* PopUpit OnOff
* Pelin tilastojen tarkastelu
* Pelin lopettaminen

## Rakenne
Ohjelman rakennetta suunniteltaessa on mietitty alusta alkaen ylläpidettävyyttä ja laajennettavuutta. Tämä ajatus on ollut korkeampi prioriteetti kuin moninaisten toiminnallisuuksien toteuttaminen "riittää, että se demoajon kestää"-mentaliteetilla. Koodi ja luokkarakenne on pyritty paketoimaan ja abstrahoimaan olio-ohjelmoinnin paradigman mukaisesti.

### Suunnittelumallit
**Strategy pattern:**
*Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.*
* MoveBehaviour
  * MoveCardinal
  * MoveDiagonally
  * MoveNoWay
Onnistuneesti implementoitu Strategy patternin, jonka avulla pystytään muuttamaan kartalla olevien objektien liikkumisalgoritmeja ajon aikana. Esimerkiksi muuttamaan pelaaja-hahmon liikkumaan vaakasuoraan tai diagonaalisti.

### Luokkakaavio
![luokkakaavio](assets/javaLabra-luokkakaavio.png "Luokkakaavio, ver 1.1")

Luokkakaaviosta käy ilmi luokkien väliset suhteet. Paketit ovat eheitä kokonaisuuksia, ehkä Main-luokan Game-pakettiin tiputtamista lukuunottamatta. Luokkakaaviossa ei ole piirretty utils-paketin suhteita kuvan sotkemisen välttämiseksi. Niissä ei kuitenkaan mitään salattavaa ole, mutta aputyökalujen käyttämisen luonteen vuoksi niiden avaaminen kuvassa ei edesauta ohjelman luokkalogiikan ymmärtämistä. Utils-paketin IntelligentPlayer tarjoaa tekoälyn ohjaamaan pelaajaa, Randomizeria käytetään muutamissa luokissa generoimaan satunnaislukuja staattisilla metodeilla, KeyboardListener tarjoaa näppäimistönkuuntelupalvelua.

Main-luokassa luodaan GUI ja kutsutaan run().

Suurin paketti ui pitää sisällään graafisen käyttöliittymän toiminnallisuudet:
 - GUI:lla on useita eri paneeleita, jotka piirretään 

### Sekvenssikaavio pelaajan ohjaamisesta ylöspäin näppäimellä 'w'

![Sekvenssikaavio1](assets/ExecuteCommand('w').png "sekve1")

### Sekvenssikaavio pelistatuksen tarkistamisesta

![Sekvenssikaavio2](assets/checkGameStatus.png "sekve2")


