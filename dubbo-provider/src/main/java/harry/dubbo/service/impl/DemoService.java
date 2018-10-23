package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.entity.Computer;
import harry.dubbo.entity.User;
import harry.dubbo.service.IDemoService;

/**
 * 
 * @author harry
 *
 */
@Service
public class DemoService implements IDemoService {

	public User queryUser(Integer id) {
		User user = new User(id,"tom");
		user.setComputer(new Computer(id, "computer"));
		
		return user;
	}

}
