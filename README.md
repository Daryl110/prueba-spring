# prueba-spring

instructions

# instalation

* clone repository <code>git clone "https://github.com/Daryl110/prueba-spring.git"</code>
* cd in proyect with the terminal <code>cd ./prueba-spring</code>

# run server angular

* cd in proyect of front-angular <code>cd ./front-angular</code>
* install dependencies with nodejs <code>npm i</code>
* run server angular <code>ng serve</code>

# run microservice spring-boot

* cd in proyect of prueba-spring <code>cd ./../prueb-spring</code>
* install and create artifact jar or executable <code>mvn -Dmaven.test.skip=true -DskipTests=true clean install</code>
* run server with jdk or jre <code>java -jar ./target/app.jar</code>

NOTE: Before running the spring application or the microservice check if you have the postgreSQL installed, it is recommended to open the project with an ide or code editor to change credentials
