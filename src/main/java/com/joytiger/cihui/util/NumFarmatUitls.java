package com.joytiger.cihui.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class NumFarmatUitls {

	private NumFarmatUitls() {
		super();
	}

	/**
	 * 保留两位小数
	 * 
	 * @param decimal
	 * @return
	 */
	public static String sub2decimalPointS(String decimal) {
		return decimal == null || "".equals(decimal) ? "0.00"
				: new BigDecimal(decimal).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

	public static Float sub2decimalPointF(String decimal) {
		return decimal == null || "".equals(decimal) ? 0.00F
				: new BigDecimal(decimal).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	public static String subDecimalPointS(String decimal, Integer point) {
		return decimal == null || "".equals(decimal) ? "0"
				: new BigDecimal(decimal).setScale(point, BigDecimal.ROUND_HALF_UP).toString();
	}

	public static Float objToFloat(Object number) {
		if (number == null) {
			return 0f;
		}
		String num = number.toString();
		num = sub2decimalPointS(num);
		if (num == null || "".equals(num)) {
			return 0f;
		} else {
			return Float.valueOf(num);
		}
	}
	
	public static String objTo2PointFloatStr(Object number){
		if (number == null) {
			return "0";
		}
		return new DecimalFormat("0.00").format(objToFloat(number));
	}

	public static Integer objToInteger(Object number) {
		if (number == null) {
			return 0;
		}
		String num = number.toString();
		if (num == null || "".equals(num)) {
			return 0;
		} else {
			return Integer.valueOf(num);
		}
	}

	public static Long objToLong(Object number) {
		if (number == null) {
			return 0l;
		}
		String num = number.toString();
		if (num == null || "".equals(num)) {
			return 0l;
		} else {
			return Long.valueOf(num);
		}
	}

}
