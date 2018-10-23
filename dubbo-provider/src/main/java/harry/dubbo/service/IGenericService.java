package harry.dubbo.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * 
 * @author harry
 *
 */
@Service("genericService")
public class IGenericService implements GenericService {

	public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
		return new Date();
	}
}
