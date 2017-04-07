# Student

All requests regarting students should be directed towards this address.



## getAll

- **URL**

  /student/getByAll

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
        "id": 1679641,
        "naam": "Devin Minnaard",
        "email": "devin.minnaard@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1F"
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
        "id": 1657627,
        "naam": "Ruben Holslag",
        "email": "ruben.holslag@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1E"
      },
      {
        "id": 1705246,
        "naam": "Sander Wiggers",
        "email": "sander.wiggers@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1C"
      },
      {
        "id": 1610525,
        "naam": "Sam Morssinkhof",
        "email": "sam.morssinkhof@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1D"
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

  > Returns json array containing all students in the system.

  ​

## getById

- URL**

  /student/getById:id

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
        "id": 1682488,
        "naam": "Karim Stekelenburg",
        "email": "karim.stekelenburg@student.hu.nl",
        "absenties": [],
        "lessen": [],
        "klas": "V1D"
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

> Returns json array containing a single student instance matching the :id argument.

