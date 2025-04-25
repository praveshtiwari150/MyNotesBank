Here are questions and answers based on the "Week 23.1" lecture content about WebRTC, its key concepts, implementation, statistics, and alternative architectures (SFU and MCU). These are designed to build a strong conceptual understanding of WebRTC and its applications, with answers sourced directly from the provided content.

---

### Questions and Answers on WebRTC Basics

**Q1: What is WebRTC, and why is it a compelling technology for real-time communication?**  
**A1:** WebRTC (Web Real-Time Communication) is a technology enabling real-time multimedia communication within web browsers without third-party plugins. It’s compelling because it’s:  
1. **Browser-native**: The only protocol for real-time media in browsers.  
2. **Proven**: Used in live streaming and apps like Zoom.  
3. **Low Latency**: Offers sub-second latency for video conferencing, one-to-one calls, and gaming.  
4. **P2P**: Enables direct peer-to-peer communication.  
5. **Open Standard**: Supported across browsers and platforms.

**Q2: What are some key use cases of WebRTC highlighted in the lecture?**  
**A2:**  
- **Video Conferencing**: Used by Zoom and Google Meet for multi-party calls.  
- **One-to-One Communication**: Platforms like Omegle and online teaching apps.  
- **Real-Time Gaming**: Supports low-latency data transfer (e.g., 30 FPS).

**Q3: How does WebRTC achieve peer-to-peer communication, and what does the diagram illustrate?**  
**A3:** WebRTC enables direct peer-to-peer (P2P) communication between browsers, transmitting media data without an intermediary server. The diagram shows two browsers connected directly, illustrating how P2P enhances efficiency and reduces latency.

---

### Questions and Answers on WebRTC Jargons

**Q4: What is the role of a signaling server in WebRTC?**  
**A4:** A signaling server facilitates the initial handshake between WebRTC peers by exchanging network addresses (IPs) and metadata needed for a P2P connection, typically using WebSocket or HTTP servers.

**Q5: What does a STUN server do, and how is it depicted in the diagram?**  
**A5:** A STUN (Session Traversal Utilities for NAT) server helps peers behind NAT devices discover their public IP addresses for direct P2P connections. The diagram shows two browsers communicating via a STUN and signaling server, with STUN determining public IPs.

**Q6: What are ICE candidates in WebRTC?**  
**A6:** ICE (Interactive Connectivity Establishment) candidates are potential networking endpoints (e.g., private router IPs or public IPs) that WebRTC uses to establish a connection between peers.

**Q7: What is the purpose of a TURN server, and how does the diagram illustrate it?**  
**A7:** A TURN (Traversal Using Relays around NAT) server relays media data between peers when a direct P2P connection fails due to restrictive networks or firewalls. The diagram shows two browsers connected through a TURN server, which forwards media data.

**Q8: What are offers and answers in WebRTC, and what does the SDP example show?**  
**A8:** An "offer" is sent by the initiating peer with its ICE candidates and session details (in SDP format), and the receiving peer responds with an "answer" containing its details. The SDP example:  
```jsx
v=0
o=- 423904492236154649 2 IN IP4 127.0.0.1
s=-
t=0 0
m=audio 49170 RTP/AVP 0
c=IN IP4 192.168.1.101
a=rtpmap:0 PCMU/8000
a=ice-options:trickle
a=candidate:1 1 UDP 2122260223 192.168.1.101 49170 typ host
a=candidate:2 1 UDP 2122194687 10.0.1.1 49171 typ host
a=candidate:3 1 UDP 1685987071 93.184.216.34 49172 typ srflx raddr 10.0.1.1 rport 49171
a=candidate:4 1 UDP 41819902 10.1.1.1 3478 typ relay raddr 93.184.216.34 rport 49172
```
shows session details and ICE candidates.

**Q9: What is the RTCPeerConnection, and how does it simplify WebRTC development?**  
**A9:** RTCPeerConnection is a browser-provided class that manages SDP, creates offers and answers, and handles media sending/receiving, abstracting WebRTC complexity for developers.

---

### Questions and Answers on Connecting the Two Sides

**Q10: What are the steps to establish a WebRTC connection between two peers?**  
**A10:**  
1. Browser 1 creates an RTCPeerConnection.  
2. Browser 1 creates an offer.  
3. Browser 1 sets the offer as its local description.  
4. Browser 1 sends the offer via the signaling server.  
5. Browser 2 receives the offer.  
6. Browser 2 sets the offer as its remote description.  
7. Browser 2 creates an answer.  
8. Browser 2 sets the answer as its local description.  
9. Browser 2 sends the answer via the signaling server.  
10. Browser 1 receives the answer and sets it as its remote description.

**Q11: What additional steps are required to send and receive media in WebRTC?**  
**A11:**  
1. **Ask for Permissions**: Request camera/microphone access.  
2. **Get Streams**: Use getUserMedia() to obtain audio/video streams.  
3. **Add Tracks**: Call addTrack() on RTCPeerConnection to add streams.  
4. **Receive Media**: The onTrack event triggers on the remote peer to render incoming streams.

**Q12: What does the media exchange diagram illustrate?**  
**A12:** The diagram shows two browsers connected via WebRTC, exchanging audio and video streams directly after adding tracks to their RTCPeerConnections, triggering onTrack events to render media.

---

### Questions and Answers on Implementation

**Q13: What technologies are used to implement a WebRTC application in this lecture?**  
**A13:** Node.js is used for the signaling server (WebSocket-based), and React with RTCPeerConnection API is used on the frontend for the user interface and WebRTC functionality.

**Q14: What messages does the signaling server handle, and what is their purpose?**  
**A14:**  
1. **createOffer**: Sent by Browser 1 to forward the offer to Browser 2.  
2. **createAnswer**: Sent by Browser 2 to forward the answer to Browser 1.  
3. **addIceCandidate**: Sent by both peers to exchange ICE candidates for connection establishment.

**Q15: How is the WebRTC connection established in the frontend implementation?**  
**A15:**  
1. Browser 1 creates an RTCPeerConnection and sends an offer via the signaling server (createOffer).  
2. Browser 2 receives the offer, sets it as its remote description, and sends an answer (createAnswer).  
3. Both peers set received descriptions to complete the connection.

**Q16: How are ICE candidates exchanged in the implementation?**  
**A16:** Peers gather ICE candidates and send them to the signaling server using the addIceCandidate message, which forwards them to the other peer for establishing the best connection.

**Q17: How is media handled in the frontend implementation?**  
**A17:**  
1. Peers obtain local streams with getUserMedia().  
2. Streams are added to RTCPeerConnection with addTrack().  
3. The onTrack event on the remote peer renders the incoming streams.

---

### Questions and Answers on WebRTC Stats

**Q18: What are WebRTC stats, and how can they be accessed in browsers?**  
**A18:** WebRTC stats provide diagnostic information about peer connections, useful for debugging. They can be accessed in browsers via `about:webrtc-internals`, showing details like media streams and ICE candidates.

**Q19: How are WebRTC stats used for debugging?**  
**A19:** Developers request a dump from `about:webrtc-internals` when users face issues. This dump includes SDP, ICE candidates, and metrics, helping identify connectivity or quality problems.

**Q20: What is the WebRTC Statistics Tool in Unity, and how does it relate to browser stats?**  
**A20:** The Unity WebRTC Statistics Tool displays connection stats in the editor (e.g., peer connections, metrics). Its dump files are compatible with Chrome’s `about:webrtc-internals`, enabling further analysis.

**Q21: What are some key statistics provided by WebRTC?**  
**A21:**  
- ICE candidate details (types, IPs, ports).  
- Media stream stats (bitrate, frame rate, packet loss, jitter).  
- Connection quality (round-trip time, bandwidth).  
- Codec and negotiation details.

---

### Questions and Answers on Other Architectures

**Q22: What is a limitation of P2P in WebRTC, and how does the diagram illustrate it?**  
**A22:** P2P doesn’t scale well beyond 3-4 people due to bandwidth and processing demands. The diagram shows multiple peers directly connected, highlighting the complexity and strain as the number increases.

**Q23: What is an SFU, and how does it address P2P limitations?**  
**A23:** An SFU (Selective Forwarding Unit) is a central media server that forwards packets between users, reducing peer load. The diagram shows an SFU connecting multiple peers, managing media distribution efficiently.

**Q24: What is an MCU, and how does it differ from an SFU?**  
**A24:** An MCU (Multipoint Control Unit) mixes audio/video on the server (decoding, mixing, and sending a single stream) before forwarding it. The diagram shows an MCU merging streams for multiple peers, unlike an SFU which only forwards individual streams.

---

### Verification of Coverage
These 24 questions and answers cover WebRTC fundamentals, key jargons (signaling, STUN, TURN, etc.), connection establishment, implementation details, WebRTC stats, and alternative architectures (SFU, MCU). All concepts, examples, and diagrams from the content are comprehensively addressed. Let me know if you need further clarification!

Here are questions and answers based on the "Week 23.2" lecture content about implementing WebRTC, focusing on the practical setup of the backend (Node.js signaling server) and frontend (React with Vite). These are designed to reinforce understanding of the hands-on implementation process, with answers sourced directly from the provided content.

---

### Questions and Answers on Backend Implementation

**Q1: What is the purpose of the backend in this WebRTC implementation?**  
**A1:** The backend implements a signaling server using Node.js and the `ws` library to facilitate the exchange of WebRTC signaling messages (e.g., offers, answers, ICE candidates) between peers, enabling the establishment of a peer-to-peer connection.

**Q2: How do you initialize a new TypeScript project for the signaling server?**  
**A2:**  
1. Run `npm init -y` to create a `package.json` file.  
2. Run `npx tsc --init` to generate a `tsconfig.json` file.  
3. Install dependencies: `npm install ws @types/ws`.

**Q3: How do you configure TypeScript for the signaling server?**  
**A3:** In `tsconfig.json`, update:  
```json
"rootDir": "./src",
"outDir": "./dist",
```
This specifies the source directory (`src`) and output directory (`dist`) for compiled JavaScript files.

**Q4: What is the initial structure of the WebSocket server in `src/index.ts`?**  
**A4:**  
```tsx
import { WebSocketServer } from 'ws';

const wss = new WebSocketServer({ port: 8080 });

let senderSocket: null | WebSocket = null;
let receiverSocket: null | WebSocket = null;

wss.on('connection', function connection(ws) {
  ws.on('error', console.error);

  ws.on('message', function message(data: any) {
    const message = JSON.parse(data);
    // Handle incoming messages here
  });

  ws.send('something');
});
```
It creates a WebSocket server on port 8080, tracks sender and receiver sockets, and sets up basic connection and message handling.

**Q5: How do you run the WebSocket server after writing the code?**  
**A5:**  
1. Compile TypeScript: `tsc -b`.  
2. Start the server: `node dist/index.js`.

**Q6: What message types does the signaling server handle, and how are they processed?**  
**A6:**  
```tsx
ws.on('message', function message(data: any) {
  const message = JSON.parse(data);
  if (message.type === 'sender') {
    senderSocket = ws;
  } else if (message.type === 'receiver') {
    receiverSocket = ws;
  } else if (message.type === 'createOffer') {
    if (ws !== senderSocket) return;
    receiverSocket?.send(JSON.stringify({ type: 'createOffer', sdp: message.sdp }));
  } else if (message.type === 'createAnswer') {
    if (ws !== receiverSocket) return;
    senderSocket?.send(JSON.stringify({ type: 'createAnswer', sdp: message.sdp }));
  } else if (message.type === 'iceCandidate') {
    if (ws === senderSocket) {
      receiverSocket?.send(JSON.stringify({ type: 'iceCandidate', candidate: message.candidate }));
    } else if (ws === receiverSocket) {
      senderSocket?.send(JSON.stringify({ type: 'iceCandidate', candidate: message.candidate }));
    }
  }
});
```
- `sender`: Stores the sender socket.  
- `receiver`: Stores the receiver socket.  
- `createOffer`: Forwards the offer SDP from sender to receiver.  
- `createAnswer`: Forwards the answer SDP from receiver to sender.  
- `iceCandidate`: Forwards ICE candidates between sender and receiver.

**Q7: What limitations does this signaling server have, and where can you find an advanced example?**  
**A7:** This server supports only one-way communication between two tabs. For two-way communication and multiple rooms, refer to: https://github.com/hkirat/omegle/.

---

### Questions and Answers on Frontend Implementation

**Q8: What tools are used to set up the frontend for the WebRTC application?**  
**A8:** React with Vite is used as the build tool for the frontend, leveraging React for the UI and Vite for fast development and bundling.

**Q9: How do you create a new React project with Vite for the frontend?**  
**A9:** Run `npm create vite@latest` and follow the prompts to set up a new React project.

**Q10: How is routing added to the React frontend, and what routes are defined?**  
**A10:**  
1. Install `react-router-dom`: `npm install react-router-dom`.  
2. Update `src/App.tsx`:  
   ```tsx
   import { Route, BrowserRouter, Routes } from 'react-router-dom';
   import { Sender } from './components/Sender';
   import { Receiver } from './components/Receiver';

   function App() {
     return (
       <BrowserRouter>
         <Routes>
           <Route path="/sender" element={<Sender />} />
           <Route path="/receiver" element={<Receiver />} />
         </Routes>
       </BrowserRouter>
     );
   }
   export default App;
   ```
   Routes defined: `/sender` for the Sender component and `/receiver` for the Receiver component.

**Q11: Why is strict mode removed in `main.tsx`, and how is it done?**  
**A11:** Strict mode is removed in `src/main.tsx` to prevent multiple WebRTC connections locally during development. Remove the `<React.StrictMode>` wrapper around `<App />`.

**Q12: What is the initial structure of the Sender component in `src/components/Sender.tsx`?**  
**A12:**  
```tsx
import { useEffect, useState } from "react";

export const Sender = () => {
  const [socket, setSocket] = useState<WebSocket | null>(null);
  const [pc, setPC] = useState<RTCPeerConnection | null>(null);

  useEffect(() => {
    const socket = new WebSocket('ws://localhost:8080');
    setSocket(socket);
    socket.onopen = () => {
      socket.send(JSON.stringify({ type: 'sender' }));
    };
  }, []);

  const initiateConn = async () => {
    // ... (implementation omitted)
  };

  const getCameraStreamAndSend = (pc: RTCPeerConnection) => {
    // ... (implementation omitted)
  };

  return (
    <div>
      Sender
      <button onClick={initiateConn}> Send data </button>
    </div>
  );
};
```
It sets up a WebSocket connection, initializes an RTCPeerConnection, and provides a button to start the connection.

**Q13: What does the Sender component do when it loads?**  
**A13:** On load, it connects to the WebSocket server at `ws://localhost:8080` via `useEffect`, sets the socket state, and sends a `{ type: 'sender' }` message to identify itself to the server.

**Q14: What is the initial structure of the Receiver component in `src/components/Receiver.tsx`?**  
**A14:**  
```tsx
import { useEffect } from "react";

export const Receiver = () => {
  useEffect(() => {
    const socket = new WebSocket('ws://localhost:8080');
    socket.onopen = () => {
      socket.send(JSON.stringify({ type: 'receiver' }));
    };
    startReceiving(socket);
  }, []);

  function startReceiving(socket: WebSocket) {
    // ... (implementation omitted)
  }

  return <div></div>;
};
```
It connects to the WebSocket server, identifies itself as the receiver, and starts listening for incoming data.

**Q15: How does the Receiver component initialize its connection to the signaling server?**  
**A15:** In `useEffect`, it creates a WebSocket connection to `ws://localhost:8080`, sends a `{ type: 'receiver' }` message on open, and calls `startReceiving` to handle incoming WebRTC data.

**Q16: What is the core functionality of this WebRTC frontend implementation?**  
**A16:** The Sender initiates a WebRTC connection, requests camera access, and sends media to the Receiver. The Receiver listens for incoming media and renders it in a video element.

---

### Questions and Answers on Enhancements and Extensions

**Q17: What enhancement is suggested for supporting multiple producers in the WebRTC application?**  
**A17:** Modify the signaling server to support multiple senders (producers) and receivers, and update the frontend components to handle multiple connections and media streams.

**Q18: How can room logic be added to the WebRTC application?**  
**A18:** Implement room functionality on the signaling server to allow users to join specific rooms, and update the frontend to enable creating or joining rooms.

**Q19: What is required to enable two-way communication in this implementation?**  
**A19:** Modify the signaling server to handle bi-directional communication and update the frontend components to support both sending and receiving media data.

**Q20: How can an SFU be integrated into this WebRTC application?**  
**A20:** Integrate an SFU server (e.g., Mediasoup), update the signaling server to communicate with it, and modify the frontend to connect to the SFU for scalable media handling instead of pure P2P.

---

### Verification of Coverage
These 20 questions and answers cover the practical implementation of WebRTC, including the backend signaling server setup with Node.js and `ws`, the frontend setup with React and Vite, and suggested enhancements (multiple producers, rooms, two-way communication, SFU). All key steps, code snippets, and concepts from the content are addressed comprehensively. Let me know if you need further details!