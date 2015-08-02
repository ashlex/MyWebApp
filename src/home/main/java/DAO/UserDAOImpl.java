package home.main.java.DAO;

import home.main.java.hibernate.HibernateUtil;
import home.main.java.User.Entity.User;
import org.hibernate.Session;

public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public boolean verification(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.get(User.class, user.getLogin());
        } catch (Exception e) {
            LOG.error(e);
        }
        return false;
    }

    @Override
    public boolean add(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error(e);
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(session.load(User.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error(e);
            return false;
        }
    }

    @Override
    public boolean remove(String login) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            int result = session.createQuery("delete from User where login=:login").setParameter("login", login).executeUpdate();
            session.getTransaction().commit();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        return false;
    }
}
