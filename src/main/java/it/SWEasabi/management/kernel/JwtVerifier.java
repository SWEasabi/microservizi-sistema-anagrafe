package it.SWEasabi.management.kernel;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
/*
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.MissingClaimException;
*/

import it.SWEasabi.management.services.AccessKeyService;

public class JwtVerifier
{
    private AccessKeyService key;
    public JwtVerifier(AccessKeyService Key)
    {
        key = Key;
    }

    private boolean verify(String token, String signature, String type)
    {
        try
        {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(signature))
                .withIssuer("auth0")
                .withClaimPresence("map")
                .withClaimPresence("type")
                .build();
            DecodedJWT jwt = verifier.verify(token);

            if(jwt.getClaim("type").asString().equals(type))
            {
                return true;
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }
    public boolean isAValidAccessJwt(String token)
    {
        return verify(token, key.getAccessKey(), "access");
    }
}
