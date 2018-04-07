package Application.Dao;


 
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Application.entity.autodialer_log;  
  

  
@Repository  
@Table(name = "autodialer_log")
public interface LogDao extends JpaRepository<autodialer_log,String>{  
  
	  
    
} 