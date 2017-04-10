**getAbsentiesByKlasId**
----

Returns array with Absentie instances linked to the specified Klas-id.

* **URL**

  /klas/lessen/<id>

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
      [
        {
          "persoon": {
            "naam": "Karim Stekelenburg",
            "email": "karim.stekelenburg@student.hu.nl",
            "rol": "student",
            "klas": "V1D",
            "persoonId": 1682488
          },
          "les": {
            "vakNaam": "TICT-V1OODC-15_2016",
            "vakCode": "TICT-V1OODC",
            "gebouw": "DL200",
            "lokaal": "4.86",
            "datum": "2017-02-06",
            "starttijd": "12:00:00",
            "eindtijd": "14:30:00",
            "klas": "V1C",
            "docent": {
              "naam": "Bart Kuipers",
              "email": "bart.kuipers@hu.nl",
              "rol": "docent",
              "persoonId": 6
            },
            "lesId": 4
          },
          "reden": "overig",
          "toelichting": "Gewoon veel te veel gesmoked gister avond toch.",
          "absentieId": 2
        },
        {
          "persoon": {
            "naam": "Karim Stekelenburg",
            "email": "karim.stekelenburg@student.hu.nl",
            "rol": "student",
            "klas": "V1D",
            "persoonId": 1682488
          },
          "les": {
            "vakNaam": "TCIF-V1AUI-15_2016",
            "vakCode": "TCIF-V1AUI",
            "gebouw": "DL200",
            "lokaal": "3.85",
            "datum": "2017-02-23",
            "starttijd": "08:30:00",
            "eindtijd": "11:00:00",
            "klas": "V1D",
            "docent": {
              "naam": "Martijn Jansen",
              "email": "martijn.jansen@hu.nl",
              "rol": "docent",
              "persoonId": 4
            },
            "lesId": 73
          },
          "reden": "ziek",
          "toelichting": "n.v.t.",
          "absentieId": 9
        },
        {
          "persoon": {
            "naam": "Karim Stekelenburg",
            "email": "karim.stekelenburg@student.hu.nl",
            "rol": "student",
            "klas": "V1D",
            "persoonId": 1682488
          },
          "les": {
            "vakNaam": "TICT-V1OODC-15_2016",
            "vakCode": "TICT-V1OODC",
            "gebouw": "DL200",
            "lokaal": "4.87",
            "datum": "2017-02-23",
            "starttijd": "11:00:00",
            "eindtijd": "13:30:00",
            "klas": "V1D",
            "docent": {
              "naam": "Peter Schuler",
              "email": "peter.schuler@hu.nl",
              "rol": "docent",
              "persoonId": 8
            },
            "lesId": 76
          },
          "reden": "ziek",
          "toelichting": "n.v.t.",
          "absentieId": 10
        }
      ],
      [
        {
          "persoon": {
            "naam": "Timo Glastra",
            "email": "timo.glastra@student.hu.nl",
            "rol": "student",
            "klas": "V1D",
            "persoonId": 1686664
          },
          "les": {
            "vakNaam": "TCIF-V1AUI-15_2016",
            "vakCode": "TCIF-V1AUI",
            "gebouw": "DL200",
            "lokaal": "3.85",
            "datum": "2017-02-09",
            "starttijd": "08:30:00",
            "eindtijd": "11:00:00",
            "klas": "V1D",
            "docent": {
              "naam": "Martijn Jansen",
              "email": "martijn.jansen@hu.nl",
              "rol": "docent",
              "persoonId": 4
            },
            "lesId": 20
          },
          "reden": "ziek",
          "toelichting": "n.v.t.",
          "absentieId": 11
        },
        {
          "persoon": {
            "naam": "Timo Glastra",
            "email": "timo.glastra@student.hu.nl",
            "rol": "student",
            "klas": "V1D",
            "persoonId": 1686664
          },
          "les": {
            "vakNaam": "TICT-V1OODC-15_2016",
            "vakCode": "TICT-V1OODC",
            "gebouw": "DL200",
            "lokaal": "4.87",
            "datum": "2017-02-09",
            "starttijd": "11:00:00",
            "eindtijd": "13:30:00",
            "klas": "V1D",
            "docent": {
              "naam": "Peter Schuler",
              "email": "peter.schuler@hu.nl",
              "rol": "docent",
              "persoonId": 8
            },
            "lesId": 23
          },
          "reden": "ziek",
          "toelichting": "n.v.t.",
          "absentieId": 12
        }
      ]
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
      "path": "/klas/absenties/3
    }
    ```
    ​
