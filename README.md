# Application to generate QR Code
- This a simple project for generating QR code using google QR code maven dependencies.

## Software Requirements
- Intellij idea IDE
- MySQL Workbench
- Postman

## How to Run this project
- First clone the repo in your folder
- Then change the MySQL password for your local system
- If **qrcode-db** is not present in your mysql workbench then create it or give other database names
- Then run the command: `mvn clean install`
- Then simply run the application

## Usage
- After successful run the application, go to postman and hit POST request to create some user data
  `http://localhost:8082/users`
- Send the JSON data in postman
  ```
  {
    "firstName": "Rajesh",
    "lastName": "Bhola",
    "email": "rajeshbhola@example.com",
    "mobile": "1234567890"
  }
  ```
- Then hit the GET request to generate the QR Code in `resources/qrcodes` folder in the project
  `http://localhost:8082/users`
