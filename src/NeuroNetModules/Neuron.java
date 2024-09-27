package NeuroNetModules;

import java.util.ArrayList;

public class Neuron implements INeuronable {
    public ArrayList<Synapse> Synapsyes = new ArrayList<Synapse>();
    private double _result = 0.0;
    public double Error = 0.0;

    @Override
    public double GetResult() {
        return _result;
    }

    public static double Activate(double x){
        return 1 / (1 + Math.pow(Math.E, x));
    }

    public void AddSynapse(Synapse synapse){
        Synapsyes.add(synapse);
    }

    public void DoActivate(){
        var sum = Synapsyes.stream()
                .mapToDouble(x -> x.ChildNeuron.GetResult() * x.Weight)
                .sum();
        _result = Activate(sum);
    }
}
