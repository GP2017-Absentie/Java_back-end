**g**etAbsentiesByDocentId
----

Returns json array containing all Absentie instances linked to docent-id.

* **URL**

  /docent/absenties/<id>

* **Method:**

  `GET` 

* **URL Params**

   **Required:**

   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    [
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.83",
        "datum": "2017-02-15",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1A",
        "docent": {
          "naam": "Annemarije van der Meer",
          "email": "annemarije.vandermeer@hu.nl",
          "rol": "docent",
          "persoonId": 3
        },
        "lesId": 43
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.83",
        "datum": "2017-02-17",
        "starttijd": "13:00:00",
        "eindtijd": "15:30:00",
        "klas": "V1A",
        "docent": {
          "naam": "Annemarije van der Meer",
          "email": "annemarije.vandermeer@hu.nl",
          "rol": "docent",
          "persoonId": 3
        },
        "lesId": 54
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.83",
        "datum": "2017-02-22",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1A",
        "docent": {
          "naam": "Annemarije van der Meer",
          "email": "annemarije.vandermeer@hu.nl",
          "rol": "docent",
          "persoonId": 3
        },
        "lesId": 69
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.83",
        "datum": "2017-02-24",
        "starttijd": "13:00:00",
        "eindtijd": "15:30:00",
        "klas": "V1A",
        "docent": {
          "naam": "Annemarije van der Meer",
          "email": "annemarije.vandermeer@hu.nl",
          "rol": "docent",
          "persoonId": 3
        },
        "lesId": 84
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.83",
        "datum": "2017-03-08",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1A",
        "docent": {
          "naam": "Annemarije van der Meer",
          "email": "annemarije.vandermeer@hu.nl",
          "rol": "docent",
          "persoonId": 3
        },
        "lesId": 97
      },
      ... AND
      ..... SO
      ....... ON
    ]
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
      "path": "/student/getById/1682488/3"
    }
    ```
