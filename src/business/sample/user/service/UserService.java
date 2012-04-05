package business.sample.user.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.dao.CommonDAO;
import business.sample.user.model.User;

@Service
public class UserService {
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private CommonDAO dao;

	public  List selectUsers(Map searchMap){
		List list = dao.queryForList("user.selectUsers",	searchMap);
		return list;

	}


	public  Map selectUser(Map searchMap){
		Map user = (Map) dao.queryForObject("user.selectUser",	searchMap);
		return user;

	}

	public void insertUser(User user){
		dao.update("user.insertUser", user);
	}
	public void updateUser(User user){
		dao.update("user.updateUser", user);
	}
	public void deleteUser(User user){
		dao.update("user.deleteUser", user);
	}


}
