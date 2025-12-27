# GearGuard Maintenance Tracker

GearGuard is a **full-stack maintenance management system** built with **Spring Boot (Java)**, **MySQL**, and **React + Material UI**.  
It allows companies to manage equipment, maintenance teams, team members, and both corrective & preventive maintenance requests efficiently.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Backend Setup (Spring Boot + MySQL)](#backend-setup-spring-boot--mysql)  
- [Frontend Setup (React + Material UI)](#frontend-setup-react--material-ui)  
- [API Endpoints](#api-endpoints)  
- [Screenshots](#screenshots)  
- [Future Enhancements](#future-enhancements)  
- [License](#license)  

---

## Features

### Equipment Management
- Add, update, delete, and view equipment
- Track department, location, and assigned employee
- Mark equipment as scrapped automatically when requests are marked as SCRAP

### Maintenance Team & Team Members
- Create teams and assign members
- Fetch members by team
- Connect equipment to maintenance teams automatically

### Maintenance Requests
- **Corrective & Preventive Requests**
- Auto-fill team from equipment
- Assign technicians automatically
- Status workflow: `NEW → IN_PROGRESS → REPAIRED → SCRAP`
- Overdue logic with visual indication
- Scrap equipment flagged automatically

### Frontend
- Equipment table with Material UI
- Kanban board for maintenance requests (drag & drop)
- Preventive maintenance calendar
- Real-time updates from backend

---

## Tech Stack

### Backend
- Java 17 / 21
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

### Frontend
- React.js
- Material UI
- Axios
- react-beautiful-dnd (Kanban board)
- FullCalendar (Preventive calendar)
- Recharts (optional graphs)

---

## Backend Setup (Spring Boot + MySQL)

1. Clone the repository:

```bash
git clone <repo-url>
cd maintenance
