# Spring Boot JPA CRUD Application

This project demonstrates a Spring Boot application with JPA for performing CRUD operations. It includes examples of custom finder methods, using `@Query` and `@Param` annotations, and executing native queries.

## Prerequisites

- Java 8 or higher
- Maven
- Spring Boot

## Getting Started

To run this application, follow these steps:

1. Clone the repository (if applicable)
    ```bash
    git clone <repository-url>
    ```

2. Navigate to the project directory
    ```bash
    cd <project-directory>
    ```

3. Build and run the application
    ```bash
    mvn spring-boot:run
    ```

## Application Structure

### `BootJpaexApplication.java`
Provide a brief description of this file here. For example:
This is the main class for the Spring Boot application. It contains the `main` method which serves as the entry point for the application.    

### `userRepository.java`
This interface extends `CrudRepository` and includes custom finder methods and queries. 

### `user.java`
This is the entity class representing the `user` table. 

# CRUD Operations

## Create

To create a new user, you can use the `save` method:

```java
user user = new user();
user.setName("prit");
user.setStatus("I am happy");
user.setCity("Vadodara");

user savedUser = userRepository.save(user);
System.out.println(savedUser);
```

# Read

To read users, you can use the `findAll` method:

```java
Iterable<User> users = UserRepository.findAll();
users.forEach(user -> System.out.println(user));
```
To read a user by ID, you can use the `findById` method:
```java
Optional<user> user = userRepository.findById(1);
user.ifPresent(System.out::println);
```
# Update

To update a user, fetch the user by ID, modify the fields, and save it back:

```java
Optional<user> optional = userRepository.findById(1);
if (optional.isPresent()) {
    user user = optional.get();
    user.setStatus("I am a Spring Boot developer");
    user updatedUser = userRepository.save(user);
    System.out.println(updatedUser);
}
```

# Delete

To delete a user by ID:

```java
userRepository.deleteById(1);
System.out.println("User deleted");

```
To delete all users:

```java
Iterable<user> allUsers = userRepository.findAll();
userRepository.deleteAll(allUsers);
System.out.println("All users deleted");
```
## Custom Finder Methods
### Find by Name
#### In BootJpaexApplication.java
```java
List<user> usersByName = userRepository.findByName("prit");
usersByName.forEach(user -> System.out.println(user));

```
#### In userRepository.java
```java
public List<user> findByName(String name); 
```
### Find by Name and City
#### In BootJpaexApplication.java
```java
List<user> usersByNameAndCity = userRepository.findByNameAndCity("prit", "Vadodara");
usersByNameAndCity.forEach(user -> System.out.println(user));
```
#### In userRepository.java
```java
 public List<user> findByNameAndCity(String name,String city);  
```
## Using @Query and @Param
### Get All Users
#### In userRepository.java
```java
@Query("select u From user u")
public List<user> getAllUser();
```

#### In BootJpaexApplication.java
```java
List<user> usersByName = userRepository.findByName("prit");
usersByName.forEach(user -> System.out.println(user));

```
### Get User by Name
#### In userRepository.java
```java
@Query("select u from user u where u.name=:n")
public List<user> getUserByName(@Param("n") String name);
```

#### In BootJpaexApplication.java
```java
List<user> usersByName = userRepository.getUserByName("yash");
usersByName.forEach(user -> System.out.println(user));

```
## Using Native Query
### Get Users
#### In userRepository.java
```java
@Query(value="select * from user",nativeQuery = true)  
public List<user> getUsers();
```

#### In BootJpaexApplication.java
```java
List<user> nativeUsers = userRepository.getUsers();
nativeUsers.forEach(user -> System.out.println(user));

```
## Conclusion
This project demonstrates basic and advanced CRUD operations using Spring Boot and JPA. You can extend this application by adding more complex queries, integrating with other services, or improving the existing functionality.
