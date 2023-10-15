Title: Vehicle Rental System

## Description

This repository contains the implementation of a comprehensive Vehicle Rental System, consisting of three services, designed to facilitate the renting of vehicles. The system offers a User Service for user authentication and authorization, a Vehicle Rental Service for clients to browse and book available vehicles, and a Notification Service to send notifications related to vehicle reservations and reminders.

## Features

### User Service
- User Types: Supports multiple user types (admin, client, and manager) with varying data attributes and privileges.
- Registration: Admin, clients, and managers can register with email verification.
- User Suspension: Admin can temporarily ban user access.
- Login: Users can log in and receive a JWT token.
- Profile Editing: Users can update their profiles.
- User Ranks: Clients receive ranks based on their total rental duration.
- Customizable Ranks: Admin can configure rank thresholds and associated discounts.

### Vehicle Rental Service
- Firm Data Management: Managers can add and update firm details, including name, description, vehicle count, vehicle types, vehicle models, and daily rental prices.
- Listing Vehicles: Users can browse available vehicles with filters for city, rental firm, and time interval, with sorting by price.
- Reservation: Clients can make reservations for vehicle types or specific models, with asynchronous notification and discount retrieval.
- Cancellation: Users can cancel reservations, triggering updates to available vehicle counts and user rental durations.
- Review System: Clients can leave reviews with ratings and comments.
- Review Management: Review listing, updating, and deletion is supported, with firms sorted by average ratings.

### Notification Service
- Notification Types: Admin can define notification types with parameters.
- Activation Email: Sends an activation email upon registration.
- Password Change Email: Sends an email for changing the password.
- Reservation Confirmation: Notifies clients and managers when a vehicle is successfully reserved.
- Reservation Cancellation: Notifies clients and managers on reservation cancellations.
- Reminder Email: Sends a reminder email three days before a reservation.
- Notification History: Stores all sent notifications, accessible by admin, clients, and managers.
- Asynchronous Communication: All notification requests are sent asynchronously via a message broker.

## Technology Stack

The system utilizes a microservices architecture with API gateway routing, message broker communication, and the following technologies:
- API Gateway: Netflix Zuul
- Service Discovery: Netflix Eureka
- Database: SQL-based databases
- Backend: Java
- Frontend: (GUI) - Implementation not included in this repository.

Keep in mind that maybe some of the features are not fully implemented
