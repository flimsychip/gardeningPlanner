import java.util.Scanner;

public class GardeningPlanner_AllieYoung {
    static int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
    static int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
    static int minTemp; static int maxTemp; static int minRain; static String[] plantGrowth = new String[12]; static int height; static int[] plantHeight = new int[12];
    static final String highlight = "\u001B[43m"; static final String reset = "\u001B[0m";

    public static void main(String[] args) {
        welcome();
        getInputs();
        for(int i = 0; i < 12; i++) {
            //to add a "+" to the positive growth values
            if(calculateGrowth(avgTemp[i], avgRain[i]) < 0) {
                plantGrowth[i] = Integer.toString(calculateGrowth(avgTemp[i], avgRain[i]));
            } else {
                plantGrowth[i] = "+" + calculateGrowth(avgTemp[i], avgRain[i]);
            }
            plantHeight[i] = calculateHeight(Integer.parseInt(plantGrowth[i]));
        }
        displayTable(findMax(plantHeight));
    }

    static void welcome() {
        System.out.println("-".repeat(89) + "\nWelcome to the CSC 215 Gardening Planner!\n" + "-".repeat(89));
    }

    static void getInputs() {
        Scanner input = new Scanner(System.in);
        System.out.print("- Enter minimum temperature for plant: ");
        minTemp = input.nextInt();
        System.out.print("- Enter maximum temperature for plant: ");
        maxTemp = input.nextInt();
        System.out.print("- Enter minimum rainfall for plant: ");
        minRain = input.nextInt();
        System.out.println("-".repeat(89));
    }

    static int calculateGrowth(int monthlyTemp, int monthlyRain) {
        if(minTemp <= monthlyTemp && monthlyTemp <= maxTemp) {
            return monthlyRain - minRain;
        }
        //if temp isn't right, plant shrinks
        return -1;
    }

    static int calculateHeight(int growth) {
        if((height + growth) > 0) {
            height += growth;
        } else {
            //height can't be negative
            height = 0;
        }
        return height;
    }

    static int findMax(int[] arr) {
        int max = 0;
        for(int item : arr) {
            if(item > max) {
                max = item;
            }
        }
        return max;
    }

    static void displayTable(int maxHeight) {
        System.out.printf("\n" + "-------------- ".repeat(6) + "\n%-15s%-15s%-15s%-15s%-15s%-15s\n", "INDEX", "MONTH", "TEMPERATURE", "RAINFALL", "PLANT GROWTH", "PLANT HEIGHT");
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 0; i < 12; i++) {
            //prints highlighted max line
            if(plantHeight[i] == maxHeight) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-5s" + highlight + "MAX" + reset + "\n", i, months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i]);
            } else {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", i, months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i]);
            }
        }
        System.out.print("-------------- ".repeat(6));
    }
}