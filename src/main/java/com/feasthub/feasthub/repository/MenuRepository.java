package com.feasthub.feasthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.feasthub.feasthub.entity.MenuItem;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem,Long>{
    
}
