**getAll**
----

Returns json array containing all Klas instances in the system.

* **URL**

  /klas

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
        "studenten": [
          {
            "naam": "Diesmer Hensbergen",
            "email": "diesmer.hensbergen@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1662367
          },
          {
            "naam": "Robin Aalten",
            "email": "robin.aalten@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1682045
          },
          {
            "naam": "Matthijs Osterhaus",
            "email": "matthijs.osterhaus@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1682362
          },
          {
            "naam": "Damien van den Bosch",
            "email": "damien.vanden.bosch@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1683113
          },
          {
            "naam": "Doeke Roos",
            "email": "doeke.roos@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1684145
          },
          {
            "naam": "Masha Steinmann",
            "email": "masha.steinmann@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1693444
          },
          {
            "naam": "Sten Terwan",
            "email": "sten.terwan@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1694069
          },
          {
            "naam": "Christian van Dijk",
            "email": "christian.van.dijk@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1694584
          },
          {
            "naam": "Lise Voorburg",
            "email": "lise.voorburg@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1695070
          },
          {
            "naam": "Florent op ten Noort",
            "email": "florent.opten.noort@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1696206
          },
          {
            "naam": "Lars van Kleef",
            "email": "lars.van.kleef@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1697336
          },
          {
            "naam": "Marick van Tuil",
            "email": "marick.van.tuil@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1698563
          },
          {
            "naam": "Stef Konijn",
            "email": "stef.konijn@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1698919
          },
          {
            "naam": "Koen Fischer",
            "email": "koen.fischer@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1699627
          },
          {
            "naam": "Pasoon Mohammad Pasoon Popal",
            "email": "pasoon.mohammadpasoonpopal@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1700011
          },
          {
            "naam": "Kin Yueng Cheung",
            "email": "kinyueng.cheung@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1702431
          },
          {
            "naam": "Thomas Korevaar",
            "email": "thomas.korevaar@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1702834
          },
          {
            "naam": "Hilbrand Meijer",
            "email": "hilbrand.meijer@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1702987
          },
          {
            "naam": "Alex Brasser",
            "email": "alex.brasser@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1703444
          },
          {
            "naam": "Larsse Vink",
            "email": "larsse.vink@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1704319
          },
          {
            "naam": "Edo van Draanen",
            "email": "edo.van.draanen@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1706750
          },
          {
            "naam": "Jorrit Strikwerda",
            "email": "jorrit.strikwerda@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1706971
          },
          {
            "naam": "Jason Posner",
            "email": "jason.posner@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1707245
          },
          {
            "naam": "Noor van Ewijk",
            "email": "noor.van.ewijk@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1708449
          },
          {
            "naam": "Chi kin Tsang",
            "email": "chikin.tsang@student.hu.nl",
            "rol": "student",
            "klas": "V1A",
            "persoonId": 1710986
          }
        ],
        "lessen": null,
        "klasId": "V1A"
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
      "path": "/klas"
    }
    ```
