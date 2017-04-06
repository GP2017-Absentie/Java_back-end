**meldAbsent**
----

Returns a persons object if login is succesful, nothing if unsuccesfull.

* **URL**

  /persoon/meldAbsent

* **Method:**

  `POST` 

* **URL Params**

   None

* **Request Example:**

  ```json
  {
    "persoonId": "3",
    "lesId": "geheim",
    "reden": "ziek",
    "toelichting":
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
      "absenties": [],
      "lessen": [],
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
