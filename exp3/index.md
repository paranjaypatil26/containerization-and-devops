# Experiment 3: Building and Comparing Nginx Docker Images

---

## Aim

To understand Docker image creation and optimization by performing the following tasks:

* Pull and run the official Nginx image
* Build custom Nginx images using Ubuntu and Alpine base images
* Compare image sizes
* Analyze Docker image layers
* Deploy custom HTML content using volume mounting

---

## Implementation Steps

---

### Step 1: Pull Official Nginx Image

```bash
docker pull nginx:latest
```

Screenshot:

![Pull Nginx](screenshots/image1.png)

---

### Step 2: Run Official Nginx Container

```bash
docker run -d --name nginx-official -p 8080:80 nginx
```

Screenshot:

![Run Official Container](screenshots/image2.png)

---

### Step 3: Check Official Image Size

```bash
docker images nginx
```

Screenshot:

![Official Image Size](screenshots/image3.png)

---

### Step 4: Build Nginx Using Ubuntu Base Image

#### Create Project Folder

```bash
mkdir nginx-ubuntu
cd nginx-ubuntu
```

#### Dockerfile (Ubuntu)

```dockerfile
FROM ubuntu:22.04
RUN apt-get update && \
    apt-get install -y nginx && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
CMD ["nginx", "-g", "daemon off;"]
```

#### Build Image

```bash
docker build -t nginx-ubuntu .
```

Screenshot:

![Ubuntu Build](screenshots/image4.png)

#### Run Container

```bash
docker run -d --name nginx-ubuntu -p 8081:80 nginx-ubuntu
```

Screenshot:

![Ubuntu Container](screenshots/image5.png)

#### Check Image Size

```bash
docker images nginx-ubuntu
```

Screenshot:

![Ubuntu Image Size](screenshots/image6.png)

---

### Step 5: Build Nginx Using Alpine Base Image

#### Create Project Folder

```bash
mkdir nginx-alpine
cd nginx-alpine
```

#### Dockerfile (Alpine)

```dockerfile
FROM alpine:latest
RUN apk add --no-cache nginx
CMD ["nginx", "-g", "daemon off;"]
```

#### Build Image

```bash
docker build -t nginx-alpine .
```

Screenshot:

![Alpine Build](screenshots/image7.png)

#### Run Container

```bash
docker run -d --name nginx-alpine -p 8082:80 nginx-alpine
```

Screenshot:

![Alpine Container](screenshots/image8.png)

#### Check Image Size

```bash
docker images nginx-alpine
```

Screenshot:

![Alpine Image Size](screenshots/image9.png)

---

### Step 6: Compare All Images

```bash
docker images | grep nginx
```

Screenshot:

![Compare Images](screenshots/image10.png)

---

### Step 7: Analyze Image Layers

```bash
docker history nginx
docker history nginx-ubuntu
docker history nginx-alpine
```

Screenshot:

![Docker History](screenshots/image11.png)

---

### Step 8: Volume Mounting with Custom HTML

#### Create HTML Directory

```bash
mkdir html
echo "<h1>Hello from Docker NGINX</h1>" > html/index.html
```

#### Run Container with Volume Mount

```bash
docker run -d \
-p 8083:80 \
-v $(pwd)/html:/usr/share/nginx/html \
nginx
```

Open in browser:

```
http://localhost:8083
```

Output:
The custom HTML page is displayed successfully.

---

## Observations

| Image Type     | Size   | Performance | Use Case            |
| -------------- | ------ | ----------- | ------------------- |
| Official Nginx | 258MB  | Optimized   | Production          |
| Ubuntu Based   | 187MB  | Moderate    | Custom environments |
| Alpine Based   | 16.7MB | Lightweight | Minimal deployments |

---

## Result

The experiment was successfully completed. The official Nginx image was pulled and executed, and custom images were built using both Ubuntu and Alpine base images. Image sizes were compared, layers were analyzed, and volume mounting was implemented to serve custom content.

---

## Conclusion

* Alpine-based images are significantly smaller and more efficient
* Ubuntu-based images provide more flexibility but increase size
* Docker image layers directly impact the final image size
* Volume mounting allows dynamic updates without rebuilding images

---

## Project Structure

```
exp3/
│
├── nginx-ubuntu/
│   └── Dockerfile
│
├── nginx-alpine/
│   └── Dockerfile
│
├── html/
│   └── index.html
│
├── screenshots/
│   ├── image1.png
│   ├── image2.png
│   ├── image3.png
│   ├── image4.png
│   ├── image5.png
│   ├── image6.png
│   ├── image7.png
│   ├── image8.png
│   ├── image9.png
│   ├── image10.png
│   └── image11.png
│
└── README.md
```

---
