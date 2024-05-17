package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.userRepository;
import com.jpa.test.entities.user;

@SpringBootApplication
public class BootjpaexApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexApplication.class, args);
	  userRepository userRepository=context.getBean(userRepository.class);
	  
	  //insert single user
//	  user user=new user();
//	  user.setName("prit");
//	  user.setStatus("i am happay");
//	  user.setCity("vadodra");
//	  
//	  user user1=userRepository.save(user);
//	  System.out.println(user1);
	  
	  //insert multipel users using saveAll
//	  user user1=new user();
//	  user1.setName("yash");
//	  user1.setStatus("i am happay");
//	  user1.setCity("anad");
//	  
//	  user user2=new user();
//	  user2.setName("jeet");
//	  user2.setStatus("i am happay");
//	  user2.setCity("anad");
//	  List<user> users=List.of(user1,user2);
//	  
//	  Iterable<user> result=userRepository.saveAll(users);
//	  System.out.println(result);
	  
	  //update the value
//	 Optional<user> optional=userRepository.findById(1);
//	 user user=optional.get();
//	 user.setStatus("i am spring boot devloper");
//	 user result=userRepository.save(user);
//	 System.out.println(result);
	  
	  //findall method read opration
	  //how to get the data 
//	  Iterable<user> itr=userRepository.findAll();
//	  itr.forEach(user->{System.out.println(user);});   //lamda function in saide foreach loop 
	  
	  //deleting the suer element 
//	  userRepository.deleteById(52);
//	  System.out.println("deleted");
	  
	  //delete all the data 
//	  Iterable<user> allusers=userRepository.findAll();
//	  allusers.forEach(user->System.out.println(user));
//	  
//	  userRepository.deleteAll(allusers);
//	  System.out.println("deleted");
	  
	  //custom finder
	  //byname
//	  List<user> users=userRepository.findByName("prit");
//	  users.forEach(user->System.out.println(user));
	  //by name and city
//	  List<user> user1=userRepository.findByNameAndCity("prit","vadodra");
//	  user1.forEach(user->System.out.println(user));
	  
	  //using @query and @param
//	  List<user> user1=userRepository.getAllUser();
//	  user1.forEach(user->System.out.println(user));
	  
//	  List<user> user1=userRepository.getUserByName("yash");
//	  user1.forEach(user->System.out.println(user));
	  
	  //using native query
	  List<user> user1=userRepository.getUsers();
	  user1.forEach(user->System.out.println(user));
	  
	  
	}

}
