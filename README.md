# Translation Web Service

This API is built according to RESTful principles, which means it uses HTTP as an application protocol. It's based on Spring Boot.  The app allows to the client to translate words.

## Installation:

Make sure that you have java and maven already installed in you machine
  - git clone https://github.com/Ibrahimhizeoui/translation.git
  - mvn spring-boot:run

## About the project
- I used maven like a project manager and it contains 3 dependency :
  * web
  * H2 an embadded database
  * Jpa to access to the data base
- In the model layer we have only Translation object:
```
    {
        "key": "fr",
        "origin": "buy-chips",
        "translated": "acheter chips"
    }
```

- I used Repository to access to the data because it reduce the amount of boilerplate code required to implement data access layers for various persistence stores.

- The are also a controller which handel the Http requestes and service object which hold business logic .

## endpoints
 | Method | URI | Parameters |
| ------ | --- | ---------- |
| GET |  http://localhost:8083/translate/{origin} | ?lang |
| GET | http://localhost:8083/translate/all/{origin}|  |
| POST | http://localhost:8083/translate | (Translation) t |
| PUT |  http://localhost:8083/translate/{id} | (Translation) t |
| DELETE | http://localhost:8083/translate/{id} |  |

