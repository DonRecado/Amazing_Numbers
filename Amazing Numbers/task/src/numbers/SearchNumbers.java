package numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

enum amazingProperties {
    EVEN,
    ODD,
    BUZZ,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    SUNNY,
    JUMPING,
    SQUARE,
    HAPPY,
    SAD
}

public class SearchNumbers {
    private final Number firstNumber;
    private final Number secondNumber;
    private amazingProperties[] properties;
    private amazingProperties[] negativeProperties;
    private String errors;

    public SearchNumbers(Number firstNumber, Number secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void setProperties(amazingProperties[] properties) {
        HashSet<amazingProperties> temp = new HashSet<>();
        for (amazingProperties prop : properties) {
            if (prop != null) {
                temp.add(prop);
            }
        }
        this.properties = temp.toArray(new amazingProperties[]{});
    }

    public void setNegativeProperties(amazingProperties[] properties) {
        HashSet<amazingProperties> temp = new HashSet<>();
        for (amazingProperties prop : properties) {
            if (prop != null) {
                temp.add(prop);
            }
        }
        this.negativeProperties = temp.toArray(new amazingProperties[]{});
    }

    public Number getSecondNumber() {
        return secondNumber;
    }

//    public amazingProperties[] getNegativeProperties() {
//        return negativeProperties;
//    }

    public amazingProperties[] getProperties() {
        return properties;
    }

    public String getErrors() {
        return errors;
    }

    public boolean checkProperties() {


        if (this.properties.length > 0 && this.negativeProperties.length > 0) {
            List<amazingProperties> propertyList = Arrays.asList(this.properties);
            List<amazingProperties> propertiesListNegative = Arrays.asList(this.negativeProperties);

            for (amazingProperties prop : propertyList) {
                if (propertiesListNegative.contains(prop)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The request contains mutually exclusive properties: ");
                    sb.append("[" + prop.name() + ", -" + prop.name() + "]\n");
                    sb.append("There are no numbers with these properties.");
                    this.errors = sb.toString();
                    return false;
                }
            }

            if (propertyList.contains(amazingProperties.EVEN) && propertyList.contains(amazingProperties.ODD)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.EVEN + ", -" + amazingProperties.ODD + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertyList.contains(amazingProperties.DUCK) && propertyList.contains(amazingProperties.SPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.DUCK + ", " + amazingProperties.SPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertyList.contains(amazingProperties.SUNNY) && propertyList.contains(amazingProperties.SQUARE)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.SUNNY + ", " + amazingProperties.SQUARE + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertyList.contains(amazingProperties.SAD) && propertyList.contains(amazingProperties.HAPPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.SAD + ", " + amazingProperties.HAPPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.EVEN) && propertiesListNegative.contains(amazingProperties.ODD)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.EVEN + ", -" + amazingProperties.ODD + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.DUCK) && propertiesListNegative.contains(amazingProperties.SPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.DUCK + ", -" + amazingProperties.SPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.SUNNY) && propertiesListNegative.contains(amazingProperties.SQUARE)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.SUNNY + ", -" + amazingProperties.SQUARE + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.SAD) && propertiesListNegative.contains(amazingProperties.HAPPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.SAD + ", -" + amazingProperties.HAPPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }
            return true;
        } else if (this.properties.length > 0) {
            List<amazingProperties> propertyList = Arrays.asList(this.properties);
            if (propertyList.contains(amazingProperties.EVEN) && propertyList.contains(amazingProperties.ODD)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.EVEN + ", -" + amazingProperties.ODD + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertyList.contains(amazingProperties.DUCK) && propertyList.contains(amazingProperties.SPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.DUCK + ", " + amazingProperties.SPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertyList.contains(amazingProperties.SUNNY) && propertyList.contains(amazingProperties.SQUARE)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.SUNNY + ", " + amazingProperties.SQUARE + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertyList.contains(amazingProperties.SAD) && propertyList.contains(amazingProperties.HAPPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[" + amazingProperties.SAD + ", " + amazingProperties.HAPPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }
            return true;
        } else {
            List<amazingProperties> propertiesListNegative = Arrays.asList(this.negativeProperties);
            if (propertiesListNegative.contains(amazingProperties.EVEN) && propertiesListNegative.contains(amazingProperties.ODD)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.EVEN + ", -" + amazingProperties.ODD + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.DUCK) && propertiesListNegative.contains(amazingProperties.SPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.DUCK + ", -" + amazingProperties.SPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.SUNNY) && propertiesListNegative.contains(amazingProperties.SQUARE)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.SUNNY + ", -" + amazingProperties.SQUARE + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }

            if (propertiesListNegative.contains(amazingProperties.SAD) && propertiesListNegative.contains(amazingProperties.HAPPY)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The request contains mutually exclusive properties: ");
                sb.append("[-" + amazingProperties.SAD + ", -" + amazingProperties.HAPPY + "]\n");
                sb.append("There are no numbers with these properties.");
                this.errors = sb.toString();
                return false;
            }
            return true;
        }
    }

    public Number[] search() {
        int counter = 0;
        long iterator = firstNumber.getNumber();
        Number[] numberArray = new Number[(int) secondNumber.getNumber()];
//
        while (counter < getSecondNumber().getNumber()) {
            Number number = new Number(iterator);
            int isValidCounter = 0;
            int isValidNegativeCounter = 0;
            boolean isValid;
            boolean isValidNegative;

            boolean hasPositive = this.properties.length > 0;
            boolean hasNegative = this.negativeProperties.length > 0;
//

            if (hasPositive && hasNegative) {
                for (int i = 0; i < this.properties.length; i++) {
                    if (processSearch(number, this.properties[i])) {
                        isValidCounter++;
                    }
                }
                isValid = this.properties.length == isValidCounter;

                if (isValid) {
                    for (int i = 0; i < this.negativeProperties.length; i++) {
                        if (!processSearch(number, this.negativeProperties[i])) {
                            isValidNegativeCounter++;
                        }
                    }
                    isValidNegative = this.negativeProperties.length == isValidNegativeCounter;
                    if (isValidNegative) {
                        numberArray[counter] = number;
                        counter++;
                    }
                }
            } else if (hasPositive) {
                for (int i = 0; i < this.properties.length; i++) {
                    if (processSearch(number, this.properties[i])) {
                        isValidCounter++;
                    }
                }
                isValid = this.properties.length == isValidCounter;

                if (isValid) {
                    numberArray[counter] = number;
                    counter++;
                }
            } else if (hasNegative) {
                for (int i = 0; i < this.negativeProperties.length; i++) {
                    if (!processSearch(number, this.negativeProperties[i])) {
                        isValidNegativeCounter++;
                    }
                }
                isValidNegative = this.negativeProperties.length == isValidNegativeCounter;
                if (isValidNegative) {
                    numberArray[counter] = number;
                    counter++;
                }
            } else {
                return null;
            }


            iterator++;
        }
        return numberArray.clone();

    }


    private boolean processSearch(Number number, amazingProperties property) {
        switch (property) {
            case EVEN:
                return number.isEven();

            case ODD:
                return number.isOdd();

            case BUZZ:
                return number.isBuzz();

            case DUCK:
                return number.isDuck();

            case PALINDROMIC:
                return number.isPalindromic();

            case GAPFUL:
                return number.isGapful();

            case SPY:
                return number.isSpy();

            case SQUARE:
                return number.isSquare();

            case SUNNY:
                return number.isSunny();

            case JUMPING:
                return number.isJumping();

            case HAPPY:
                return number.isHappy();

            case SAD:
                return !number.isHappy();

            default:
                return false;
        }
    }

}
