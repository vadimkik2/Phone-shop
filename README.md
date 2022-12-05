# Phone-Shop 
## 📋 Description:
This application is a store simulation, where you can add a phone to the database, order a phone, see a list of phones, 
register user and save him in the database.
* Manager can add goods to database.
* Manager/client can see a list of all available products and their prices
  and quantity. 
* Client can order several phones at once.
* Application check and automatically delete not paid orders every 5 minutes.
* Client can pay for his orders.

## 🔎 Project structure
#### The project has an 3-Tier Architecture

* Controller - This level allows the user to work with this application.
* Service - This level of architecture is responsible for processing the data received from the DAO level.
* Repository - This level of architecture is responsible for communicating with the database.

## ⚙ Technologies:
* Java 11
* Maven
* Tomcat
* H2DataBase
* Lombok
* Spring Boot
* Spring Boot security

## 🚀 Quickstart
1. Clone repository
2. Create new project from Version Control
3. Run project

### For testing, you can use ready-made profiles:
1. ROLE_Manager
* Login: admin@adm.ua
* Password: admin123456

2. ROLE_USER
* Login: pavlo@uk.ua
* Password: Pavlo123456

Also you can create your own user whose role will be "USER" by default.