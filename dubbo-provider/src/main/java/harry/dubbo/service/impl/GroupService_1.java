package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.service.IGroupService;

/**
 * 
 * @author harry
 *
 */
@Service("groupService_1")
public class GroupService_1 implements IGroupService {

	public String[] getStringArray() {
		return new String[]{"a","b"};
	}
}
