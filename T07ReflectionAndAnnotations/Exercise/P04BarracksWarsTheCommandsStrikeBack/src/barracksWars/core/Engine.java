package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

	private static final String COMMANDS_CLASS_PATH = "barracksWars.core.commands.";
	private static final String METHOD_EXECUTE = "execute";

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) {
		String result = "";
		String commandClassFullName = COMMANDS_CLASS_PATH + data[0].substring(0, 1).toUpperCase() + data[0].substring(1);
		try {
			Class commandClass = Class.forName(commandClassFullName);
			Constructor<Command> commandConstructor = commandClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			Command commandInstance = commandConstructor.newInstance(data, this.repository, this.unitFactory);
			Method executeMethod = commandClass.getDeclaredMethod(METHOD_EXECUTE);
			try {
				result = (String) executeMethod.invoke(commandInstance);
			} catch (InvocationTargetException ex) {
				return ex.getCause().getMessage();
			}
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
