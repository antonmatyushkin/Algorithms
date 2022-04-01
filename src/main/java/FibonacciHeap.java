import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FibonacciHeap {

    public static void main(String[] args) throws IOException {
        System.out.print("Введите два числа из диапозонов [1, 10^18] и [2, 10^5]: ");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String[] numbers = str.split(" ");
        run(Long.parseLong(numbers[0]), Long.parseLong(numbers[1]));
    }

    private static void run(long n, long m) {
        if (n >= 1 && m >= 2) System.out.println(n + ": " + fibonacci(n, m));
    }

    private static long fibonacci(long n, long m) {
        long a = 0;
        long b = 1;

        ArrayList<Long> periodPizano = new ArrayList<>();
        periodPizano.add(a);
        periodPizano.add(b);

        for (long i = 2; i <= n; i++) {
            long c = (a + b) % m;
            a = b;
            b = c;

            if (periodPizano.size() > 2 && periodPizano.get(periodPizano.size() - 1) == 1L && periodPizano.get(periodPizano.size() - 2) == 0L) {
                periodPizano.remove(periodPizano.size() - 1);
                periodPizano.remove(periodPizano.size() - 1);
                System.out.println("periodPizano = " + periodPizano.size());
                break;
            } else {
                periodPizano.add(c);
            }
        }

        int index = (int) (n % periodPizano.size());
        return periodPizano.get(index);
    }
}
