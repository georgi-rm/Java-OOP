package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers) {
            if (doesStringContainsLetter(number)) {
                stringBuilder.append("Invalid number!");
            } else {
                stringBuilder.append("Calling... ").append(number);
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            if (doesStringContainsDigits(url)) {
                stringBuilder.append("Invalid URL!");
            } else {
                stringBuilder.append("Browsing: ").append(url)
                        .append("!");
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private boolean doesStringContainsDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean doesStringContainsLetter(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
