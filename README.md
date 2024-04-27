# TestJavaSentra

## Registro de usuario

Enviar el siguiente json para los registros:

Endpoint: {path}/test/registro
Body json:
```json
 {
        "name": "Pedro Perez",
        "email": "pedroPerez@gmail.org",
        "password": "Clave12345",
        "phones": [
            {
                "number": "97777875",
                "citycode": "3",			
                "contrycode": "56"
            }
        ]
}
```


## login de usuario

Enviar username y password por ejemplo:

Endpoint: {path}/test/login
Body json:

```json
{
    "username": "pedroPerez@gmail.org",
    "password" : "Clave12345"
}

```


## Perfil de usuario

Enviar id generado en por el registro Ejemplo:

EndPoint:
{path}/test/perfil/65a4f42d-6526-4a6f-8574-25a01fd79c8d

Se tiene que agregar el Header:
X-auth-token : {token que se ha generado}
Ejemplo:  X-auth-token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJzdWIiOiJodW50ZXIyIiwiZXhwIjoxNzAwNzkyMzMwfQ.C8Axodoi6X7pbVoGDJaOCssQKBW7TFvxpvKkXjPx590

```json

{
    "id": "045c5f42-2f1d-44e7-b902-406571217a79",
    "created": "2023-11-24 01:48",
    "modified": "2023-11-24 01:48",
    "last-login": "2023-11-24 01:48",
    "isactive": "activo",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJzdWIiOiJodW50ZXIyIiwiZXhwIjoxNzAwNzkyMzMwfQ.C8Axodoi6X7pbVoGDJaOCssQKBW7TFvxpvKkXjPx590"
}
```
Para la documentación con Swagger el Endpoint es el siguiente:
http://localhost:8080/swagger-ui.html#/

<img align="center"  src="https://github.com/imundo/TestPracticoJavaWork/blob/main/swaggerimagen.JPG">


POSTMAN COLLECTION:

```json

{
  "info": {
    "_postman_id": "374bcef2-2bad-47c0-98d0-d8c871165831",
    "name": "SentraCollection",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "localhost:8080/test/registro",
      "request": {
        "method": "POST",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "{\r\n        \"name\": \"Isaac mundo\",\r\n        \"email\": \"imundo90@gmail.com\",\r\n        \"password\": \"Clave12345\",\r\n        \"phones\": [\r\n            {\r\n                \"number\": \"977778275\",\r\n                \"citycode\": \"3\",\t\t\t\r\n                \"contrycode\": \"+56\"\r\n            }\r\n        ]\r\n}",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": {
          "raw": "localhost:8080/test/registro",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "test",
            "registro"
          ]
        },
        "description": "Registro de usuario "
      },
      "response": []
    },
    {
      "name": "localhost:8080/test/login",
      "request": {
        "method": "POST",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "{\r\n    \"username\": \"imundo90@gmail.com\",\r\n    \"password\" : \"Clave12345\"\r\n}",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": {
          "raw": "localhost:8080/test/login",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "test",
            "login"
          ]
        },
        "description": "Login de usuario "
      },
      "response": []
    },
    {
      "name": "localhost:8080/test/perfil/65a4f42d-6526-4a6f-8574-25a01fd79c8d",
      "request": {
        "method": "POST",
        "header": [
          {
            "key": "X-auth-token",
            "value": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJpbXVuZG85MEBnbWFpbC5jb20iLCJzdWIiOiJDbGF2ZTEyMzQ1IiwiZXhwIjoxNzE0MjUzMzk5fQ.VEUGLfZuwvM51jfAy2CSJ8ytjYExy6RheEXOB98-Pgw",
            "type": "text"
          }
        ],
        "url": {
          "raw": "localhost:8080/test/perfil/65a4f42d-6526-4a6f-8574-25a01fd79c8d",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "test",
            "perfil",
            "65a4f42d-6526-4a6f-8574-25a01fd79c8d"
          ]
        },
        "description": "consulta de perfil de usuario"
      },
      "response": []
    }
  ]
}
```
