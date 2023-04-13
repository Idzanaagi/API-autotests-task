API-autotests-task

Стек: Java 19, maven, junit5, Rest Assured, Jackson, allure, Jenkins

Проект автотестов для тестирования [PokeAPI](https://pokeapi.co/).

Реализованы:
- [тесты-кейсы](https://github.com/Idzanaagi/API-autotests-task/blob/main/src/TestCases.txt) по чек-листу;
- [POJO объекты](https://github.com/Idzanaagi/API-autotests-task/tree/main/src/test/java/pojo);
- сами [автотесты](https://github.com/Idzanaagi/API-autotests-task/tree/main/src/test/java/api); 
- [хелпер](https://github.com/Idzanaagi/API-autotests-task/blob/main/src/test/java/helpers/RequestWrapperHelper.java), чтобы свести дублирование кода к минимуму;
- параллельный [запуск](https://github.com/Idzanaagi/API-autotests-task/blob/7903c85fa6c4ea192f2d0ef6965c4615862e790b/pom.xml#L79-L82) тестов;
- [сборка и прогон тестов](https://github.com/Idzanaagi/API-autotests-task/blob/main/.github/workflows/maven.yml) через GIthub Actions;
- и сборка, прогон тестов и формирование отчёта Allure в Jenkins:

![api-allure](https://user-images.githubusercontent.com/87720620/231712894-e739cd12-ebbc-4143-a711-afdcf99387fd.png)

Установка и запуск (windows 11, IntelliJ IDEA):
- склонировать этот репозиторий;
- открыть проект в IDE;
- запустить все тесты (Shift+f10 или mvn clean test);
- или перейти в test/java/api/, выбрать понравившийся тест и запустить его.

Сформировать отчёт allure (powershell):
```
mvn clean test
allure generate --clean
allure open
```
