package NeuroNetModules;

public class Input implements INeuronable{
    private double _value = 0.0;

    public void SetValue(double value){
        _value = value;
    }

    @Override
    public double GetResult() {
        return _value;
    }
}
