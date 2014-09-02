package net.reamtech.composer;

public enum Chord {
	I("I", new Interval[] {Interval.M3, Interval.m3}),
	i("i", new Interval[] {Interval.m3, Interval.M3}),
	II("II", new Interval[] {Interval.M3, Interval.m3}),
	ii("ii", new Interval[] {Interval.m3, Interval.M3}),
	III("III", new Interval[] {Interval.M3, Interval.m3}),
	iii("iii", new Interval[] {Interval.m3, Interval.M3}),
	IV("IV", new Interval[] {Interval.M3, Interval.m3}),
	iv("iv", new Interval[] {Interval.m3, Interval.M3}),
	V("V", new Interval[] {Interval.M3, Interval.m3}),
	v("v", new Interval[] {Interval.m3, Interval.M3}),
	VI("VI", new Interval[] {Interval.M3, Interval.m3}),
	vi("vi", new Interval[] {Interval.m3, Interval.M3}),
	VII("VII", new Interval[] {Interval.M3, Interval.m3}),
	vii("vii", new Interval[] {Interval.m3, Interval.M3}),
	viio("viio", new Interval[] {Interval.m3, Interval.m3});
	
	
	private String name;
	private Interval[] makeup;
	private Chord[] followWith = new Chord[0];
	
	public String getName() {
		return name;
	}
	
	public Interval[] getMakeup() {
		return makeup;
	}
	
	public Chord[] getFollowWith() {
		return followWith;
	}
	
	public void setFollowWith(Chord[] followWith) {
		this.followWith = followWith;
	}
	
	private Chord(String name, Interval[] makeup) {
		this.name = name;
		this.makeup = makeup;
	}
	
	public boolean canFollowWith(Chord other) {
		for (Chord chord : getFollowWith()) {
			if (chord.equals(other)) {
				return true;
			}
		}
		return false;
	}
	
	public static String[] getNotesInChord(Chord chord, PitchName root) {
		String[] notes = new String[chord.getMakeup().length + 1];
		notes[0] = root.getName();
		
		PitchClass pitchClass = PitchClass.getPitchClass(root);
		PitchName pitch = root;
		int letterNumber = 0;
		
		if (pitch.getLetter() == "C") {
			letterNumber = 0;
		} else if (pitch.getLetter() == "D") {
			letterNumber = 1;
		} else if (pitch.getLetter() == "E") {
			letterNumber = 2;
		} else if (pitch.getLetter() == "F") {
			letterNumber = 3;
		} else if (pitch.getLetter() == "G") {
			letterNumber = 4;
		} else if (pitch.getLetter() == "A") {
			letterNumber = 5;
		} else if (pitch.getLetter() == "B") {
			letterNumber = 6;
		}
		
		for (int i = 0; i < chord.getMakeup().length; i++) {
			pitchClass = Interval.getPitchClassByIntervalAway(pitch, chord.getMakeup()[i], true);
			
			for (PitchName p : pitchClass.getEnharmonicPitches()) {
				int letterNumber2 = 0;
				if (p.getLetter() == "C") {
					letterNumber2 = 0;
				} else if (p.getLetter() == "D") {
					letterNumber2 = 1;
				} else if (p.getLetter() == "E") {
					letterNumber2 = 2;
				} else if (p.getLetter() == "F") {
					letterNumber2 = 3;
				} else if (p.getLetter() == "G") {
					letterNumber2 = 4;
				} else if (p.getLetter() == "A") {
					letterNumber2 = 5;
				} else if (p.getLetter() == "B") {
					letterNumber2 = 6;
				}
				if (letterNumber2 < letterNumber) {
					letterNumber2 += 7;
				}
				if (letterNumber2 - letterNumber == 2) {
					letterNumber = letterNumber2;
					if (letterNumber > 6) letterNumber -= 7;
					notes[i + 1] = p.getName();
					pitch = p;
					break;
				}
			}
			
			//notes[i + 1] = pitch.getName();
		}
		
		return notes;
	}

}
