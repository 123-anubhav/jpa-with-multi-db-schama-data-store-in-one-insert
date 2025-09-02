package in.anubhav.jpa.db1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.anubhav.entity.Result;

@Repository
public interface IResultDaoDb1 extends JpaRepository<Result, Integer>{

}
