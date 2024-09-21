# FX Deal Spring Boot Application

This project is a Spring Boot application for managing FX  deals. It provides features to create new deals, display a list of deals, and store them in a MySQL database using Docker.

## Features

- Create FX Deals
- View FX Deals in a table
- Currency dropdown with ISO code 
- Auto-generated `dealUniqueId` and `dealTimestamp`
- Supports Tailwind CSS for styling

## Technologies Used

- Java 17
- Spring Boot 3.3.3
- MySQL Database
- Docker & Docker Compose
- Tailwind CSS

---

## Prerequisites

- [Docker](https://www.docker.com/get-started) installed on your machine.
- [Maven](https://maven.apache.org/install.html) installed.

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/orjwanati/fx_deal.git
cd fx_deal
```

## How to Run the Application

###  Build and Run with Docker Compose
You can build and run the application using the provided Makefile.

To build the app and start the containers:

```bash
make run
```
This will build the Docker image for the Spring Boot app and start all services, including the MySQL database.

To start the app in detached mode:

```bash
make start
```
To view logs:

```bash
make logs
```
To stop the running containers:

```bash
make stop
```
To clean up Docker containers, images, volumes:

```bash
make clean
```
### Access the Application

Once the application is running, you can access the following:

Create Deal Form:
URL: http://localhost:8080/createDeal
View All Deals:
All deals will be listed on the same page of form submission.
