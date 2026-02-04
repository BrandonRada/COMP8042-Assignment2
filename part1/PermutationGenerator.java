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
    public Integer[] largestSmallerNumbers(){
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
