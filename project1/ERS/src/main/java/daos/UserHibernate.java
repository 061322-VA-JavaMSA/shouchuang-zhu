package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import models.User;
import utils.HibernateUtil;

public class UserHibernate implements UserDao {
	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			// define entity to be searched
			Root<User> root = cq.from(User.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("username"), username);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			user = (User) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}
	
	public List<User> getUsers() {
		List<User> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}

	@Override
	public void updateUser(User u) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			String str = "Update User set email = :email," + "firstName = :fname," + "lastName = :lname " + "where id = :id";
			Transaction txn = s.beginTransaction();
			Query query = s.createQuery(str);
			
			query.setParameter("email", u.getEmail());
			query.setParameter("fname", u.getFirstName());
			query.setParameter("lname", u.getLastName());
			query.setParameter("id", u.getId());
			query.executeUpdate();
			txn.commit();
			
		}
		
	}
}
