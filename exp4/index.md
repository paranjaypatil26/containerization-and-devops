# Experiment 4: Flask Application using Docker

---

## Aim

To create a simple Flask application, containerize it using Docker, build Docker images, and manage containers.

---

## Tools Used

* Docker
* Python (Flask)
* Terminal (MacOS)

---

## Step 1: Create Project Directory

```bash
mkdir my-flask-app
cd my-flask-app
```

---

## Step 2: Create Required Files

```bash
nano app.py
nano requirements.txt
nano Dockerfile
nano .dockerignore
```

---

## Step 3: Build Docker Image

```bash
docker build -t my-flask-app .
```

### Output

![Build Image](../screenshots/ex4img3.png)

---

## Step 4: Check Docker Images

```bash
docker images
```

### Output

![Docker Images](../screenshots/ex4img4.png)

---

## Step 5: Tag Image with Version

```bash
docker build -t my-flask-app:1.0 .
docker build -t my-flask-app:latest -t my-flask-app:1.0 .
```

### Output

![Tagging Image](../screenshots/ex4img5.png)

---

## Step 6: Tag for Docker Hub

```bash
docker build -t username/my-flask-app:1.0 .
```

### Output

![Docker Hub Tag](../screenshots/ex4img6.png)

---

## Step 7: View Image History

```bash
docker history my-flask-app
```

### Output

![Docker History](../screenshots/ex4img10.png)

---

## Step 8: Inspect Docker Image

```bash
docker inspect my-flask-app
```

### Output

![Docker Inspect](../screenshots/ex4img11.png)

---

## Step 9: Run Docker Container

```bash
docker run -d -p 5000:5000 --name flask-container my-flask-app
```

### Output

![Run Container](../screenshots/ex4img12.png)

---

## Step 10: Container Management

```bash
docker ps
docker logs flask-container
docker stop flask-container
docker start flask-container
docker rm flask-container
```

### Output

![Container Commands](../screenshots/ex4img13.png)

---

## Result

The Flask application was successfully containerized using Docker.
Docker images were created, tagged, and inspected.
The container was executed and managed using Docker commands.

---

## Conclusion

This experiment demonstrates how a Flask application can be packaged into a Docker container and managed using Docker commands. It provides a clear understanding of image creation, tagging, inspection, and container lifecycle management.

---
