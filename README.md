<h2>Traveather</h2>

Travel management application. You can create your journey with waypoints. The service will automatically set weather, currency, emergency calls and other informations to specified destination.

TBD: Service will consume data from other services like weather-service, currency-service etc.

<h3>Build application using Maven Deamon</h3>

`mvnd clean install -T 3`

<h3>Run application</h3>

`mvnd spring-boot:run -pl application`

<h3>Setup docker for service</h3>

Build JAR by maven
`mvn clean install -T 3`

Start up containers by
`docker compose up -d`

<h3>mySQL</h3>

database: `traveather-database`

user: `root`

password: `password`



