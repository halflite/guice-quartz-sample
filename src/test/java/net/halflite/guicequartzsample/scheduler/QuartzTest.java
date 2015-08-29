package net.halflite.guicequartzsample.scheduler;

import static org.assertj.core.api.StrictAssertions.assertThat;

import javax.inject.Inject;

import net.halflite.guicequartzsample.DefaultGuiceBerryEnv;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.quartz.Scheduler;

import com.google.guiceberry.junit4.GuiceBerryRule;

public class QuartzTest {

	@Rule
	public final GuiceBerryRule rule = new GuiceBerryRule(DefaultGuiceBerryEnv.class);

	@Inject
	private Quartz quartz;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetScheduler() throws Exception {
		// 実行
		Scheduler scheduler = quartz.getScheduler();

		// 検証
		assertThat(scheduler).isNotNull();
		assertThat(scheduler.isStarted()).isTrue();
	}

}
