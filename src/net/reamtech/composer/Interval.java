package net.reamtech.composer;

public enum Interval {
	P1(0),A1(1),
	d2(0),m2(1),M2(2),A2(3),
	d3(2),m3(3),M3(4),A3(5),
	d4(3),m4(4),P4(5),A4(6),
	d5(5),m5(6),P5(7),A5(8),
	d6(7),m6(8),M6(9),A6(10),
	d7(9),m7(10),M7(11),A7(12),
	d8(10),m8(11),P8(12),A8(13);
	
	private final int halfSteps;
	
	public int getHalfSteps() {
		return halfSteps;
	}
	
	private Interval(int halfSteps) {
		this.halfSteps = halfSteps;
	}
	
	public static PitchClass interval(PitchClass start, Interval interval, boolean up) {
		int clockNumber = 0;
		if (up) {
			clockNumber = start.clockNumber + interval.halfSteps;
		} else {
			clockNumber = start.clockNumber - interval.halfSteps;
		}
		if (clockNumber < 0) {
			clockNumber += 12;
		}
		return PitchClass.getPitchClassByClockNumber(clockNumber);
	}
	
	public static PitchClass getPitchClassByIntervalAway(PitchName pitch, Interval distance, boolean up) {
		PitchClass pitchClass = PitchClass.getPitchClass(pitch);
		for (PitchClass pitchClass2 : PitchClass.values()) {
			if (distance.equals(Interval.distance(pitchClass, pitchClass2, up))) {
				return pitchClass2;
			}
		}
		return null;
	}
	
	public static Interval distance(PitchClass one, PitchClass two, boolean up) {
		int distance = 0;
		if (up) {
			distance = two.clockNumber - one.clockNumber;
		} else {
			distance = one.clockNumber - two.clockNumber;
		}
		if (distance < 0) {
			distance += 12;
		}
		if (distance == 0) {
			return P1;
		} else if (distance == 1) {
			return m2;
		} else if (distance == 2) {
			return M2;
		} else if (distance == 3) {
			return m3;
		} else if (distance == 4) {
			return M3;
		} else if (distance == 5) {
			return P4;
		} else if (distance == 6) {
			return A4;
		} else if (distance == 7) {
			return P5;
		} else if (distance == 8) {
			return m6;
		} else if (distance == 9) {
			return M6;
		} else if (distance == 10) {
			return m7;
		} else if (distance == 11) {
			return M7;
		} else if (distance == 12) {
			return P8;
		} else {
			return null;
		}
	}
	
	public boolean equals(Interval other) {
		if (this.getHalfSteps() == other.getHalfSteps()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean equals(Interval one, Interval two) {
		if (one.getHalfSteps() == two.getHalfSteps()) {
			return true;
		} else {
			return false;
		}
	}
}
