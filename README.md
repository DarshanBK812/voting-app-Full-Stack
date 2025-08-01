# Voting App

A professional, full-stack voting application that enables users to create polls, cast votes, and view results in real-time. This project consists of an Angular front-end and a Spring Boot back-end.

---

## Table of Contents

1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Architecture](#architecture)
4. [Prerequisites](#prerequisites)
5. [Installation](#installation)
6. [Running the Application](#running-the-application)

   * [Back-End (Spring Boot)](#back-end-spring-boot)
   * [Front-End (Angular)](#front-end-angular)
7. [API Documentation](#api-documentation)
8. [Project Structure](#project-structure)
9. [Contributing](#contributing)
10. [License](#license)
11. [Contact](#contact)

---

## Features

* **Create Polls**: Admin users can create new polls with custom questions and options.
* **Cast Votes**: Authenticated users can vote on active polls.
* **Real-Time Results**: Live vote counts are updated without page refresh.
* **Responsive UI**: Adaptable design for desktop and mobile devices.
* **Role-Based Access**: Separate admin and voter privileges.

---

## Tech Stack

* **Front-End:** Angular, TypeScript, RxJS, Bootstrap
* **Back-End:** Spring Boot, Java, Spring Data JPA, Hibernate, MySQL
* **Database:** MySQL
* **Build Tools:** Maven (back-end), Angular CLI (front-end)
* **Version Control:** Git & GitHub

---

## Architecture

The application follows a classical layered architecture:

* **Controller Layer:** REST controllers to handle HTTP requests.
* **Service Layer:** Business logic and transaction management.
* **Repository Layer:** Data access using Spring Data JPA.

The front-end communicates with the back-end via RESTful APIs, consuming JSON responses.

---

## Prerequisites

* Java 11 or higher
* Maven 3.6+
* Node.js 14+ and npm 6+
* MySQL server running locally or remotely
* Git

---

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/DarshanBK812/voting-app-Full-Stack.git
   cd voting-app-Full-Stack
   ```
2. **Set up the database:**

   * Create a MySQL database named `voting_app`.
   * Update `application.properties` (in `backend/src/main/resources`) with your DB credentials.

---

## Running the Application

### Back-End (Spring Boot)

1. Navigate to the back-end directory:

   ```bash
   cd poll-app
   ```
2. Build and run:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. The API will be available at `http://localhost:8080/api`.

### Front-End (Angular)

1. Open a new terminal and go to the front-end folder:

   ```bash
   cd voteapp
   ```
2. Install dependencies:

   ```bash
   npm install
   ```
3. Serve the application:

   ```bash
   ng serve
   ```
4. The UI will be running at `http://localhost:4200`.

---

## API Documentation

| Endpoint                      | Method | Description                    |
| ----------------------------- | ------ | ------------------------------ |
| `/api/polls`                  | GET    | List all polls                 |
| `/api/polls`                  | POST   | Create a new poll              |
| `/api/polls/{pollId}`         | GET    | Get details of a specific poll |
| `/api/polls/{pollId}/vote`    | POST   | Vote on a poll option          |
| `/api/polls/{pollId}/results` | GET    | Fetch live results of a poll   |

---

## Project Structure

```
voting-app-Full-Stack/
├── backend/           # Spring Boot application
│   ├── src/main/java/
│   ├── src/main/resources/
│   └── pom.xml
├── frontend/          # Angular application
│   ├── src/
│   └── angular.json
├── .gitignore
└── README.md
```

---

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add YourFeature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a Pull Request

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

**Darshan B K** – [GitHub](https://github.com/DarshanBK812) | [LinkedIn](https://www.linkedin.com/in/darshan-b-k-a7b501298)

Feel free to reach out for any questions or feedback! 🎉
