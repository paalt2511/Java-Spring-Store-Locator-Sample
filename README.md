## Sample Backend for Store Locator

### Requirements

1. JDK 6 or greater should be installed
2. Maven 3

### Setting up project in ECLIPSE
1. Goto `File` -> `Import` -> Select `Existing Maven Project`
2. Browser to the cloned repo and select `OK`. You will see the `pom.xml` under Projects on the UI.
3. Click on Finish
5. Right click on the Project just created , Select `Maven` -> `Update Project`, Click Ok
6. Open `application.properties` and update the database properties
7. Run the Application

### Setting up project in Intellij IDEA
1. Open Intellij
2. In settings ensure that Maven Plugin is enabled
3. Goto `File` -> `Open` and select the pom file
4. Intellij will Import the Maven project and download required plugins
5. Open `application.properties` and update the database properties
6. Run the Application
7. Note - To create the build via eclipse, Right Click on the project, Click on "Run as" and click "mvn install".

### Creating and Running the build
You can also create the build via `mvn install`. To run the application simply copy the StoreLocator-0.0.1-SNAPSHOT.war placed in the target directory and use the below command:
java -jar StoreLocator-0.0.1-SNAPSHOT.war


### Verify backend setup
1. Ensure application is running
2. Hit http://localhost:8086/swagger-ui.html
3. Goto Store Controller, Expand it.
4. To test any API, Hit `Try it out!` button and verify the response

### Technology Stack
1. Spring Boot as primary framework
2. Hibernate as ORM
3. HSQL as Database

### Code Walkthrough
Backend of this application is a Spring Boot powered Application which is configured on start by ApplicationInitializer class which is the main class of application and is responsible for configuring Data Source, Hibernate Session Factory and initializing embedded Tomcat Container.
Spring boot automatically starts the tomcat instance when main method of this class is run and the application is deployed on the server. 
Backend has 4 layers as below and data flows in the mentioned order
1. Controller (Rest API exposed)
2. Service
3. Repository (Interacts with database via Hibernate as ORM)

Note : Java packages are created in the same hierarchy.
Database used for this application is HSQL which is populated with default data of 100 stores on application startup by DatabaseInitializer class by reading stores.txt placed in resources folder.
