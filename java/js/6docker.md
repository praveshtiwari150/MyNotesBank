Below are essential questions and answers derived directly from the content you provided about Docker in "Week 12.3 - Actionable Docker." These focus on key concepts, installation, verification, practical usage, and common commands necessary for understanding and getting started with Docker.

---

### **Questions and Answers**

#### **1. What is the purpose of today’s session on Docker?**
**Answer:**  
Today’s session is focused on providing a short, actionable introduction to Docker. It helps you get started with running packages locally and gives you a taste of what Docker can do, while a more detailed understanding can be gained from the Docker series on YouTube (Part 1 and Part 2).

#### **2. How can Docker be installed?**
**Answer:**  
Docker can be installed using the Docker GUI, which simplifies the setup process. Detailed instructions for various operating systems are available on the official Docker documentation website at https://docs.docker.com/engine/install/.

#### **3. How do you verify that Docker is installed correctly?**
**Answer:**  
After installation, verify that Docker is installed correctly by running the command `docker run hello-world`. This command pulls the "hello-world" image from Docker Hub and runs it in a new container, printing a message to the terminal to confirm Docker is working.

#### **4. What are the main reasons for using Docker?**
**Answer:**  
Docker is used for:  
- **Containerization of Applications**: It packages applications and their dependencies into lightweight, standalone containers that run consistently across different environments.  
- **Running Other People's Code and Packages**: It allows you to run software built by others without setting up the environment or dependencies, as they are included in the container.  
- **Running Common Software Packages**: It enables running software like databases (e.g., MongoDB, PostgreSQL) in containers without installing them directly on the host machine.

#### **5. How does Docker streamline development and deployment?**
**Answer:**  
Docker streamlines the development process, simplifies deployment, and enhances scalability and portability by isolating applications in containers. This makes it easier to manage dependencies and avoid conflicts between different software running on the same system.

#### **6. What is Docker Hub, and how does it compare to GitHub?**
**Answer:**  
Docker Hub is the default registry for Docker images, similar to GitHub for code. It’s a cloud-based repository where users can sign up, push custom images, pull images from others, and use automated build workflows. Like GitHub, it offers version control, collaboration, public and private repositories, community content (e.g., official images), and automated builds tied to source code changes.

#### **7. What are Docker images and containers?**
**Answer:**  
Docker images are blueprints that include an application and its dependencies, stored in registries like Docker Hub. Containers are instances created from these images—lightweight, standalone, executable software packages that run the application consistently across environments.

#### **8. What does the `docker run` command do?**
**Answer:**  
The `docker run` command creates and starts a Docker container from a specified image. For example, `docker run mongo` starts a MongoDB container using the official MongoDB image from Docker Hub. It’s like saying "start this application" in Docker.

#### **9. What is the purpose of the `docker ps` command?**
**Answer:**  
The `docker ps` command lists all currently running containers, showing details like container ID, image used, command executed, creation time, status, and ports. It’s similar to listing active processes on a computer.

#### **10. How do you stop a running Docker container?**
**Answer:**  
You stop a running container using the `docker kill <container_id>` command, which immediately halts the specified container. It’s like force-quitting an application on your computer.

#### **11. How do you run a MongoDB container with port mapping in detached mode?**
**Answer:**  
To run a MongoDB container in detached mode with port mapping, use:  
```bash
docker run -d -p 27017:27017 mongo
```  
The `-d` flag runs it in the background (detached mode), and `-p 27017:27017` maps the container’s MongoDB port (27017) to the host’s port (27017), making it accessible locally.

#### **12. How do you run a PostgreSQL container and set its password?**
**Answer:**  
To run a PostgreSQL container with a password, use:  
```bash
docker run -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
```  
The `-e POSTGRES_PASSWORD=mysecretpassword` sets the default user’s password, `-d` runs it in detached mode, and `-p 5432:5432` maps the PostgreSQL port (5432) from the container to the host.

#### **13. What is the connection string for a PostgreSQL container running locally?**
**Answer:**  
The connection string for a PostgreSQL container running locally is:  
```
postgresql://postgres:mysecretpassword@localhost:5432/postgres
```  
It includes the username (`postgres`), password (`mysecretpassword`), host (`localhost`), port (`5432`), and database name (`postgres`).

#### **14. How can you test a PostgreSQL connection from Node.js using the `pg` library?**
**Answer:**  
You can test a PostgreSQL connection with this Node.js script:  
```jsx
const { Client } = require('pg');
const connectionString = 'postgresql://postgres:mysecretpassword@localhost:5432/postgres';
const client = new Client({ connectionString });

client.connect(err => {
  if (err) {
    console.error('connection error', err.stack);
  } else {
    console.log('connected to the database');
  }
});

client.query('SELECT NOW()', (err, res) => {
  if (err) {
    console.error(err);
  } else {
    console.log(res.rows[0]);
  }
  client.end();
});
```  
This script connects to the database, runs a query to fetch the current time, logs the result, and closes the connection.

#### **15. Why is port mapping important when running containers like MongoDB or PostgreSQL?**
**Answer:**  
Port mapping (e.g., `-p 27017:27017` for MongoDB) is important because it allows you to access the service inside the container from your host machine. Without it, the service (e.g., MongoDB or PostgreSQL) would run isolated within the container and be inaccessible externally. Mapping links the container’s port to the host’s port, like setting up a direct line to an office in a building.

---

These questions and answers cover the foundational concepts, installation steps, verification process, practical commands, and examples of running common packages (MongoDB and PostgreSQL) from your provided content. They are essential for anyone starting with Docker and looking to apply it actionably.