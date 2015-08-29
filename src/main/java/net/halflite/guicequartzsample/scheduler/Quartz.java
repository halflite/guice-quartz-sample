package net.halflite.guicequartzsample.scheduler;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

/** Scheduler保持クラス */
@Singleton
public class Quartz {

	private final Scheduler scheduler;

	@Inject
	public Quartz(final SchedulerFactory factory, final GuiceJobFactory jobFactory) throws SchedulerException {
		this.scheduler = factory.getScheduler();
		this.scheduler.setJobFactory(jobFactory);
		this.scheduler.start();
	}

	/** @return Schedulerを返します。 */
	public final Scheduler getScheduler() {
		return this.scheduler;
	}
}
