**g**etLessenByStudentId
----

Returns json array containing all Les instances linked to student-id.

* **URL**

  /student/lessen/<id>

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
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-02-07",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 8
      },
      {
        "vakNaam": "TICT-V1GP-15_2016",
        "vakCode": "TICT-V1GP",
        "gebouw": "DL200",
        "lokaal": "5.82",
        "datum": "2017-02-08",
        "starttijd": "09:00:00",
        "eindtijd": "11:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter van Rooijen",
          "email": "peter.vanrooijen@hu.nl",
          "rol": "docent",
          "persoonId": 10
        },
        "lesId": 14
      },
      {
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
      {
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
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "3.91",
        "datum": "2017-02-13",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 31
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-02-14",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 37
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "3.85",
        "datum": "2017-02-16",
        "starttijd": "08:30:00",
        "eindtijd": "11:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 47
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-02-16",
        "starttijd": "11:00:00",
        "eindtijd": "13:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 48
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "3.91",
        "datum": "2017-02-20",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 55
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-02-21",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 61
      },
      {
        "vakNaam": "TICT-V1GP-15_2016",
        "vakCode": "TICT-V1GP",
        "gebouw": "DL200",
        "lokaal": "4.84",
        "datum": "2017-02-22",
        "starttijd": "09:30:00",
        "eindtijd": "11:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter van Rooijen",
          "email": "peter.vanrooijen@hu.nl",
          "rol": "docent",
          "persoonId": 10
        },
        "lesId": 68
      },
      {
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
      {
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
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "3.91",
        "datum": "2017-03-06",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 85
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-03-07",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 91
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "3.85",
        "datum": "2017-03-09",
        "starttijd": "08:30:00",
        "eindtijd": "11:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 101
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-03-09",
        "starttijd": "11:00:00",
        "eindtijd": "13:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 102
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "3.91",
        "datum": "2017-03-13",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 109
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-03-14",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 115
      },
      {
        "vakNaam": "TICT-V1GP-15_2016",
        "vakCode": "TICT-V1GP",
        "gebouw": "DL200",
        "lokaal": "4.84",
        "datum": "2017-03-15",
        "starttijd": "09:30:00",
        "eindtijd": "11:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter van Rooijen",
          "email": "peter.vanrooijen@hu.nl",
          "rol": "docent",
          "persoonId": 10
        },
        "lesId": 122
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "3.85",
        "datum": "2017-03-16",
        "starttijd": "08:30:00",
        "eindtijd": "11:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 127
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-03-16",
        "starttijd": "11:00:00",
        "eindtijd": "13:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 130
      },
      {
        "vakNaam": "TICT-V1OODC-15_2016",
        "vakCode": "TICT-V1OODC",
        "gebouw": "DL200",
        "lokaal": "3.91",
        "datum": "2017-03-20",
        "starttijd": "10:00:00",
        "eindtijd": "12:30:00",
        "klas": "V1D",
        "docent": {
          "naam": "Peter Schuler",
          "email": "peter.schuler@hu.nl",
          "rol": "docent",
          "persoonId": 8
        },
        "lesId": 139
      },
      {
        "vakNaam": "TCIF-V1AUI-15_2016",
        "vakCode": "TCIF-V1AUI",
        "gebouw": "DL200",
        "lokaal": "4.87",
        "datum": "2017-03-21",
        "starttijd": "11:30:00",
        "eindtijd": "14:00:00",
        "klas": "V1D",
        "docent": {
          "naam": "Martijn Jansen",
          "email": "martijn.jansen@hu.nl",
          "rol": "docent",
          "persoonId": 4
        },
        "lesId": 144
      }
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
      "path": "/student/lessen/1682488"
    }
    ```
