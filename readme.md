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

## Output

    Welcome to the Aconex site clearing simulator. This is a map of the site:
    
    o o t o o o o o o o
    o o o o o o o T o o
    r r r o o o o T o o
    r r r r o o o o o o
    r r r r r t o o o o
    
    The bulldozer is currently located at the Northern edge of the site, immediately to the West of the site, and facing East.
    
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: a 2
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: r
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: l  
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: a 6
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: l
    (l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
    
    The simulation has ended at your request. These are the commands you issued:
    
    advance 2, turn right, advance 4, turn left, advance 6, turn left, advance 4
    
    The costs for this land clearing operation were:
    
    Item                            Quantity    Cost
    communication overhead                 7       7
    fuel usage                            20      20
    uncleared squares                     35     105
    destruction of protected tree          1      10
    paint damage to bulldozer              1       2
    ----
    Total                                        144
    
    
    Thankyou for using the Aconex site clearing simulator.

## License
MIT

