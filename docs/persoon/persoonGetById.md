**getById**
----

Returns json array containing a single persoon instance matching the <id> argument.

* **URL**

  /persoon/<id>

* **Method:**

  `GET` 

* **URL Params**

   **Required:**

   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    {
      "naam": "Dick Pronk",
      "email": "dick.pronk@hu.nl",
      "rol": "docent",
      "persoonId": 2
    }
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
      "path": "/persoon/3
    }
    ```
    ​
