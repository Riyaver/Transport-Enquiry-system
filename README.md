# Transport-Enquiry-system

Abstract 
The aim is to create a Transport enquiry system that can be accessed by the user and store the entered data in a file using file handling. 
The project includes several classes which are needed for the functioning of an enquiry system, some of the classes include Main, SignUp, Login, Vehicle, etc. It It 
is a small-scale replica of the existing transport inquiry system, where you can log in or sign up on the interface and check the availability of either bus, plane, or train and can also book for the same. 
The project also uses Java Swing libraries to create a graphical user interface.

Project Description 
The project includes 8 classes all of which are linked to one another and stores the 
data in 5 different text files, each representing details regarding their respective 
classes. Every page or interface contains a logo on the top. 
All the classes are described below 
Main 
● The Main class represents the home page of the interface, it gives two 
options either sign up or sign in. 
● The class uses Java swing libraries to create the interface. 
● This class also uses action listener and action event libraries for the proper 
functioning of the button in such a way that when the button is pressed the 
home page would lead to a different page 
SignUp  
● This class is used to sign up for the interface it takes variable such as 
username, email, phone no, password and confirm password 
● If the password and confirm password does not match it will give a pop 
saying “Passwords do not match” 
● If any of the fields are left empty it will give pop-up saying “Please fill all 
the details”. 
● The class also uses file handling to store all the details in a text file in the 
same folder names “Person_details” with a comma separating them. 
3 
● All the entered data, even the past data is stored in this file and can be 
accessed by Login class to match the data. 
● After the data is successfully entered it again gives a pop saying “Data 
Saved Successfully” and then directly leads to the mode of transportation 
page. 
● The class also contains a back button to go to the Vehicle page. 
Login 
● This class is used to login to the interface  
● The class contains username and password which are then checked from the 
SignUp class. 
● If the username and password are matched “Login Successful” message is 
displayed and the page directly leads to the modes of transportation page. 
● If the details do not match it gives an “incorrect password/username” 
message. 
● The class also contains a back button leading to the Vehicle page. 
Vehicle 
● This page includes all the modes of transportation available which are bus 
and train. 
● The bus and train buttons are available which then lead to the bus and train 
interface. 
● The class also contains booking, history, and a back button. 
● The history button reads data from Bus_details and Train_details text files 
and displays it in the text area. 
● This class also contains a back button leading to the home page. 
Bus 
4 
● This class displays information about the bus according to the route chosen 
● The following routes are available: 
○ Delhi- Amritsar 
○ Delhi- Kolkata 
○ Kolkata - Delhi 
○ Kolkata - Mumbai 
● These routes are made available using radio buttons, when the route is 
selected and submit button is pressed, the details of that route are displayed 
on the screen. 
● All the details of the bus are stored in a file called “Bus_details”. 
● This class also contains a back button leading to the vehicle page. 
Train 
● Similar to the bus this class displays information related to the route of the 
train  
● The routes available are: 
○ Delhi - Kolkata 
○ Delhi - Mumbai 
○ Delhi - Amritsar 
○ Kolkata - Delhi 
○ Mumbai - Delhi 
○ Kolkata - Mumbai 
● These routes are made available using radio buttons, when the route is 
selected and submit button is pressed, the details of that route are displayed 
on the screen. 
● All these details are stored in the “Train_details” text file. 
● This class also contains a back button leading to the vehicle page. 
5 
Booking 
● This class as the name suggests is used for booking, it takes inputs such as 
name, phone no, source, destination, and date. 
● The user enters the above-mentioned data and then all the data is stored in a 
text file called “Booking_details”. 
●  This class also contains a back button leading to the vehicle page. 
Details 
● This class is used to display all the previously entered or selected data by the 
user and opens up after pressing the history button. 
● The data is displayed in a text area. 
● The data displayed include data from text files: Bus_details, Train_details, 
and Booking_details, 
● This class also contains a back button leading to the vehicle page. 
