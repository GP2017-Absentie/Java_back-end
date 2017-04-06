**getById**
----

Returns json array containing a single student instance matching the :id argument.

* **URL**

  /student/getById:id

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
        "id": 1682488,
        "naam": "Karim Stekelenburg",
        "email": "karim.stekelenburg@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1D"
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
