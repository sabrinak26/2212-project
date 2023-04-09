### <div align="center"> CS 2212 Group Project - Winter Session 2023 </div>
# **Team 16:** Western University Mapping Application
 **Authors: Karim Abousamra, Robyn Berdan, Benjamin Trpcic Childs, Sabrina Ke, Taha Ali Siddiqui**
 ## **Software Description:**  
  This is a desktop application designed to help individuals navigate commonly used buildings on Western's Campus including Middlesex College (MC), Alumni Hall (AH), and Natural Sciences Centre (NSC). This application takes advantage of the floor plans provided by Western University to allow users to search the maps and customize aspects of them to suit their own preferences and/or needs. The application will allow users to search for rooms in buildings, locate points of interest, browse available maps, and create and store their own points of interest. In addition, an editing tool will also be included for developers to create and edit map metadata.

## **Install - Required Libraries and Third-Party Tools**
To set up and install the software on your system, please follow the instructions below. Note that the instructions are written for a Windows 10 system.
1. Create a BitBucket account, if you do not already have one, by visiting the BitBucket website (https://bitbucket.org/).
2. Download and install a Java IDE. We recommend using Apache Netbeans version 17 (https://netbeans.apache.org/download/nb17/). Download the installer and packages for your device and follow the given instructions.
3. Download and install Java Development Kit 19 (JDK 19), if you do not already have it, from the official website (https://www.oracle.com/java/technologies/javase-jdk19-downloads.html). To check if you have JDK, follow the steps below:
- Search for and open the Command Prompt (Windows) or Terminal (macOS/Linux).
- Type "java -version" and press Enter.
- If JDK is installed, the Command Prompt/Terminal will display the version number of the installed JDK. If JDK is not installed, the Command Prompt/ Terminal will display an error message.
4. Download and install Git from the official website (https://git-scm.com/downloads).

## **Build:**
To build this software from source code, please follow these steps:
1. first clone the repository to your local system.
2. Select the 'Clone' action from the left sidebar of Bitbucket
3. Copy the link provided
4. In your IDE go to *Team > Remote > Clone* and paste in the link provided and select finish.
5. Install all necessary components, libraries, and third-party tools.
6. Next navigate to *src > main > java > main.java* in your IDE.
7. Once the project is loaded, you can build the software by typing 'Build' in the search box on the top right of the page and selecting build. The bottom screen of the page will indicate if you have successfully built the program.
 
## **Running the Software:**
After building the software, you can run it using the following steps:

 1. Navigate to  Main.java from *src > main > java > main.java* in your IDE.
 2. Select 'Run' and 'Run Project' from the top of the page to run the program.
 3. If you have successfully run the program, the application main page should appear.

 Note: Before running the software, make sure that all required libraries and third-party tools are installed on your system. If any errors occur during runtime, check if all the necessary libraries and tools are present and properly configured. Also, make sure that your system meets the minimum requirements for running the software.

## **User Guide:**
When you run this program you will be brought to our main page where you will be able to navigate and modify the available building maps. The ‘About’ button provides additional information on the application and the 'Help' button provides information on how to use the program. The application contains the following functionalities:

### **Navigating Maps:**
Maps of Middlesex College (MC), Natural Science Centre (NSC), and Alumni Hall (AH) will be provided. You can select the map you are interested in by clicking on the tab with the name of the building at the top of the application. For large maps, you can use the scroll bar to navigate the map and better view the maps. Buildings have several floors that can be accessed using the drop-down menu at the bottom of each map to select available floors for each building.

### **Displaying Layers:**
Each map has several layers for collections of common POIs (points of interest) or POIs that fall under the same category. By selecting or unselecting the layer, you can hide or display certain POIs of the specified layer. 

### **Searching for and Interacting with POIs:**
Using the search bar, you can search for specific POIs. Simply type in the name of the POI or the room number and names or numbers of matching POIs will appear. Once the search is initiated by clicking the ‘find POI’ button, the map containing the POI will be displayed and the POI will be highlighted on the map. In addition, for each map and floor, a list of all available POIs for the currently displayed map will be available on the side of the screen. For more information on POIs, you can click on the POI and a description will appear at the bottom that lists the name of the POI, the room number, and a brief description of the POI.

### **Creating and Editing User POIs:**
To create your own POI, you click where on the map you wish to create a POI. You can then enter a name, description, and location for your new POI. Once you have added your POI, it will appear when you select the ‘User POIs’ layer. Clicking on the ‘Edit POI’ button will provide the
option to edit the POI information. Built-in POIs cannot be edited by users.

### **Managing Favourite POIs:**
To manage your favourite POIs, select the ‘Favourites’ button to view all your favourited POIs. If you click on a POI in the list, you will be directed to the POI on the map. Here, you can ‘unfavourite’ the POI to remove it from the list by unselecting the favourite box. To add a new POI to your favourites list, simply click on the POI and select it as ‘favourite’.

### **Navigating and Exiting the Application:**
To navigate to developer mode, you can use the login feature at the top of the screen and enter the username and password. To log out select the ‘logout’ button. To exit the application, tap on the ‘X’ button located at the top right of the screen. You will be given a warning if there are any
unsaved work that you may lose when switching modes or exiting the application. 

### **Persistent Data:**
Any user-created POIs or favourited POIs that you create will be saved between sessions. This means that you can exit the application and return to it later without losing any of your data.

### **Current Weather:**
In the top right-hand corner of the main page, the current weather in London is shown. Note that this feature is internet-dependent, so it only operates with internet access.
 
## **Editor Mode:**
 This software contains an editor mode to edit the metadata for the built-in points of interest (POIs) through a graphical interface. 

To access the editor mode, you must first log in by entering the following credentials into the login function located at the top of the main page:

- **Username:** Admin

- **Password:** password

 Once you have successfully logged in, you can start editing the built-in POIs by adding, editing, and removing them on the map. You can also specify additional metadata for each POI, including its name, room number, description, and category. This allows you to easily toggle POIs on and off with the appropriate layer. To log out, just click the 'log out' button at the top of the page.

If you encounter any issues, refer to this README file for troubleshooting steps or contact our team for assistance.

