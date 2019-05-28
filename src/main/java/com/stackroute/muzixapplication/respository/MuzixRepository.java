package com.stackroute.muzixapplication.respository;

import com.stackroute.muzixapplication.domain.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MuzixRepository extends MongoRepository<Album,Integer> {

}
