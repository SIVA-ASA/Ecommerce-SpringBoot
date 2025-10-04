package com.ecom.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CommnServiceImpl implements CommonService {

	@Value("${rupee.sign}")
	public String rupeeSign;
	
	@Override
public void removeSessionMessage() {
    ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (attrs != null) {
        HttpServletRequest request = attrs.getRequest();
        HttpSession session = request.getSession(false); // false: don't create new session
        if (session != null) {
            session.removeAttribute("succMsg");
            session.removeAttribute("errorMsg");
        }
    }
}

	
	@Override
	public String rupeeSign()
	{
		return rupeeSign;
	}
}
