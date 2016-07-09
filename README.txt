Zadania rekrutacyjne z Javy w firmie GlobalLogic:

1. Write a Java program that will find first non repeating character in String. Your solution should be as close to optimal as possible.

ex.: for String "Streets" answer is 'r'

2. Write thread safe optimal Singleton implementation in Java. Write simple program that will use Singleton in a way that make sense.

3. Wite a Java program that will use Listener and Command design patterns in a way that make sense.


Zrobi³em projekt w maven'ie ¿eby by³o ³atwo go odtworzyæ. Zadania wykona³em w JavaFX, bo wydaje mi siê ¿e lepiej wygl¹da ich prezentacja za pomoc¹ interfejsu graficznego ni¿ konsoli. G³ówn¹ klas¹ któr¹ nale¿y uruchomiæ po zbudowaniu projektu w Maven'ie jest klasa "Start.java" i wtedy wybraæ odpowiednie zadanie. Doda³em jakieœ proste testy które potwierdzaj¹ poprawne dzia³anie.

Odnoœnie zadañ:
1. Sam algorytm wyszukiwania znajduje siê w klasie "Controller" w metodzie "findFirstNonRepeatingChar".
2. Jest to aplikacja ksi¹¿ki adresowej wykorzystuj¹ca bazê danych SQLite. Singleton jest wykorzystany w 2 miejscach: w klasie po³¹czenia z baz¹ danych "ConnectDB" oraz w klasie ksi¹¿ki "AddressBook".
3. Jest to aplikacja która generuje losowe oceny dla podanej liczby studentów oraz w zale¿noœci od zaznaczenia rysuje wybrane wykresy. W paczce "model" wykorzystany jest wzorzec obserwator oraz polecenie (wg mnie te wzorce s¹ bardzo podobne i je¿eli chodzi o obiekty/metody ró¿nice s¹ bardzo niewielkie dlatego doda³em do obserwatora tylko kilka metod i 1 klasê).