# Appreciation-Post-Board

SI Personal Project verification Code: WTC-8T6DPTGB

> A lightweight, real-time message submission and processing system built with **Spring Boot**, **REST APIs**, **JSON Serialization**, and **Java Messaging Service (JMS)**.

---

## 📌 Project Overview

The **Appreciation Post Board** allows students, teachers, and staff to send appreciation messages (shoutouts) to anyone on campus. 

Instead of processing requests synchronously—which could lead to slow server responses during traffic spikes—the application decouples reception from processing. Submissions hit a REST endpoint, convert into a JSON payload, and are placed directly into an asynchronous **JMS queue**. A background listener handles moderation, text cleanup, and broadcasting.

---

## 🚀 Track Coverage & Requirements

### 🛠️ Track 1: Foundations of Java Messaging (JMS)
* **Asynchronous Processing:** The REST API hands off incoming shoutouts to an in-memory **ActiveMQ** message broker, immediately returning an `HTTP 202 Accepted` response.
* **JMS Queue (`school-shoutouts-queue`):** Holds pending shoutouts in memory until consumed.
* **Message Listener (`@JmsListener`):** An asynchronous worker continuously listens to the queue, executes basic moderation rules (profanity filtering), and outputs approved messages to the server console log.

### 🛠️ Track 2: Advanced REST & JSON Serialization
* **RESTful Endpoint:** Exposes `POST /api/shoutouts` to ingest new messages.
* **JSON Serialization & Deserialization:**
  * Uses **Jackson** to convert incoming HTTP JSON request bodies into `Shoutout` Java objects.
  * Uses `MappingJackson2MessageConverter` to serialize Java objects into JSON text messages across the JMS broker.

---

## 📁 Project Structure

```text
Appreciation-post-Board/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── co/
        │       wethinkcode/
        │           shoutout/
        │               ShoutoutPostApp.java
        │               controller/
        │                   ShoutoutController.java
        │               listener/
        │                   ShoutoutModeratorListener.java
        │               model/
        │                   Shoutout.java
        └── resources/
            └── static/
                └── index.html  <-- Frontend Form

#Tech Stack & Prerequisites

Java: 17+

Framework: Spring Boot 3.2.x

Build Tool: Apache Maven

Dependencies:

spring-boot-starter-web (REST APIs & JSON)

spring-boot-starter-activemq & activemq-broker (Embedded JMS Broker)

---

## Future Roadmap & Enhancements

- [ ] **Live Billboard Display (`/board.html`):** Implement Server-Sent Events (SSE) or WebSockets so submitted appreciation posts automatically stream and render on a live presentation page in real time without refreshing.
- [ ] **Database Persistence:** Add Spring Data JPA & H2/PostgreSQL database integration to permanently store moderation-approved shoutouts.
- [ ] **Reaction Counters:** Allow students to react (💖, 👏) to posts on the live feed.

Quickstart Guide

1. Clone & Build
# Clean and compile the project
mvn clean package

2. Run the Application
mvn spring-boot:run

3. Open Web Frontend
Open your web browser and navigate to:
http://localhost:8080/




