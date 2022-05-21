# Ohjelmointi 2 - Harjoitustyö
Java-ohjelmoinnin jatkokurssin harjoitustyö. Kurssisivu ja tarkemmat ohjeet tehtävään: https://ohjelmointi2.github.io/09_harjoitustyo/harjoitustyo

## Projektin tiedostot
```
Pääohjelma:                         Rooli:
    Main.java                           Käynnistää Tomcat-palvelimen sekä määrittää web-sovelluksen tarvittavat asetukset.
    
Model-luokat:                       Rooli:
    Album.java                          Mallintaa yksittäisiä data-alkioita.
    Artist.java                         Mallintaa yksittäisiä data-alkioita.
    
DAO-luokat:                         Rooli:
    AlbumDao.java                       Rajapinta, joka määrittelee, mitä operaatioita JDBCAlbumDao-luokan on toteutettava.
    ArtistDao.java                      Rajapinta, joka määrittelee, mitä operaatioita JDBCArtistDao-luokan on toteutettava.
    Database.java                       Yhdistää tietokantaan sekä sulkee yhteydet tarvittaessa.
    JDBCAlbumDao.java                   Toteuttaa rajapinnan ja sisältää konkreettisen SQL-logiikan.
    JDBCArtistDao.java                  Toteuttaa rajapinnan ja sisältää konkreettisen SQL-logiikan.  
    
Servletit:                          Rooli:
    AlbumServlet.java                   Välittää Java-arvoja ja HTTP-pyyntöjä albums.jsp-tiedostolle.
    ArtistServlet.java                  Välittää Java-arvoja ja HTTP-pyyntöjä artists.jsp-tiedostolle.
    IndexServlet.java                   Välittää Java-arvoja ja HTTP-pyyntöjä index.jsp-tiedostolle.
    SearchArtistServlet.java            Välittää Java-arvoja ja HTTP-pyyntöjä search.jsp-tiedostolle.

JSP-sivut:                          Rooli:
    albums.jsp                          Pitää sisällään albumisivun ulkoisen toiminnallisuuden.
    artists.jsp                         Pitää sisällään artistisivun ulkoisen toiminnallisuuden.
    index.jsp                           Pitää sisällään kotisivun ulkoisen toiminnallisuuden.
    search.jsp                          Pitää sisällään etsi-sivun ulkoisen toiminnallisuuden.
    
JS-tiedosto:                        Rooli:
    app.js                              Sisältää ohjelmakoodin, jonka JSP-sivut hakevat ladatessaan.
```
