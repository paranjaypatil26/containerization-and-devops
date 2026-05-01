# Experiment 6: Docker and Docker Compose Lab

## Aim

To understand Docker containerization and Docker Compose by deploying Nginx, WordPress, and a Node.js application.

---

## Objective

* Run a container using Docker
* Serve static content using Nginx
* Use Docker Compose for container orchestration
* Deploy WordPress with MySQL
* Build and run a Node.js application

---

## Tools Used

* Docker
* Docker Compose
* Nginx
* MySQL
* WordPress
* Node.js

---

## Step 1: Create Project Directory and HTML File

```bash
mkdir docker-lab
cd docker-lab
mkdir html
echo "Hello from Docker Run" > html/index.html
```

![Step 1](screenshots/img1.png)

---

## Step 2: Run Nginx Container

```bash
docker run -d \
--name lab-nginx \
-p 8081:80 \
-v $(pwd)/html:/usr/share/nginx/html \
nginx:alpine
```

![Step 2](screenshots/img2.png)

---

## Step 3: Verify Running Container

```bash
docker ps
```

![Step 3](screenshots/img3.png)

---

## Step 4: Access Application

Open in browser:

```
http://localhost:8081
```

![Step 4](screenshots/img4.png)

---

## Step 5: Stop Container

```bash
docker stop lab-nginx
```

![Step 5](screenshots/img5.png)

---

## Step 6: Docker Compose (Nginx)

```bash
touch docker-compose.yml
docker compose up -d
docker compose ps
docker compose down
```

![Step 6](screenshots/img6.png)

---

## Step 7: Create Network

```bash
docker network create wp-net
```

![Step 7](screenshots/img7.png)

---

## Step 8: Run MySQL Container

```bash
docker run -d \
--name mysql \
--network wp-net \
-e MYSQL_ROOT_PASSWORD=secret \
-e MYSQL_DATABASE=wordpress \
mysql:5.7
```

![Step 8](screenshots/img8.png)

---

## Step 9: Run WordPress Container

```bash
docker run -d \
--name wordpress \
--network wp-net \
-p 8082:80 \
-e WORDPRESS_DB_HOST=mysql \
-e WORDPRESS_DB_PASSWORD=secret \
wordpress
```

![Step 9](screenshots/img9.png)

---

## Step 10: Access WordPress

Open in browser:

```
http://localhost:8082
```

![Step 10](screenshots/img10.png)

---

## Step 11: Docker Compose for WordPress

```bash
mkdir wp-compose
cd wp-compose
touch docker-compose.yml
docker compose up -d
```

![Step 11](screenshots/img11.png)

---

## Step 12: Stop and Remove Containers

```bash
docker compose down
docker compose down -v
```

![Step 12](screenshots/img12.png)

---

## Step 13: Create Node.js App Setup

```bash
mkdir node-compose-lab
cd node-compose-lab
touch app.js
touch Dockerfile
touch docker-compose.yml
```

![Step 13](screenshots/img13.png)

---

## Step 14: Build and Run Node App

```bash
docker compose up --build -d
```

![Step 14](screenshots/img14.png)

---

## Step 15: Verify Running Containers

```bash
docker ps
```

![Step 15](screenshots/img15.png)

---

## Step 16: Access Node Application

Open in browser:

```
http://localhost:3000
```

![Step 16](screenshots/img16.png)

---

## Result

Successfully deployed and managed multiple applications using Docker and Docker Compose, including Nginx, WordPress with MySQL, and a Node.js application.

---
