# Absentie

All requests regarting absenties should be directed towards this address.

## meldAbsent

- **URL**

  /absentie/meldAbsent

- **Method:**

  `POST` 

- **URL Params**

  None

- **Request Example:**

  ```json
  {
  	"reden": "overig",
  	"toelichting": "nee geen zin in.",
  	"persoonId": 4,
  	"lesId": 6
  }
  ```

  ​

- **Success Response:**

  - **Code:** 200 <br />
    **Content:** 

    ​

- **Error Response:**

  - **Code:** 400 BAD REQUEST <br />
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

- **Notes:**

  > Adds absentie instance to the database.



## meldZiek

- **URL**

  /absentie/meldZiek

- **Method:**

  `POST` 

- **URL Params**

  None

- **Request Example:**

  ```json
  {
  	"datum": "2017-02-23",
  	"persoonId": 1682488
  }
  ```

  ​

- **Success Response:**

  - **Code:** 200 <br />
    **Content:** 

    ​

- **Error Response:**

  - **Code:** 400 BAD REQUEST <br />
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

- **Notes:**

  > Method adds absentie objects for every lesson for the specified person for that day.