# Building Java Projects with Maven
This guide walks you through using Maven to build a simple Java project.

## What you’ll build
You’ll create an application that provides the time of day and then build it with Maven.

## What you’ll need
+ A favorite text editor or IDE
+ JDK 6 or later
+ Install Maven

## Install Maven.
+ [Install Maven on Windows](https://www.baeldung.com/install-maven-on-windows-linux-mac#installing-maven-on-windows)
+ [Install Maven on Linux](https://www.baeldung.com/install-maven-on-windows-linux-mac#installing-maven-on-linux)
+ [Install Maven on Mac OSX](https://www.baeldung.com/install-maven-on-windows-linux-mac#installing-maven-on-mac-os-x)

## Set up the project
import the project as Existing Maven project in eclipse


### Define a simple Maven build
---
+ You need to create a Maven project definition.
+ Maven projects are defined with an XML file named pom.xml.
+ Among other things, this file gives the project’s name, version, and dependencies that it has on external libraries.
+ Create a file named `pom.xml` at the root of the project and give it the following contents:

 `pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>customAnnotations</groupId>
  <artifactId>customAnnotations</artifactId>
  <name>customAnnotations</name>
  <description>this is to create custom annotation in java</description>
  <build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.7.0</version>
        <configuration>
          <release>9</release>
        </configuration>
      </plugin>
    </plugins>
  </build>
  <version>0.0.1</version>
</project>
```
With the exception of the optional `<packaging>` element, this is the simplest possible `pom.xml` file necessary to build a Java project. It includes the following details of the project configuration:
+ `<modelVersion>`. POM model version (always 4.0.0).
+ `<groupId>`. Group or organization that the project belongs to. Often expressed as an inverted domain name.
+ `<artifactId>`. Name to be given to the project’s library artifact (for example, the name of its JAR or WAR file).
+ `<version>`. Version of the project that is being built.
+ `<packaging>` - How the project should be packaged. Defaults to "jar" for JAR file packaging. Use "war" for WAR file packaging.

### Build Java code
---
Maven is now ready to build the project. You can execute several build lifecycle goals with Maven now, including goals to compile the project’s code, create a library package (such as a JAR file), and install the library in the local Maven dependency repository.

To try out the build, issue the following at the command line:

  `mvn compile`
  + This will run Maven, telling it to execute the compile goal. When it’s finished, you should find the compiled .class files in the target/classes directory.
  + Since it’s unlikely that you’ll want to distribute or work with .class files directly, you’ll probably want to run the package goal instead:

`mvn package`

  + The package goal will compile your Java code, run any tests, and finish by packaging the code up in a JAR file within the target directory. The name of the JAR file will be based on the project’s `<artifactId>` and `<version>`. For example, given the minimal `pom.xml` file from before, the JAR file will be named gs-maven-0.1.0.jar.

    **Note:**  If you’ve changed the value of <packaging> from "jar" to "war", the result will be a WAR file within the target directory instead of a JAR file.

Maven also maintains a repository of dependencies on your local machine (usually in a .m2/repository directory in your home directory) for quick access to project dependencies. If you’d like to install your project’s JAR file to that local repository, then you should invoke the install goal:

`mvn install`

The install goal will compile, test, and package your project’s code and then copy it into the local dependency repository, ready for another project to reference it as a dependency.

Speaking of dependencies, now it’s time to declare dependencies in the Maven build.

### Declare Dependencies
---

## Run project
---
+ To run this project run the following command.

    `java -cp target/customAnnotations-0.0.1.jar com.java.main.TestCustomAnnotations`
