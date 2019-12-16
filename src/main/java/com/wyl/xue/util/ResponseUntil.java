package com.wyl.xue.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: ResponseUntil
 * @Function: 返回头工具
 * @Date: 2019/12/16 13:49
 * @author wangyl
 * @version V1.0
 */
public enum ResponseUntil {
    RESPONSE;

    /**
     * @Description 将返回信息写入返回信息中
     * @param result 返回信息
     * @param response 返回头
     * @return void
     * @Date 2019/12/16 14:12
     * @Author wangyl
     * @Version V1.0
     */
    public static void writeResponse(WebResult result, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(mapper.writeValueAsString(result));
        printWriter.flush();
    }
}
