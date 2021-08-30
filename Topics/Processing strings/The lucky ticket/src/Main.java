import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        readInput();
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split("");
        scanner.close();

        int firstThree = 0;
        int lastThree = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (i <= 2) {
                firstThree += Integer.parseInt(inputArray[i]);
            } else {
                lastThree += Integer.parseInt(inputArray[i]);
            }
        }

        System.out.println(firstThree == lastThree ? "Lucky" : "Regular");

    }
}