### Spring Boot Boilerplate
##### A template to get building quickly without some of the extra hassle.
#
##### Included:
- Gradle-based Multi-module project structure
- Patterns for easier and more maintainable API Building
- Integration testing module with TestRestTemplate
- MongoDB integration, including Embedded MongoDB for integration testing (Flapdoodle)
- Spring Profiles with different application.properties and main classes for local, production, and testing environments
- Keycloak authentication
#
###### After running ```./gradlew (build task)```, the executable jar will be located within ```entrypoint/build/libs```. 
#
#
###### Currently, Gradle Tasks for building jars available are ```buildLocal``` and ```buildProduction```.
#
#
###### More build configuration can be added based on how many environments you prefer (e.g. staging), along with adding their respective main classes and ```application.properties``` (e.g. ```application-staging.properties```)

