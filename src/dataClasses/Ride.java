package dataClasses;

public class Ride {
  private int rideRequestId;
  private String driverEmail;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;
  private double distance;
  private double charge;
  private int driverRating;
  private int passengerRating;

  public Ride(int rideRequestId, String driverEmail, String startDate, String startTime, String endDate, String endTime,
      double distance, double charge, int driverRating, int passengerRating) {
    this.rideRequestId = rideRequestId;
    this.driverEmail = driverEmail;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
    this.distance = distance;
    this.charge = charge;
    this.driverRating = driverRating;
    this.passengerRating = passengerRating;
  }

  public int getRideRequestId() {
    return rideRequestId;
  }

  public void setRideRequestId(int rideRequestId) {
    this.rideRequestId = rideRequestId;
  }

  public String getDriverEmail() {
    return driverEmail;
  }

  public void setDriverEmail(String driverEmail) {
    this.driverEmail = driverEmail;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public double getCharge() {
    return charge;
  }

  public void setCharge(double charge) {
    this.charge = charge;
  }

  public int getDriverRating() {
    return driverRating;
  }

  public void setDriverRating(int driverRating) {
    this.driverRating = driverRating;
  }

  public int getPassengerRating() {
    return passengerRating;
  }

  public void setPassengerRating(int passengerRating) {
    this.passengerRating = passengerRating;
  }
}
