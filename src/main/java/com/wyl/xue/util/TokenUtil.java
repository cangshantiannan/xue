/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName: TokenUntil
 * @Function: TODO
 * @Date: 2019/12/17 0:36
 * @author wyl
 * @version V1.0
 */
public class TokenUtil {
    /**
     * 默认有效期1小时
     */
    private static final long EXPIRE_TIME = 60 * 60 * 1000;
    /**
     * 密钥
     */
    private static final String JWT_SECRET = "wylaigyx";


    /**
     * 用户名称
     */
    private static final String USERNAME = Claims.SUBJECT;

    /**
     * 创建时间
     */
    private static final String CREATED = "created";
    /**
     * 权限列表
     */
    private static final String AUTHORITIES = "authorities";


    /**
     * @Description
     * @param userName
     * @param authorities
     * @param expire_time
     * @param TokenId
     * @return java.lang.String
     * @Date 2019/12/17 1:11
     * @Author wangyl
     * @Version V1.0
     */
    public static String generateUserInfoToken(String userName, Object authorities, Long expire_time, String TokenId) {
        Map<String, Object> claims = new HashMap<>(5);
        claims.put(USERNAME, userName);
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authorities);
        return generateToken(claims, expire_time, TokenId);
    }

    /**
     * @Description
     * @param userName
     * @param authorities
     * @param TokenId
     * @return java.lang.String
     * @Date 2019/12/17 1:11
     * @Author wangyl
     * @Version V1.0
     */
    public static String generateUserInfoToken(String userName, Object authorities, String TokenId) {
        Map<String, Object> claims = new HashMap<>(5);
        claims.put(USERNAME, userName);
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authorities);
        return generateToken(claims, EXPIRE_TIME, TokenId);
    }

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
    private static String generateToken(Map<String, Object> claims, Long expire_time, String TokenId) {
        Date expirationDate = new Date(System.currentTimeMillis() + expire_time);
        return Jwts.builder().setClaims(claims).setId(TokenId).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, generalKey()).compact();
    }

    /**
     * @Description 通过Base64加密生成秘钥
     * @param
     * @return javax.crypto.SecretKey
     * @Date 2019/12/17 0:56
     * @Author wangyl
     * @Version V1.0
     */
    private static SecretKey generalKey() {
        String stringKey = JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}
