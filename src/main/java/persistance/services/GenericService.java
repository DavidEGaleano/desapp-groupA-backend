package persistance.services;

import java.io.Serializable;
import java.util.List;
import persistance.repositories.GenericRepository;

import org.springframework.transaction.annotation.Transactional;


public class GenericService<T> implements Serializable {

    private static final long serialVersionUID = -6540963495078524186L;

    private GenericRepository<T> repository;

    public GenericRepository<T> getRepository() {
        return this.repository;
    }

    public void setRepository(final GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Transactional
    public void delete(final T object) {
        this.getRepository().delete(object);
    }

    @Transactional(readOnly = true)
    public List<T> retriveAll() {
        return this.getRepository().findAll();
    }

    @Transactional
    public void save(final T object) {
        this.getRepository().save(object);
    }

    @Transactional
    public void update(final T object) {
        this.getRepository().update(object);
    }
    
    @Transactional
    public void deleteAll(){
    	List<T> values = this.getRepository().findAll();
    	for(int i=0; i<values.size();i++){
    		this.delete(values.get(i));
    	}
    }
    
    @Transactional
    public T getById(final Integer id){
    	return this.getRepository().findById(id);
    }

}

