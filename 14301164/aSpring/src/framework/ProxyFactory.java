package framework;

public class ProxyFactory extends AdvisedSupport{
	
	public Object getProxy() {
		return new JdkDynamicAopProxy(this).getProxy();
	}
}
