import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestCommonDivisor {

    public static void main(String[] args) throws IOException {
        System.out.print("Введите два числа a >= 1 и b <= 2*10^9: ");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String[] numbers = str.split(" ");
        System.out.println(euclidGCD(Long.parseLong(numbers[0]), Long.parseLong(numbers[1])));
    }

    private static long euclidGCD(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) return euclidGCD(a % b, b);
        if (b >= a) return euclidGCD(a, b % a);
        return 0;
    }
}
