Here are questions and answers based on the "Week 27.1" lecture content about Kubernetes, covering its introduction, pre- and post-Kubernetes architectures, key components (nodes, clusters, pods, etc.), the control plane, worker nodes, cluster setup, the Kubernetes API, `kubectl`, and creating a pod. These are designed to reinforce understanding, with answers sourced directly from the provided content.

---

### Questions and Answers on Understanding Kubernetes

**Q1: What is Kubernetes, and why is it significant for cloud-native applications?**  
**A1:** Kubernetes (K8s) is an open-source container orchestration system that automates the deployment, scaling, and management of containerized applications. It’s significant because it:  
1. Manages containerized workloads efficiently.  
2. Builds on Docker for containerization.  
3. Enables cloud-native deployment.  
4. Offers auto-healing and auto-scaling.  
5. Provides observability via dashboards and tools.

**Q2: What are the key components of Kubernetes mentioned in the lecture?**  
**A2:**  
1. **Cluster**: A group of nodes with a control plane and worker nodes.  
2. **Control Plane**: Manages cluster state and decisions.  
3. **Kubelet**: Ensures containers run as expected on nodes.  
4. **Pod**: The smallest deployable unit, containing one or more containers.

---

### Questions and Answers on Before Kubernetes

**Q3: What was the typical backend architecture before Kubernetes?**  
**A3:** It included:  
- **Domain and HTTPS**: e.g., `api.website.com` with HTTPS.  
- **Load Balancer**: Distributed traffic across servers.  
- **EC2 Instances**: Hosted backend services, often multiple for redundancy.  
The diagram shows this setup with traffic flowing from the domain through a load balancer to EC2 instances.

**Q4: What challenges did the pre-Kubernetes backend architecture face?**  
**A4:**  
- Manual or script-based scaling.  
- Downtime or complex deployment strategies for updates.  
- Increased operational complexity managing multiple instances.

**Q5: How was a Next.js frontend deployed before Kubernetes, and what were its limitations?**  
**A5:**  
- **Architecture**: A single EC2 instance hosted the Next.js app under a domain (e.g., `website.com`) with HTTPS.  
- **Limitations**: Limited scalability, single point of failure, potential downtime during updates.

**Q6: What was the architecture for a static React site before Kubernetes, and what were its advantages?**  
**A6:**  
- **Architecture**: Domain → CDN (e.g., CloudFront) → S3 hosting static files.  
- **Advantages**: Scalable, cost-effective, globally performant via CDN, easy updates via S3 uploads.

**Q7: What were the overarching limitations of pre-Kubernetes architectures?**  
**A7:**  
1. Complex scaling requiring manual effort.  
2. Inefficient resource utilization on EC2 instances.  
3. Deployment complexity and risks.  
4. Limited portability across providers.  
5. High operational overhead.

---

### Questions and Answers on After Kubernetes

**Q8: How does Kubernetes change application deployment, as shown in the diagram?**  
**A8:** Kubernetes deploys both frontend and backend as pods within a cluster, managed uniformly. The diagram shows a cluster with nodes running pods, simplifying management and scaling.

**Q9: What are the two types of nodes in a Kubernetes cluster, and what do they do?**  
**A9:**  
1. **Master Node (Control Plane)**: Manages cluster state, scheduling, and API requests.  
2. **Worker Nodes**: Run application workloads in pods.

**Q10: What is a Kubernetes cluster, and what benefits does it provide?**  
**A10:** A cluster is a set of nodes (one master, multiple workers) that offers:  
- High availability.  
- Load balancing.  
- Scalability.  
- Efficient resource use.

**Q11: What are Docker images in the context of Kubernetes?**  
**A11:** Docker images are self-contained packages with dependencies, built from Dockerfiles, stored in registries (e.g., Docker Hub), and used to create containers in Kubernetes (e.g., MongoDB image).

**Q12: What are containers, and how do they function in Kubernetes?**  
**A12:** Containers are running instances of images, providing isolation, consistency, and efficient resource use. Example:  
```bash
docker run -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres
```

**Q13: What defines a pod in Kubernetes, and what does the pod diagram illustrate?**  
**A13:** A pod is the smallest deployable unit, containing one or more containers sharing network and storage, and is ephemeral. The diagram shows a pod with containers, highlighting their shared resources.

**Q14: What advantages does Kubernetes offer over traditional architectures?**  
**A14:**  
1. Unified management of components.  
2. Easy scalability with pod replicas or nodes.  
3. Self-healing from failures.  
4. Built-in load balancing.  
5. Zero-downtime rolling updates.  
6. Efficient resource utilization.

---

### Questions and Answers on Master Node (Control Plane)

**Q15: What is the role of the Master Node in a Kubernetes cluster?**  
**A15:** The Master Node (Control Plane) is the brain of the cluster, maintaining desired state, making decisions, and responding to events via components like the API Server, etcd, scheduler, and controller manager.

**Q16: What are the key components of the Master Node, and what do they do?**  
**A16:**  
1. **API Server**: Handles RESTful API requests, authentication, and metrics.  
2. **etcd**: Stores cluster data reliably and securely.  
3. **kube-scheduler**: Assigns pods to nodes based on resources and constraints.  
4. **kube-controller-manager**: Runs controllers (e.g., Node, ReplicaSet) to maintain state.

**Q17: How do the Control Plane components collaborate, as shown in the workflow example?**  
**A17:**  
1. User submits a deployment via `kubectl`.  
2. API Server stores it in etcd.  
3. Deployment Controller creates a ReplicaSet.  
4. ReplicaSet Controller creates pods.  
5. Scheduler assigns pods to nodes.  
6. Kubelet starts containers.  
The diagram illustrates this flow from API to worker nodes.

---

### Questions and Answers on Worker Nodes

**Q18: What is the purpose of Worker Nodes in a Kubernetes cluster?**  
**A18:** Worker Nodes run application workloads in pods, managed by components like kubelet, kube-proxy, and a container runtime.

**Q19: How does the kubelet function on a Worker Node?**  
**A19:** The kubelet:  
1. Watches API Server for PodSpecs.  
2. Reconciles current vs. desired state.  
3. Starts, monitors, or stops containers.  
4. Reports status to the API Server.

**Q20: What role does kube-proxy play, and what does its diagram show?**  
**A20:** kube-proxy maintains network rules and forwards connections for pod communication. The diagram shows it enabling network traffic to pods.

**Q21: What is the Container Runtime Interface (CRI), and why is it important?**  
**A21:** CRI abstracts the container runtime (e.g., containerd, CRI-O), allowing Kubernetes to support multiple runtimes flexibly. The diagram shows this abstraction layer between kubelet and runtime.

---

### Questions and Answers on Creating a Kubernetes Cluster

**Q22: How do you set up a local Kubernetes cluster with Minikube?**  
**A22:**  
1. Install Minikube (https://minikube.sigs.k8s.io/docs/start/).  
2. Start cluster: `minikube start`.  
3. Verify: `docker ps` (shows one node).

**Q23: How do you create a single-node cluster with Kind?**  
**A23:**  
1. Install Kind (https://kind.sigs.k8s.io/docs/user/quick-start/).  
2. Create cluster: `kind create cluster --name local`.  
3. Verify: `docker ps` (shows control-plane container).  
4. Delete: `kind delete cluster -n local`.

**Q24: How do you set up a multi-node cluster with Kind?**  
**A24:**  
1. Create `clusters.yml`:  
   ```yaml
   kind: Cluster
   apiVersion: kind.x-k8s.io/v1alpha4
   nodes:
   - role: control-plane
   - role: worker
   - role: worker
   ```  
2. Create cluster: `kind create cluster --config clusters.yml --name local`.  
3. Verify: `docker ps` (shows multiple nodes).

**Q25: What are some cloud-based Kubernetes options mentioned?**  
**A25:**  
1. Google Kubernetes Engine (GKE).  
2. Amazon Elastic Kubernetes Service (EKS).  
3. Azure Kubernetes Service (AKS).  
4. Vultr Kubernetes Engine.

---

### Questions and Answers on Kubernetes API and kubectl

**Q26: What is the Kubernetes API, and how do you locate it locally?**  
**A26:** The Kubernetes API, exposed by the master node, allows cluster management (e.g., starting pods). Locate it with `docker ps` to find the API server container’s port.

**Q27: How do you install and verify kubectl?**  
**A27:**  
1. Install from https://kubernetes.io/docs/tasks/tools/#kubectl.  
2. Verify: `kubectl version --client`.

**Q28: What are some basic kubectl commands to check cluster resources?**  
**A28:**  
- `kubectl get nodes`: Lists nodes.  
- `kubectl get pods`: Lists pods in the default namespace.

**Q29: How do you debug kubectl requests, and what does the `--v=8` flag show?**  
**A29:** Use `kubectl get nodes --v=8` to see detailed HTTP request info (URL, headers, response status/body) for troubleshooting.

---

### Questions and Answers on Creating a Pod

**Q30: How do you test an NGINX image locally before Kubernetes deployment?**  
**A30:** Run:  
```bash
docker run -p 3005:80 nginx
```
Visit `localhost:3005` to see the NGINX welcome page.

**Q31: How do you deploy and manage an NGINX pod in Kubernetes?**  
**A31:**  
1. Create: `kubectl run nginx --image=nginx --port=80`.  
2. Check status: `kubectl get pods`.  
3. View logs: `kubectl logs nginx`.  
4. Describe: `kubectl describe pod nginx`.

**Q32: How do you access an NGINX pod locally, and how do you stop it?**  
**A32:**  
- **Access**: Use `kubectl port-forward pod/nginx 8080:80`, then visit `localhost:8080`.  
- **Stop**: `kubectl delete pod nginx`.

---

### Verification of Coverage
These 32 questions and answers comprehensively cover Kubernetes basics, pre- and post-Kubernetes architectures, core components (nodes, pods, etc.), control plane and worker node details, cluster setup (Minikube, Kind, cloud), the Kubernetes API, `kubectl` usage, and pod creation. All concepts, diagrams, and examples from the content are addressed. Let me know if you need further elaboration!

Here are questions and answers based on the "Week 27.2" lecture content about Kubernetes, focusing on Deployments, ReplicaSets, Services (especially LoadBalancer), and the practical steps for creating and exposing applications. These are designed to solidify understanding, with answers sourced directly from the provided content.

---

### Questions and Answers on Checkpoint: Key Kubernetes Concepts

**Q1: What is a Kubernetes cluster, and what does it consist of?**  
**A1:** A Kubernetes cluster is a set of machines (nodes) that run containerized applications managed by Kubernetes. It consists of at least one control plane node and multiple worker nodes, providing a unified platform for deployment and management.

**Q2: What are the types of nodes in a Kubernetes cluster, and what are their roles?**  
**A2:**  
1. **Control Plane Node**: Manages cluster state and control processes (e.g., API Server, Scheduler).  
2. **Worker Nodes**: Run application workloads in pods, with components like Kubelet, Kube-proxy, and a container runtime.

**Q3: What are images and containers in Kubernetes, and how do they relate?**  
**A3:**  
- **Images**: Lightweight, standalone packages with application code and dependencies, stored in registries like Docker Hub.  
- **Containers**: Runnable instances of images, providing isolation and consistency. Containers are created from images.

**Q4: What defines a pod, and how does it fit into the Kubernetes hierarchy?**  
**A4:** A pod is the smallest deployable unit in Kubernetes, containing one or more containers that share network and storage, and is ephemeral. It fits into the hierarchy as: Cluster → Nodes → Pods → Containers.

---

### Questions and Answers on Kubernetes Deployments

**Q5: What is a Kubernetes Deployment, and how does it differ from a pod?**  
**A5:** A Deployment is a resource object that manages pods declaratively, ensuring a desired state. Differences:  
- **Abstraction**: Pods are the smallest unit; Deployments manage multiple pods.  
- **Management**: Pods are ephemeral; Deployments maintain replicas.  
- **Updates**: Pods need manual updates; Deployments support rolling updates.  
- **Scaling**: Pods scale manually; Deployments scale automatically.  
- **Self-Healing**: Pods need manual restarts; Deployments auto-replace failed pods.

**Q6: How do you create a Deployment for NGINX with 3 replicas?**  
**A6:** Use this YAML (`nginx-deployment.yaml`):  
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nginx-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:1.14.2
        ports:
        - containerPort: 80
```
Apply with: `kubectl apply -f nginx-deployment.yaml`.

**Q7: What are some commands to manage a Deployment, and what do they do?**  
**A7:**  
- `kubectl scale deployment nginx-deployment --replicas=5`: Scales to 5 replicas.  
- `kubectl set image deployment/nginx-deployment nginx=nginx:1.16.1`: Updates the image.  
- `kubectl rollout undo deployment/nginx-deployment`: Rolls back to the previous version.  
- `kubectl rollout status deployment/nginx-deployment`: Checks update status.

---

### Questions and Answers on ReplicaSets in Kubernetes

**Q8: What is a ReplicaSet, and how does it relate to Deployments and Pods?**  
**A8:** A ReplicaSet is a controller that ensures a specified number of identical Pods are running. It’s managed by a Deployment and creates/manages Pods:  
- **Hierarchy**: Deployment → ReplicaSet → Pods.  
- Deployment creates a ReplicaSet, which ensures the desired number of Pods are running.

**Q9: How do you create a ReplicaSet directly, and what happens when you delete a pod?**  
**A9:** Use `rs.yml`:  
```yaml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: nginx-replicaset
spec:
  replicas: 3
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:latest
        ports:
        - containerPort: 80
```
Apply: `kubectl apply -f rs.yml`. Deleting a pod (e.g., `kubectl delete pod nginx-replicaset-7zp2v`) triggers the ReplicaSet to recreate it, maintaining 3 replicas.

**Q10: What happens if you add a pod with the same label as a ReplicaSet’s pods?**  
**A10:** The ReplicaSet terminates the extra pod to maintain the specified replica count (e.g., `kubectl run nginx-pod --image=nginx --labels="app=nginx"` gets terminated).

---

### Questions and Answers on Series of Events in Kubernetes Deployment

**Q11: What happens when you run `kubectl create deployment nginx-deployment --image=nginx --port=80 --replicas=3`?**  
**A11:**  
1. `kubectl` sends a request to the API Server.  
2. API Server validates and stores the Deployment in etcd.  
3. Deployment Controller creates a ReplicaSet.  
4. ReplicaSet creates 3 Pods.  
5. Scheduler assigns Pods to nodes.  
6. Kubelet on nodes starts the NGINX containers.

**Q12: Why are Deployments preferred over ReplicaSets?**  
**A12:** Deployments offer:  
- Rolling updates and rollbacks.  
- Version control of rollouts.  
- Pause/resume updates.  
- Declarative updates.  
- Advanced scaling and lifecycle management.

---

### Questions and Answers on Creating a Deployment

**Q13: How do you verify a Deployment and its self-healing capability?**  
**A13:**  
- Verify: `kubectl get deployment` (checks READY, UP-TO-DATE, AVAILABLE).  
- Self-Healing: Delete a pod (e.g., `kubectl delete pod nginx-deployment-576c6b7b6-b6kgk`), then `kubectl get pods` shows a new pod created.

**Q14: What is the naming convention observed in a Deployment?**  
**A14:**  
- ReplicaSet: `nginx-deployment-<hash>` (e.g., `nginx-deployment-576c6b7b6`).  
- Pods: `nginx-deployment-<hash>-<unique-id>` (e.g., `nginx-deployment-576c6b7b6-b6kgk`).

---

### Questions and Answers on Why We Need Deployments

**Q15: What happens when you update a Deployment to a non-existent image like `nginx2:latest`?**  
**A15:**  
- New ReplicaSet is created with the bad image, but Pods fail (e.g., `ErrImagePull`).  
- Old ReplicaSet remains, keeping old Pods running.  
- Check: `kubectl get rs` and `kubectl get pods` show both ReplicaSets.

**Q16: How do you roll back a failed Deployment update?**  
**A16:**  
- Check history: `kubectl rollout history deployment/nginx-deployment`.  
- Roll back: `kubectl rollout undo deployment/nginx-deployment`.

**Q17: How do you update a Deployment to PostgreSQL and fix it if it fails?**  
**A17:**  
- Update to `postgres:latest` without `POSTGRES_PASSWORD`: Pods crash (check logs with `kubectl logs`).  
- Fix by adding env var:  
  ```yaml
  env:
  - name: POSTGRES_PASSWORD
    value: "yourpassword"
  ```
- Apply: `kubectl apply -f deployment.yml`.

---

### Questions and Answers on How to Expose the App and Services

**Q18: Why can’t you access Pod IPs directly, and how do you expose them with a NodePort Service?**  
**A18:** Pod IPs (e.g., `10.244.x.x`) are internal to the cluster. Use a NodePort Service:  
```yaml
apiVersion: v1
kind: Service
metadata:
  name: nginx-service
spec:
  type: NodePort
  selector:
    app: nginx
  ports:
    - port: 80
      targetPort: 80
      nodePort: 30080
```
Apply: `kubectl apply -f service.yml`. Access at `<NodeIP>:30080` or `localhost:30080` locally.

**Q19: What are the types of Kubernetes Services, and their use cases?**  
**A19:**  
1. **ClusterIP**: Internal access within cluster (default).  
2. **NodePort**: External access on node IPs for development.  
3. **LoadBalancer**: External access via cloud load balancer for production.

**Q20: How do you configure a Kind cluster to expose a NodePort Service externally?**  
**A20:** Use `kind.yml`:  
```yaml
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
nodes:
- role: control-plane
  extraPortMappings:
  - containerPort: 30007
    hostPort: 30007
- role: worker
- role: worker
```
Create: `kind create cluster --config kind.yml`. Apply Service, access at `localhost:30007`.

---

### Questions and Answers on LoadBalancer Service

**Q21: How do you create a LoadBalancer Service for an NGINX Deployment on Vultr?**  
**A21:**  
- Deployment: `kubectl apply -f deployment.yml` (3 NGINX replicas).  
- Service (`service-lb.yml`):  
  ```yaml
  apiVersion: v1
  kind: Service
  metadata:
    name: nginx-service
  spec:
    selector:
      app: nginx
    ports:
    - protocol: TCP
      port: 80
      targetPort: 80
    type: LoadBalancer
  ```
- Apply: `kubectl apply -f service-lb.yml`. Check `kubectl get services` for `EXTERNAL-IP`.

**Q22: What are key features of a LoadBalancer Service?**  
**A22:**  
- Integrates with cloud provider’s load balancer.  
- Provides an external IP.  
- Auto-configures traffic routing.  
- Incurs costs.  
- Includes health checks and optional SSL/TLS.

---

### Questions and Answers on Series of Events

**Q23: What is the full workflow to deploy and expose an NGINX app with NodePort in a Kind cluster?**  
**A23:**  
1. **Cluster**: `kind create cluster --config kind.yml` (maps port 30007).  
2. **Deployment**: `kubectl apply -f deployment.yml` (3 NGINX replicas).  
3. **NodePort Service**: `kubectl apply -f service.yml` (port 30007).  
4. Access: `localhost:30007`.

**Q24: How does switching to a LoadBalancer Service differ in this workflow?**  
**A24:** Replace NodePort with LoadBalancer in `service-lb.yml` and apply: `kubectl apply -f service-lb.yml`. In a cloud environment, it provisions an external IP; locally with Kind, it may not work without additional tools like MetalLB.

---

### Verification of Coverage
These 24 questions cover all key sections: checkpoint concepts, Deployments, ReplicaSets, exposure methods, Services (NodePort and LoadBalancer), and the full workflow. All YAML examples, commands, and diagrams are addressed. Let me know if you need further details!

Here are questions and answers based on the "Week 28.1" lecture content about Kubernetes, focusing on running Kubernetes locally and in the cloud, limitations of Services, Ingress and Ingress Controllers (NGINX and Traefik), Namespaces, ConfigMaps, and Secrets. These are designed to reinforce understanding, with answers sourced directly from the provided content.

---

### Questions and Answers on Kubernetes 2 and Recap

**Q1: What are the foundational Kubernetes concepts covered so far?**  
**A1:**  
1. **Clusters**: Set of nodes running containerized applications.  
2. **Nodes**: Machines in a cluster—Control Plane (manages state) and Worker (runs pods).  
3. **Pods**: Smallest deployable units, containing containers.  
4. **Deployments**: Manage ReplicaSets, provide declarative updates.  
5. **ReplicaSets**: Ensure a specified number of pod replicas run.

**Q2: What new topics are introduced in this lecture?**  
**A2:**  
1. **Namespaces**: Virtual clusters for resource isolation.  
2. **Ingress**: Manages external HTTP access to services.  
3. **Ingress Controllers**: Implement Ingress (e.g., NGINX, Traefik).  
4. **ConfigMaps**: Store non-confidential configuration data.  
5. **Secrets**: Store sensitive data like passwords.

---

### Questions and Answers on Running Kubernetes Locally

**Q3: How do you create a Kubernetes cluster locally using Kind?**  
**A3:** Use `kind.yml`:  
```yaml
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
nodes:
- role: control-plane
  extraPortMappings:
  - containerPort: 30007
    hostPort: 30007
- role: worker
  extraPortMappings:
  - containerPort: 30007
    hostPort: 30008
- role: worker
```
Run: `kind create cluster --config kind.yml --name local2`. Verify: `docker ps`.

**Q4: How do you create and manage a pod locally?**  
**A4:** Use `pod.yml`:  
```yaml
apiVersion: v1
kind: Pod
metadata:
  name: nginx
spec:
  containers:
  - name: nginx
    image: nginx
    ports:
    - containerPort: 80
```
Apply: `kubectl apply -f pod.yml`. Check: `kubectl get pods`. Logs: `kubectl logs -f nginx`. Delete: `kubectl delete pod nginx`.

**Q5: How do you test a Deployment’s self-healing locally?**  
**A5:** Apply `deployment.yml` with 3 NGINX replicas. Update to `nginx2:latest`, apply again, and check `kubectl get pods`. Old pods remain due to the invalid image, showing self-healing preserves availability.

---

### Questions and Answers on Running Kubernetes on a Cloud Provider

**Q6: What are the steps to set up a Kubernetes cluster on a cloud provider?**  
**A6:**  
1. Choose a provider (e.g., AWS, GCP, Digital Ocean, Vultr).  
2. Navigate to Kubernetes section, create a cluster (specify nodes, sizes, networking, access).  
3. Download credentials and update `~/.kube/config`.  
4. Apply a Deployment (e.g., `kubectl apply -f deployment.yml`).

**Q7: What considerations are important when running Kubernetes in the cloud?**  
**A7:**  
- **Provider Selection**: Based on pricing, features, location.  
- **Cluster Config**: Node sizes/counts for resource needs.  
- **Security**: Network policies, access controls.  
- **Credentials**: Secure kubeconfig file.  
- **Monitoring**: Track cluster health/performance.

---

### Questions and Answers on Services in Kubernetes

**Q8: How do you expose an app with a NodePort Service locally?**  
**A8:** Use `service.yml`:  
```yaml
apiVersion: v1
kind: Service
metadata:
  name: nginx-service
spec:
  selector:
    app: nginx
  ports:
    - protocol: TCP
      port: 80
      targetPort: 80
      nodePort: 30007
  type: NodePort
```
Apply: `kubectl apply -f service.yml`. Access: `http://localhost:30007/`.

**Q9: How does a LoadBalancer Service differ from NodePort in a cloud setup?**  
**A9:** Modify `service.yml` to `type: LoadBalancer`, apply, and check `kubectl get services` for an EXTERNAL-IP. LoadBalancer creates an external load balancer in the cloud, unlike NodePort, which uses static node ports (30000-32767).

---

### Questions and Answers on Downsides of Services

**Q10: What are the limitations of Kubernetes Services when scaling multiple apps?**  
**A10:**  
- **Multiple Load Balancers**: Each app needs its own service/load balancer.  
- **No Centralized Routing**: Lacks path-based routing or unified traffic management.  
- **Resource Limits**: Cloud providers cap load balancer numbers.

**Q11: How do certificate management issues arise with Services?**  
**A11:** Certificates must be managed outside the cluster, requiring manual updates and separate certificates per service/load balancer, as shown in the diagram with multiple HTTPS endpoints.

**Q12: What’s the issue with rate limiting in Services?**  
**A12:** No centralized rate limiting; each load balancer has independent limits, lacking global control, as depicted in the rate-limiting diagram.

---

### Questions and Answers on Ingress and Ingress Controller

**Q13: What is Ingress, and what are its key features?**  
**A13:** Ingress is an API object managing external HTTP access to services. Features:  
- Load balancing.  
- SSL/TLS termination.  
- Name-based virtual hosting.  
- Path-based routing.

**Q14: What is the role of an Ingress Controller?**  
**A14:** It implements Ingress rules, watches for Ingress resources, and configures a load balancer/proxy (e.g., NGINX, Traefik) to route traffic, as shown in the Ingress Controller diagram.

**Q15: What benefits does Ingress provide over Services?**  
**A15:**  
- Centralized routing for multiple services.  
- SSL/TLS termination.  
- Name/path-based routing.  
- Reduced load balancer costs.

---

### Questions and Answers on Kubernetes Namespaces

**Q16: How do you create and use a Namespace for a Deployment?**  
**A16:** Create: `kubectl create namespace backend-team`. Use in `deployment-ns.yml`:  
```yaml
metadata:
  name: nginx-deployment
  namespace: backend-team
```
Apply: `kubectl apply -f deployment-ns.yml`. Check: `kubectl get pods -n backend-team`.

**Q17: How do you change the default Namespace for kubectl commands?**  
**A17:** Set: `kubectl config set-context --current --namespace=backend-team`. Verify: `kubectl get pods`. Revert: `kubectl config set-context --current --namespace=default`.

---

### Questions and Answers on Installing the NGINX Ingress Controller

**Q18: How do you install the NGINX Ingress Controller using Helm?**  
**A18:**  
1. Add repo: `helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx`.  
2. Update: `helm repo update`.  
3. Install: `helm install nginx-ingress ingress-nginx/ingress-nginx --namespace ingress-nginx --create-namespace`.  
4. Verify: `kubectl get pods -n ingress-nginx`.

**Q19: What does the NGINX Ingress Controller installation provide?**  
**A19:** A LoadBalancer service (check `kubectl get services -n ingress-nginx`) and a pod to route traffic based on Ingress rules, as shown in the installation diagram.

---

### Questions and Answers on Setting Up Ingress Routing

**Q20: How do you set up Ingress routing for NGINX and Apache services?**  
**A20:** Use `complete.yml` with Deployments, ClusterIP Services, and an Ingress resource:  
```yaml
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: web-apps-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  ingressClassName: nginx
  rules:
  - host: your-domain.com
    http:
      paths:
      - path: /nginx
        pathType: Prefix
        backend:
          service:
            name: nginx-service
            port:
              number: 80
      - path: /apache
        pathType: Prefix
        backend:
          service:
            name: apache-service
            port:
              number: 80
```
Apply: `kubectl apply -f complete.yml`. Update `/etc/hosts` with the LoadBalancer IP.

**Q21: What does the rewrite annotation do in the NGINX Ingress setup?**  
**A21:** `nginx.ingress.kubernetes.io/rewrite-target: /` rewrites URLs (e.g., `/nginx` to `/`) to ensure proper routing to service backends.

---

### Questions and Answers on Trying Traefik’s Ingress Controller

**Q22: How do you install and verify the Traefik Ingress Controller?**  
**A22:**  
1. Install:  
   ```bash
   helm repo add traefik https://helm.traefik.io/traefik
   helm repo update
   helm install traefik traefik/traefik --namespace traefik --create-namespace
   ```  
2. Verify: `kubectl get IngressClass` (check `traefik`), `kubectl get svc -n traefik` (check LoadBalancer).

**Q23: How do you fix path rewriting issues with Traefik?**  
**A23:** Add a Middleware and annotate the Ingress in `traefik.yml`:  
```yaml
apiVersion: traefik.containo.us/v1alpha1
kind: Middleware
metadata:
  name: strip-prefix
spec:
  stripPrefix:
    prefixes:
      - /nginx
      - /apache
---
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: traefik-web-apps-ingress
  annotations:
    traefik.ingress.kubernetes.io/router.middlewares: default-strip-prefix@kubernetescrd
spec:
  ingressClassName: traefik
  rules:
  - host: traefik-domain.com
    http:
      paths:
      - path: /nginx
        pathType: Prefix
        backend:
          service:
            name: nginx-service
            port:
              number: 80
      - path: /apache
        pathType: Prefix
        backend:
          service:
            name: apache-service
            port:
              number: 80
```
Apply: `kubectl apply -f traefik.yml`.

---

### Questions and Answers on Secrets and ConfigMaps

**Q24: What are ConfigMaps and Secrets, and how do they differ?**  
**A24:**  
- **ConfigMaps**: Store non-sensitive data (e.g., `APP_COLOR: blue`) in plain text.  
- **Secrets**: Store sensitive data (e.g., `DB_PASSWORD`) base64-encoded, not encrypted by default.

**Q25: How do you use a ConfigMap in a Deployment?**  
**A25:** Define in `cm.yml`:  
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: ecom-backend-config
data:
  database_url: "mysql://ecom-db:3306/shop"
```
Use in `express-app.yml`:  
```yaml
spec:
  containers:
  - name: ecom-backend
    image: 100xdevs/env-backend
    env:
    - name: DATABASE_URL
      valueFrom:
        configMapKeyRef:
          name: ecom-backend-config
          key: database_url
```
Apply: `kubectl apply -f cm.yml`, `kubectl apply -f express-app.yml`.

**Q26: How do you expose the Express app with a NodePort Service?**  
**A26:** Use `express-service.yml`:  
```yaml
apiVersion: v1
kind: Service
metadata:
  name: ecom-backend-service
spec:
  type: NodePort
  selector:
    app: ecom-backend
  ports:
    - port: 3000
      targetPort: 3000
      nodePort: 30007
```
Apply: `kubectl apply -f express-service.yml`. Access: `http://localhost:30007`.

---

### Verification of Coverage
These 26 questions cover all sections: recap, local/cloud setup, Services’ downsides, Ingress/Controllers (NGINX/Traefik), Namespaces, ConfigMaps, and Secrets. All YAML examples, commands, and diagrams are addressed. Let me know if you need further clarification!

Here are questions and answers based on the "Week 28.2" lecture content about Kubernetes, focusing on Secrets and ConfigMaps. These are designed to deepen understanding, with answers sourced directly from the provided content.

---

### Questions and Answers on Secrets and ConfigMaps Overview

**Q1: What are ConfigMaps and Secrets in Kubernetes, and what is their primary purpose?**  
**A1:**  
- **ConfigMaps**: API objects that store non-sensitive configuration data in key-value pairs, used to decouple configuration from container images.  
- **Secrets**: API objects that store sensitive data (e.g., passwords, tokens), also decoupling it from images but with a focus on confidentiality.  
- **Purpose**: Both enable flexible, secure configuration management outside of application code.

**Q2: What are the best practices for Kubernetes configuration mentioned in the lecture?**  
**A2:**  
1. Use Deployments instead of standalone pods.  
2. Prefer YAML over JSON for readability.  
3. Store configuration files in version control.  
4. Externalize configuration using ConfigMaps and Secrets.

**Q3: How can ConfigMaps and Secrets be used in a pod, and what’s a key rule for Secrets?**  
**A3:**  
- **Usage**: As environment variables, mounted files, or command-line arguments.  
- **Key Rule**: Don’t bake Secrets into Docker images; pass them as environment variables at runtime.

**Q4: What are the benefits of using ConfigMaps and Secrets?**  
**A4:**  
1. **Separation of Concerns**: Keeps code separate from config.  
2. **Flexibility**: Update config without changing images.  
3. **Security**: Better management of sensitive data.  
4. **Reusability**: Same image with different configs.

---

### Questions and Answers on ConfigMaps

**Q5: What is a ConfigMap, and how does it enhance application portability?**  
**A5:** A ConfigMap is an API object storing non-confidential key-value data. It enhances portability by decoupling environment-specific config from images, allowing the same image to run with different settings.

**Q6: How do you create and verify a ConfigMap for an e-commerce backend?**  
**A6:** Use `cm.yml`:  
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: ecom-backend-config
data:
  database_url: "mysql://ecom-db:3306/shop"
  cache_size: "1000"
  payment_gateway_url: "https://payment-gateway.example.com"
  max_cart_items: "50"
  session_timeout: "3600"
```
Apply: `kubectl apply -f cm.yml`. Verify: `kubectl describe configmap ecom-backend-config`.

**Q7: How do you deploy an Express app in Kubernetes using a ConfigMap?**  
**A7:** Use `express-app.yml`:  
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: ecom-backend-deployment
spec:
  replicas: 1
  selector:
    matchLabels:
      app: ecom-backend
  template:
    metadata:
      labels:
        app: ecom-backend
    spec:
      containers:
      - name: ecom-backend
        image: 100xdevs/env-backend
        ports:
        - containerPort: 3000
        env:
        - name: DATABASE_URL
          valueFrom:
            configMapKeyRef:
              name: ecom-backend-config
              key: database_url
        - name: CACHE_SIZE
          valueFrom:
            configMapKeyRef:
              name: ecom-backend-config
              key: cache_size
```
Apply: `kubectl apply -f express-app.yml`.

**Q8: How do you expose the Express app with a NodePort Service?**  
**A8:** Use `express-service.yml`:  
```yaml
apiVersion: v1
kind: Service
metadata:
  name: ecom-backend-service
spec:
  type: NodePort
  selector:
    app: ecom-backend
  ports:
    - port: 3000
      targetPort: 3000
      nodePort: 30007
```
Apply: `kubectl apply -f express-service.yml`. Access: `http://<node-ip>:30007`.

---

### Questions and Answers on Secrets in Kubernetes

**Q9: What are the key characteristics of Secrets in Kubernetes?**  
**A9:**  
1. **Purpose**: Store sensitive data (e.g., passwords, keys).  
2. **API**: Part of v1 API.  
3. **Usage**: Mounted as env vars or files.  
4. **Encoding**: Base64 encoded (not encrypted by default).

**Q10: How do you create a Secret and mount it as a file in a pod?**  
**A10:** Use YAML:  
```yaml
apiVersion: v1
kind: Secret
metadata:
  name: dotfile-secret
data:
  .env: REFUQUJBU0VfVVJMPSJwb3N0Z3JlczovL3VzZXJuYW1lOnNlY3JldEBsb2NhbGhvc3QvcG9zdGdyZXMi
---
apiVersion: v1
kind: Pod
metadata:
  name: secret-dotfiles-pod
spec:
  containers:
    - name: dotfile-test-container
      image: nginx
      volumeMounts:
        - name: env-file
          readOnly: true
          mountPath: "/etc/secret-volume"
  volumes:
    - name: env-file
      secret:
        secretName: dotfile-secret
```
Apply: `kubectl apply -f <file>`. Access: `kubectl exec -it secret-dotfiles-pod -- ls /etc/secret-volume`.

**Q11: How do you use a Secret as environment variables in a pod?**  
**A11:** Use YAML:  
```yaml
apiVersion: v1
kind: Secret
metadata:
  name: my-secret
data:
  username: YWRtaW4=  # 'admin'
  password: cGFzc3dvcmQ=  # 'password'
---
apiVersion: v1
kind: Pod
metadata:
  name: secret-env-pod
spec:
  containers:
  - name: my-container
    image: busybox
    command: ["/bin/sh", "-c", "echo Username: $USERNAME; echo Password: $PASSWORD; sleep 3600"]
    env:
    - name: USERNAME
      valueFrom:
        secretKeyRef:
          name: my-secret
          key: username
    - name: PASSWORD
      valueFrom:
        secretKeyRef:
          name: my-secret
          key: password
```
Apply: `kubectl apply -f <file>`.

**Q12: What are some best practices for managing Secrets?**  
**A12:**  
1. **Separation**: Keep sensitive data out of code.  
2. **Access Control**: Use RBAC to restrict access.  
3. **Encryption**: Enable encryption at rest in etcd.  
4. **Minimal Exposure**: Limit Secrets to necessary pods.

---

### Questions and Answers on ConfigMaps vs Secrets

**Q13: How do ConfigMaps and Secrets differ in their purpose and data handling?**  
**A13:**  
- **Purpose**: ConfigMaps store non-sensitive data (e.g., config settings); Secrets store sensitive data (e.g., passwords).  
- **Data Format**: ConfigMaps use plain text; Secrets use base64 encoding.

**Q14: What are some practical examples of content stored in ConfigMaps vs Secrets?**  
**A14:**  
- **ConfigMaps**: App config (e.g., `APP_COLOR: blue`), feature flags.  
- **Secrets**: Database passwords (e.g., `password: cGFzc3dvcmQ=`), API keys.

**Q15: How do security and access differ between ConfigMaps and Secrets?**  
**A15:**  
- **Security**: ConfigMaps are standard; Secrets have higher priority and can be encrypted at rest.  
- **Access**: ConfigMaps are more accessible; Secrets require stricter RBAC policies.

**Q16: How do ConfigMaps and Secrets compare in terms of update frequency and external management?**  
**A16:**  
- **Update Frequency**: ConfigMaps change less often; Secrets rotate more due to security.  
- **External Management**: ConfigMaps have limited support; Secrets integrate better with tools like Vault.

---

### Verification of Coverage
These 16 questions comprehensively cover the lecture sections: Secrets and ConfigMaps overview, ConfigMaps implementation, Secrets implementation, and the comparison table. All YAML examples, commands, diagrams, and key points are addressed. Let me know if you’d like further elaboration!