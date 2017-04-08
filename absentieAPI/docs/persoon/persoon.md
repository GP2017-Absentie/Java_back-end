# Persoon

All requests regarding people with unknown roles should be directed to this address. Student and docent specific functionalities are caught under their own adresses.

## getAll

- **URL**

  /persoon/getByAll

- **Method:**

  `GET` 

- **URL Params**

  None`

- **Success Response:**

  - **Code:** 200 <br />
    **Content:** 

    ```json
    [
      {
        "id": 0,
        "naam": "Alex Jongman",
        "email": "alex.jongman@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 1679641,
        "naam": "Devin Minnaard",
        "email": "devin.minnaard@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1F"
      },
      {
        "id": 1,
        "naam": "Jos van Reenen",
        "email": "jos.vanreenen@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 1697304,
        "naam": "Jan Dekkers",
        "email": "jan.dekkers@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1D"
      },
      {
        "id": 2,
        "naam": "Dick Pronk",
        "email": "dick.pronk@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 1657627,
        "naam": "Ruben Holslag",
        "email": "ruben.holslag@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1E"
      },
      .... and
      ...... so
      ........ on
      ]
    ```

    ​

- **Error Response:**

  - **Code:** 404 NOT FOUND <br />
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

- **Notes:**

  > All requests regarding people with unknown roles should be directed to this address. Student and docent specific functionalities are caught under their own adresses.



## getById

- **URL**

  /persoon/getById:id

- **Method:**

  `GET` 

- **URL Params**

  **Required:**

  `id=[integer]`

- **Success Response:**

  - **Code:** 200 <br />
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

- **Error Response:**

  - **Code:** 404 NOT FOUND <br />
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

- **Notes:**

  > Returns json array containing a single persoon instance matching the :id argument.



## login

- **URL**

  /persoon/login

- **Method:**

  `POST` 

- **URL Params**

  None

- **Request Example:**

  ```json
  {
    "email": "karim.stekelenburg@student.hu.nl",
    "password": "geheim"
  }
  ```

  ​

- **Success Response:**

  - **Code:** 200 <br />
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

  > Returns a persons object if login is succesful, nothing if unsuccesfull.