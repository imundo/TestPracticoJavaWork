package cl.test.java.prueba.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.test.java.prueba.constants.ppTestConstants;
import cl.test.java.prueba.domain.AppTestJwtAuthenticationToken;
import cl.test.java.prueba.entity.UsersDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	 
	public JwtAuthenticationFilter() {
		super("/test/pruebaBci/perfil/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String header = request.getHeader(ppTestConstants.HEADER_AUTHORIZACION_KEY);

		if (header == null) {
			throw new RuntimeException("Falta token");
		}
		AppTestJwtAuthenticationToken token = new AppTestJwtAuthenticationToken(header);
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		UsersDetail user = ((UsersDetail) auth.getPrincipal());
		String token = user.getUsers().getToken();
		response.addHeader(ppTestConstants.HEADER_AUTHORIZACION_KEY, token);
		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
	}

}
