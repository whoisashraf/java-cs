
import java.util.Scanner;

public class VehicleInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Information System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a car");
            System.out.println("2. Add a motorcycle");
            System.out.println("3. Add a truck");
            System.out.println("4. Exit");

            int choice = getValidInteger(scanner, "option: ");

            switch (choice) {
                case 1:
                    System.out.println("\nEnter the details for a car:");
                    Car car = createCar(scanner);
                    displayVehicleDetails("Car Details", car);
                    break;
                case 2:
                    System.out.println("\nEnter the details for a motorcycle:");
                    Motorcycle motorcycle = createMotorcycle(scanner);
                    displayVehicleDetails("Motorcycle Details", motorcycle);
                    break;
                case 3:
                    System.out.println("\nEnter the details for a truck:");
                    Truck truck = createTruck(scanner);
                    displayVehicleDetails("Truck Details", truck);
                    break;
                case 4:
                    System.out.println("Exiting the Vehicle Information System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        }
    }

    private static Car createCar(Scanner scanner) {
        Car car = new Car();

        // Prompt and get user input for car details
        car.setMake(getUserInput(scanner, "Enter the make of the car:"));
        car.setModel(getUserInput(scanner, "Enter the model of the car:"));
        car.setYear(getValidYear(scanner, "Enter the manufacturing year of the car:"));
        car.setNumberOfDoors(getValidInteger(scanner, "Enter the number of doors:"));
        car.setFuelType(getValidFuelType(scanner, "Enter the fuel type (petrol, diesel, electric):"));

        return car;
    }

    private static Motorcycle createMotorcycle(Scanner scanner) {
        Motorcycle motorcycle = new Motorcycle();

        // Prompt and get user input for motorcycle details
        motorcycle.setMake(getUserInput(scanner, "Enter the make of the motorcycle:"));
        motorcycle.setModel(getUserInput(scanner, "Enter the model of the motorcycle:"));
        motorcycle.setYear(getValidYear(scanner, "Enter the manufacturing year of the motorcycle:"));
        motorcycle.setNumberOfWheels(getValidInteger(scanner, "Enter the number of wheels:"));
        motorcycle.setMotorcycleType(
                getValidMotorcycleType(scanner, "Enter the type of motorcycle (sport, cruiser, off-road):"));

        return motorcycle;
    }

    private static Truck createTruck(Scanner scanner) {
        Truck truck = new Truck();

        // Prompt and get user input for truck details
        truck.setMake(getUserInput(scanner, "Enter the make of the truck:"));
        truck.setModel(getUserInput(scanner, "Enter the model of the truck:"));
        truck.setYear(getValidYear(scanner, "Enter the manufacturing year of the truck:"));
        truck.setCargoCapacity(getValidDouble(scanner, "Enter the cargo capacity of the truck (in tons):"));
        truck.setTransmissionType(
                getValidTransmissionType(scanner, "Enter the transmission type of the truck (manual, automatic):"));

        return truck;
    }

    private static void displayVehicleDetails(String label, Vehicle vehicle) {
        System.out.println("\n" + label + ":");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());

        if (vehicle instanceof CarVehicle) {
            CarVehicle carVehicle = (CarVehicle) vehicle;
            System.out.println("Number of Doors: " + carVehicle.getNumberOfDoors());
            System.out.println("Fuel Type: " + carVehicle.getFuelType());
        }

        if (vehicle instanceof MotorVehicle) {
            MotorVehicle motorVehicle = (MotorVehicle) vehicle;
            System.out.println("Number of Wheels: " + motorVehicle.getNumberOfWheels());
            System.out.println("Motorcycle Type: " + motorVehicle.getMotorcycleType());
        }

        if (vehicle instanceof TruckVehicle) {
            TruckVehicle truckVehicle = (TruckVehicle) vehicle;
            System.out.println("Cargo Capacity (in tons): " + truckVehicle.getCargoCapacity());
            System.out.println("Transmission Type: " + truckVehicle.getTransmissionType());
        }
    }

    private static String getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getValidYear(Scanner scanner, String prompt) {
        int year;
        while (true) {
            try {
                System.out.print(prompt);
                year = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        return year;
    }

    private static int getValidInteger(Scanner scanner, String prompt) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        return value;
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        return value;
    }

    private static String getValidFuelType(Scanner scanner, String prompt) {
        String fuelType;
        while (true) {
            System.out.print(prompt);
            fuelType = scanner.next().toLowerCase();
            if (fuelType.equals("petrol") || fuelType.equals("diesel") || fuelType.equals("electric")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid fuel type.");
            }
        }
        return fuelType;
    }

    private static String getValidMotorcycleType(Scanner scanner, String prompt) {
        String motorcycleType;
        while (true) {
            System.out.print(prompt);
            motorcycleType = scanner.next().toLowerCase();
            if (motorcycleType.equals("sport") || motorcycleType.equals("cruiser")
                    || motorcycleType.equals("off-road")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid motorcycle type.");
            }
        }
        return motorcycleType;
    }

    private static String getValidTransmissionType(Scanner scanner, String prompt) {
        String transmissionType;
        while (true) {
            System.out.print(prompt);
            transmissionType = scanner.next().toLowerCase();
            if (transmissionType.equals("manual") || transmissionType.equals("automatic")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid transmission type.");
            }
        }
        return transmissionType;
    }
}
