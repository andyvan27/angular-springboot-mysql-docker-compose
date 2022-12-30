# angular-springboot-mysql-docker-compose
 Sample of AngularJS, SpringBoot and MySql running on Docker Compose
 
 # To run
 
 Open your command prompt and execute the following to clone this app to your local directory:
 
 git clone https://github.com/andyvan27/angular-springboot-mysql-docker-compose.git
 
 Ensure your local Docker engine running with Docker Compose enabled in the settings. Then run this command:
 
 docker compose up
 
 It will build all conatiner images and create/start their containers.
 
 To shutdown:
 
 docker compose down
 
 To try the fontend app go to http://localhost:4200/
 
 For the first run, may be the MySql container is not ready prior to the backend trying to connect to. In this case, please do:
 
 docker compose stop
 
 docker compose start
 
 Currently, I have not finished the whole UI functionalities. To add some data to the backend/db, please use Postman to POST some sample data to:
 
 http://localhost:8080/employee/add
 
 with a json in the body like:
 
 {
  "email": "jonh.smith@gmail.com",
  "imageUrl": "https://bootdey.com/img/Content/avatar/avatar4.png",
  "jobTitle": "Sale",
  "name": "John Smith",
  "phone": "0411 333 777"
 }
 
Add couple of employees in and you will see them on the home page. (avatar<i>.png should be available for different images)
