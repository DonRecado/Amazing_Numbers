package numbers;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        init();
        System.out.println("Goodbye!");
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);

        /*
         * 1.) Print Welcome and Instruction
         * 2.) Display the instructions
         * 3.) Ask for a request
         * 4.) If a user enters zero, terminate the program;
         * 5.) If numbers are not natural, print the error message;
         * 6.) If an incorrect property is specified, print the error message and the list of available properties;
         * 7.) For one number, calculate and print the properties of the number;
         * */

//        1.) Print Welcome and Instruction
        System.out.println("Welcome to Amazing Numbers!\n\n");

//        2.) Display Instructions
        printInstruction();


        while (true) {
            boolean hasNoErrors = true;
            Number firstNumber = null;
            Number secondNumber = null;
            SearchNumbers request = null;

//        3.) ask for a request
            System.out.print("Enter a Request: ");
            String input = scanner.nextLine();
            System.out.println();
//        4.) If a user enters zero, terminate the program;
            if (input.equals("0")) {
                break;
            }


//        5.) If numbers are not natural, print the error message;
            /*
             * 5.1) Split the input to an Array
             * 5.2) Check if array longer then 1 and smaller than 5 => current max length
             * 5.3) if yes Check is the first two inputs are actual Numbers else just the first
             * 5.3.1) If yes then immediately instantiate the Numbers and continue to natural check
             *        else print error Message => restart
             * 5.4) If they are numbers (it is a number) then check if they are natural
             * 5.5.1) if the Numbers are natural continue else print error Message => restart
             * */

//            5.1) Split the input to an Array
            String[] strArray = input.trim().split(" ");

//            5.2) Check if array longer then 1 and smaller than 5 => current max length

            if (strArray.length > 1) {
//            5.3) If yes then immediately instantiate the Numbers and continue to natural check
//                 else print error Message => restart
                if (isNumeric(strArray[0]) && isNumeric(strArray[1])) {
                    firstNumber = new Number(Long.parseLong(strArray[0]));
                    secondNumber = new Number(Long.parseLong(strArray[1]));
                } else {
                    hasNoErrors = printErrors("noNumber", 0);
                    System.out.println();
                }
            } else if (strArray.length == 1) {
                if (isNumeric(strArray[0])) {
                    firstNumber = new Number(Long.parseLong(strArray[0]));
                } else {
                    hasNoErrors = printErrors("noNumber", 0);
                    System.out.println();
                }
            } else {
                hasNoErrors = printErrors("maxParam", 0);
                System.out.println();
            }

//          5.4) If they are numbers (it is a number) then check if they are natural
//            5.5.1) if the Numbers are natural continue else print error Message => restart
            if (firstNumber != null && !firstNumber.isNatural()) {
                hasNoErrors = printErrors("notNatural", 1);
                System.out.println();
            }

            if (secondNumber != null && !secondNumber.isNatural()) {
                hasNoErrors = printErrors("notNatural", 2);
                System.out.println();
            }


            /*
             * 6.) If an incorrect property is specified, print the error message and the list of available properties;
             * 6.1) Check if the numbers are correct and the input contains property elements
             * 6.1.1) If yes continue else restart
             * 6.1.2) Instantiate the SearchNumbers class with the first two numbers
             * 6.2) Check if the properties match the defined enum if yes continue else print error and restart
             * 6.3) Create an Array of the selected properties and add it to the SearchNumbers class and continue
             * */

//            6.1) Check if the numbers are correct and the input contains property elements
            if (firstNumber != null && secondNumber != null
                    && firstNumber.isNatural() && secondNumber.isNatural()
                    && strArray.length > 2) {
//            6.1.2) Instantiate the SearchNumbers class with the first two numbers
                request = new SearchNumbers(firstNumber, secondNumber);
//                6.1.2.1) Predefine the later needed property Array

//            6.2) Check if the properties match the defined enum if yes continue else print error and restart

                /*
                 * I defined a boolean Array to check weather the properties are right
                 * I assigned also only the properties to a new String array as the numbers aren`t needed anymore
                 * If the array has errors we print the error and start over
                 * Else we continue
                 * */


                boolean[] hasErrors = new boolean[strArray.length - 2];
                String[] tempStringArray = new String[strArray.length - 2];

                for (int i = 2; i < strArray.length; i++) {
                    tempStringArray[i - 2] = strArray[i];
                    for (amazingProperties prop : amazingProperties.values()) {
                        if (strArray[i].charAt(0) == '-') {
                            if (prop.name().equals(strArray[i].substring(1).toUpperCase())) {
                                hasErrors[i - 2] = true;
                            }
                        } else {
                            if (prop.name().equals(strArray[i].toUpperCase())) {
                                hasErrors[i - 2] = true;
                            }
                        }
                    }
                }


                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hasErrors.length; i++) {
                    if (!hasErrors[i]) {
                        sb.append(strArray[i + 2]);
                        sb.append(" ");
                    }
                }
                String propErrors = sb.toString().trim();

                if (propErrors.length() > 0) {
                    hasNoErrors = printErrors("wrongProperty", 2, propErrors);
                } else {
//                    /*
//                     * Now its time to check if we have double properties inside the array
//                     * We convert the array to a Hashset (which does not allow double entries) and
//                     *   later convert it back as double entries should be ignored
//                     * Then we create the array of amazingProperties to assign to the SearchNumbers object
//                     *
//                     * */
                    LinkedHashSet<String> propSet = new LinkedHashSet<>(Arrays.asList(tempStringArray));
                    String[] temp = propSet.toArray(new String[propSet.size()]);
                    amazingProperties[] tempProperties = new amazingProperties[propSet.size()];
                    amazingProperties[] tempNegativeProperties = new amazingProperties[propSet.size()];
                    for (int i = 0; i < temp.length; i++) {
                        for (amazingProperties prop : amazingProperties.values()) {
                            if (temp[i].charAt(0) == '-') {
                                if (temp[i].substring(1).toUpperCase().equals(prop.name())) {
                                    tempNegativeProperties[i] = prop;
                                }
                            }
                            if (temp[i].toUpperCase().equals(prop.name())) {
                                tempProperties[i] = prop;
                            }
                        }
                    }
                    request.setProperties(tempProperties);
                    request.setNegativeProperties(tempNegativeProperties);

                }

            }

            /*
             * 7.) For one number, calculate and print the properties of the number;
             * 7.1) Verify that from here on there is no possibility to enter the code if anything is wrong
             *
             *
             *
             * */

            if (hasNoErrors) {
                switch (strArray.length) {
                    case 1:
                        if (firstNumber != null) {
                            processSingle(firstNumber);
                        }
                        break;
                    case 2:
                        if (firstNumber != null) {
                            processRow(firstNumber, secondNumber);
                            System.out.println();
                        }
                        break;
                    case 3:
                        assert request != null;
                        if (request.getProperties() != null) {
                            Number[] resultArraySs = request.search();
                            for (Number num : resultArraySs) {
                                printNumberList(num);
                            }
                            System.out.println();
                        }
                        break;
                    default:
                        assert request != null;
                        if (request.checkProperties()) {
                            Number[] resultArrayMs = request.search();
                            for (Number num : resultArrayMs) {
                                printNumberList(num);
                            }
                        } else {
                            System.out.println(request.getErrors());
                        }
                        System.out.println();
                        break;
                }
            }

        }// TODO END WHILE
    }


    public static void processSingle(Number number) {
        System.out.println(number);
    }

    public static void processRow(Number first, Number interval) {
        for (long i = first.getNumber(); i < first.getNumber() + interval.getNumber(); i++) {
            Number number = new Number(i);
            printNumberList(number);
        }
    }

    public static void printInstruction() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    private static void printNumberList(Number number) {
        System.out.print(String.format("%,d", number.getNumber()).replace(".", ",") + " is " + (number.isBuzz() ? "buzz, " : ""));
        System.out.print(number.isDuck() ? "duck, " : "");
        System.out.print(number.isPalindromic() ? "palindromic, " : "");
        System.out.print(number.isGapful() ? "gapful, " : "");
        System.out.print(number.isSpy() ? "spy, " : "");
        System.out.print(number.isSquare() ? "square, " : "");
        System.out.print(number.isSunny() ? "sunny, " : "");
        System.out.print(number.isJumping() ? "jumping, " : "");
        System.out.print(number.isHappy() ? "happy, " : "");
        System.out.print(!number.isHappy() ? "sad, " : "");
        System.out.print(number.isEven() ? "even" : "");
        System.out.print(number.isOdd() ? "odd" : "");
        System.out.println();
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean printErrors(String type, int parameter, String further) {
        switch (type) {
            case "noNumber":
                System.out.println("Please enter Numbers!");
                break;

            case "notNatural":
                String msg = parameter == 1 ? "first" : "second";
                System.out.println("The " + msg + " parameter should be a natural number or zero.");
                break;

            case "maxParam":
                System.out.println("You can only enter a maximum of 4 Parameters");
                break;

            case "wrongProperty":
                String[] properties = further.split(" ");
                StringBuilder sb = new StringBuilder();
                String msgOne, msgTwo;
                if (properties.length > 1) {
                    msgOne = "The properties [";
                    msgTwo = "] are wrong.";
                } else {
                    msgOne = "The property [";
                    msgTwo = "] is wrong.";
                }
                sb.append(msgOne);
                for (String property : properties) {
                    sb.append(property.toUpperCase());
                    sb.append(", ");
                }
                sb.append(msgTwo);
                System.out.println(sb.toString().trim().replace(", ]", "]"));

                System.out.println("Available properties: " + Arrays.toString(amazingProperties.values()));
                System.out.println();
                break;

            case "exclusiveProperty":
                properties = further.split(" ");
                System.out.println("The request contains mutually exclusive properties: [" + properties[0] +
                        ", " + properties[1] + "]");
                System.out.println("Available properties: " + Arrays.toString(amazingProperties.values()));
                System.out.println();
                break;

        }
        return false;
    }

    private static boolean printErrors(String type, int parameter) {
        return printErrors(type, parameter, "");
    }


}