package andneuralnetwork.model;

public final class ANDNeuralNetwork {
    private static final int[] target = {0, 0, 0, 1};
    private static final int totalInput = 3;
    private static final int[][] input = {{1, 0, 0},
                                          {1, 0, 1},
                                          {1, 1, 0},
                                          {1, 1, 1}};

    public static int[] getTarget() {
        return target;
    }

    public static int getTotalInput() {
        return totalInput;
    }

    public static int[] getInput(int index) {
        return input[index];
    }
}
