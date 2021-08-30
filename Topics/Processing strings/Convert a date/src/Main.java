import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();
        scanner.close();

        String year = inputDate.substring(0, 4);
        String month = inputDate.substring(5, 7);
        String day = inputDate.substring(8, 10);

        System.out.println(month + "/" + day + "/" + year);
    }
}