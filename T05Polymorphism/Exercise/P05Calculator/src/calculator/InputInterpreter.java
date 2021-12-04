package calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> memory;

    public InputInterpreter(CalculationEngine engine, ArrayDeque<Integer> memory){
        this.engine = engine;
        this.memory = memory;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }

        if (operation.equals("/")) {
            return new DivisionOperation();
        }

        if (operation.equals("ms")) {
            return new MemorySaveOperation(this.memory);
        }

        if (operation.equals("mr")) {
            return new MemoryRecallOperation(this.memory);
        }

        return null;
    }
}
