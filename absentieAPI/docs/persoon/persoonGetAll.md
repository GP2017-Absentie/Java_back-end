**getAll**
----

Returns json array containing all persons in the system. Depending on the type of person (docent, student) it returns the corresponding data-set.

* **URL**

  /persoon/getByAll

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
        "id": 0,
        "naam": "Alex Jongman",
        "email": "alex.jongman@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 1679641,
        "naam": "Devin Minnaard",
        "email": "devin.minnaard@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1F"
      },
      {
        "id": 1,
        "naam": "Jos van Reenen",
        "email": "jos.vanreenen@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 1697304,
        "naam": "Jan Dekkers",
        "email": "jan.dekkers@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1D"
      },
      {
        "id": 2,
        "naam": "Dick Pronk",
        "email": "dick.pronk@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 1657627,
        "naam": "Ruben Holslag",
        "email": "ruben.holslag@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1E"
      },
      .... and
      ...... so
      ........ on
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
