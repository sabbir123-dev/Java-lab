
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

class TicketProcessor {

    public void bookTicket(String passengerName, String ageStr, double price) throws InvalidAgeException {


        if (passengerName == null) {
            throw new NullPointerException();
        }

        int age = Integer.parseInt(ageStr);


        if (age <= 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 1 and 120.");
        }

        System.out.println("Ticket booking successful!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
    }
}

public class problem1 {
    public static void main(String[] args) {
        TicketProcessor tp = new TicketProcessor();



        try {
            tp.bookTicket(null, "ten", 102.98);
        } catch (NumberFormatException e) {
            System.out.println("Error: Age must be a valid number.");
        } catch (NullPointerException e) {
            System.out.println("Error: Passenger name cannot be null."+e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Checking ticket availability...");
        }
    }
}
