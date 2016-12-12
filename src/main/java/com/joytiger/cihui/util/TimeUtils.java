package com.joytiger.cihui.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.joytiger.cihui.model.Race;

public final class TimeUtils {

	public static Log log = LogFactory.getLog(TimeUtils.class);
	private static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");

	private TimeUtils() {
		super();
	}

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static Long getNowTime() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 判断时间戳是否过时
	 * 
	 * @param time
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static boolean isOldTime(Long time) throws IllegalArgumentException {
		if (time == null) {
			throw new IllegalArgumentException("参数输入有误");
		}
		if (time >= System.currentTimeMillis() / 1000)
			return false;
		else
			return true;
	}

	/**
	 * 获取当日零点时间戳
	 * 
	 * @return Long
	 * @throws ParseException
	 */
	public static Long getTodayDate() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(dateFormat.format(new Date())).getTime() / 1000;
	}

	public static Integer getRaceDayIndex(Race raceInfo, Long time) {
		Long starttime = raceInfo.getStarttime();
		// Date date = new Date(starttime*1000);
		long startDateDayL = dateDayL(starttime);

		Long endtime = raceInfo.getEndtime();

		long endDataDayL = dateDayL(endtime);

		if (time < startDateDayL || time > (endDataDayL + (60 * 60 * 24))) {
			return 0;
		} else {
			return (int) Math.ceil((time - raceInfo.getStarttime()) * 1.0 / (60 * 60 * 24)) + 1;
		}
	}

	public static Long dateDayL(Long time) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String format = dateFormat.format(new Date(time * 1000));
			return dateFormat.parse(format).getTime() / 1000;
		} catch (ParseException e) {
			log.error("时间转换异常:", e);
			return 0l;
		}
	}

	public static Integer getRaceDayCount(Race raceInfo) {
		if (raceInfo != null) {
			return (int) Math.ceil((raceInfo.getEndtime() - raceInfo.getStarttime()) * 1.0 / (60 * 60 * 24));
		} else {
			throw new IllegalArgumentException("参数异常！");
		}

	}

	public static String getTodayStr(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		return dayFormat.format(date);
	}
}
