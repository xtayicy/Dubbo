import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;

import harry.dubbo.entity.Computer;
import harry.dubbo.entity.User;
import harry.dubbo.service.CallbackListener;
import harry.dubbo.service.ICommonService;
import harry.dubbo.service.IComputerService;
import harry.dubbo.service.IGenericService;
import harry.dubbo.service.IGroupService;
import harry.dubbo.service.IUserService;
import harry.dubbo.service.IVersionService;

/**
 * 
 * @author harry
 *
 */
public class DubboTest {
	private final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * 本地存根
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException{
		IUserService userService = (IUserService) context.getBean("userService");
		User user = userService.getUser(1, "tom");
		System.out.println(user);
	}
	
	/**
	 * 参数回调
	 */
	@Test
	public void test_(){
		IComputerService computerService = (IComputerService) context.getBean("computerService");
		Computer computer = computerService.getComputer("tom", new CallbackListener() {
			
			public User getUser(User user) {
				user.setComputer(new Computer("computer"));
				
				return user;
			}
		});
		
		System.out.println(computer);
	}
	
	/**
	 * 多版本
	 */
	@Test
	public void test_01(){
		IVersionService versionService_1 = (IVersionService) context.getBean("versionService_1");
		System.out.println(versionService_1.getVersion());
		
		IVersionService versionService_2 = (IVersionService) context.getBean("versionService_2");
		System.out.println(versionService_2.getVersion());
		
		IVersionService versionService_random = (IVersionService) context.getBean("versionService_random");
		System.out.println(versionService_random.getVersion());
	}
	
	/**
	 * 分组聚合
	 */
	@Test
	public void test_02(){
		IGroupService groupService = (IGroupService) context.getBean("groupService");
		String[] array = groupService.getStringArray();
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * 泛化引用
	 */
	@Test
	public void test_03(){
		GenericService genericService = (GenericService) context.getBean("demoService");
		Object $invoke = genericService.$invoke("queryUser", new String[]{"java.lang.Integer"}, new Object[]{1});
		System.out.println($invoke);
	}
	
	/**
	 * 泛化实现
	 */
	@Test
	public void test_04(){
		IGenericService genericService = (IGenericService) context.getBean("genericService");
		Object o = genericService.doNothing();
		System.out.println(o);
		
		EchoService echoService = (EchoService) genericService;
		Object $echo = echoService.$echo("hello");
		System.out.println($echo);
		
		System.out.println(RpcContext.getContext().isConsumerSide());
		System.out.println(RpcContext.getContext().getRemoteAddressString());
		System.out.println(RpcContext.getContext().getUrl().getParameter("application"));
	}
	
	/**
	 * 隐式传参
	 */
	@Test
	public void test_05(){
		RpcContext.getContext().setAttachment("attch", "hello");
		ICommonService commonService = (ICommonService) context.getBean("commonService");
		System.out.println(commonService.methodInvoke());
	}
	
	/**
	 * 服务降级
	 */
	@Test
	public void test_06(){
		ICommonService commonService = (ICommonService) context.getBean("commonService");
		System.out.println(commonService.methodInvoke(1));
	}
}
