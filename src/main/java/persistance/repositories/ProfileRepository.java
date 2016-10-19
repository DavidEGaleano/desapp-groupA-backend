package persistance.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import model.Profile;

public class ProfileRepository extends HibernateGenericDAO<Profile> implements GenericRepository<Profile> {
    private static final long serialVersionUID = -4036535812105672110L;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Profile> filterProfile(final String pattern) {
        return (List<Profile>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<Profile> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Profile.class);
                criteria.add(Restrictions.like("name", "%" + pattern + "%"));
                return criteria.list();
            }

        });
    }

    @Override
    protected Class<Profile> getDomainClass() {
        return Profile.class;
    }
}
