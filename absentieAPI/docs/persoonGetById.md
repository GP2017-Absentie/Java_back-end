**getById**
----

Returns json array containing a single persoon instance matching the :id argument.

* **URL**

  /persoon/getById:id

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
        "id": 7,
        "naam": "Bart van Eijkelenburg",
        "email": "bart.vaneijkelenburg@hu.nl",
        "absenties": [],
        "lessen": []
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
    ​
