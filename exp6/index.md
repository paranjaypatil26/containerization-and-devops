# 🚀 Experiment 6A: Docker Run vs Docker Compose

## 📌 Objective
To understand the difference between Docker Run and Docker Compose and implement both approaches.

---

# 🔹 Task 1: Single Container using Docker Run

## Step 1: Create Project Directory

![Step 1](screenshots/img1.png)

---

## Step 2: Run Nginx Container

![Step 2](screenshots/img2.png)

---

## Step 3: Verify Running Container

![Step 3](screenshots/img3.png)

---

## Step 4: Access in Browser

![Step 4](screenshots/img4.png)

---

## Step 5: Stop Container

![Step 5](screenshots/img5.png)

---

# 🔹 Task 1: Using Docker Compose

## Step 6: Create docker-compose.yml and Run

![Step 6](screenshots/img6.png)

---

## Step 7: Verify and Stop

![Step 7](screenshots/img7.png)

---

# 🔹 Task 2: Multi-Container (WordPress + MySQL)

## Step 8: Create Network

![Step 8](screenshots/img8.png)

---

## Step 9: Run MySQL and WordPress Containers

![Step 9](screenshots/img9.png)

---

## Step 10: WordPress Setup Page

![Step 10](screenshots/img10.png)

---

# 🔹 Task 2: Using Docker Compose

## Step 11: Run using Compose

![Step 11](screenshots/img11.png)

---

## Step 12: WordPress Running

![Step 12](screenshots/img12.png)

---

## Step 13: Stop and Remove Containers

![Step 13](screenshots/img13.png)

---

# 🔹 Task 5: Dockerfile + Docker Compose (Node App)

## Step 14: Create Files

![Step 14](screenshots/img14.png)

---

## Step 15: Build and Run Application

![Step 15](screenshots/img15.png)

---

## Step 16: Verify Running Container

![Step 16](screenshots/img16.png)

---

## Step 17: Output in Browser

![Step 17](screenshots/img17.png)

---

# 🧠 Conclusion

- Docker Run is **imperative** (manual commands)
- Docker Compose is **declarative** (configuration-based)
- Compose simplifies multi-container applications
- Dockerfile allows custom image creation

---

# 🎯 Key Learning

- Container networking using service names
- Volume persistence
- Multi-container orchestration
- Image build vs prebuilt image usage

---

# ⚡ Commands Summary

```bash
docker run
docker compose up -d
docker compose down
docker compose up --build -d