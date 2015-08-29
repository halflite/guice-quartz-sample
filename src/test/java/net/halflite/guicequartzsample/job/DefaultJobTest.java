package net.halflite.guicequartzsample.job;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import javax.inject.Inject;

import net.halflite.guicequartzsample.DefaultGuiceBerryEnv;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.quartz.JobExecutionContext;

import com.google.guiceberry.junit4.GuiceBerryRule;

public class DefaultJobTest {
	@Rule
	public final GuiceBerryRule rule = new GuiceBerryRule(DefaultGuiceBerryEnv.class);

	@Inject
	private DefaultJob defaultJob;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() throws Exception {
		JobExecutionContext context = mock(JobExecutionContext.class);
		defaultJob.execute(context);

		// 呼ばれなかったことを確認
		verifyNoMoreInteractions(context);
	}

}
