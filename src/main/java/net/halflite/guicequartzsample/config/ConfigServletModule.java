package net.halflite.guicequartzsample.config;

import com.google.inject.servlet.ServletModule;

/** ServletModuleの設定 */
public class ConfigServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		super.configureServlets();
		install(new ConfigModule());
	}
}
