package com.tad.common.util;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {

	private static final String SESSION_COOKIE_NAME = "TADSESSIONCOOKIE";
	private static final String SESSION_COOKIE_PATH = "/";
	private static final int SESSION_COOKIE_MAXAGE = 30*24*60*60;
	private static Map<String, Object> sessionStore = new ConcurrentHashMap<String, Object>();

	
	/**
	 * 세션 생성
	 */
	public void createSession(Object value, HttpServletResponse response) {

		// 세션 id를 생성하고, 값을 세션에 저장
		String sessionId = UUID.randomUUID().toString();
		sessionStore.put(sessionId, value);

		// 쿠키 생성
		Cookie tadSessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
		tadSessionCookie.setPath(SESSION_COOKIE_PATH);
		tadSessionCookie.setMaxAge(SESSION_COOKIE_MAXAGE);
		response.addCookie(tadSessionCookie);
	}

	/**
	 * 세션 조회
	 */
	public Object getSession(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
		if (sessionCookie == null) {
			return null;
		}
		return sessionStore.get(sessionCookie.getValue());
	}

	/**
	 * 세션 만료
	 */
	public void expires(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
		if (sessionCookie != null) {
			sessionStore.remove(sessionCookie.getValue());
		}
	}

	public Cookie findCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(cookieName)) {
	                return cookie;
	            }
	        }
		}
		return null;
	}
}
