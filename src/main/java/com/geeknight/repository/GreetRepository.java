package com.geeknight.repository;

import com.geeknight.model.Greet;
import org.springframework.data.repository.CrudRepository;

public interface GreetRepository extends CrudRepository<Greet,Long> {

}
