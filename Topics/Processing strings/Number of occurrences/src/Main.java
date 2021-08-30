import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String search = scanner.nextLine();

        int difference = input.length() - input.replaceAll(search, "").length();
        System.out.println(difference / search.length());
    }
}