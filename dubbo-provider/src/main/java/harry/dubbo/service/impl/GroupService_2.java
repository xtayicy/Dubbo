package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.service.IGroupService;

/**
 * 
 * @author harry
 *
 */
@Service("groupService_2")
public class GroupService_2 implements IGroupService {

	public String[] getStringArray() {
		return new String[]{"c","d"};
	}
}
