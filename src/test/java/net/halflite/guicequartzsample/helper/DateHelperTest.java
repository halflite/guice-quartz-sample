package net.halflite.guicequartzsample.helper;

import static org.assertj.core.api.StrictAssertions.assertThat;

import javax.inject.Inject;

import net.halflite.guicequartzsample.DefaultGuiceBerryEnv;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.guiceberry.junit4.GuiceBerryRule;

public class DateHelperTest {

	@Rule
	public final GuiceBerryRule rule = new GuiceBerryRule(DefaultGuiceBerryEnv.class);

	@Inject
	private DateHelper dateHelper;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrintNow() {
		// 実行
		String printNow = dateHelper.printNow();

		// 日本のタイムゾーンが表示されている
		assertThat(printNow).isNotEmpty().endsWith("+0900");
	}

}
