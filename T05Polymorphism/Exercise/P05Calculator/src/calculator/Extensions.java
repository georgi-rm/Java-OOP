package calculator;

import java.util.ArrayDeque;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine, ArrayDeque<Integer> memory) {
        return new InputInterpreter(engine, memory);
    }
}
