package kh.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kh.spring.dto.MembersDTO;
import kh.spring.util.EncryptUtils;


@Aspect
@Component
public class TestAspect {
	

	@Pointcut("execution(* kh.spring.impl.MembersServiceImpl.insert*(..))")
	public void insertPointCut() {}
	
	@Before("insertPointCut()")
	public void pwEncryptUtil(JoinPoint jp) {
		MembersDTO dto = (MembersDTO)jp.getArgs()[0];
		String pw = EncryptUtils.getSha256(dto.getPw());
		System.out.println(pw);
		dto.setPw(pw);
	}
	
	@Pointcut("execution(* kh.spring.impl.MembersServiceImpl.idpwcheck*(..))")
	public void loginCout() {}
	
	@Before("loginCout()")
	public void loginsuccess(JoinPoint jp) {
		MembersDTO dto = (MembersDTO)jp.getArgs()[0];
		String pw = EncryptUtils.getSha256(dto.getPw());
		System.out.println(pw);
		dto.setPw(pw);
	}
}
