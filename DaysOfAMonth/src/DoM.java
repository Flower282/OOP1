import java.util.Scanner;

public class DoM {
    /**
     * write a program to display the days of the month,
     * which is entered by the user(both month and year)
     * If it is an invalid month or year, ask the user to enter again
     */
    public static int getMonthNumber(String month) {
        //The user can either enter a month in its full name, abbreviation, in 3 letters, or in number.
        //To illustrate, the valid inputs of January are January, Jan., Jan, and 1
        return switch (month) {
            //use the case-insensitive
            case "January", "Jan.", "Jan", "1" -> 1;
            case "February", "Feb.", "Feb", "2" -> 2;
            case "March", "Mar.", "Mar", "3" -> 3;
            case "April", "Apr.", "Apr", "4" -> 4;
            case "May","May.", "5" -> 5;
            case "June", "Jun.", "Jun", "6" -> 6;
            case "July", "Jul.", "Jul", "7" -> 7;
            case "August", "Aug.", "Aug", "8" -> 8;
            case "September", "Sep.", "Sep", "9" -> 9;
            case "October", "Oct.", "Oct", "10" -> 10;
            case "November", "Nov.", "Nov", "11" -> 11;
            case "December", "Dec.", "Dec", "12" -> 12;
            default -> -1;
        };



    }
    public static void displayTheNumberOfDayOfAMonth(Integer month, Integer year ) {
        //The number of days in each month
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //Check if the year is a leap year
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            daysInMonth[2] = 29;
        }
        System.out.println("The number of days in " + month + "/" + year + " is " + daysInMonth[month]);
    }
    public static void main(String[] args) {
        //If it is an invalid month/year, ask the user to enter again.
        Scanner sc = new Scanner(System.in);
        int monthNumber, yearNumber = -1;
        do {
            System.out.println("Enter the month: ");
            String month = sc.nextLine();
            monthNumber = getMonthNumber(month);
            if (monthNumber == -1) {
                System.out.println("Invalid month. Please enter again.");
            }
        }while (monthNumber == -1);

        do {
            System.out.println("Enter the year (Please enter a year in a non-negative number and enter all the digits): ");
            String checkYear = sc.nextLine();
            try {
                int year = Integer.parseInt(checkYear);
                if (year >= 0) {
                    yearNumber = year;
                    break;
                } else {
                    System.out.println("You've entered a negative number! Please enter again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter again.");
            }
        }while (yearNumber == -1);

        displayTheNumberOfDayOfAMonth(monthNumber, yearNumber);
    }
}
