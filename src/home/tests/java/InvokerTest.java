package home.tests.java;

import org.junit.Assert;
import org.junit.Test;

import home.main.java.ICommand;
import home.main.java.Invoker;

import java.util.HashMap;
import java.util.Map;

public class InvokerTest extends Assert {

	@Test
	public void testAddCommand() throws Exception {
		Invoker invoker = new Invoker();
		assertFalse(invoker.addCommand(null, null));
		assertFalse(invoker.addCommand("key", null));
		assertFalse(invoker.addCommand(null, createCommandMock()));
		assertFalse(invoker.addCommand("", createCommandMock()));
		assertTrue(invoker.addCommand("key", createCommandMock()));
		assertTrue(invoker.findAndExecute("key"));
	}

	@Test
	public void testAddCommandsRange() throws Exception {
		Invoker invoker = new Invoker();
		Map<String, ICommand> commands = new HashMap<String, ICommand>();
		for (int i = 0; i < 10; i++)
			commands.put(Integer.toString(i), createCommandMock());
		assertTrue(invoker.addCommandsRange(commands));
		assertFalse(invoker.addCommandsRange(null));
			assertTrue(invoker.findAndExecute(Integer.toString(0)));
			assertTrue(invoker.findAndExecute(Integer.toString(1)));
			assertTrue(invoker.findAndExecute(Integer.toString(2)));
			assertTrue(invoker.findAndExecute(Integer.toString(3)));
			assertTrue(invoker.findAndExecute(Integer.toString(4)));
			assertTrue(invoker.findAndExecute(Integer.toString(5)));
			assertTrue(invoker.findAndExecute(Integer.toString(6)));
			assertTrue(invoker.findAndExecute(Integer.toString(7)));
			assertTrue(invoker.findAndExecute(Integer.toString(8)));
			assertTrue(invoker.findAndExecute(Integer.toString(9)));
	}
	@Test
	public void testFindAndExecute() throws Exception {
		Invoker invoker=new Invoker();
		assertFalse(invoker.findAndExecute(null));
		assertFalse(invoker.findAndExecute("12"));
		assertTrue(invoker.addCommand("key",createCommandMock()));
		assertTrue(invoker.findAndExecute("key"));
	}

	public ICommand createCommandMock() {
		return new ICommand() {
			@Override
			public void execute() {

			}
		};
	}
}