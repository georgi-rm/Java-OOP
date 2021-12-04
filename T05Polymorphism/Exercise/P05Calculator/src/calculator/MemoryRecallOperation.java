package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MemoryRecallOperation implements Operation {
    private final ArrayDeque<Integer> memory;

    public MemoryRecallOperation(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return !this.memory.isEmpty();
    }
}
