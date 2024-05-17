package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.user;

public interface userRepository extends CrudRepository<user, Integer>{
          
	 //delete or update things using name or any other fildusing custom finder and query_methods
	//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	      public List<user> findByName(String name);  //here naming is big thing to take care 
          
          public List<user> findByNameAndCity(String name,String city);       //here And qery_methods  is userd there are other mathods also to add in name 
          
          //@query and @param
          @Query("select u From user u")
          public List<user> getAllUser();
          
          @Query("select u from user u where u.name=:n")
          public List<user> getUserByName(@Param("n") String name);  //for binding name with parameter @param is used
          
          @Query(value="select * from user",nativeQuery = true)  //for use native sqlquery 
          public List<user> getUsers();
          
          
}
