**getAll**
----

Returns json array containing all absenties in the system.

* **URL**

  /absentie

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
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
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
        "reden": "doctor",
        "toelichting": "STD shit.",
        "absentieId": 3
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
      "path": "/absentie"
    }
    ```
