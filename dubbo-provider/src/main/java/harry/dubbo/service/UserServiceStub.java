package harry.dubbo.service;

import harry.dubbo.entity.User;

/**
 * 
 * @author harry
 *
 */
public class UserServiceStub implements IUserService {
	private IUserService userService;
	
	public UserServiceStub(IUserService userService){
		this.userService = userService;
	}

	public User getUser(Integer id, String name) {
		return null;
	}

}
