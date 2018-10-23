package harry.dubbo.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;

import harry.dubbo.service.ICommonService;

/**
 * 
 * @author harry
 *
 */
@Service
public class CommonService implements ICommonService {

	public Object methodInvoke() {
		System.out.println(RpcContext.getContext().getAttachment("attch"));
		
		return "method invoke";
	}

	public Object methodInvoke(Integer id) {
		System.out.println(id);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
