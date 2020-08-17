# uberApp
Application allows passengers to arrange rides with drivers in their city. Created by Alexandra Duron and Graeme Somerville.

A simplified version of Uber we created as a practice project. This is the client side program.

#### Specification
* Drivers/Passengers can login with unique username
* Passengers can see drivers in the same city
* Passengers are able to select a driver and arrange a ride
* Program works over internet/WAN/LAN
* Drivers recieve notification when a passenger has arranged a ride with them

#### Design Notes
* The program follows the MVC design pattern.
* User information is stored on a postgresSQL database we hosted on "heroku.com" (we chose heroku as it has a free option for hobbyists)
* JDBC is used to query/edit the database
* Client-Server communication is handled through java sockets
* Command Line Interface

#### To Run
Compile the classes then run in any terminal with access to the internet

    javac Main.java
    java Main

