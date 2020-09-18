/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.admin.security;

import com.wyl.xue.core.util.TokenUtilBase;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserInfoJwt
 * @Function: 用户JWT
 * @Date: 2019/12/17 20:21
 * @author wyl
 * @version V1.0
 */
public class UserInfoJwt {

    private static final TokenUtilBase tokenUtilBase = new TokenUtilBase();
    /**
     * 用户名称
     */
    private static final String USERNAME = "sub";
    /**
     * 创建时间
     */
    private static final String CREATED = "created";
    /**
     * 权限列表
     */
    private static final String AUTHORITIES = "authorities";

    /**
     * 用户ID
     */
    private static final String USERID = "userid";


    final static private String TOKENHEADER = "Bearer ";

    final static private String AUTHTOKENSTART = "Authorization";

    /**
     * @Description 生成一个用户信息的Token 自定义有效时间
     * @param userName 用户名称
     * @param authorities 用户权限列表
     * @param expire_time 有效时间
     * @param TokenId tokenid
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
        claims.put(USERID, TokenId);
        return tokenUtilBase.generateToken(claims, expire_time, TokenId);
    }

    /**
     * @Description 生成一个用户信息的Token 默认有效时间1小时
     * @param userName 用户名称
     * @param authorities 用户权限列表
     * @param TokenId tokenid
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
        claims.put(USERID, TokenId);
        return tokenUtilBase.generateToken(claims, TokenId);
    }

    /**
     * @Description 从token中返回用户信息
     * @param token
     * @return java.util.Map
     * @Date 2019/12/17 20:46
     * @Author wangyl
     * @Version V1.0
     */
    public static Map UserInfo(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return tokenUtilBase.getClaimsFromToken(token);
    }

    /**
     * @Description 判断是否过期
     * @param token
     * @return java.lang.Boolean
     * @Date 2020/4/16 23:22
     * @Author wangyl
     * @Version V1.0
     */
    public static Boolean UserInfoTokenTimeOut(String token) {
        return tokenUtilBase.tokenExpired(token);
    }


    /**
     * @Description 从请求头获取token信息
     * @param request 请求头
     * @return java.lang.String
     * @Date 2019/12/21 21:46
     * @Author wangyl
     * @Version V1.0
     */
    public static String getToken(@Nullable HttpServletRequest request) {
        String token = request.getHeader(AUTHTOKENSTART);
//        if (!StringUtils.isEmpty(token)) {
//            token = token.substring(TOKENHEADER.length());
//        } else {
//            return null;
//        }
        return token;
    }
}
