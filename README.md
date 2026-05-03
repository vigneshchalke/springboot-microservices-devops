# 🚀 Microservices Quiz Application with CI/CD Pipeline

This project is a **microservices-based Quiz Application** built using **Spring Boot** and integrated with a complete **CI/CD pipeline using Jenkins and Docker**.

---

## 🧠 Project Overview

This system is designed using **microservices architecture**, where each service is independently developed, deployed, and managed.

The application includes:

* Service Discovery using Eureka
* API Gateway for routing
* Multiple backend services (Quiz, Question)
* CI/CD automation pipeline

---

## 🏗️ Architecture

```
Client → API Gateway → Microservices → Database
                ↓
           Eureka Server
```

---

## 🔧 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* REST APIs

### Microservices

* Eureka Server (Service Discovery)
* API Gateway

### DevOps

* Jenkins (CI/CD)
* Docker (Containerization)
* Docker Hub (Image Registry)
* Maven (Build Tool)
* GitHub (Version Control)

---

## ⚙️ Features

* Microservices-based architecture
* Service registration & discovery (Eureka)
* API Gateway routing
* RESTful APIs
* Automated build & deployment using Jenkins
* Docker containerization for all services
* Image management via Docker Hub
* Multi-container deployment using Docker Compose

---

## 🚀 CI/CD Pipeline Flow

```
GitHub → Jenkins → Maven Build → Docker Build → Docker Hub Push
```

---

## 📂 Project Structure

```
springboot-microservices-devops/
│
├── eureka-server/
├── gateway-ms/
├── question-ms/
├── quiz-ms/
├── docker-compose.yml
└── README.md
```

---

## 🐳 Docker Setup

### Build Images

```bash
docker build -t vigneshchalke/quiz-eureka-server ./eureka-server
docker build -t vigneshchalke/quiz-api-gateway ./gateway-ms
docker build -t vigneshchalke/quiz-question-service ./question-ms
docker build -t vigneshchalke/quiz-quiz-service ./quiz-ms
```

---

### Run with Docker Compose

```bash
docker-compose up
```

---

## 🔗 Service Ports

| Service          | Port |
| ---------------- | ---- |
| API Gateway      | 9091 |
| Quiz Service     | 8081 |
| Question Service | 8082 |
| Eureka Server    | 8761 |

---

## 📸 Screenshots

### 🔹 Running Containers

<img width="1920" height="1200" alt="Screenshot 2026-05-03 091625" src="https://github.com/user-attachments/assets/0e828a71-3d8f-4829-9d6f-d3e8e8055f23" />


### 🔹 Jenkins Pipeline

<img width="1899" height="977" alt="Screenshot 2026-05-03 113717" src="https://github.com/user-attachments/assets/d2eb86cf-4f5b-400d-ae38-4bb322cf38d5" />


### 🔹 Docker Hub Images

<img width="1887" height="914" alt="Screenshot 2026-05-03 120424" src="https://github.com/user-attachments/assets/6e16a1b0-8771-48e2-9cd4-598d5b182df9" />


---

## 🧪 How to Run Locally

1. Clone the repository:

```bash
git clone https://github.com/vigneshchalke/springboot-microservices-devops.git
```

2. Navigate to project:

```bash
cd springboot-microservices-devops
```

3. Run services:

```bash
docker-compose up
```

---

## 🎯 Key Learnings

* Microservices architecture design
* CI/CD pipeline implementation
* Docker containerization and orchestration
* Jenkins automation workflows
* Integration of multiple services

---

## 📌 Future Enhancements

* Deploy on AWS EC2
* Add Kubernetes orchestration
* Implement monitoring (Prometheus & Grafana)
* Add authentication & security

---

## 🤝 Connect with Me

* LinkedIn: www.linkedin.com/in/vignesh-chalke
  
* GitHub: https://github.com/vigneshchalke

---

## ⭐ If you like this project, give it a star!

---
