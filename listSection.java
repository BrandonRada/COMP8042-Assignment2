import java.util.Random;

class PermutationGenerator{
    private int size;
    private int[] inputList;
    private Random rand = new Random();

    public PermutationGenerator(int n){
        this.size = n;
        this.inputList = new int[n];

        for (int i = 0; i < n; i++){
            inputList[i] = i;
        }
    }

    public PermutationGenerator(int[] inputList){
        this.size = inputList.length;
        // Clone just so we dont modify the original list.
        this.inputList = inputList.clone();
    }

    // My method for finding the smallest larger number for each index i O(n^2).
    public Integer[] smallestLargerNumbers(){
        Integer[] outputList = new Integer[size];

        for (int i = 0; i < size; i++){
            Integer bestValue = null;

            for (int j = i + 1; j < size; j++){
                if (inputList[j] > inputList[i]){
                    if (bestValue == null || inputList[j] < bestValue){
                        bestValue = inputList[j];
                    }
                }
                
            }
            outputList[i] = bestValue;
        }
        return outputList;
    }

    // My method for finfing the largest smaller number for each index i O(n^2).
    public Integer[] largestSmallestNumbers(){
        Integer[] outputList = new Integer[size];

        for (int i = 0; i < size; i++){
            Integer bestValue = null;

            for (int j = i + 1; j < size; j++){
                if (inputList[j] < inputList[i]){
                    if (bestValue == null || inputList[j] > bestValue){
                        bestValue = inputList[j];
                    }
                }
            }
            outputList[i] = bestValue;
        }
        return outputList;
    }

    /** My function for shuffling an array
     * This shuffle function uses the Fisher-Yates shuffle algorithm.
     */
    public void shuffle(){
        for (int i = size -1; i > 0; i--){
            int j = rand.nextInt(i + 1);
            int temp = inputList[i];
            inputList[i] = inputList[j];
            inputList[j] = temp;
        }
    }

    // Purely for the testListSection code to access the shuffled input list.
    public int[] getInputList(){
        return inputList;
    }

}



/**
1. You are faced with a problem - you have been given a list L of n integers which are some
permutation of the numbers 0, 1, 2, ... , n-1. We want to generate a new list L new of size
n that contains (at each L new[i]) the smallest number in L located after position i that is larger
than L[i]. If no number exists set L new[i] to be null.
Example: L = [1,0,6,4,2,3,5] L new = [2,2,null,5,3,5,null]
Assume that once a Permutation object is created for a certain size n we will reshuffle multiple
times and use the method defined above after each reshuffle. I want you to implement the code
without doing any sorting.
Note: Don’t name your lists as they appear in the code, implement with whatever list data
structure(s) you want.


2. Write code to reshuffle.


3. Justify the decisions you made for your implementation in part 1 and state the Big-O runtime
complexity of algorithm.


4. Given a list L of n integers which are some permutation of the numbers 0, 1, 2, ... , n-1. Use the
same data structures you chose in part 1 to write a method that generates a new list of size n
that contains the largest number in L located after position i that is smaller than L[i].
Example: L = [1,0,6,4,2,3,5] L new = [0,null,5,3,null,null,null]

 */