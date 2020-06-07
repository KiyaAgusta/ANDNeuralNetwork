package andneuralnetwork.controller;

import andneuralnetwork.model.*;

public class Trainer {
    private final int epoch;
    private final double meu;
    private final ANDNeuralNetwork nlp;
    private final Perceptron perceptron;
    private int epochCount;
    
    public Trainer(int epoch, double meu) {
        this.epoch = epoch;
        this.meu = meu;
        
        nlp = new ANDNeuralNetwork();
        perceptron = new Perceptron();
    }
    
    public String train() {
        String string = "";
        int[] input = new int[nlp.getTotalInput()];
        
        for (int iteration = 1; iteration <= epoch; iteration++) {
            string += "\nEPOCH " + iteration + "\n";
            int errorCount = 0;
            
            for (int i = 0; i < nlp.getTarget().length; i++) {
                string += perceptron;
                input = nlp.getInput(i);
                int output = perceptron.getOutput(input);
                
                string += "Output = " + output + "\n" +
                          "Target = " + nlp.getTarget()[i] + "\n";
                
                if (output != nlp.getTarget()[i]) {
                    errorCount++;
                    double error = nlp.getTarget()[i] - output;
                    
                    if (error != 0) {
                        Weight weight = perceptron.getWeight();
                        Weight newWeight = new Weight(3, false);
                        double value;
                        
                        for (int j = 0; j < nlp.getTotalInput(); j++) {
                            value = weight.getValue(j) + (meu * input[j] * error);
                            newWeight.setValue(value, j);
                        }
                            
                        perceptron.setWeight(newWeight);
                    }
                }
            }

            string += "TOTAL " + errorCount + " ERROR!\n";
            
            if (errorCount == 0) {
                epochCount = iteration;
                break;
            }

            epochCount = iteration;
        }
        
        return string;
    }
    
    public Perceptron getPerceptron() {
        return perceptron;
    }
    
    public int getEpochCount() {
        return epochCount;
    }
    
    @Override
    public String toString() {
        return "\nFINAL RESULT\n" + perceptron + "\n" +
               "LAST DATA IN EPOCH " + epochCount;
    }
}
