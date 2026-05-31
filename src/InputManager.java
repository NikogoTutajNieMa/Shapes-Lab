import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputManager {
    static Scanner scanner = new Scanner(System.in);

    public static double inputDouble(String message){
        double value;
        while(true){
            try {
                System.out.print(message);
                value = scanner.nextDouble();
                return value;
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println(Typography.BRIGHT_RED.getCode() + "This is not a number\n" + Typography.RESET.getCode());
            }
        }
    }

    public static int inputInt(String message){
        int value;
        while(true){
            try {
                System.out.print(message);
                value = scanner.nextInt();
                return value;
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println(Typography.BRIGHT_RED.getCode() + "This is not a number\n" + Typography.RESET.getCode());
            }
        }
    }
}