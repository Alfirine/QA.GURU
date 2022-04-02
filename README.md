<p align="right">
<a href="https://visitor-badge-reloaded.herokuapp.com/badge?page_id=Alfirine/QA.GURU&color=55acb7&style=flat&logo=Github&text=Hello_Visitors!">
  <img title="|Customized by Alfirine|" src="https://visitor-badge-reloaded.herokuapp.com/badge?page_id=Alfirine/QA.GURU&color=55acb7&style=flat&logo=Github&text=Hello_Visitors!"/>
  <img title="|Customized by Alfirine|" alt="GitHub watchers" src="https://img.shields.io/github/watchers/Alfirine/QA.GURU?color=55acb7&logo=github">
</a>
</p>

# QA.GURU. Дипломная работа. Тесты для webinar.ru :star:

## UI тесты с API предусловиями
:white_check_mark: Add single tag to course     
:white_check_mark: Add multiple tags to course     
:white_check_mark: Delete tags in course    
:white_check_mark: Add single tag to student     
:white_check_mark: Add multiple tags to student    
:white_check_mark: Delete tags from student    
:white_check_mark: Registration for course on current date    
:white_check_mark: Registration for course on future date    
:white_check_mark: Create new course    
:white_check_mark: Create template course    
:white_check_mark: Movement of lessons within one part    
:white_check_mark: Movement of lessons between parts    
:white_check_mark: Movement of parts

## :rocket: Технологии и инструменты

<p  align="left"

<code><img width="5%" title="IntelliJ IDEA" src="images/DEA-logo.svg"></code>
<code><img width="5%" title="Java" src="images/java-logo.svg"></code>
<code><img width="5%" title="Selenide" src="images/selenide-logo.svg"></code>
<code><img width="5%" title="REST-Assured" src="images/rest-assured-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="images/selenoid-logo.svg"></code>
<code><img width="5%" title="Gradle" src="images/gradle-logo.svg "></code>
<code><img width="5%" title="JUnit5" src="images/junit5-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="images/allure-Report-logo.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/allure-ee-logo.svg"></code>
<code><img width="5%" title="Github" src="images/git-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="images/jenkins-logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/Telegram.svg"></code>
</p>

## :computer: Запуск тестов из терминала

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов с заполненным remote.properties:*

```bash
gradle clean test
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов без заполненного remote.properties:*

```bash
gradle clean test 
  -Dbrowser=[BROWSER]
  -DbrowserVersion=[BROWSER_VERSION]
  -DbrowserSize=[BROWSER_SIZE]
  -DremoteDriverUrl=https://[REMOTE_DRIVER_URL]/wd/hub/
  -Dthreads=[THREADS]
  -DapiToken=[APITOKEN]
```

где:
>- [x] *-Dbrowser - браузер, в котором будут выполняться тесты (по умолчанию chrome)*
>- [x] *-DbrowserVersion - версия браузера (по умолчанию 91.0)*
>- [x] *-DbrowserSize - размер окна браузера (по умолчанию 1920x1080)*
>- [x] *-DremoteDriverUrl - адрес удаленного сервера, где будут выполняться тесты (по умолчанию http://selenoid.autotests.cloud/wd/hub/)*
>- [x] *-Dthreads - количество потоков выполняющихся тестов*
>- [x] *-DapiToken - токен, для доступа к API*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов в несколько потоков:*

```bash
gradle clean test -Dthreads=[threadsValue]
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Сформировать allure отчет:*

```bash
allure serve build/allure-results
```
## <img width="4%" title="Jenkins" src="images/jenkins-logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/GraduateWork/17/)

### :pushpin: Параметры сборки

    BROWSER (по умолчанию chrome)
    BROWSER_VERSION (по умолчанию 91.0)
    ENVIRONMENT (название тестового стенда)
    APITOKEN (токен для доступа к API)
    THREADS (число потоков)

*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<p align="left">
  <img src="images/job_param.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="images/allure-Report-logo.svg"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница с сформированным html-отчетом.*

<p align="left">
  <img src="images/allure_jobs_history.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/allure-Report-logo.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/GraduateWork/17/allure/)


### :pushpin: Общая информация

*Главная страница Allure-отчета содержит следующие информационные блоки:*

> - [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="left">
  <img src="images/allure_report.png" alt="allure_report" width="900">
</p>

### :pushpin: Список тестов c описанием шагов

*На данной странице представляется стандартное распределение выполнявшихся тестов по тестовым наборам или классам, в
которых находятся тестовые методы.*

<p align="left">
  <img src="images/allure_report_steps.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Telegram" src="images/Telegram.svg"> Уведомления в Telegram

<p align="left">
  <img src="images/tlgrm.png" alt="Telegram" width="440">
</p>

## Контакты
[<img title="My Github" alt="Alfirine | Github" width="30px" src="https://github.githubassets.com/favicons/favicon.svg">](https://github.com/Alfirine)
[<img title="My Telegram" alt="Alfirin | Telegram" width="30px" src="https://telegram.org/favicon.ico">](https://t.me/Alfirin) 
