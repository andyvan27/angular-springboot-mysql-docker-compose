# angular-springboot-mysql-docker-compose
Sample of AngularJS, SpringBoot and MySql running on Docker Compose
 
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

### Reference
Many thanks to Nelson and Junior in this video: https://www.youtube.com/watch?v=Gx4iBLKLVHk&list=PLBvjNj5-9WtGnqj2G4T7uH07-JeRST2b8&index=3. Please give all credits to them.

### Differences from the video
- Used `CrudRepository` instead of `JpaRepository`
- Added backend container debugging option (exposed port 5005)
- Grouped front end and back end in 1
- Upgraded to Java 17, SpringBoot 3 and Angular 15 and their alpine images
- Optionally passed configuration environment variables into the app when running in containers, but not when running locally, without code changes
- Handled CORS from Controller instead of main class

### Deploy to Azure Web App for Containers
- `docker-compose-backend.yml`
- `docker-compose-frontend.yml`