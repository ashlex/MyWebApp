package home.tests.DAO;

import home.main.DAO.UserDAO;
import home.main.DAO.UserDAOImpl;
import home.main.User.Entity.User;
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

	public void testRemove() throws Exception {
		UserDAO dao = new UserDAOImpl();
		assertTrue(dao.remove(1));
	}
}