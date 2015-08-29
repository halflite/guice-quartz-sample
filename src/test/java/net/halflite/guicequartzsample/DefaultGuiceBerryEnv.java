package net.halflite.guicequartzsample;

import net.halflite.guicequartzsample.config.ConfigServletModule;

import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.AbstractModule;

public class DefaultGuiceBerryEnv extends AbstractModule {

	@Override
	protected void configure() {
		install(new GuiceBerryModule());
		install(new ConfigServletModule());
	}
}
