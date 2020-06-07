package andneuralnetwork.model;

public class Perceptron {
    double treshold;
    Weight weight;
 
    public Perceptron() {
        treshold = 0;
        weight = new Weight(3, true);
    }
    
    public int getOutput(int[] input) {
        double summation = 0;
        
        for (int i = 0; i < input.length; i++)
            summation += weight.value[i] * input[i];
            
        if(summation < treshold)
            return 0;
        else
            return 1;
    } 

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Weight getWeight() {
        return weight;
    }
    
    @Override
    public String toString() {
        String string = "--------------------" + "\n";
        string += weight;
        return string;
    }
}
