package home.main.java;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
	Map<String, ICommand> commands;

	public Invoker() {
		commands = new HashMap<String, ICommand>();
	}

	public boolean addCommand(String key, ICommand command) {
		if (key != null && !key.isEmpty() && command != null) {
			commands.put(key, command);
			return true;
		}
		return false;
	}

	public boolean addCommandsRange(Map<String, ICommand> commands) {
		if (commands != null) {
			this.commands.putAll(commands);
			return true;
		}
		return false;
	}

	public boolean findAndExecute(String key) {
		if (key == null) {
			return false;
		}
		ICommand command = commands.get(key);
		if (command != null) {
			command.execute();
			return true;
		}
		return false;
	}
}
