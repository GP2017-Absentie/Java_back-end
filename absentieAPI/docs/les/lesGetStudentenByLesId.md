**getAbsentiesByLesId**
----

Returns array of Student instances linked to the specified Les-id

+ **URL**

* /les/studenten/<id>

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
        "naam": "Sam Morssinkhof",
        "email": "sam.morssinkhof@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1610525
      },
      {
        "naam": "Jotte Smit",
        "email": "jotte.smit@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1630766
      },
      {
        "naam": "Dahir Warsame",
        "email": "dahir.warsame@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1674604
      },
      {
        "naam": "Owen Ashby",
        "email": "owen.ashby@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1676955
      },
      {
        "naam": "Sebastiaan van Rijn",
        "email": "sebastiaan.van.rijn@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1679008
      },
      {
        "naam": "Karim Stekelenburg",
        "email": "karim.stekelenburg@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1682488
      },
      {
        "naam": "Monisha Wielkens",
        "email": "monisha.wielkens@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1683203
      },
      {
        "naam": "Timo Glastra",
        "email": "timo.glastra@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1686664
      },
      {
        "naam": "Bart van Straaten",
        "email": "bart.van.straaten@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1694982
      },
      {
        "naam": "Stefan de Raadt",
        "email": "stefan.de.raadt@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1696654
      },
      {
        "naam": "Yoram van de Kamp",
        "email": "yoram.vande.kamp@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1696880
      },
      {
        "naam": "Jan Dekkers",
        "email": "jan.dekkers@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1697304
      },
      {
        "naam": "Thomas Mocellin",
        "email": "thomas.mocellin@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1699599
      },
      {
        "naam": "Lucca Huijgens",
        "email": "lucca.huijgens@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1699882
      },
      {
        "naam": "Lex den Otter",
        "email": "lex.den.otter@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1700311
      },
      {
        "naam": "Joris van Heijningen",
        "email": "joris.van.heijningen@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1702504
      },
      {
        "naam": "Bas Henstra-Hill",
        "email": "bas.henstra-hill@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1702730
      },
      {
        "naam": "Ana Goessens",
        "email": "ana.goessens@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1703506
      },
      {
        "naam": "Nick Windt",
        "email": "nick.windt@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1703679
      },
      {
        "naam": "Martin de Jongh",
        "email": "martin.de.jongh@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1704879
      },
      {
        "naam": "Chung Wong",
        "email": "chung.wong@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1704916
      },
      {
        "naam": "Nathan Haseth",
        "email": "nathan.haseth@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1707366
      },
      {
        "naam": "Gijs van Gorp",
        "email": "gijs.van.gorp@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1710676
      },
      {
        "naam": "Robin Klok",
        "email": "robin.klok@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1710907
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
      "path": "/les/studenten/3
    }
    ```
    ​
