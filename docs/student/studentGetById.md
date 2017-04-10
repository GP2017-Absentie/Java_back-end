**getById**
----

Returns json array containing a single student instance matching the <id> argument.

* **URL**

  /student/:id

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
      "naam": "Devin Minnaard",
      "email": "devin.minnaard@student.hu.nl",
      "rol": "student",
      "klas": "V1F",
      "persoonId": 1679641
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
      "path": "/student/1679641"
    }
    ```
