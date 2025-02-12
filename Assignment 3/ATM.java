import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATM {
    private static final int CORRECT_PIN = 1234;
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int pin, double amount) throws InvalidPINException, InsufficientBalanceException {
        if (pin != CORRECT_PIN) {
            throw new InvalidPINException("Error: Invalid PIN.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Error: Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining Balance: " + balance);
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(3000); 
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();

            atm.withdraw(pin, amount);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        } finally {
            atm.displayBalance();
            scanner.close();
        }
    }
}
