**removeById**
----

Returns json array containing a absentie persoon instance matching the <id> argument.

* **URL**

  /absentie/<id>

* **Method:**

  `DELETE` 

* **URL Params**

   **Required:**

   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json

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
      "path": "/absentie/3
    }
    ```
    ​
