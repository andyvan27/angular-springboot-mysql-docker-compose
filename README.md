# angular-springboot-mysql-docker-compose
Sample of AngularJS, SpringBoot and MySql running on Docker Compose, Azure Web App for Containers and Azure Kubernetes Service.
 
### Run 
Open your command prompt and execute the following to clone this app to your local directory:
 
`git clone https://github.com/andyvan27/angular-springboot-mysql-docker-compose.git`
 
Ensure your local Docker engine running with Docker Compose enabled in the settings. Then run this command:
 
`docker compose up`
 
It will build all container images and create/start their containers.
 
### Shutdown 
`docker compose down`
 
### Font end app 
`http://localhost/`

### Back end app
`http://localhost:8080/employee/<all><add><update><delete>/<id>`
 
### Troubleshoot
For the first run, may be the MySql container is not ready prior to the backend trying to connect to. In this case, please do:
```
docker compose stop 
docker compose start
```

### Deploy to Azure Web App for Containers
- Create 2 Web App for Containers in Azzure
- Provide the Docker Compose files when asked by the UI or arguments if use az cli:
```
docker-compose-backend.yml
docker-compose-frontend.yml
```

### Deploy to local Kubernetes
- `kubectl apply -f emp-app-kube.yml`

### Deploy to AKS
- Create AKS cluster
```
az login
az account list
az account set --subscription <subscription id or name>
az group create --name <resource group name> --location <region name>
az aks create -g <resource group name> -n <aks cluster name> --enable-managed-identity --node-count 2  --node-vm-size Standard_B2S --generate-ssh-keys
az aks get-credentials --resource-group <resource group name> --name <aks cluster name>
```
- Apply backend service 
```
kubectl apply -f emp-app-aks-backend.yml
```
- Get and note down the external ip address of the back end
```
kubectl get service backend --watch
```
- Modify `emp-app-aks-frontend.yml` to have the right ip address of the back end (At BACKEND_URL)
- Apply frontend service
```
kubectl apply -f emp-app-aks-frontend.yml
```

### Deploy to local Kubernetes with ingress-nginx
- Install ingress-nginx
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/cloud/deploy.yaml
```
- Apply services
```
kubectl apply -f emp-app-kube-local-ingress.yml
```

### Deploy to AKS with ingress-nginx
- Create AKS cluster
```
az login
az account list
az account set --subscription <subscription id or name>
az group create --name <resource group name> --location <region name>
az aks create -g <resource group name> -n <aks cluster name> --enable-managed-identity --node-count 2  --node-vm-size Standard_B2S --generate-ssh-keys
az aks get-credentials --resource-group <resource group name> --name <aks cluster name>
```
- Install ingress-nginx
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/cloud/deploy.yaml
```
- Apply services
```
kubectl apply -f emp-app-kube-aks-ingress.yml
```

### References
- Many thanks to Nelson and Junior in this video: https://www.youtube.com/watch?v=Gx4iBLKLVHk&list=PLBvjNj5-9WtGnqj2G4T7uH07-JeRST2b8&index=3. Please give all credits for the sample code to them.
- App Service for containers: https://learn.microsoft.com/en-us/azure/app-service/tutorial-multi-container-app
- Aks quick deployment: https://learn.microsoft.com/en-us/azure/aks/learn/quick-kubernetes-deploy-cli
- Greate video on Kubernetes including Ingress of Nana from TechWorld: https://www.youtube.com/watch?v=X48VuDVv0do
- Aks ingress: 
  - https://levelup.gitconnected.com/ingress-nginx-on-azure-kubernetes-service-14e6108373e9
  - https://kubernetes.github.io/ingress-nginx/deploy/#azure
  - https://learn.microsoft.com/en-us/azure/aks/ingress-basic?tabs=azure-cli


### Differences from the video
- Used `CrudRepository` instead of `JpaRepository`
- Added backend container debugging option (exposed port 5005)
- Grouped front end and back end in 1
- Upgraded to Java 17, SpringBoot 3 and Angular 15 and their alpine images
- Optionally passed configuration environment variables into the app when running in containers, but not when running locally, without code changes
- Handled CORS from Controller instead of main class
