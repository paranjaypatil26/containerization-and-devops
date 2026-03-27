<<<<<<< HEAD
# 🐳 Experiment 3: Building and Comparing Nginx Docker Images

---

## 📌 Aim

To:

- Pull and run the official Nginx image  
- Build custom Nginx images using Ubuntu and Alpine  
- Compare image sizes  
- Analyze Docker layers  
- Deploy custom HTML using volume mounting  

---

# 🚀 Step 1: Pull Official Nginx Image

```bash
docker pull nginx:latest
```

📷 Screenshot:

![Pull Nginx](screenshot/image1.png)

---

# 🚀 Step 2: Run Official Nginx Container

```bash
docker run -d --name nginx-official -p 8080:80 nginx
```

📷 Screenshot:

![Run Official](screenshot/image2.png)

---

# 🚀 Step 3: Check Official Image Size

```bash
docker images nginx
```

📷 Screenshot:

![Official Image Size](screenshot/image3.png)

---

# 🏗 Step 4: Build Nginx Using Ubuntu Base Image

## Create Folder

```bash
mkdir nginx-ubuntu
cd nginx-ubuntu
```

## Dockerfile (Ubuntu)

```dockerfile
FROM ubuntu:22.04
RUN apt-get update && \
    apt-get install -y nginx && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
CMD ["nginx", "-g", "daemon off;"]
```

## Build Image

```bash
docker build -t nginx-ubuntu .
```

📷 Screenshot:

![Ubuntu Build](screenshot/image4.png)

## Run Container

```bash
docker run -d --name nginx-ubuntu -p 8081:80 nginx-ubuntu
```

📷 Screenshot:

![Ubuntu Run](screenshot/image5.png)

## Check Image Size

```bash
docker images nginx-ubuntu
```

📷 Screenshot:

![Ubuntu Image Size](screenshot/image6.png)

---

# 🏗 Step 5: Build Nginx Using Alpine Base Image

## Create Folder

```bash
mkdir nginx-alpine
cd nginx-alpine
```

## Dockerfile (Alpine)

```dockerfile
FROM alpine:latest
RUN apk add --no-cache nginx
CMD ["nginx", "-g", "daemon off;"]
```

## Build Image

```bash
docker build -t nginx-alpine .
```

📷 Screenshot:

![Alpine Build](screenshot/image7.png)

## Run Container

```bash
docker run -d --name nginx-alpine -p 8082:80 nginx-alpine
```

📷 Screenshot:

![Alpine Run](screenshot/image8.png)

## Check Image Size

```bash
docker images nginx-alpine
```

📷 Screenshot:

![Alpine Image Size](screenshot/image9.png)

---

# 📊 Step 6: Compare All Images

```bash
docker images | grep nginx
```

📷 Screenshot:

![Compare Images](screenshot/image10.png)

---

# 🔍 Step 7: Analyze Image Layers

```bash
docker history nginx
docker history nginx-ubuntu
docker history nginx-alpine
```

📷 Screenshot:

![Docker History](screenshot/image11.png)

---

# 📂 Step 8: Volume Mounting Custom HTML

## Create HTML Folder

```bash
mkdir html
echo "<h1>Hello from Docker NGINX</h1>" > html/index.html
```

## Run Container with Volume

```bash
docker run -d \
-p 8083:80 \
-v $(pwd)/html:/usr/share/nginx/html \
nginx
```

Open:

```
http://localhost:8083
```

✔ Custom HTML page is displayed.

---

# 📈 Observations

| Image Type | Size | Performance | Use Case |
|------------|------|------------|----------|
| Official Nginx | 258MB | Optimized | Production |
| Ubuntu Based | 187MB | Moderate | Customization |
| Alpine Based | 16.7MB | Lightweight | Minimal Deployments |

---

# ✅ Result

Successfully:

- Pulled official Nginx image  
- Built custom Ubuntu and Alpine images  
- Compared image sizes  
- Analyzed image layers  
- Implemented volume mounting  

---

# 🎯 Conclusion

- Alpine images are significantly smaller and more efficient.
- Ubuntu images provide flexibility but increase size.
- Docker layering impacts final image size.
- Volume mounting allows dynamic content updates without rebuilding.

---

# 📂 Project Structure

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


=======
# 🐳 Experiment 3: Building and Comparing Nginx Docker Images

---

## 📌 Aim

To:

- Pull and run the official Nginx image  
- Build custom Nginx images using Ubuntu and Alpine  
- Compare image sizes  
- Analyze Docker layers  
- Deploy custom HTML using volume mounting  

---

# 🚀 Step 1: Pull Official Nginx Image

```bash
docker pull nginx:latest
```

📷 Screenshot:

![Pull Nginx](screenshots/image1.png)

---

# 🚀 Step 2: Run Official Nginx Container

```bash
docker run -d --name nginx-official -p 8080:80 nginx
```

📷 Screenshot:

![Run Official](screenshots/image2.png)

---

# 🚀 Step 3: Check Official Image Size

```bash
docker images nginx
```

📷 Screenshot:

![Official Image Size](screenshots/image3.png)

---

# 🏗 Step 4: Build Nginx Using Ubuntu Base Image

## Create Folder

```bash
mkdir nginx-ubuntu
cd nginx-ubuntu
```

## Dockerfile (Ubuntu)

```dockerfile
FROM ubuntu:22.04
RUN apt-get update && \
    apt-get install -y nginx && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
CMD ["nginx", "-g", "daemon off;"]
```

## Build Image

```bash
docker build -t nginx-ubuntu .
```

📷 Screenshot:

![Ubuntu Build](screenshots/image4.png)

## Run Container

```bash
docker run -d --name nginx-ubuntu -p 8081:80 nginx-ubuntu
```

📷 Screenshot:

![Ubuntu Run](screenshots/image5.png)

## Check Image Size

```bash
docker images nginx-ubuntu
```

📷 Screenshot:

![Ubuntu Image Size](screenshots/image6.png)

---

# 🏗 Step 5: Build Nginx Using Alpine Base Image

## Create Folder

```bash
mkdir nginx-alpine
cd nginx-alpine
```

## Dockerfile (Alpine)

```dockerfile
FROM alpine:latest
RUN apk add --no-cache nginx
CMD ["nginx", "-g", "daemon off;"]
```

## Build Image

```bash
docker build -t nginx-alpine .
```

📷 Screenshot:

![Alpine Build](screenshots/image7.png)

## Run Container

```bash
docker run -d --name nginx-alpine -p 8082:80 nginx-alpine
```

📷 Screenshot:

![Alpine Run](screenshots/image8.png)

## Check Image Size

```bash
docker images nginx-alpine
```

📷 Screenshot:

![Alpine Image Size](screenshots/image9.png)

---

# 📊 Step 6: Compare All Images

```bash
docker images | grep nginx
```

📷 Screenshot:

![Compare Images](screenshots/image10.png)

---

# 🔍 Step 7: Analyze Image Layers

```bash
docker history nginx
docker history nginx-ubuntu
docker history nginx-alpine
```

📷 Screenshot:

![Docker History](screenshots/image11.png)

---

# 📂 Step 8: Volume Mounting Custom HTML

## Create HTML Folder

```bash
mkdir html
echo "<h1>Hello from Docker NGINX</h1>" > html/index.html
```

## Run Container with Volume

```bash
docker run -d \
-p 8083:80 \
-v $(pwd)/html:/usr/share/nginx/html \
nginx
```

Open:

```
http://localhost:8083
```

✔ Custom HTML page is displayed.

---

# 📈 Observations

| Image Type | Size | Performance | Use Case |
|------------|------|------------|----------|
| Official Nginx | 258MB | Optimized | Production |
| Ubuntu Based | 187MB | Moderate | Customization |
| Alpine Based | 16.7MB | Lightweight | Minimal Deployments |

---

# ✅ Result

Successfully:

- Pulled official Nginx image  
- Built custom Ubuntu and Alpine images  
- Compared image sizes  
- Analyzed image layers  
- Implemented volume mounting  

---

# 🎯 Conclusion

- Alpine images are significantly smaller and more efficient.
- Ubuntu images provide flexibility but increase size.
- Docker layering impacts final image size.
- Volume mounting allows dynamic content updates without rebuilding.

---

# 📂 Project Structure

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
>>>>>>> b3ed93b (Added Docker experiment README and screenshots)
