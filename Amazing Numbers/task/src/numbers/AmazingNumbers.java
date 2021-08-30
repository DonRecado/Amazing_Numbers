package numbers;

public interface AmazingNumbers {

    boolean isEven();

    boolean isOdd();

    boolean isBuzz();

    boolean isDuck();

    boolean isPalindromic();

    boolean isGapful();

    boolean isSpy();

    boolean isSunny();

    boolean isSquare();

    boolean isJumping();

    boolean isHappy();

    default String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    default String numberToString(long number) {
        return Long.toString(number);
    }


}
