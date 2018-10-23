package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.entity.User;
import harry.dubbo.service.IUserService;

/**
 * 
 * @author harry
 *
 */
@Service
public class UserService implements IUserService {

	public User getUser(Integer id,String name) {
		System.out.println("new...");
		return new User(id,name);
	}
}
