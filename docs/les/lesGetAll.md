**getAll**
----

Returns json array containing all Les instances in the system.

* **URL**

  /les

* **Method:**

  `GET` 

* **URL Params**

   None`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    [
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "3.91",
        "datum": "2017-02-06",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 1
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "6.84",
        "datum": "2017-02-06",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1B",
        "docent": {
          "naam": "Bart van Eijkelenburg",
          "email": "bart.vaneijkelenburg@hu.nl",
          "rol": "docent",
          "persoonId": 7
        },
        "lesId": 2
      },
      .... AND
      ...... SO
      ........ ON
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
      "path": "/les"
    }
    ```
