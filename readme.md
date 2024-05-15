# Construction Site Clearing Simulator

A simulator that helps simulate bulldozer to a trainee. It accepts four commands:

     1. (A)dvance
     2. (L)eft
     3. (R)ight
     4. (Q)uit


It supports various lands as follows:

     1. Plain Land
     2. Rocky Land
     3. Land with Tree
     4. Land with Reserved Tree


[More Information...](https://amanchhabra.github.io/ConstructionSiteClearingSimulator/)

## Building the Application

     ./gradlew build

## Running the Application

### Gradlew

     1. Clone the repository
     2. Run the application using command ./gradlew -q --console plain run --args="src/main/resources/sitemap.txt"

### Standalone

     1. Clone the repository
     2. Build the application 
     3. Run the application using command java -jar ConstructionSiteClearingSimulator-1.0-SNAPSHOT.jar sitemap.txt 


## License
MIT

