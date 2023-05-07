package domain;

public class OperationMultiply implements Operation {

    @Override
    public long operate(long op1, long op2) {
        return op1 * op2;
    }

    @Override
    public String getName() {
        return " multiply ";
    }

}
