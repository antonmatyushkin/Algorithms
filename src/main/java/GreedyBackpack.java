import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyBackpack {

    class Item implements Comparable<Item> {
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item item) {
            long r1 = (long) cost * item.weight;
            long r2 = (long) item.cost * weight;
            return -Long.compare(r1, r2);
        }
    }

    public static void main(String[] args) {
        /**
         * В метод run() передается boolean значение соответствующее:
         * true - ввод данных из командной строки
         * false - чтение данных из фацйла
         */
        new GreedyBackpack().run(false);
    }

    private void run(boolean commandLine) {
        if (commandLine) {
            // Ввод данных из командной строки
            try (Scanner input = new Scanner(System.in)) {
                int n = input.nextInt( );
                int w = input.nextInt( );
                Item[] items = new Item[n];
                for (int j = 0; j < n; j++) {
                    items[j] = new Item(input.nextInt( ), input.nextInt( ));
                }
                Arrays.sort(items);
                double result = 0;
                for (Item item : items) {
                    if (item.weight <= w) {
                        result += item.cost;
                        w -= item.weight;
                    } else {
                        result += (double) item.cost * w / item.weight;
                        break;
                    }
                }
                System.out.println(result);
            }
        } else {
            // Чтение данных из файла
            try (Scanner input = new Scanner(new File("src/main/resources/input.txt"))) {
                int n = input.nextInt( );
                int w = input.nextInt( );
                Item[] items = new Item[n];
                for (int j = 0; j < n; j++) {
                    items[j] = new Item(input.nextInt( ), input.nextInt( ));
                }
                Arrays.sort(items);
                double result = 0;
                for (Item item : items) {
                    if (item.weight <= w) {
                        result += item.cost;
                        w -= item.weight;
                    } else {
                        result += (double) item.cost * w / item.weight;
                        break;
                    }
                }
                System.out.println(result);
            } catch ( IOException exception ) {
                System.out.println(exception.getMessage());
            }
        }

    }
}
