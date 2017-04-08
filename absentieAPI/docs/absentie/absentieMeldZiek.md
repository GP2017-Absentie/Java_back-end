meldZiek
----

Method adds absentie objects for every lesson for the specified person for that day.

* **URL**

  /absentie/ziek

* **Method:**

  `POST` 

* **URL Params**

   None

* **Request Example:**

  ```json
  {
  	"datum": "2017-02-23",
  	"persoonId": 1682488
  }
  ```

  ​

* **Success Response:**

  * **Code:** 200 <br />
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
      "path": "/absentie/ziek"
    }
    ```

