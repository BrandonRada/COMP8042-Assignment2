public class testListSection {
    public static void main(String[] args){
        int[] testArray = {1,0,6,4,2,3,5};

        PermutationGenerator pg = new PermutationGenerator(testArray);

        Integer[] smallestLarger = pg.smallestLargerNumbers();
        Integer[] largestSmaller = pg.largestSmallestNumbers();

        System.out.println("\nInput: ");
        printArray(testArray);

        System.out.println("\nSmallest Larger Numbers: ");
        printArray(smallestLarger);

        System.out.println("\nLargest Smaller Numbers: ");
        printArray(largestSmaller);

        // Test the shuffle method
        System.out.println("\n==== Now to test Shuffling ====");
        pg.shuffle();
        printArray(pg.getInputList());

    }

    // A helper function to print arrays storing int
    private static void printArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // A helper function to print arrays storing Integer
    private static void printArray(Integer[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}