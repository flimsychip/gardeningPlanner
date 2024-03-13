import java.util.Scanner;

public class GardeningPlanner_AllieYoung {
    static int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
    static int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
    static int minTemp; static int maxTemp; static int minRain; static int[] plantGrowth = new int[12]; static int[] plantHeight = new int[12];


    public static void main(String[] args) {
        welcome();
        getInputs();
        for(int i = 0; i < avgTemp.length; i++) {
            plantGrowth[i] = calculateGrowth(avgTemp[i], avgRain[i]);
        }
    }

    static void welcome() {
        System.out.println("-".repeat(90) + "\nWelcome to the CSC 215 Gardening Planner!\n" + "-".repeat(90));
    }

    static void getInputs() {
        Scanner input = new Scanner(System.in);
        System.out.print("- Enter minimum temperature for plant: ");
        minTemp = input.nextInt();
        System.out.print("- Enter maximum temperature for plant: ");
        maxTemp = input.nextInt();
        System.out.print("- Enter minimum rainfall for plant: ");
        minRain = input.nextInt();
        System.out.println("-".repeat(90));
    }

    static int calculateGrowth(int monthlyTemp, int monthlyRain) {
        if(minTemp <= monthlyTemp && monthlyTemp <= maxTemp) {
            return monthlyRain - minRain;
        }
        return -1;
    }
}