package home.main.java.DAO;

import home.main.java.User.Entity.User;

public interface UserDAO {
	boolean verification(User user);
	boolean add(User user);
	boolean remove(int id);
	boolean remove(String login);
}
