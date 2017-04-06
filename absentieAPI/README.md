# Absentie API



[TOC]

## General usage

The API's request URL's have a simple argument argument structure: `[entity]/[method]/args*`. When no method is provided the API will redirect the request to the getAll method for that entity.

> **Example usage:**
>
> to request student with *id* *1700011* we call `localhost:8080/student/getById/1700011



## Entity Request Overview

The Absentie API has six seperate entities to interact with, each holding their own set of HTTP-requests. Requests that are implemented for all entities are documented below as 'core requests'.

------



<u>underlined</u>	=	todo

regular		=	done



- **core requests**

  - getAll(): ArrayList<T>

- **persoon requests**

  - getById(int id): Persoon
  - <u>getByName(String name): Persoon</u>

- **student requests**

  - getById(int id): Student
  - <u>getByName(String name): Student</u>

- **docent requests**

  - getById(int id): Docent
  - <u>getByName(String name): Docent</u>

- **absentie requests**

  - getById(int id): Absentie
  - getByLes(Les les): ArrayList<Absentie>
  - <u>getByDate::</u>
    - <u>getByDate(Date startDate, Date endDate): ArrayList<Absentie></u>
    - <u>getByDate(Date date): ArrayList<Absentie></u>

- **les requests**

  - getById(int id): Les
  - <u>getAbsenties(): ArrayList<Absentie></u>

- **klas requests**

  - getStudents
  - <u>getAbsenties::</u>
    - <u>getAbsenties(Date startDate, Date endDate): ArrayList<Absentie></u>
    - <u>getAbsentie(Date date): ArrayList<Absentie></u>

  ​

## Requests

### Student

accesspoint URL:	`[host]:[port]/student/*` 



#### GET Methods

------

##### getAll

**request URL	:**`[host]:[port]/student` 

**returns		:**	JSON array containing all students known in our database.



**example request:** `localhost:8080/student/getById/1682488`

**example output:**

```json
[
  {
    "naam": "Devin Minnaard",
    "email": "devin.minnaard@student.hu.nl",
    "absenties": [],
    "lessen": [],
    "studentNummer": 1679641,
    "klas": "V1F"
  },
  {
    "naam": "Jan Dekkers",
    "email": "jan.dekkers@student.hu.nl",
    "absenties": [],
    "lessen": [],
    "studentNummer": 1697304,
    "klas": "V1D"
  }
]
```

------

##### getById

**request URL	:**`[host]:[port]/student/getById/<ID>` 

**returns		:**	JSON array containing the object corresponding to the request <ID>.



**example request:** `localhost:8080/student/getById/1682488`

**example output:**

```json
[
  {
    "naam": "Karim Stekelenburg",
    "email": "karim.stekelenburg@student.hu.nl",
    "absenties": [],
    "lessen": [],
    "studentNummer": 1682488,
    "klas": "V1D"
  }
]
```



# developer todo

### Core Methods

- [x] Implement getAll everywhere
      - [x] Persoon
      - [x] Student
      - [x] Docent
      - [x] Absentie
      - [x] Les
      - [x] Klas




**login**

**get**

- Input = email & wachtwoord
- return =  persoon obj

**Absent melden** **: POST** (ook annuleren)

+ input =/absentie/meldZiek/[datum]/[persId]
+ or
+ input = /absentie/meldAbsent/(array)[lesId]/[perId]
+ return = success code

**Absentie overzicht : GET**

Cal: absentie/getByPersonId/:id

Response: array of absentie objects



**Absenties : GET**

filteren op (begin, eind) datum, persoon, 