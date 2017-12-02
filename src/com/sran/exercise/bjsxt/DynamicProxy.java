package com.sran.exercise.bjsxt;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDAO userDAO = new UserDAO();
		InvocationHandler h = new TransactionInvocationHandler(userDAO);
		BaseDAO dao = (BaseDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), 
				new Class[] {BaseDAO.class}, 
				h);
		dao.save(1, "liusiyuan");
	}

}

interface BaseDAO {
	public void save(int id, String name);
}

class UserDAO implements BaseDAO {

	@Override
	public void save(int id, String name) {
		System.out.println("insert " + id + ": " + name);
	}
	
}

class TransactionInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public TransactionInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("start transaction!");
		result = method.invoke(target, args);
		System.out.println("commit transaction!");
		
		return result;
	}
	
}