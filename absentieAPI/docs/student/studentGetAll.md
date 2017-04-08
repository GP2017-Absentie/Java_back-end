**getAll**
----

Returns json array containing all students in the system.

* **URL**

  /student

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
        "naam": "Devin Minnaard",
        "email": "devin.minnaard@student.hu.nl",
        "rol": "student",
        "klas": "V1F",
        "persoonId": 1679641
      },
      {
        "naam": "Jan Dekkers",
        "email": "jan.dekkers@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1697304
      },
      {
        "naam": "Ruben Holslag",
        "email": "ruben.holslag@student.hu.nl",
        "rol": "student",
        "klas": "V1E",
        "persoonId": 1657627
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
      "path": "/student"
    }
    ```
