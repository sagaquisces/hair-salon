# Hair Salon Management System
A web page that allows user to organize stylists and clients:

## Specifications
  * Lists all stylists.
  * Upon selectings a stylist, view their details and their list of clients.
  * Navigate to a form that will allow user to add a stylist.
  * Navigate to a form that allows user to add clients to existing stylist.
  * Allows user to update details for stylist and clients.
  * Allows user to delete clients
  * Allows user to delete stylists and reassign clients.
  ```
    /* In PSQL */
    CREATE DATABASE hair_salon;
    \c hair_salon;
    CREATE TABLE stylists (id serial PRIMARY KEY, firstname varchar, lastname varchar, email varchar, description text);
    CREATE TABLE clients (id serial PRIMARY KEY, firstname varchar, lastname varchar, email varchar, stylistID int);
    CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;
  ```  

## What's included
Within the repository you'll find the following directories and files:

```
hair-salon
├── README.md
├── build.gradle
├── .gitignore
└── src
    ├── main
    │   ├── java
    │   │   ├── DB.java
    │   │   ├── Stylist.java
    │   │   ├── Client.java
    |   |   ├── App.java
    │   │   └── VelocityTemplateEngine.java
    │   └── resources
    │       └── templates
    │           ├── layout.vtl
    │           ├── index.vtl
    │           ├── xxx.vtl
    │           ├── xxx.vtl
    │           ├── xxx.vtl
    │           ├── xxx.vtl
    │           ├── xxx.vtl
    │           ├── xxx.vtl
    │           ├── xxx.vtl
    │           └── xxx.vtl
    └── test
        └── java
            ├── DatabaseRule.java
            ├── StylistTest.java
            └── ClientTest.java
```


## Technologies Used
* Java
* SQL
* Spark
* Velocity
* Gradle
* HTML
### License
Copyright 2017 Michael Dunlap

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
