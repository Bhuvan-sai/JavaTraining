package Ex6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Lorry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Declare and initialize variables
        int distance = 0;
        int noOfHoursPerDay = 0;
        int speed = 0;
        LocalDate startDate = null;
        LocalTime beginTime = null;

        boolean validInput = false;
        // Handle input exceptions using try-catch blocks
        while (!validInput) {
            try {
                System.out.print("Enter the distance (in km): ");
                distance = sc.nextInt();

                System.out.print("Enter no of hours per day: ");
                noOfHoursPerDay = sc.nextInt();

                System.out.print("Enter the speed of the lorry (in km/hr): ");
                speed = sc.nextInt();

                System.out.print("Enter the starting date of journey (in YYYY-MM-DD format): ");
                String beginDate = sc.next();
                startDate = LocalDate.parse(beginDate);

                System.out.print("Enter the starting time (in HH:MM format): ");
                String beginTimeGiven = sc.next();
                // convert input string to LocalTime object
                beginTime = LocalTime.parse(beginTimeGiven);

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // clear the scanner buffer
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid date or time in the specified format.");
                // clear the scanner buffer
                sc.nextLine();
            }
        }
        //Calculate the total time required and the total number of days required to complete the journey
        double totalTimeRequired = distance / speed;
        double totalNumberOfDays = Math.round(totalTimeRequired / noOfHoursPerDay);
        // create a new ArrayList to store holidays
        List<String> holidaysList = new ArrayList<>();

        for (int i = 0; i <= totalNumberOfDays; i++) {
            LocalDate currentDate = startDate.plusDays(i);
            if (currentDate.getMonthValue() == 1 && currentDate.getDayOfMonth() == 1) {
                holidaysList.add("New Year Day");
            } else if (currentDate.getMonthValue() == 1 && currentDate.getDayOfMonth() == 26) {
                holidaysList.add("Republic Day");
            } else if (currentDate.getMonthValue() == 8 && currentDate.getDayOfMonth() == 15) {
                holidaysList.add("Independence Day");
            } else if (currentDate.getDayOfWeek().getValue() == 6 && currentDate.getDayOfMonth() >= 8
                    && currentDate.getDayOfMonth() <= 14) {
                holidaysList.add("Second Saturday");
            } else if (currentDate.getDayOfWeek().getValue() == 7) {
                holidaysList.add("Sunday");
            }
        }
        // Calculate the total number of days required, including holidays and weekends, and the estimated date and time of arrival
        double totalNumDays = totalNumberOfDays + holidaysList.size();
        LocalDate endDate = startDate.plusDays((long) totalNumDays);
        LocalTime destinationTime = beginTime.plus((long) Math.floorMod(Math.round(totalTimeRequired * 60), 480),ChronoUnit.MINUTES);
        System.out.println("Lorry will reach the destination on " + endDate + " at " + destinationTime + ".");
    }
}