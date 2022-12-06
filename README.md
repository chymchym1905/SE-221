# SE-221
# UWC 2.0 Project
---
## Requirements:
- Java 17
- Eclipse Enterprise Edition
- MySQL Workbench
## Framework using:
- Spring Boot
## How to operate the app:
Step 1: After Installed the requirements above, Open Eclipse and Choose your workplace folder.

Step 2: Click on the File on the menu bar and Choose import.

Step 3: In import choose Maven folder and Choose Existing Maven Projects.

Step 4: Next to Root Directory, Choose Browse and link it to the folder contains pom.xml and click finish.

Step 5: Right click onto Demo in Project Explorer section choose build path, in librarries tab, choose JRE Java 17 to avoid errors.
![alt-text](https://cdn.discordapp.com/attachments/731900619538825256/1049299195040895046/image.png)

Step 6: In Project Explorer, extend src/main/resources -> click on application.properties to configure the server.port if needed and configure your database account and password.
![alt-text](https://cdn.discordapp.com/attachments/731900619538825256/1049300697335742524/image.png)

Step 7: Again in Project Explorer, extend src/main/java-> com.uwc -> UwcApplication.java and click the Red run button
![alt-text](https://cdn.discordapp.com/attachments/731900619538825256/1049301567720919091/image.png)

Step 8: Open your browser and enter "localhost:..." with the ... is the server.host you configured in step 6.