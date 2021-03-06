package bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import util.ReflectionUtils;


public class BeanUtil {
	
	public static void invokeSetterMethod( Object obj, String propertyName, Object propertyValue)
	{
		char [] tmp = propertyName.toCharArray();
		//将开头变为大写
		if(tmp[0] >= 'a' && tmp[0] <= 'z')
		{
			tmp[0] -= 32;
		}
		String setMethodName = String.format("set%s", String.valueOf(tmp));
		Field field;
		Class<?> cls = obj.getClass();
		try {
			field = cls.getDeclaredField(propertyName);
			Class<?> type = field.getType();
			Method method = ReflectionUtils.findMethod(cls, setMethodName, type);
			if(method!=null){
			method.invoke(obj, propertyValue);
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
