**getAll**
----

Returns json array containing all persons in the system. Depending on the type of person (docent, student) it returns the corresponding data-set.

* **URL**

  /persoon

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
        "naam": "Alex Jongman",
        "email": "alex.jongman@hu.nl",
        "rol": "docent",
        "persoonId": 0
      },
      {
        "naam": "Devin Minnaard",
        "email": "devin.minnaard@student.hu.nl",
        "rol": "student",
        "klas": "V1F",
        "persoonId": 1679641
      },
      {
        "naam": "Jos van Reenen",
        "email": "jos.vanreenen@hu.nl",
        "rol": "docent",
        "persoonId": 1
      },
      {
        "naam": "Jan Dekkers",
        "email": "jan.dekkers@student.hu.nl",
        "rol": "student",
        "klas": "V1D",
        "persoonId": 1697304
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
