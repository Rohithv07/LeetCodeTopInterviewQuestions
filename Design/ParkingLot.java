
// https://youtu.be/V9NEOLpt3tg

import java.util.*;

public class ParkingLot {
	// multiple floors
	List<ParkingFloor> parkingFloors;
	// multiple entry
	List<Entrance> entrances;
	// multiple exit
	List<Exit> exits;

	// address of the parking lot
	Address address;
	// name of parking lot
	String parkingLotName;

	// api exposed to check for parking space available or not
	public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
	// api exposed to update the parking attendand
	public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId);
}


class ParkingFloor {
	// id for each parking floor
	int levelId;
	// check whether the parking floor is full
	boolean isFull;
	// there will be parking spaces for different vehicles
	List<ParkingSpace> parkingSpace;
	// display board
	ParkingDisplayBoard parkingDisplayBoard;
}

class Gate {
	// there will be a gateId
	int gateId;
	// there will be a gate attaendant;
	ParkingAttendant parkingAttendant;
}

class Entrance extends Gate {
	// entrace gate should get parking ticket
	public ParkingTicket getParkingTicket(Vehicle vechile);
}

class Exit extends Gate {
	// exit gate should do payment
	public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType);
}

class Address {
	String country;
	String city;
	String state;
	String street;
	String pinCode;
}

class ParkingSpace {
	int spaceId;
	boolean isSpaceFull;
	double costPerHour;
	Vehicle vechicle;
	ParkingSpaceType parkingSpaceType; // 2 wheeler, 4 wheeler, truck etc 
}

class ParkingDisplayBoard {
	Map<ParkingSpaceType, Integer> freeSpotAvailableMap;

	// api to update our hashmap
	public void freeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces);
}

class Account {
	String name;
	String email;
	String password;
	String empId;
	Addess address;
}

class Admin extends Account {
	public boolean addParkingLot(ParkingLot parkingLot, ParkingFloor parkingFloor);
	public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace);
	public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard parkingDisplayBoard);
}

class ParkingAttendant extends Account {
	Payment paymentService;

	// if he can process the vehicle entry as there might be proper space to accomadate a vehicle
	public processVehicleEntry(Vehicle vehicle);
	// at the exit, he need to do the settling of payment
	public PaymentInfo processPayment(ParkingTicket parkingTicket, ParkingType parkingType);
}

class Vehicle {
	String licenseNumber;
	VehicleType vehicleType;
	PaymentInfo paymentInfo;
	ParkingTicket parkingTicket;
}

class ParkingTicket {
	int parkingId;
	int levelId;
	int spaceId;
	double totalCost;
	Date entryTime;
	Date exitTime;
	ParkingSpaceType parkingSpaceType;
	ParkingTicketStatus parkingTicketStatus;

	// this need to update total cost
	public void updateTotalCost();
	// this also need to update the exit time
	public void updateExitTime(Date exitTime);
}


public enum PaymentType {
	CASH, CREDIT_CARD, DEBIT_CARD, UPI;
}

public enum ParkingSpaceType {
	BIKE_PARKING, CAR_PARKING, TRUCK_PARKING;
}

class Payment {
	public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

class PaymentInfo {
	double amount;
	Date paymentDate;
	int transacrionId;
	ParkingTicket parkingTicket;
	PaymentStatus paymentStatus;
}

public enum ParkingTicketStatus {
	PAID, ACTIVE;
}

public enum VehicleType {
	BIKE, CAR;
}

public enum PaymentStatus {
	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUND;
}

