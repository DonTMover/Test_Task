# Тестовое Задание
Как оно работает? 
Требуется:
Java 17, gradle 7.5+
PostgreSQL 15.

Тип строк указан в скобках: имя(тип);

Вам потребуется изменить в классе sql изменить данные сервера, логин,пароль

Далее в нашей базе данных мы создает две таблицы items и cards.
В items строки:id(integer),name(text),price(numeric),promotional(boolean);

В cards:discound(integer),first_name(text),last_name(text),id(integer);

Пример запуска программы:`java Main 50-1 51-1 card-9999`

Пример запуска с использованием файла с аргументами: `java Main -f "C:\Users\DonTMover\IdeaProjects\main\1.txt"`

Вывод в консоль так-же продублирован в файл result.txt;(найти его можно в папке проекта)

Из нереализованного: защита от sql инъекций(PreparedStatment не так хорошо работает у меня как хотелось-бы),разбить класс PrintTheCheck на большее количество методов.
