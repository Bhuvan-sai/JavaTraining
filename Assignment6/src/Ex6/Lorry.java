package Ex6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lorry {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the distance(in km): ");
		int distance = sc.nextInt();

		System.out.print("Enter no of Hours per day:");
		int noOfHoursPerDay = sc.nextInt();

		System.out.print("Enter the speed of the Lorry(in km/hr): ");
		int speed = sc.nextInt();

		System.out.print("Enter the starting date of journey(in YYYY-MM-DD format): ");
		String beginDate = sc.next();
		LocalDate startDate = LocalDate.parse(beginDate);

		System.out.print("Enter the starting time(in HH:MM format): ");
		String beginTimeGiven = sc.next();
		LocalTime beginTime = LocalTime.parse(beginTimeGiven);

		double totalTimeRequired = distance / speed;
		double totalNumberOfDays = Math.round(totalTimeRequired / noOfHoursPerDay);

		List<String> holidaysList = new ArrayList<>();

		for (int i = 0; i <= totalNumberOfDays; i++) {
			LocalDate currentDate = startDate.plusDays(i);
			if(currentDate.getMonthValue() == 1 && currentDate.getDayOfMonth()==1){
				holidaysList.add("New Year Day");
			}else if (currentDate.getMonthValue() == 1 && currentDate.getDayOfMonth() == 26) {
				holidaysList.add("Republic Day");
			}else if (currentDate.getMonthValue() == 8 && currentDate.getDayOfMonth() == 15) {
				holidaysList.add("Independence Day");
			}else if(currentDate.getDayOfWeek().getValue() == 6 && currentDate.getDayOfMonth() >= 8
					&& currentDate.getDayOfMonth() <= 14) {
				holidaysList.add("Second Saturday");
			}else if(currentDate.getDayOfWeek().getValue() == 7) {
				holidaysList.add("Sunday");
			}
		}
		double totalNumDays = totalNumberOfDays + holidaysList.size();
		LocalDate endDate = startDate.plusDays((long) totalNumDays);
		LocalTime destinationTime = beginTime.plus((long) Math.floorMod(Math.round(totalTimeRequired * 60), 480),
				ChronoUnit.MINUTES);
		System.out.println("Lorry will reach the destination on " + endDate + " at " + destinationTime + ".");
	}
}