# ms-course

### Build and run using a Postgres container

##### Compile
* On root dir run `sh compile.sh`

##### Build config server docker image;
* On /hr-config-server dir run `docker build -r hr-config-server .`

##### Up the project
* On root dir run the script below
```
docker run -p 8888:8888 --name hr-config-server --network hr-net -d hr-config-server
docker-compose -f prod-compose.yml up
```

### Authentication using Oauth2;

* Execute a POST request for `http://localhost:8765/hr-oauth/oauth/token` using Bsic Auth
* The client username is `myappname123` and password is `myappsecret123`
* In the request body use x-www-form-urlencoded content-type
* Enter the attributes username, password and grand_type. grand_type value is `password`;
* Use the result token on Autherization header of your request;

### Get Microservices config

* You can get a microservice config doing a request for `http://localhost:8888/{microservice-name}/{microservice-profile}`
* Ex `http://localhost:8888/hr-worker/default`
