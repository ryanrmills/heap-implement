import java.util.Scanner;

/**
 * Interactive runner program for testing your Heap implementation.
 * 
 * Commands:
 *   - Add a value
 *   - Pop the front value
 *   - Peek at the front value
 *   - Check the size
 *   - Check whether the heap is empty
 *   - Quit
 * 
 * Wherever you see TODO comments, you will need to fill in the appropriate
 * code to construct your Heap or call one of its methods. The method names
 * and return types are up to you based on your design decisions.
 */
public class HeapRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Heap heap = new Heap();

        System.out.println("=== Heap Tester ===");

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("a") || choice.equals("add")) {
                System.out.print("Enter an integer to add: ");
                String input = scanner.nextLine().trim();
                int value;
                try {
                    value = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("That wasn't a valid integer. Try again.");
                    continue;
                }
 
                heap.add(value);
                System.out.println("Added " + value + " to heap.");
 
            } else if (choice.equals("p") || choice.equals("pop")) {
                if (heap.isEmpty()) {
                    System.out.println("Cannot pop: heap is empty.");
                } else {
                    int popped = heap.pop();
                    System.out.println("Popped: " + popped);
                }

            } else if (choice.equals("k") || choice.equals("peek")) {
                if (heap.isEmpty()) {
                    System.out.println("Cannot peek: heap is empty.");
                } else {
                    int front = heap.peek();
                    System.out.println("Front value: " + front);
                }

            } else if (choice.equals("s") || choice.equals("size")) {
                System.out.println("Heap size: " + heap.size());

            } else if (choice.equals("e") || choice.equals("empty")) {
                System.out.println("Heap is empty: " + heap.isEmpty());

            } else if (choice.equals("q") || choice.equals("quit")) {
                break;

            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Prints the menu of available commands.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("---- Commands ----");
        System.out.println("  a / add   - add a value to the heap");
        System.out.println("  p / pop   - pop the front value off the heap");
        System.out.println("  k / peek  - peek at the front value of the heap");
        System.out.println("  s / size  - print the size of the heap");
        System.out.println("  e / empty - check whether the heap is empty");
        System.out.println("  q / quit  - exit the program");
        System.out.print("Enter command: ");
    }
}
