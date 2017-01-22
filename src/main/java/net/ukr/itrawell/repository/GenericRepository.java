package net.ukr.itrawell.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends Repository<T, ID> {

    void delete(T instance);
    
    List<T> findAll();
    
    Optional<T> findOne(ID id);
    
    T save(T instance);
    
}
