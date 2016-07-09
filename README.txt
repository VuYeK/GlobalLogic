Zadania rekrutacyjne z Javy w firmie GlobalLogic:

1. Write a Java program that will find first non repeating character in String. Your solution should be as close to optimal as possible.

ex.: for String "Streets" answer is 'r'

2. Write thread safe optimal Singleton implementation in Java. Write simple program that will use Singleton in a way that make sense.

3. Wite a Java program that will use Listener and Command design patterns in a way that make sense.


Zrobi�em projekt w maven'ie �eby by�o �atwo go odtworzy�. Zadania wykona�em w JavaFX, bo wydaje mi si� �e lepiej wygl�da ich prezentacja za pomoc� interfejsu graficznego ni� konsoli. G��wn� klas� kt�r� nale�y uruchomi� po zbudowaniu projektu w Maven'ie jest klasa "Start.java" i wtedy wybra� odpowiednie zadanie. Doda�em jakie� proste testy kt�re potwierdzaj� poprawne dzia�anie.

Odno�nie zada�:
1. Sam algorytm wyszukiwania znajduje si� w klasie "Controller" w metodzie "findFirstNonRepeatingChar".
2. Jest to aplikacja ksi��ki adresowej wykorzystuj�ca baz� danych SQLite. Singleton jest wykorzystany w 2 miejscach: w klasie po��czenia z baz� danych "ConnectDB" oraz w klasie ksi��ki "AddressBook".
3. Jest to aplikacja kt�ra generuje losowe oceny dla podanej liczby student�w oraz w zale�no�ci od zaznaczenia rysuje wybrane wykresy. W paczce "model" wykorzystany jest wzorzec obserwator oraz polecenie (wg mnie te wzorce s� bardzo podobne i je�eli chodzi o obiekty/metody r�nice s� bardzo niewielkie dlatego doda�em do obserwatora tylko kilka metod i 1 klas�).