package net.halflite.guicequartzsample.helper;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;

/** 日時ヘルパークラス */
@Singleton
public class DateHelper {

	/** TimeZone定義 */
	private final DateTimeZone defaultTimeZone;

	/**
	 * 現在時刻を返します。
	 *
	 * @return 現在時刻
	 */
	public String printNow() {
		return DateTime.now()
				.withZone(this.defaultTimeZone)
				.toString(ISODateTimeFormat.basicDateTimeNoMillis());
	}

	@Inject
	public DateHelper(@Named("default.time.zone") String timeZone) {
		this.defaultTimeZone = DateTimeZone.forID(timeZone);
	}
}