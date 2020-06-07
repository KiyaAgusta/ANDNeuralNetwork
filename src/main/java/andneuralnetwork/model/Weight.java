package andneuralnetwork.model;

import java.text.DecimalFormat;
import java.util.Random;

public class Weight {
    double[] value;
    
    public Weight(int length, boolean generator) {
        this.value = new double[length];
        
        if(generator) {
            for (int i = 0; i < length; i++)
                this.value[i] = generateRandom(-1, 1);
        }
    }

    public void setValue(double value, int index) {
        this.value[index] = value;
    }
    
    public double getValue(int index) {
        return value[index];
    }
    
    public String getValueString(int index) {
        return getDecimalFormat(value[index]);
    }

    private double generateRandom(double minimal, double maximal) {
        Random r = new Random();
        return (r.nextInt((int) ((maximal - minimal) * 10 + 1)) + minimal *10) / 10.0;
    }
    
    private String getDecimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.#####");
        
        return df.format(number);
    }
    
    @Override
    public String toString() {
        String string = "";
        
        for (int i = 0; i < value.length; i++)
            string += "Weight " + (i+1) + " = "+ getDecimalFormat(this.value[i]) + "\n";
        
        return string;
    } 
}
