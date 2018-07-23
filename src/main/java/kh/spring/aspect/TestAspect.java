package kh.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
	
	
	@Around("loginCout()")
	public int loginsuccess(ProceedingJoinPoint pjp) {
		String id = pjp.getArgs()[0].toString();
		String pw = pjp.getArgs()[1].toString();
		
		pw=EncryptUtils.getSha256(pw);
		
		int result = 0;
		
		try {
			result = (Integer)pjp.proceed(new Object[] {id,pw});
		}catch(Throwable e) {
			
		}
		return result;
	}
	
/*	@Before("loginCout()")
	public void loginsuccess(JoinPoint jp) {
		MembersDTO dto = (MembersDTO)jp.getArgs()[0];
		String pw = EncryptUtils.getSha256(dto.getPw());
		System.out.println(pw);
		dto.setPw(pw);
	}*/
	
	
//	HashMap을 통해서 했을경우
/*	@Before("loginCout()")
	public void loginsuccess(JoinPoint jp) {
		HashMap<String,String> map = (HashMap)jp.getArgs()[0];
		map.put("pw", EncryptUtils.getSha256(map.get("pw")));
	}*/
}
