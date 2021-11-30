package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_CLASS_PATH = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;
        String commandClassFullName = COMMANDS_CLASS_PATH + data[0].substring(0, 1).toUpperCase() + data[0].substring(1);
        try {
            Class<?> commandClass = Class.forName(commandClassFullName);
            Constructor<?> commandConstructor = commandClass.getDeclaredConstructor(String[].class);
            executable = (Executable) commandConstructor.newInstance((Object) data);
            setFields(executable);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return executable;
    }

    private void setFields(Executable executable) throws IllegalAccessException {
        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] localFields = this.getClass().getDeclaredFields();

        for (Field field : executableFields) {
            field.setAccessible(true);
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                for (Field localField : localFields) {
                    if (localField.getType() == field.getType()) {
                        field.set(executable, localField.get(this));
                    }
                }
            }
        }
    }
}
