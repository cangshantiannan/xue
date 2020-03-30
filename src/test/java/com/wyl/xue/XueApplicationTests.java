package com.wyl.xue;

import com.wyl.xue.mybatis.entity.SystemPost;
import com.wyl.xue.mybatis.entity.SystemUsers;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XueApplicationTests {

	@Test
	void entity() {
		SystemPost systemPost = SystemPost.builder().postName("测试22").departmentId(1).postId(6).build();
		System.out.println(systemPost.updateById());
	}
}
