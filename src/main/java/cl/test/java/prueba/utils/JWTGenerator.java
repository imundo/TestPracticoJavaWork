package cl.test.java.prueba.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import cl.test.java.prueba.constants.ppTestConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTGenerator {

	public static String createJWT(String id, String subject) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ppTestConstants.SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(id)
										   .setSubject(subject)
										   .signWith(signatureAlgorithm, signingKey);
		
		long nowMillis = System.currentTimeMillis();
		Date exp = Util.addMinutesToDate(30, new Date(nowMillis));
		builder.setExpiration(exp);
		return builder.compact();
	}

	public static Claims parseJWT(String jwt) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ppTestConstants.SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt).getBody();
	}
}
