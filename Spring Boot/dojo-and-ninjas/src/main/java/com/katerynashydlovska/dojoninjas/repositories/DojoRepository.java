package com.katerynashydlovska.dojoninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.katerynashydlovska.dojoninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{

}
