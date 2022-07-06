# Automata tesztek a FordításokK weboldalhoz

## Az oldalról
A FordításokK egy PHP alapú weboldal Dél-Korea pop kultúrájáról, amely szabadon szerkeszthető minden bejelentkezett felhasználó által.
Az oldal nevének eredete egy szó játék a fordítások és a sokk szavakkal. 
Az oldal a koreai dalok fordításának hozzáadhatóságára fókuszál.

## Követelmények
- [x] Regisztráció
- [x] Bejelentkezés
- [x] Adatkezelési nyilatkozat használata
- [x] Adatok listázása
- [x] Több oldalas lista bejárása
- [x] Új adat bevitel
- [x] Ismételt és sorozatos adatbevitel adatforrásból
- [x] Meglévő adat módosítás
- [x] Adat vagy adatok törlése
- [x] Adatok lementése felületről
- [x] Kijelentkezés

## Elérhetőségi linkek
A tesztelt oldal elérhetősége: [FordításokK](http://forditasokk.probaljaki.hu/)

Projekt GitHub repository-ja: [forditasokk-automata-test](https://github.com/horvathzsofi/forditasokk-automata-test) 

Tesztesetek elérhetősége: [Tesztesetek](https://docs.google.com/spreadsheets/d/191MBhlIjzQ8oI81xvtqpH7dKkrOclZ86t2Y7rggFqs8/edit?usp=sharing)
Vagy pedig a projekt gyökerében.

Az automatizált teszt report elérhetősége: [Allure](https://horvathzsofi.github.io/forditasokk-automata-test/).

## Tesztek futtatása
### Lokálisan
#### Előfeltétel
A `git clone` paranccsal töltse le a gépére a projektet.
 ```
$ git clone https://github.com/horvathzsofi/forditasokk-automata-test.git
```    
#### Lehetőségek
1. Valamilyen IDE segítségével (pl.: IntelliJ IDEA) nyissa meg a projektet és futtassa a teszteket.
2. Tesztek futtatása parancsorból
```
mvn test
```
   *A parancs abban az esetben működik, amennyiben átnavigált a projekt mappájába.*
     
### GitHub action-ön keresztül
#### Előfeltétel
Jogosultság a projekthez.
#### Lehetőségek
1. Már lefutott workflow-k újra futtatásával
2. Repository frissítésével
```
$ git push origin main
```
*A `git push` parancs estén újrafuttatja a teszteket, amennyiben a main branchre lettek feltöltve.*