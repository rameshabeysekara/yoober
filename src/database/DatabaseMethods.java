/*
 * Group members: Matthew Ovie Enamuotor & Thenahandi Ramesh Bandara Abeysekara
 * Instructions: For Project 2, implement all methods in this class, and test to confirm they behave as expected when the program is run.
 */

package database;

import java.sql.*;
import java.util.*;

import dataClasses.*;
import dataClasses.Driver;

public class DatabaseMethods {
  private Connection conn;

  public DatabaseMethods(Connection conn) {
    this.conn = conn;
  }

  /*
   * Accepts: Nothing
   * Behaviour: Retrieves information about all accounts
   * Returns: List of account objects
   */
  public ArrayList<Account> getAllAccounts() throws SQLException {
    ArrayList<Account> accounts = new ArrayList<Account>();

    String getAccountDetails = "SELECT a.FIRST_NAME, a.LAST_NAME, a.BIRTHDATE, a.PHONE_NUMBER, a.EMAIL, ad.STREET, ad.CITY, ad.PROVINCE, ad.POSTAL_CODE, CASE WHEN p.ID IS NOT NULL THEN 1 ELSE 0 END AS isPassenger, CASE WHEN d.ID IS NOT NULL THEN 1 ELSE 0 END AS isDriver FROM accounts AS a LEFT JOIN addresses AS ad ON a.ADDRESS_ID = ad.ID LEFT JOIN passengers AS p ON a.ID = p.ID LEFT JOIN drivers AS d ON a.ID = d.ID";
    try (
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getAccountDetails)) {

      while (rs.next()) {
        String firstName = rs.getString("FIRST_NAME");
        String lastName = rs.getString("LAST_NAME");

        Address address = new Address(
            rs.getString("STREET"),
            rs.getString("CITY"),
            rs.getString("PROVINCE"), rs.getString("POSTAL_CODE"));

        String phoneNumber = rs.getString("PHONE_NUMBER");
        String email = rs.getString("EMAIL");
        String birthdate = rs.getString("BIRTHDATE");
        boolean isPassenger = rs.getBoolean("isPassenger");
        boolean isDriver = rs.getBoolean("isDriver");

        Account accountDetails = new Account(firstName, lastName, address.getStreet(), address.getCity(),
            address.getProvince(), address.getPostalCode(), phoneNumber, email,
            birthdate, isPassenger, isDriver);

        accounts.add(accountDetails);

      }
      ;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return accounts;
  }

  /*
   * Accepts: Email address of driver
   * Behaviour: Calculates the average rating over all rides performed by the
   * driver specified by the email address
   * Returns: The average rating value
   */
  public double getAverageRatingForDriver(String driverEmail) throws SQLException {
    double averageRating = 0.0;

    String getAverageDriverRating = "SELECT AVG(RATING_FROM_PASSENGER) FROM accounts INNER JOIN drivers ON accounts.ID =  drivers.ID INNER JOIN rides ON drivers.ID = rides.DRIVER_ID WHERE EMAIL = ?";

    try (PreparedStatement stmt = conn.prepareStatement(getAverageDriverRating)) {
        stmt.setString(1, driverEmail);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                averageRating = rs.getDouble(1);
            } else {
                System.out.println("Driver with email '" + driverEmail + "' not found.");
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return averageRating;
}



  /*
   * Accepts: Account details, and passenger and driver specific details.
   * Passenger or driver details could be
   * null if account is only intended for one type of use.
   * Behaviour:
   * - Insert new account using information provided in Account object
   * - For non-null passenger/driver details, insert the associated data into the
   * relevant tables
   * Returns: Nothing
   */
  public void createAccount(Account account, Passenger passenger, Driver driver) throws SQLException {
    // TODO: Implement
    // Hint: Use the available insertAccount, insertPassenger, and insertDriver
    // methods
  }

  /*
   * Accepts: Account details (which includes address information)
   * Behaviour: Inserts the new account, as well as the account's address if it
   * doesn't already exist. The new/existing address should
   * be linked to the account
   * Returns: Id of the new account
   */
  public int insertAccount(Account account) throws SQLException {
    int accountId = -1;

    // TODO: Implement
    // Hint: Use the insertAddressIfExists method

    return accountId;
  }

  /*
   * Accepts: Passenger details (should not be null), and account id for the
   * passenger
   * Behaviour: Inserts the new passenger record, correctly linked to the account
   * id
   * Returns: Id of the new passenger
   */
  public int insertPassenger(Passenger passenger, int accountId) throws SQLException {
    // TODO: Implement

    return accountId;
  }

  /*
   * Accepts: Driver details (should not be null), and account id for the driver
   * Behaviour: Inserts the new driver and driver's license record, correctly
   * linked to the account id
   * Returns: Id of the new driver
   */
  public int insertDriver(Driver driver, int accountId) throws SQLException {
    // TODO: Implement
    // Hint: Use the insertLicense method

    return accountId;
  }

  /*
   * Accepts: Driver's license number and license expiry
   * Behaviour: Inserts the new driver's license record
   * Returns: Id of the new driver's license
   */
  public int insertLicense(String licenseNumber, String licenseExpiry) throws SQLException {
    int licenseId = -1;
    // TODO: Implement

    return licenseId;
  }

  /*
   * Accepts: Address details
   * Behaviour:
   * - Checks if an address with these properties already exists.
   * - If it does, gets the id of the existing address.
   * - If it does not exist, creates the address in the database, and gets the id
   * of the new address
   * Returns: Id of the address
   */
  public int insertAddressIfExists(Address address) throws SQLException {
    int addressId = -1;

    // TODO: Implement

    return addressId;
  }

  /*
   * Accepts: Name of new favourite destination, email address of the passenger,
   * and the id of the address being favourited
   * Behaviour: Finds the id of the passenger with the email address, then inserts
   * the new favourite destination record
   * Returns: Nothing
   */
  public void insertFavouriteDestination(String favouriteName, String passengerEmail, int addressId)
      throws SQLException {
    // TODO: Implement
  }

  /*
   * Accepts: Email address
   * Behaviour: Determines if a driver exists with the provided email address
   * Returns: True if exists, false if not
   */
  public boolean checkDriverExists(String email) throws SQLException {
    String checkDriverQuery = "SELECT COUNT(*) FROM drivers INNER JOIN accounts ON drivers.ID = accounts.ID WHERE EMAIL = ?";

        try (PreparedStatement stmt = conn.prepareStatement(checkDriverQuery)) {
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                // return if there is at least one row and if column 1 is greater than 0
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
  

  /*
   * Accepts: Email address
   * Behaviour: Determines if a passenger exists with the provided email address
   * Returns: True if exists, false if not
   */
  public boolean checkPassengerExists(String email) throws SQLException {
    // TODO: Implement

    return true;
  }

  /*
   * Accepts: Email address of passenger making request, id of dropoff address,
   * requested date/time of ride, and number of passengers
   * Behaviour: Inserts a new ride request, using the provided properties
   * Returns: Nothing
   */
  public void insertRideRequest(String passengerEmail, int dropoffLocationId, String date, String time,
      int numberOfPassengers) throws SQLException {
    int passengerId = this.getPassengerIdFromEmail(passengerEmail);
    int pickupAddressId = this.getAccountAddressIdFromEmail(passengerEmail);

    // TODO: Implement
  }

  /*
   * Accepts: Email address
   * Behaviour: Gets id of passenger with specified email (assumes passenger
   * exists)
   * Returns: Id
   */
  public int getPassengerIdFromEmail(String passengerEmail) throws SQLException {
    int passengerId = -1;
    // TODO: Implement

    return passengerId;
  }

  /*
   * Accepts: Email address
   * Behaviour: Gets id of driver with specified email (assumes driver exists)
   * Returns: Id
   */
  public int getDriverIdFromEmail(String driverEmail) throws SQLException {
    int driverId = -1;
    // TODO: Implement

    return driverId;
  }

  /*
   * Accepts: Email address
   * Behaviour: Gets the id of the address tied to the account with the provided
   * email address
   * Returns: Address id
   */
  public int getAccountAddressIdFromEmail(String email) throws SQLException {
    int addressId = -1;
    // TODO: Implement

    return addressId;
  }

  /*
   * Accepts: Email address of passenger
   * Behaviour: Gets a list of all the specified passenger's favourite
   * destinations
   * Returns: List of favourite destinations
   */
  public ArrayList<FavouriteDestination> getFavouriteDestinationsForPassenger(String passengerEmail)
      throws SQLException {
    ArrayList<FavouriteDestination> favouriteDestinations = new ArrayList<FavouriteDestination>();

    // TODO: Implement

    return favouriteDestinations;
  }

  /*
   * Accepts: Nothing
   * Behaviour: Gets a list of all uncompleted ride requests (i.e. requests
   * without an associated ride record)
   * Returns: List of all uncompleted rides
   */
  public ArrayList<RideRequest> getUncompletedRideRequests() throws SQLException {
    ArrayList<RideRequest> uncompletedRideRequests = new ArrayList<RideRequest>();

    // TODO: Implement

    return uncompletedRideRequests;
  }

  /*
   * Accepts: Ride details
   * Behaviour: Inserts a new ride record
   * Returns: Nothing
   */
  public void insertRide(Ride ride) throws SQLException {
    // TODO: Implement
    // Hint: Use getDriverIdFromEmail
  }

}
