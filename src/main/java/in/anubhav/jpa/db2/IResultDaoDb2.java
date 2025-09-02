package in.anubhav.jpa.db2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.anubhav.entity.Result;

@Repository
public interface IResultDaoDb2 extends JpaRepository<Result, Integer> {

}
