package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MemorySaveOperation implements Operation {
    private final ArrayDeque<Integer> memory;

    public MemorySaveOperation(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        if (this.memory.isEmpty()) {
            return 0;
        }
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
