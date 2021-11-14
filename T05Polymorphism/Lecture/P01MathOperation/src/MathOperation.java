public class MathOperation {
    public int add(int first, int second) {
        return first + second;
    }

    public int add(int first, int second, int third) {
        return add(add(first, second), third );
    }

    public int add(int first, int second, int third, int forth) {
        return add(add(first, second, third), forth);
    }
}
