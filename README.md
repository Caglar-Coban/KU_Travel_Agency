# KU Travel Agency

A **Java Swing-based travel management system** developed as part of the **COMP132: Advanced Programming** course at **Koç University** (Fall 2024).

This project simulates a travel agency platform that enables users and admins to manage travel-related entities such as flights, hotels, taxis, and travel packages.

---

## 🧭 Overview

The system allows:
- **User authentication** (sign up / login)  
- **Reservation management** for flights, hotels, taxis, and travel packages  
- **Custom travel package creation** by users  
- **Administrative control** over travel packages  
- **Statistics and reports** for both users and admins  
- **Logging system** to track actions such as reservations, cancellations, and modifications  

📄 The full project report is available in the [`/report`](./report/) folder:  
**KU_Travel_Agency_Report_Çağlar_Çoban.pdf**

---

## 🧩 System Architecture

### 🧱 Class Design
- **Entities (Abstract Class)** – Base class for all reservation entities (`Flight`, `Hotel`, `Taxi`, `TravelPackage`).  
- **Loggable (Interface)** – Implemented by both `Admin` and `Customer` classes.  
- **TravelPackage** – Has-a relationship with `Flight`, `Hotel`, and `Taxi`.  
- **Reservation** – Manages booking and cancellation logic.  
- **FileHelpers** – Handles file reading, writing, and modification in `/data` and `/logs` folders.  

### 🖥️ GUI
Developed using **Java Swing** and **Eclipse WindowBuilder**.  
Main components:
- `JTable` for listing and selecting entities  
- `JLabel`, `JTextField`, `JPasswordField`, `JComboBox` for input and display  
- `JTextArea` for displaying entity details and costs  
- `ActionListener` and `MouseListener` for interactive UI handling  

---

## 📂 Data & File Management

All data is stored in `.txt` files for persistence.

| Folder | Purpose |
|---------|----------|
| `/data` | Stores final travel packages and entity data |
| `/logs` | Contains logs for reservations, payments, cancellations, modifications, and login actions |
| `/src`  | Main source code files |

Example log files:
- `Reservations.txt` — Stores active reservations  
- `Cancellations.txt` — Keeps cancelled bookings  
- `Payments.txt` — Tracks all user payments and refunds  
- `LoginLogs.txt` — Records all login activities  

---

## 💡 Features

### 👥 User Side
- Sign up & Login  
- Make and cancel reservations  
- Create custom travel packages  
- View travel history and cancellation history  
- View personal statistics (total bookings, cancellations, spending, success rate)

### 🧑‍💼 Admin Side
- Create, edit, and delete travel packages  
- View and manage all user reservations  
- Access global statistics (agency profits, hotel/flight/taxi revenues)  
- View user-specific statistics  
- Review system logs  

---

## 💰 Profit Calculation
The agency’s profit is calculated by summing all received payments and subtracting costs recorded in the `Payments` log file.  
All results are displayed in a tabular format via the admin statistics GUI.

---

## 🧮 Implementation Highlights
- **Data saving** — `PrintWriter` is used to write data directly to files.  
- **Data loading** — `BufferedReader` reads files line by line and parses them into entity objects.  
- **Availability check** — The system validates seats, destinations, and compatible travel entities before confirming reservations.  
- **GUI integration** — Dynamic tables and event-driven components for a real-time booking experience.  

---

## 🧰 Tech Stack
- **Language:** Java  
- **IDE:** Eclipse (WindowBuilder GUI plugin)  
- **UI Library:** Swing  
- **Data Storage:** Text files (`.txt`)  

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/<username>/KU_Travel_Agency.git
   cd KU_Travel_Agency
   ```
2. Open the project in **Eclipse IDE**
3. Make sure your file paths for `/data` and `/logs` are correct
4. Run the main application file from the `src` folder  
5. Login credentials for demo:
   ```
   Admin → username: admin | password: admin  
   User  → username: Çağlar | password: 123C
   ```

---

## 📊 Example Packages
| Package | Hotel | Airline | Duration | Taxi | City |
|----------|--------|----------|-----------|------|------|
| Rome | Marriott | Pegasus Airlines | 3 days | Yellow Taxi | Rome |
| Paris | Marriott | Pegasus Airlines | 5 days | Orange Taxi | Paris |
| Czech | Marriott | GlobalJet | 5 days | Orange Taxi | Prague |
| Dublin | Hilton | Pegasus Airlines | 3 days | Yellow Taxi | Dublin |

---

## 👨‍💻 Author
**Çağlar Çoban**  
Koç University — COMP132 Advanced Programming  
Fall 2024  

---

## 📝 References
GUI tutorials and media resources used are listed in the project report.  
All visual and educational materials credited to their respective authors.
