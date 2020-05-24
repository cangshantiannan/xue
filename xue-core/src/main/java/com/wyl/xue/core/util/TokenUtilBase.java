/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.core.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TokenUtilBase
 * @Function: 提供部分jwt 基础接口
 * @Date: 2019/12/17 0:36
 * @author wyl
 * @version V1.0
 */
public class TokenUtilBase {
    /**
     * 默认有效期1小时
     */
    private long EXPIRE_TIME = 60 * 60 * 100000;
    /**
     * 密钥
     */
    private String JWT_SECRET = "wylaigyx";

    /**
     * @Description 自定义默认的失效时间和加密串
     * @param expire_time 失效时间
     * @param jwt_secret 加密串
     * @return
     * @Date 2019/12/17 20:39
     * @Author wangyl
     * @Version V1.0
     */
    public TokenUtilBase(long expire_time, String jwt_secret) {
        this.EXPIRE_TIME = expire_time;
        this.JWT_SECRET = jwt_secret;
    }

    public TokenUtilBase() {}

    /**
     * @Description 生成一个JWT信息
     * @param claims 需要存储的信息
     * @param expire_time 设置token的超时时间
     * @param TokenId TokenId
     * @return java.lang.String
     * @Date 2019/12/17 1:02
     * @Author wangyl
     * @Version V1.0
     */
    public String generateToken(Map<String, Object> claims, Long expire_time, String TokenId) {
        Date expirationDate = new Date(System.currentTimeMillis() + expire_time);
        return Jwts.builder().setClaims(claims).setId(TokenId).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, generalKey()).compact();
    }

    /**
     * @Description 生成一个JWT信息
     * @param claims 需要存储的信息
     * @param TokenId TokenId
     * @return java.lang.String
     * @Date 2019/12/17 20:38
     * @Author wangyl
     * @Version V1.0
     */
    public String generateToken(Map<String, Object> claims, String TokenId) {
        return this.generateToken(claims, EXPIRE_TIME, TokenId);
    }

    /**
     * @Description 判断Token是否时效
     * @param token
     * @return java.lang.Boolean
     * @Date 2019/12/17 13:41
     * @Author wangyl
     * @Version V1.0
     */
    public Boolean tokenExpired(String token) {
        Claims claims = getClaimsFromToken(token);
        Date expiration = claims.getExpiration();
        return expiration.after(new Date());
    }


    /**
     * @Description 从Token中获取Claims信息
     * @param token
     * @return io.jsonwebtoken.Claims
     * @Date 2019/12/17 13:24
     * @Author wangyl
     * @Version V1.0
     */
    public Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * @Description 通过Base64加密生成秘钥
     * @param
     * @return javax.crypto.SecretKey
     * @Date 2019/12/17 0:56
     * @Author wangyl
     * @Version V1.0
     */
    private SecretKey generalKey() {
        String stringKey = JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}
