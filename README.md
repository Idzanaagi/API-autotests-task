API-autotests-task

Стек: Java 19, maven, junit5, Rest Assured, Jackson, allure

Структура проекта:
- TestCases.txt - тест-кейсы 
- src/test/java/api/ - тесты
- src/test/java/pojo - POJO объекты

Реализовано:
- подробные тест-кейсы по чек-листу 
- автотесты
- отчёты Allure 
- параллельный запуск тестов 
- запуск в CI/CD

Сформировать отчёт allure (powershell):
```
mvn clean test
allure generate --clean
allure open
```