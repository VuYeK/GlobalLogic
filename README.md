# Zadania rekrutacyjne z Javy w firmie GlobalLogic: || GlobalLogic's recruitment tasks from Java

## Zadania / Tasks

1. Write a Java program that will find first non repeating character in String. Your solution should be as close to optimal as possible.

ex.: for String "Streets" answer is 'r'

2. Write thread safe optimal Singleton implementation in Java. Write simple program that will use Singleton in a way that make sense.

3. Wite a Java program that will use Listener and Command design patterns in a way that make sense.

## Rozwiązanie / Solution

Zrobiłem projekt w maven'ie żeby było łatwo go odtworzyć. Zadania wykonałem w JavaFX, bo wydaje mi się że lepiej wygląda ich prezentacja za pomocą interfejsu graficznego niż konsoli. Główną klasą którą należy uruchomić po zbudowaniu projektu w Maven'ie jest klasa "Start.java" i wtedy wybrać odpowiednie zadanie. Dodałem jakieś proste testy które potwierdzają poprawne działanie. <br />
Project was made with Maven and JavaFX. You need tu run Start.java to start program. Project have also some tests. <br />

Odnośnie zadań:<br />
1. Sam algorytm wyszukiwania znajduje się w klasie "Controller" w metodzie "findFirstNonRepeatingChar".<br />
2. Jest to aplikacja książki adresowej wykorzystująca bazę danych SQLite. Singleton jest wykorzystany w 2 miejscach: w klasie połączenia z bazą danych "ConnectDB" oraz w klasie książki "AddressBook".<br />
3. Jest to aplikacja która generuje losowe oceny dla podanej liczby studentów oraz w zależności od zaznaczenia rysuje wybrane wykresy. W paczce "model" wykorzystany jest wzorzec obserwator oraz polecenie (wg mnie te wzorce są bardzo podobne i jeżeli chodzi o obiekty/metody rónice są bardzo niewielkie dlatego dodałem do obserwatora tylko kilka metod i 1 klasą).