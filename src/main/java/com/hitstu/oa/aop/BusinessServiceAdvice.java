package com.hitstu.oa.aop;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hitstu.oa.checkin.mapper.IElderlyMapper;
import com.hitstu.oa.checkin.service.impl.ElderlyServiceImpl;

//业务层Advice类

@Component
@Aspect
public class BusinessServiceAdvice {

	@Autowired
	private SqlSessionFactory ssf = null;

	// 环绕Advice
	@Around(value = "execution(* com.hitstu.oa.checkin.service.impl.ElderlyServiceImpl.*(..))")
	public Object methodAround(ProceedingJoinPoint pjp) throws Throwable {
		// 方法前代码区
		// 打开一个新的Session
		SqlSession session = ssf.openSession();
		// 取得DAO接口的对象
		IElderlyMapper elderlyMapper = session.getMapper(IElderlyMapper.class);
		System.out.println("方法前");
		if (pjp.getTarget() instanceof ElderlyServiceImpl) {
			((ElderlyServiceImpl) pjp.getTarget()).setElderlyMapper(elderlyMapper);
		}
		System.out.println("拦截");
		Object result = pjp.proceed(); // 调用拦截对象
		System.out.println("方法后");
		// 方法后代码区
		// 提交事务
		session.commit();
		session.close();
		return result;

	}

}
