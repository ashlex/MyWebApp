package home.tests.java.DAO;

import home.main.java.DAO.UserDAO;
import home.main.java.DAO.UserDAOImpl;
import home.main.java.User.Entity.User;
import junit.framework.TestCase;

public class UserDAOImplTest extends TestCase {

	public void testVerification() throws Exception {
		UserDAO dao = new UserDAOImpl();
		assertFalse(dao.verification(new User()));
	}

	public void testAdd() throws Exception {
		UserDAO dao = new UserDAOImpl();
		User user = new User();
		user.setName("Alexej");
		user.setLogin("login");
		user.setPassword("password");
		assertTrue(dao.add(user));
	}

	public void testRemoveByLogin() throws Exception {

		UserDAO dao = new UserDAOImpl();
		User user = new User();
		user.setName("Alexej");
		user.setLogin("test");
		user.setPassword("password");
		assertTrue(dao.add(user));
		assertTrue(dao.remove("test"));
	}
}