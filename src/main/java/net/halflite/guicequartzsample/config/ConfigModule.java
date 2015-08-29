package net.halflite.guicequartzsample.config;

import static com.google.inject.name.Names.bindProperties;
import static org.seasar.util.io.ResourceUtil.getProperties;
import net.halflite.guicequartzsample.helper.DateHelper;
import net.halflite.guicequartzsample.job.DefaultJob;
import net.halflite.guicequartzsample.scheduler.GuiceJobFactory;
import net.halflite.guicequartzsample.scheduler.Quartz;

import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;

/** DI設定モジュール */
public class ConfigModule extends AbstractModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigModule.class);

	@Override
	protected void configure() {
		bindProperties(binder(), getProperties("app-config.properties"));

		bind(DateHelper.class);
		bind(DefaultJob.class);
		bindScheduler();
	}

	/** Quartz関連のDI設定 */
	private void bindScheduler() {
		try {
			bind(SchedulerFactory.class).toInstance(new StdSchedulerFactory(getProperties("quartz.properties")));
			bind(GuiceJobFactory.class);
			bind(Quartz.class).asEagerSingleton();
		} catch (SchedulerException e) {
			LOGGER.warn(e.getMessage(), e);
		}
	}
}
