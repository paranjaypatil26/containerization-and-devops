# Experiment 5: Docker Volumes, Networking, and Container Management

## Aim

To explore Docker volumes, bind mounts, environment variables, container monitoring, and networking.

---

## Objective

* Understand Docker volumes (anonymous & named)
* Use bind mounts for host-container communication
* Implement data persistence using volumes
* Work with environment variables
* Monitor container resources
* Explore Docker networking and multi-container setup

---

## Tools Used

* Docker
* Nginx
* MySQL
* PostgreSQL
* Redis
* Node.js
* Flask

---

## Step 1: Create Container with Anonymous Volume

```bash
docker run -d -v /app/data --name web1 nginx
docker volume ls
docker inspect web1 | grep -A 5 Mounts
```

![Step 1](screenshots/step1.png)

---

## Step 2: Create Named Volume

```bash
docker volume create mydata
docker run -d -v mydata:/app/data --name web2 nginx
docker volume inspect mydata
```

![Step 2](screenshots/step2.png)

---

## Step 3: Bind Mount Example

```bash
mkdir ~/myapp-data
docker run -d -v ~/myapp-data:/app/data --name web3 nginx
echo "From Host" > ~/myapp-data/host-file.txt
docker exec web3 cat /app/data/host-file.txt
```

![Step 3](screenshots/step3.png)

---

## Step 4: MySQL Container with Volume

```bash
docker run -d \
--name mysql-db \
-v mysql-data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=secret \
mysql:8.0
```

![Step 4](screenshots/step4.png)

---

## Step 5: Verify Data Persistence

```bash
docker stop mysql-db

docker run -d \
--name new-mysql \
-v mysql-data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=secret \
mysql:8.0
```

![Step 5](screenshots/step5.png)

---

## Step 6: Run Node Application Container

```bash
docker run -d \
--name app1 \
-e DEBUG=true \
-e PORT=3000 \
-p 3000:3000 \
node
```

![Step 6](screenshots/step6.png)

---

## Step 7: Use Environment File

```bash
echo "DATABASE_HOST=localhost" > .env
echo "DATABASE_PORT=5432" >> .env
echo "API_KEY=secret123" >> .env

docker run -d --env-file .env --name app2 nginx
docker exec app2 env
```

![Step 7](screenshots/step7.png)

---

## Step 8: Monitor Containers

```bash
docker stats
```

![Step 8](screenshots/step8.png)

---

## Step 9: Filter Containers

```bash
docker stats | grep web
```

![Step 9](screenshots/step9.png)

---

## Step 10: View Processes

```bash
docker top web1
```

![Step 10](screenshots/step10.png)

---

## Step 11: View Container Logs

```bash
docker logs web1
```

![Step 11](screenshots/step14.png)

---

## Step 12: Inspect Container

```bash
docker inspect web1
```

![Step 12](screenshots/step15.png)
![Step 12 Continued](screenshots/step16.png)

---

## Step 13: List Networks

```bash
docker network ls
```

![Step 13](screenshots/step17.png)

---

## Step 14: Test Container Communication

```bash
docker exec web1 curl http://web2
```

![Step 14](screenshots/step18.png)

---

## Step 15: Run Container with Host Network

```bash
docker run -d --network host nginx
```

![Step 15](screenshots/step19.png)

---

## Step 16: Run Container with No Network

```bash
docker run -d --network none alpine sleep 3600
```

![Step 16](screenshots/step20.png)

---

## Step 17: Create Custom Network

```bash
docker network create app-network
```

![Step 17](screenshots/step21.png)

---

## Step 18: Run PostgreSQL Container

```bash
docker run -d \
--name postgres-db \
--network app-network \
-e POSTGRES_PASSWORD=secret \
-v pgdata:/var/lib/postgresql/data \
postgres:15
```

![Step 18](screenshots/step22.png)

---

## Step 19: Run Web App Container

```bash
docker run -d \
--name web-app \
--network app-network \
-p 8080:3000 \
-e DATABASE_URL="postgres://postgres:secret@postgres-db:5432/mydb" \
node
```

![Step 19](screenshots/step23.png)

---

## Step 20: View Running Containers and Networks

```bash
docker ps
docker volume ls
docker network ls
```

![Step 20](screenshots/step24.png)

---

## Step 21: Create Another Network

```bash
docker network create myapp-network
docker network ls
```

![Step 21](screenshots/step25.png)

---

## Step 22: Run PostgreSQL with New Network

```bash
docker run -d \
--name postgres \
--network myapp-network \
-e POSTGRES_PASSWORD=mysecretpassword \
-e POSTGRES_DB=mydatabase \
-v postgres-data:/var/lib/postgresql/data \
postgres:15
```

![Step 22](screenshots/step26.png)

---

## Step 23: Run Redis Container

```bash
docker run -d \
--name redis \
--network myapp-network \
-v redis-data:/data \
redis:7-alpine
```

![Step 23](screenshots/step27.png)

---

## Step 24: Run Flask Application

```bash
docker run -d \
--name flask-app \
--network myapp-network \
-p 5001:5000 \
-e DATABASE_URL="postgresql://postgres:mysecretpassword@postgres:5432/mydatabase" \
-e REDIS_URL="redis://redis:6379" \
-e DEBUG="false" \
-e LOG_LEVEL="INFO" \
flask-app:latest
```

---

## Step 25: Verify Flask App in Browser

Open:

```
http://localhost:5001
```

![Step 25](screenshots/step27.png)

---

## Result

Successfully implemented:

* Docker volumes (anonymous & named)
* Bind mounts
* Data persistence with MySQL & PostgreSQL
* Environment variables & `.env` usage
* Container monitoring (`docker stats`)
* Docker networking (bridge, host, none, custom)
* Multi-container application (PostgreSQL + Redis + Flask)

---

## Conclusion

This experiment demonstrated how Docker enables efficient container management, persistent storage, and seamless communication between multiple services using networks.

---
