**getById**
----

Returns a persons object if login is succesful, nothing if unsuccesfull.

* **URL**

  /persoon/login

* **Method:**

  `PUT` 

* **URL Params**

   None

* **Request Example:**

  ```json
  {
    "email": "karim.stekelenburg@student.hu.nl",
    "password": "geheim"
  }
  ```

  ​

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    {
      "id": 1682488,
      "naam": "Karim Stekelenburg",
      "email": "karim.stekelenburg@student.hu.nl",
      "klas": "V1D"
    }
    ```

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
      "message": "Password or email incorrect",
      "path": "/persoon/login"
    }
    ```
