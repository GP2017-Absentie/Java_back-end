meldAbsent
----

Adds absentie instance to the database.

* **URL**

  /absentie

* **Method:**

  `POST` 

* **URL Params**

   None

* **Request Example:**

  ```json
  {
  	"reden": "overig",
  	"toelichting": "geen zin in.",
  	"persoonId": 4,
  	"lesId": 6
  }
  ```

  ​

* **Success Response:**

  * **Code:** 200 <br/>
    **Content:** 

    ​

* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:**

    ```json
    {
      "timestamp": 1491513650053,
      "status": 400,
      "error": "Bad Request",
      "exception": "java.lang.IllegalArgumentException",
      "path": "/absentie"
    }
    ```

