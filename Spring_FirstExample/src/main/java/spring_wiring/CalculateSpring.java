package spring_wiring;

import domain.Operation;
import domain.ResultWriter;

public class CalculateSpring {

    private Operation ops;
    private ResultWriter writer;

    public void setOps(Operation ops) {
        this.ops = ops;
    }

    public Operation getOps() {
        return ops;
    }

    public void setWriter(ResultWriter writer) {
        this.writer = writer;
    }

    public ResultWriter getWriter() {
        return writer;
    }

    public void execute(String[] numbers) {
        long op1 = Long.parseLong(numbers[0]);
        long op2 = Long.parseLong(numbers[1]);
        writer.showResult(String.format("The result of %s%s%s is %s!",
        		op1, ops.getName(), op2, ops.operate(op1, op2)));
    }
}