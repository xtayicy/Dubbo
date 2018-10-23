package harry.dubbo.service;

import harry.dubbo.entity.Computer;

/**
 * 
 * @author harry
 *
 */
public interface IComputerService {
	public Computer getComputer(String username,CallbackListener callbackListener);
}
