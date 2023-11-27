package com.feasthub.feasthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.feasthub.feasthub.entity.MenuItem;
import com.feasthub.feasthub.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
