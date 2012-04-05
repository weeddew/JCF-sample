package business.sample.action;

import java.util.List;
import java.util.Map;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;
import jcf.sua.ux.webflow.mvc.WebFlowRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import business.sample.user.model.User;
import business.sample.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	private Log logger =
		LogFactory.getLog(getClass());

	@Autowired
	private UserService  userService;




	@RequestMapping("/create")
	public void createform(MciRequest request,
			MciResponse response){
		response.setViewName("/user/create");

	}

	/**
	 *JSON 요청일 경우에 Client에서 Content-Type/application/json+sua 으로 요청 보냄
	 * @param request
	 * @param response
	 */
	@RequestMapping("/selectUsers")
	public void selectUsers(MciRequest request,
			MciResponse response){
		List list =userService.selectUsers(request.getParam());
		response.setList("userList", list);

		response.setViewName("/user/list");

	}

	@RequestMapping("/view")
	public void selectUser(MciRequest request,
			MciResponse response){
		Map searchMap =request.getParam();
		Map user =	userService.selectUser(searchMap);
		response.set("user", user);
		response.setViewName("/user/view");


	}
	@RequestMapping("/insert")
	public void insertUser(MciRequest request,
			MciResponse response){
		User user = request.getParam(User.class);
		userService.insertUser(user);
		response.setViewName("redirect:selectUsers.action");
	}

	@RequestMapping("/update")
	public void update(MciRequest request,
			MciResponse response){
		User user = request.getParam(User.class);
		userService.updateUser(user);
		response.setViewName("redirect:selectUsers.action");
	}

	@RequestMapping("/delete")
	public void delete(MciRequest request,
			MciResponse response){
		User user = request.getParam(User.class);
		userService.deleteUser(user);
		response.setViewName("redirect:selectUsers.action");
	}



}
