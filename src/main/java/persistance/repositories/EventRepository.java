package persistance.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import kind.Kind;
import model.Event;

public class EventRepository extends HibernateGenericDAO<Event> implements GenericRepository<Event> {
    private static final long serialVersionUID = -4036535812105672110L;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> obtainEconomicEvents(final int limit) {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                criteria.add(Restrictions.between("amount",0,limit));
                return criteria.list();
            }

        });
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> obtainEventsWithLimitOfPersons(final int limit) {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                criteria.add(Restrictions.between("limitOfPersons",limit,9999));
                return criteria.list();
            }

        });
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> obtainEventsForTypesEvents( List<Kind> listofkinds) {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {

            public List<Event> doInHibernate(final Session session) throws HibernateException {           	
                Criteria criteria = session.createCriteria(Event.class);
                //criteria.add(Restrictions.in("types",list));               
                return criteria.list();           

            }

        });
    }

    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }

}
