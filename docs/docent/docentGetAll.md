**getAll**
----

Returns json array containing all docent in the system.

* **URL**

  /docent

* **Method:**

  `GET` 

* **URL Params**

   None`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

    ```json
    [
      {
        "naam": "Alex Jongman",
        "email": "alex.jongman@hu.nl",
        "rol": "docent",
        "persoonId": 0
      },
      {
        "naam": "Jos van Reenen",
        "email": "jos.vanreenen@hu.nl",
        "rol": "docent",
        "persoonId": 1
      },
      .... AND
      ...... SO
      ........ ON
      ]
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
      "path": "/student/getById/1682488/3"
    }
    ```


    ​```
