/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.jwt;

import com.wyl.xue.security.UserInfoJwt;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @ClassName: JwtUtilTest
 * @Function:
 * @Date: 2019/12/17 19:47
 * @author wyl
 * @version V1.0
 */
@Slf4j
public class JwtUtilTest {
    @Test
    void MakeToken() {
        System.out.println(UserInfoJwt.generateUserInfoToken("wyl", "wyl", "wyl"));
    }

    @Test
    void ParsingToken() {
        log.info("123");
        System.out.println(UserInfoJwt.UserInfo("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3eWwiLCJleHAiOjE1NzY1OTA3MzMsImNyZWF0ZWQiOjE1NzY1ODcxMzMzNzEsImF1dGhvcml0aWVzIjoid3lsIiwianRpIjoid3lsIn0.vKUTmEprVoCRWiTvzZAtZO1lOi3tSCkYSLDiETSEMepNeBzn8IAVLpx4o0-cRaDl3uDb4Fu4E2MKIlsLttBJqQ"));
    }
}
