# Test automation project android-application "Wikipedia"

## :page_with_curl:         Content

➠ [Covered functionality](#globe_with_meridians-covered-functionality)

➠ [Technology stack](#computer-technology-stack)

➠ [Running tests from the terminal](#technologist-running-tests-from-the-terminal)

➠ [Build in Jenkins](#-jenkins-build-main-page)

➠ [Test results report in Allure Report](#-test-results-report-in-allure-report)

➠ [Integration with Allure TestOps](#-integration-with-allure-testops)

➠ [Telegram notifications using a bot](#-telegram-notifications-using-a-bot)

➠ [An example of running a test in Selenoid](#-an-example-of-running-a-test-in-selenoid)
## <a name="globe_with_meridians-covered-functionality"></a>:globe_with_meridians: Covered functionality

### UI

- [x] Check Onboarding content
- [x] Compare date with actual day
- [x] Check article content
- [x] Check Search input
- [x] Sign up

## :computer: Technology stack

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="BrowserStack" src="images/logo/browserstack.svg">
<img width="6%" title="Appium" src="images/logo/appium.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="images/logo/alluretestops.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

```mermaid        
    stateDiagram-v2
        State1: START
        State2: Java & IntelliJ IDEA
        State3: Selenide & JUnit5 & Appium
        State4: Gradle
        State5: GitHub
        State6: Jenkins
        State7: BrowserStack
        State8: Allure Report and Allure TestOps
        State9: Telegram
        State10: STOP
        State1 --> State2
        State2 --> State3
        State3 --> State4
        State4 --> State5
        State5 --> State6
        State6 --> State7
        State7 --> State8
        State8 --> State9
        State9 --> State10
        note right of State2 : Working with code
        note left of State3 : Frameworks
        note right of State4 : Project build
        note left of State5 : Version control system and project hosting
        note right of State6 : Parameterization and run build
        note left of State7 : Containerization
        note right of State8 : Reporting
        note left of State9 : Notifications
```

## :technologist: Running tests from the terminal

### Local test run:

```
gradle clean test -DdeviceHost=local
```

### Remote test run:

```
gradle clean test -DdeviceHost=browserstack
```

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Jenkins Build Main Page

<p align="center">
  <img src="images/screenshots/JenkinsMainPAge.jpg">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Test results report in Allure Report

### :pushpin: Main page of the Allure report

<p align="center">
<img title="Allure Overview" src="images/screenshots/mainDachboardAR.jpg">
</p>

### :pushpin: Page with tests


<p align="center">
<img title="Allure Behaviors" src="images/screenshots/pageWithTests.jpg">
</p>

### :pushpin: Window with charts

<p align="center">
<img width="30%"  title="Allure Overview Dashboard" src="images/screenshots/chartsAR.jpg">
</p>



## <img width="4%" title="Allure TestOps" src="images/logo/alluretestops.svg"> Integration with Allure TestOps

### :pushpin: Test cases with launch history

<p align="center">
<img title="Allure Overview" src="images/screenshots/ATestOpstestcase.jpg">
</p>

### :pushpin: Dashboard


<p align="center">
<img title="Allure Behaviors" src="images/screenshots/ATestOpsDash.jpg">
</p>



## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications using a bot

> After the build is completed, the bot created in <code>Telegram</code> automatically processes and sends a message with a report.
<p align="center">
<img width="30%"  title="Telegram Notifications" src="images/screenshots/telegramBot.jpg">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> An example of running a test in Selenoid

> A video is attached to each test in the report. One of these videos is shown below. Test case for checking the sending of an application to the company
<p align="center">
  <img title="Selenoid Video" src="images/gif/657f38371d02e78d321704cc37755f8e.gif">
</p>

<a target="_blank" href="https://t.me/YuriyMqa">t.me/dmitrishin13</a>