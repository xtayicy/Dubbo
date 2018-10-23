package harry.dubbo.service;

import java.io.Serializable;

import harry.dubbo.entity.User;

/**
 * 
 * @author harry
 *
 */
public interface CallbackListener extends Serializable {
	public User getUser(User user);
}
