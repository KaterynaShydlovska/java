package com.katerynashydlovska.redbelt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.katerynashydlovska.redbelt.models.Idea;


@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{

}
