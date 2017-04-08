**getById**
----

Returns single les instance matching the <id> argument.

* **URL**

  /les/<id>

* **Method:**

  `GET` 

* **URL Params**

   **Required:**

   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    {
      "vakNaam": "TCIF-V1AUI-15_2016",
      "vakCode": "TCIF-V1AUI",
      "gebouw": "DL200",
      "lokaal": "3.83",
      "datum": "2017-02-06",
      "starttijd": "12:00:00",
      "eindtijd": "14:30:00",
      "klas": "V1A",
      "docent": {
        "naam": "Alex Jongman",
        "email": "alex.jongman@hu.nl",
        "rol": "docent",
        "persoonId": 0
      },
      "lesId": 3
    }
    ```

    ​

* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:**

    ```json
    {
      "timestamp": 1491431101039,
      "status": 404,
      "error": "Not Found",
      "message": "No message available",
      "path": "/les/3
    }
    ```
    ​
