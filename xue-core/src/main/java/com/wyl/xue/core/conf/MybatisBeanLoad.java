/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.core.conf;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: MybatisBeanLoad
 * @Function: TODO
 * @Date: 2020/4/22 22:00
 * @author wyl
 * @version V1.0
 */
@SpringBootApplication
public class MybatisBeanLoad {
    /**
     * @Description 注入mybatisPlus 分支插件
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @Date 2020/4/12 16:58
     * @Author wangyl
     * @Version V1.0
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        /**
         *设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
         * paginationInterceptor.setOverflow(false);
         */
        /**
         *设置最大单页限制数量，默认 500 条，-1 不受限制
         * paginationInterceptor.setLimit(500);
         */
        /**
         *开启 count 的 join 优化,只针对部分 left join
         */
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

}
