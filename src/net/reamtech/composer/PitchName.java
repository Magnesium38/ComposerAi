package net.reamtech.composer;

public enum PitchName {
	Abb("A",-2),Ab("A",-1),A("A"),As("A",1),Ax("A",2),	
	Bbb("B",-2),Bb("B",-1),B("B"),Bs("B",1),Bx("B",2),
	Cbb("C",-2),Cb("C",-1),C("C"),Cs("C",1),Cx("C",2),
	Dbb("D",-2),Db("D",-1),D("D"),Ds("D",1),Dx("D",2),
	Ebb("E",-2),Eb("E",-1),E("E"),Es("E",1),Ex("E",2),
	Fbb("F",-2),Fb("F",-1),F("F"),Fs("F",1),Fx("F",2),
	Gbb("G",-2),Gb("G",-1),G("G"),Gs("G",1),Gx("G",2);
	
	private final String letter;
	private final int modifier;

	public String getLetter() {
		return letter;
	}

	public int getModifier() {
		return modifier;
	}
	
	public String getName() {
		String returnStr = getLetter();
		if (getModifier() == -2) {
			return returnStr + "bb";
		} else if (getModifier() == -1) {
			return returnStr + "b";
		} else if (getModifier() == 1) {
			return returnStr + "s";
		} else if (getModifier() == 2) {
			return returnStr + "x";
		}
		return returnStr;
	}
	
	private PitchName(String letter) {
		this(letter, 0);
	}
	
	private PitchName(String letter, int modifier) {
		this.letter = letter.toUpperCase();
		this.modifier = modifier;
	}
	
	public boolean equals(PitchName other) {
		if (this.letter == other.letter && this.modifier == other.modifier) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean equalsEnharmonically(PitchName one, PitchName two) {
		PitchClass pClass = PitchClass.getPitchClass(one);
		return pClass.contains(two);
	}
	
	public boolean equalsEnharmonically(PitchName other) {
		PitchClass pClass = PitchClass.getPitchClass(this);
		return pClass.contains(other);
	}
}
