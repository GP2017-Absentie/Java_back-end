**getById**
----

Returns Les instance with the specified id. The included Persoon and Docent datasets are minimized.

* **URL**

  /persoon/getById/:id

* **Method:**

  `GET` 

* **URL Params**

   **Required:**

   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    /*
    since the call is on one specific lesson instance, absentie's private "Les" attribute is not shown in this call. for a complete dataset of the absentie instance you should call absentie/getById/<id>
    */
    [
      {
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
          "persoonId": 6
        },
        "absenties": [
          {
            "persoon": { // for a full dataset you should call persoon/getById/<id>
              "naam": "Karim Stekelenburg",
              "persoonId": 1682488
            },
            "reden": "overig",
            "toelichting": "Gewoon veel te veel gesmoked gister avond toch.",
            "absentieId": 2
          },
          {
            "persoon": {
              "naam": "Martijn Jansen",
              "persoonId": 4
            },
            "reden": "doctor",
            "toelichting": "STD shit.",
            "absentieId": 3
          }
        ],
        "lesId": 4
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
      "path": "/student/getById/1682488/3"
    }
    ```

* **Notes:**

   > Since the call is on one specific lesson instance, absentie's private "Les" attribute is not shown in this call. For a complete dataset of the absentie instance you should call absentie/getById/<id>
