# Laundry Service Entry

A simple web application for a laundry service entries. The user enters customer details, the data is saved in MySQL, and all entries are shown in a table.

## Features

- Entry form with Customer, Clothes, Service (Wash, Iron, Dry Clean) and Rate per Cloth
- Saves each entry in a MySQL database
- Lists all entries in a table: ID, Customer, Clothes, Service, Rate per Cloth

## Technologies Used

- Java (Servlets)
- HTML and CSS
- MySQL
- Maven
- Apache Tomcat 9

## Project Structure

```
case-study
├── db.sql                          # database table script
├── pom.xml                         # Maven configuration
└── src/main
    ├── java/com/example
    │   ├── DBConnection.java       # MySQL connection
    │   ├── ServiceEntry.java       # saves a new entry
    │   └── GetEntry.java           # reads entries
    └── webapp
        ├── index.html              # entry form
        ├── style.css               # styling
        └── WEB-INF/web.xml
```

## Database Setup

Run the script in `db.sql` in MySQL once.

## How to Run

1. Install Java, Maven, MySQL and Apache Tomcat 9.
2. Run `db.sql` in MySQL to create the database and table.
3. Open `DBConnection.java` and set your own MySQL username and password.
4. Build the project:
   ```
   mvn clean package
   ```
5. Copy the generated `.war` file from the `target` folder and paste to Tomcat's `webapps` folder.
6. Start Tomcat (`bin\startup.bat`).
7. Open the browser:
   ```
   http://localhost:8080/case-study/index.html
   ```

## Author

Punam Nikam
