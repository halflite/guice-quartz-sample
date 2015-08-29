package net.halflite.guicequartzsample.scheduler;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import net.halflite.guicequartzsample.DefaultGuiceBerryEnv;
import net.halflite.guicequartzsample.job.DefaultJob;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.spi.TriggerFiredBundle;

import com.google.guiceberry.junit4.GuiceBerryRule;

public class GuiceJobFactoryTest {

	@Rule
	public final GuiceBerryRule rule = new GuiceBerryRule(DefaultGuiceBerryEnv.class);

	@Inject
	private GuiceJobFactory guiceJobFactory;

	@Inject
	private DefaultJob defaultJob;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNewJob() throws Exception {
		JobDetail jobDetail = mock(JobDetail.class);
		Class<? extends Job> jobClass = DefaultJob.class;
		OngoingStubbing<Class<? extends Job>> when = when(jobDetail.getJobClass());
		when.thenReturn(jobClass);

		TriggerFiredBundle bundle = mock(TriggerFiredBundle.class);
		when(bundle.getJobDetail()).thenReturn(jobDetail);

		Scheduler scheduler = mock(Scheduler.class);

		// 実行
		Job newJob = guiceJobFactory.newJob(bundle, scheduler);

		// 検証
		assertThat(newJob).isNotNull().isEqualTo(defaultJob);
		verify(bundle, times(1)).getJobDetail();
		verify(jobDetail, times(1)).getJobClass();
		verifyNoMoreInteractions(scheduler);
	}
}
