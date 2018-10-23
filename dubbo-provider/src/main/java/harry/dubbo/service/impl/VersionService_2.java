package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.service.IVersionService;

/**
 * 
 * @author harry
 *
 */
@Service("versionService_2")
public class VersionService_2 implements IVersionService {

	public Integer getVersion() {
		return 2;
	}
}
