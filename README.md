# yoober

## The requirements for the console application are as follows:
•	When starting the application, a welcome message is shown
•	Immediately following the welcome message, a menu of options supported by the application should be shown. The supported options should be:
1.	View all account details
2.	Calculate the average rating for a specific driver
3.	Create a new account
4.	Submit a ride request
5.	Complete a ride
•	Then, the application should accept user input to select a menu option. The user will enter the number of the menu option they wish to perform. For example, if they want to view all account details, they would enter the number 1.
•	Based on the option entered by the user, the application should handle the request appropriately. The required behaviour for each option is as follows:
======================================================================
1.	The following data for each account should be displayed to the user:
• First and last name
•	Full address (i.e. street, city, province, postal code)
•	Phone number
•	Email address
•	Whether the account is used by a passenger, driver, or both

2.	The user should be instructed to enter the email address of the driver in which they are interested. Then, the average of all available ratings given by passengers for all trips the specified driver has provided should be calculated and displayed to the user.

3.	With the data provided by the user specified below, insert new records into the database as appropriate. The user should be prompted to enter values for:
•	First and last name
•	Birthdate
•	Full address (i.e. street, city, province, postal code)
•	Phone number
•	Email address
•	Then, the user should be asked if the new account will be used by a passenger, driver, or both.
•	If passenger, prompt user to enter:	Credit card number
•	If driver, prompt user to enter:	Driver’s license number,	Driver’s license expiry date
•	If both, prompt the user to enter the information listed above for passengers and drivers
4.	With the data provided by the user specified below, insert new records as appropriate into the database. The user should be instructed to enter:
•	The email address of the passenger making the request
	Then, ask the user whether they want to choose their destination from the specified passenger’s list of favourite destinations
•	If yes:
o	Display a list containing the name and full address details of all the passenger’s favourite destinations
o	Prompt the user to enter the name corresponding to their choice of destination from their list of favourites 
•	If no:
o	Prompt the user to enter the full address details of their destination. Save this address in the database if necessary.
o	Ask the user if they want to make this destination a new favourite
	If they do, prompt the user to provide a name for the location, and add the destination as a new favourite location for the passenger
	Then, prompt the user to enter:
•	Desired pick-up date and time
•	Total number of riders
	For simplicity, we will assume the pick-up location is always the address tied to the passenger’s account
5.	Display a list containing the following details of all uncompleted rides requests:
•	ID
•	First and last name of passenger who requested the trip
•	Street and city of both the pick-up and destination addresses
•	Desired pick-up date and time

•	Then, prompt the user to enter the ID corresponding to the ride they want to complete (assume input will always be a number)
•	Complete the ride in the database with the following information provided by the user:
•	Driver’s email address
•	Use this to help specify the driver for the trip
•	Actual start/end date/time
•	Distance travelled
•	Cost
•	Driver’s rating
•	Passenger’s rating
•	Every time the user selects a menu option and finishes the option’s workflow, they should be prompted again to select a new option. They may exit the application by entering the word “exit” instead of a menu option.
•	Remember, all addresses should only be stored in the database once. So, whenever address details are provided by the user, a new address should only be created in the database if it doesn’t already exist.
•	For options 2, 4, and 5, if no passenger/driver can be found with the email address entered by the user, indicate this to the user and ask for a new email address until a valid one is provided
•	When the user is expected to enter numeric information (e.g. distance travelled for trip), assume they input valid data. There is no requirement to validate the input is numeric.
