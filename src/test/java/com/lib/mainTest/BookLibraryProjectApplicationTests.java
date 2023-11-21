package com.lib.mainTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import com.lib.main.BookLibraryProjectApplication;


@SpringBootConfiguration
class BookLibraryProjectApplicationTests {

	@Test
	void testcontextLoads() {
		String str = "FlamManagerServiceApplicationTests";
		assertNotNull(str);

		BookLibraryProjectApplication.main(new String[] {});
	}

}
