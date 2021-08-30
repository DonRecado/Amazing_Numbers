package numbers;

public class Number implements AmazingNumbers {
    private long number;
    private boolean isNatural;
    private boolean isZero;

    public Number(long number) {
        this.number = number;
        this.isNatural = number >= 0;
        this.isZero = number == 0;
    }

    public long getNumber() {
        return number;
    }

    public boolean isNatural() {
        return isNatural;
    }

    public boolean isZero() {
        return isZero;
    }

    @Override
    public boolean isEven() {
        return number % 2 == 0;
    }

    @Override
    public boolean isOdd() {
        return number % 2 != 0;
    }

    @Override
    public boolean isBuzz() {
        return number % 10 == 7 || number % 7 == 0;
    }

    @Override
    public boolean isDuck() {
        long temp = number;
        while (temp != 0) {
            if (temp % 10 == 0) {
                return true;
            }
            temp /= 10;
            if (temp < 0) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isPalindromic() {
        return numberToString(number).equals(reverseString(numberToString(number)));
    }

    @Override
    public boolean isGapful() {
        if (this.number < 100) {
            return false;
        }
        String stringNumber = numberToString(number);
        int newNumber = Integer.parseInt(stringNumber.charAt(0) + stringNumber.substring(stringNumber.length() - 1, stringNumber.length()));
        return number % newNumber == 0;
    }

    @Override
    public boolean isSpy() {
        long temp = number;
        long sum = 0;
        long product = 1;
        while (temp != 0) {
            sum += temp % 10;
            product *= temp % 10;
            temp /= 10;
        }

        return sum == product;
    }

    @Override
    public boolean isSunny() {
        double number = Long.valueOf(this.number).doubleValue() + 1;
        if (Math.sqrt(number) % 1 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSquare() {
        double number = Long.valueOf(this.number).doubleValue();
        if (Math.sqrt(number) % 1 == 0) {
            return true;
        }
        return number == 1;
    }

    @Override
    public boolean isJumping() {
        String number = Long.toString(this.number, 10);
        boolean status = true;
        for (int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            if (i != 0) {
                int oldNumber = Character.getNumericValue(number.charAt(i - 1));
                if (num - oldNumber > 1 || num - oldNumber < -1 || num == oldNumber) {
                    status = false;
                }
            }
        }
        return status;
    }

    @Override
    public boolean isHappy() {
        long number = this.number;
        while (Long.toString(number).length() != 1) {
            String numString = Long.toString(number);
            int sum = 0;
            for (int i = 0; i < numString.length(); i++) {
                sum += Math.pow(Character.getNumericValue(numString.charAt(i)), 2);
            }
            number = sum;
        }

        return number == 7 || number == 1;

    }

    @Override
    public String toString() {

        return "Properties of " + String.format("%,d", number).replace(".", ",") + "\n" +
                "buzz: " + this.isBuzz() + "\n" +
                "duck: " + this.isDuck() + "\n" +
                "palindromic: " + this.isPalindromic() + "\n" +
                "gapful: " + this.isGapful() + "\n" +
                "spy: " + this.isSpy() + "\n" +
                "sunny: " + this.isSunny() + "\n" +
                "square: " + this.isSquare() + "\n" +
                "jumping: " + this.isJumping() + "\n" +
                "happy: " + this.isHappy() + "\n" +
                "sad: " + !this.isHappy() + "\n" +
                "even: " + this.isEven() + "\n" +
                "odd: " + this.isOdd() + "\n";

    }
}
