package com.Javaguide.springbootrestapiwithDB.Repository;

import com.Javaguide.springbootrestapiwithDB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface UserRepository extends JpaRepository<User,String> {

}
