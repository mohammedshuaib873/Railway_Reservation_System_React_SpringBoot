package com.RailwayUserManagenet.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.RailwayUserManagenet.model.UserSignUp;

/**
 * @author Mohammed Shuaib A T
 *This Interface Is Used For Adding MongoRepository Which Acts As A Database
 */
@Repository
public interface UserSignUpRepository extends MongoRepository<UserSignUp, Integer> {

}
