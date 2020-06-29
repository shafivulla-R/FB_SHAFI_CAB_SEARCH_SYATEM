package org.codejudge.sb.enums;

public enum CabSearchSystemEnums {

	SUCCESS("success"), NOCABSAVAILABLE("No cabs available!");

	private String value;

	CabSearchSystemEnums(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static CabSearchSystemEnums fromValue(String v) {
		for (CabSearchSystemEnums c : CabSearchSystemEnums.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException();
	}

}
