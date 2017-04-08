# Docent

All requests regarting docenten should be directed towards this address.

## getAll

- URL**

  /docent/getByAll

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
        "id": 1,
        "naam": "Jos van Reenen",
        "email": "jos.vanreenen@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 2,
        "naam": "Dick Pronk",
        "email": "dick.pronk@hu.nl",
        "absenties": [],
        "lessen": []
      },
      {
        "id": 3,
        "naam": "Annemarije van der Meer",
        "email": "annemarije.vandermeer@hu.nl",
        "absenties": [],
        "lessen": []
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

  > Returns json array containing all docent in the system.



## getById

- **URL**

  /docent/getById:id

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
        "id": 4,
        "naam": "Martijn Jansen",
        "email": "martijn.jansen@hu.nl",
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

  > Returns json array containing a single docent instance matching the :id argument.