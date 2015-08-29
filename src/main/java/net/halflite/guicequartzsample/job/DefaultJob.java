package net.halflite.guicequartzsample.job;

import javax.inject.Inject;
import javax.inject.Singleton;

import net.halflite.guicequartzsample.helper.DateHelper;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 基本のジョブクラス */
@Singleton
public class DefaultJob implements Job {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultJob.class);

	@Inject
	private DateHelper dateHelper;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOGGER.debug("{}, done.", dateHelper.printNow());
	}
}
