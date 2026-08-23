# Triad QA

Портфоліо-проєкт з автоматизації тестування: **Web UI + API + Mobile** в одному репозиторії, єдиним стилем коду, зі звітами Allure і запуском у CI.

> Статус: 🚧 у розробці. Каркас готовий (Фаза 0), далі — наповнення тестами.

---

## Що всередині

| Опора | Ціль | Стек |
|-------|------|------|
| **Web UI** | [saucedemo.com](https://www.saucedemo.com) (Swag Labs) | Selenide, TestNG, Page Object |
| **API** | [restful-booker](https://restful-booker.herokuapp.com) | rest-assured, Jackson, Lombok |
| **Mobile** | Sauce Labs *My Demo App* (Android) | Appium, UiAutomator2 |

Web і Mobile — це один і той самий магазин Swag Labs у двох іпостасях.

---

## Стек

- **Java 21**, **Maven**
- **TestNG** — тест-раннер
- **Selenide** — Web UI
- **rest-assured + Jackson + Lombok** — API
- **Appium (java-client)** — Mobile
- **Allure** — звіти
- **GitHub Actions** — CI *(додамо на Фазі 4)*

---

## Структура

```
triad-qa/
├── src/test/java/
│   ├── org/config/       # TestBase, MobileBaseTest
│   ├── org/helpers/      # PageTools, Specifications
│   ├── org/web/pages/    # Page Objects (Swag Labs)
│   ├── org/api/pojos/    # Booking, AuthToken...
│   ├── org/mobile/screens/  # Mobile Page Objects
│   └── tests/
│       ├── ui/           # Web UI тести
│       ├── api/          # API тести
│       └── mobile/       # Mobile тести
├── src/test/resources/   # allure.properties, logback.xml
├── testng.xml
└── pom.xml
```

---

## Як запускати

```bash
# усі тести (Web + API), headless
mvn clean test -Dheadless=true

# звіт Allure (тимчасовий сервер)
mvn allure:serve

# статичний звіт у target/site/
mvn allure:report
```

> Mobile-тести запускаються окремо після старту Appium Server та емулятора (Фаза 3).

---

## Дорожня карта

- [x] **Фаза 0** — каркас проєкту
- [ ] **Фаза 1** — Web UI (Swag Labs)
- [ ] **Фаза 2** — API (restful-booker)
- [ ] **Фаза 3** — Mobile (Appium)
- [ ] **Фаза 4** — CI/CD, звіт онлайн, README-вітрина

---

_Автор: Маріанна · Automation QA_
