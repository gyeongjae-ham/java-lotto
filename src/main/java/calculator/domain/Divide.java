package calculator.domain;

public class Divide implements Operator{
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
