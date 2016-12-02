package persistance.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import model.Profile;
import model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {
    private static final long serialVersionUID = -4036535812105672110L;
    //redefinir
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<User> filterRepository(final String pattern) {
        return (List<User>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<User> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Profile.class);
                criteria.add(Restrictions.like("name", "%" + pattern + "%"));
                return criteria.list();
            }
        });
    }

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> obtainUserWithToken(String token) {
        return (List<User>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<User> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("token", token));
                return criteria.list();
            }
        });
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> obtainUserWithEmail(String email) {
        return (List<User>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<User> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("mail", email));
                return criteria.list();
            }
        });
    }
}
