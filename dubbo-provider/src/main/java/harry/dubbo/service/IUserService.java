package harry.dubbo.service;

import harry.dubbo.entity.User;

/**
 * 
 * @author harry
 *
 */
public interface IUserService {
	public User getUser(Integer id,String name);
}
