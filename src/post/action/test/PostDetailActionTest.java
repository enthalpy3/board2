package post.action.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import post.PostDao;


class PostDetailActionTest {

	private PostDao data;

	@BeforeEach
	void setUp() throws Exception {
		data = new PostDao();
		System.out.println("시작d");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("end");
	}

	@Test
	void testRequestPro() {

		assertEquals("도지다", data.getPost("126").getName());
	}

}
