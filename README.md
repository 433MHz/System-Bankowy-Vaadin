Wykonane przy użyciu freamworka spring-boot, Maven oraz Vaadin. Wygenerowane na stronie https://vaadin.com/start/latest

(BRAK PLIKU .JAR NA GITHUBIE) Aby uruchomić trzeba w Maven uzyc komendy mvn spring-boot:run a następnie w przeglądarce wejść pod adres http://localhost:8080/

(BRAK PLIKU .JAR NA GITHUBIE) Można też uruchomić plik wykonywalny .jar w folderze target za pomocą CMD komendą "java -jar (nazwa pliku)" a następnie wejść pod adres http://localhost:8080/

(TYLKO TO ZADZIAŁA) A jeżeli nie działa ani tak ani tak to trzeba w Intellij IDEA kliknąć file/ open / a następnie otworzyć plik pom.xml i wybrać opcje uruchomienia jako projekt. Następnie trzeba wybrać po prawej stronie zakładkę "Maven"/ rozwinąć zakładkę "Stronabankowavaadin"/ "Plugins"/ "spring-boot"/ i kliknąć 2x na opcje "spring-boot:run". Po tej czynności należy chwilę poczekać i wejść w przeglądarce pod adres http://localhost:8080/


Projekt nie używa baz danych ponieważ ich jeszcze nie umiem ¯\_(ツ)\_/¯
