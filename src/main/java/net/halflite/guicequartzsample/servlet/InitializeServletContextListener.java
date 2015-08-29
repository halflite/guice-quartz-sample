package net.halflite.guicequartzsample.servlet;

import javax.servlet.annotation.WebListener;

import net.halflite.guicequartzsample.config.ConfigServletModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/** Guice用ServletContextListener実装 */
@WebListener
public class InitializeServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ConfigServletModule());
	}
}
