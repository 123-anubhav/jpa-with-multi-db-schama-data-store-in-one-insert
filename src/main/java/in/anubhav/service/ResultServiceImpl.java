package in.anubhav.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import in.anubhav.entity.Result;
import in.anubhav.jpa.db1.IResultDaoDb1;
import in.anubhav.jpa.db2.IResultDaoDb2;

@Service
public class ResultServiceImpl implements IResultService {

	private final IResultDaoDb1 resultDaoDb1;
	private final IResultDaoDb2 resultDaoDb2;

	public ResultServiceImpl(IResultDaoDb1 resultDaoDb1, IResultDaoDb2 resultDaoDb2) {
		this.resultDaoDb1 = resultDaoDb1;
		this.resultDaoDb2 = resultDaoDb2;
	}

	@Transactional
	public Result saveUser(Result result) {
		Result saved1 = resultDaoDb1.save(result);
		resultDaoDb2.save(result); // insert into second DB
		return saved1;
	}
}
