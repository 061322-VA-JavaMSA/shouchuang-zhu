package daos;

import java.util.List;

import org.hibernate.Session;

import models.User;
import utils.HibernateUtil;

public class UserHibernate implements UserDao {
	public List<User> getUsers() {
		List<User> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}
}
