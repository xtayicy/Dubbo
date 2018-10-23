package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.entity.Computer;
import harry.dubbo.entity.User;
import harry.dubbo.service.CallbackListener;
import harry.dubbo.service.IComputerService;

/**
 * 
 * @author harry
 *
 */
@Service
public class ComputerService implements IComputerService {

	public Computer getComputer(String username, CallbackListener callbackListener) {
		User user = new User("tom");
		user = callbackListener.getUser(user);
		user.getComputer().setId(1);
		System.out.println(user.getComputer());
		
		return user.getComputer();
	}

}
