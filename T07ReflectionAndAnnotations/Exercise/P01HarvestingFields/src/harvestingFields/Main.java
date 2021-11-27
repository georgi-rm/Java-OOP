package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		Field[] allDeclaredFields = RichSoilLand.class.getDeclaredFields();

		while (!input.equals("HARVEST")) {
			switch (input) {
				case "private":
					printFields(allDeclaredFields, e -> Modifier.isPrivate(e.getModifiers()));
					break;
				case "protected":
					printFields(allDeclaredFields, e -> Modifier.isProtected(e.getModifiers()));
					break;
				case "public":
					printFields(allDeclaredFields, e -> Modifier.isPublic(e.getModifiers()));
					break;
				case "all":
					printFields(allDeclaredFields, e -> true);
					break;
			}


			input = scanner.nextLine();
		}

	}

	public static void printFields(Field[] fields, Predicate<Field> fieldPredicate) {
		Arrays.stream(fields)
				.filter(fieldPredicate)
				.forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers())
						, f.getType().getSimpleName(), f.getName()));
	}
}
