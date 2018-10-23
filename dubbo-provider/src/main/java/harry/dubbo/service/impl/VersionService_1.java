package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import harry.dubbo.service.IVersionService;

/**
 * 
 * @author harry
 *
 */
@Service("versionService_1")
public class VersionService_1 implements IVersionService {

	public Integer getVersion() {
		return 1;
	}
}
