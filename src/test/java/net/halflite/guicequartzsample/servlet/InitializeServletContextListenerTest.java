package net.halflite.guicequartzsample.servlet;

import static org.assertj.core.api.StrictAssertions.assertThat;
import net.halflite.guicequartzsample.job.DefaultJob;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

public class InitializeServletContextListenerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInjector() {
		InitializeServletContextListener listener = new InitializeServletContextListener();
		// 実行
		Injector injector = listener.getInjector();

		// 検証
		assertThat(injector).isNotNull();
		DefaultJob defaultJob = injector.getInstance(DefaultJob.class);
		assertThat(defaultJob).isNotNull();
	}
}
