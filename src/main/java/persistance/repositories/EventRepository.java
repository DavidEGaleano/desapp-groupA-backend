package persistance.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import model.Event;
import model.Profile;

public class EventRepository extends HibernateGenericDAO<Event> implements GenericRepository<Event> {
    private static final long serialVersionUID = -4036535812105672110L;
    //redefinir
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> filterEvent(final String pattern) {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Profile.class);
                criteria.add(Restrictions.like("name", "%" + pattern + "%"));
                return criteria.list();
            }

        });
    }

    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }
}
