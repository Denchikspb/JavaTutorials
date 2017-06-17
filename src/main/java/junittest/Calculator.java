package junittest;

/**
 * Created by Денис on 17.06.2017.
 */
public class Calculator {
    private int firstNumber;
    private int secondNumber;

    public Calculator(){

    }

    Calculator(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int calculateSum(){
        return (firstNumber + secondNumber);
    }
}
