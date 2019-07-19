# Source code

This repository uses as a sample application the one you can find in the official [Spring Guides GitHub repository](https://github.com/spring-guides/gs-accessing-data-mysql). Some of its files have been modified in order to use the [Bitnami MariaDB container image](https://github.com/bitnami/bitnami-docker-mariadb) as a database instead of the existing one and for packaging the service as a WAR file. 

See the LICENSE.code.txt file for more information on this.

# Assumptions and prerequisites

To understand this document and to follow the [Deploy locally a Spring Boot application using Bitnami containers](https://docs.bitnami.com/containers/how-to/deploy-locally-spring-boot-application-docker) tutorial is assumed that:

* You have basic knowledge of [Docker](https://www.docker.com/) containers.
* You have a Docker environment installed and configured. [Learn more about installing Docker](https://docs.docker.com/install/).
* You have a Docker Hub account. [Register for a free account](https://hub.docker.com/).
* You have Apache Maven already installed. [Refer to the official Apache Maven Project documentation](https://maven.apache.org/install.html).

# Changes done in the source code

In this repository, you will find the resulting WAR package from cloning the [above mentioned sample repository](https://github.com/spring-guides/gs-accessing-data-mysql) after applying the changes below and running the `mvn package` command. These are the changes done to the source code explained in detail:

1) Replace the current database connection with the MariaDB one by editing the `src/main/resources/application.properties`. The resulting content should look like as follows:

```bash
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://mariadb:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword
```
These are the values that you will use to create the `docker-compose.yml` in the step 2 of the [Deploy locally a Spring Boot application using Bitnami containers](https://docs.bitnami.com/containers/how-to/deploy-locally-spring-boot-application-docker) tutorial. 

2) To generate a WAR package instead of a JAR file, it is necessary to perform the changes below to the `pom.xml` file: 

```bash
diff --git a/complete/pom.xml b/complete/pom.xml
index 0f2080c..e51caeb 100644
--- a/complete/pom.xml
+++ b/complete/pom.xml
@@ -6,6 +6,7 @@
     <groupId>org.springframework</groupId>
     <artifactId>gs-mysql-data</artifactId>
     <version>0.1.0</version>
+    <packaging>war</packaging>
 
     <parent>
         <groupId>org.springframework.boot</groupId>
@@ -18,6 +19,13 @@
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
         </dependency>
+
+        <!-- marked the embedded servlet container as provided -->
+        <dependency>
+            <groupId>org.springframework.boot</groupId>
+            <artifactId>spring-boot-starter-tomcat</artifactId>
+            <scope>provided</scope>
+        </dependency>
         
         <!-- JPA Data (We are going to use Repositories, Entities, Hibernate, etc...) -->
```

3) Refer the embedded servlet container in the application file by editing the `src/main/java/hello/Application.java` as shown below:

```bash
diff --git a/complete/src/main/java/hello/Application.java b/complete/src/main/java/hello/Application.java
index 5abd411..7710721 100644
--- a/complete/src/main/java/hello/Application.java
+++ b/complete/src/main/java/hello/Application.java
@@ -2,11 +2,18 @@ package hello;
 
 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
+import org.springframework.boot.builder.SpringApplicationBuilder;
+import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 
 @SpringBootApplication
-public class Application {
+public class Application extends SpringBootServletInitializer {
 
     public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
     }
+
+    @Override
+    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
+        return builder.sources(Application.class);
+    }
 }

```

4) Generate the WAR file by running the `mvn package` command. The resulting file will be located in `target/gs-mysql-data-0.1.0.war`.
