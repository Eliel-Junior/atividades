package br.upe.pii.exemplo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalDAO extends CrudRepository<Local, Long>{
	

}
