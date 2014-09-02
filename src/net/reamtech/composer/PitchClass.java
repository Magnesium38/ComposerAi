package net.reamtech.composer;

public enum PitchClass {
	A(9, new PitchName[] {PitchName.A, PitchName.Gx, PitchName.Bbb}),
	As(10, new PitchName[] {PitchName.As, PitchName.Bb}),
	B(11, new PitchName[] {PitchName.B, PitchName.Ax, PitchName.Cb}),
	C(0, new PitchName[] {PitchName.C, PitchName.Bs, PitchName.Dbb}),
	Cs(1, new PitchName[] {PitchName.Cs, PitchName.Db}),
	D(2, new PitchName[] {PitchName.D, PitchName.Cx, PitchName.Ebb}),
	Ds(3, new PitchName[] {PitchName.Ds, PitchName.Eb}),
	E(4, new PitchName[] {PitchName.E, PitchName.Dx, PitchName.Fb}),
	F(5, new PitchName[] {PitchName.F, PitchName.Es, PitchName.Gbb}),
	Fs(6, new PitchName[] {PitchName.Fs, PitchName.Gb}),
	G(7, new PitchName[] {PitchName.G, PitchName.Fx, PitchName.Abb}),
	Gs(8, new PitchName[] {PitchName.Gs, PitchName.Ab});
	
	public final PitchName[] enharmonicPitches;
	public final int clockNumber;
	
	private PitchClass(int clockNumber, PitchName[] enharmonicPitches) {
		this.clockNumber = clockNumber;
		this.enharmonicPitches = enharmonicPitches;
	}
	
	public int getClockNumber() {
		return clockNumber;
	}
	
	public static PitchClass getPitchClassByClockNumber(int clockNumber) {
		for (PitchClass pClass : PitchClass.values()) {
			if (pClass.clockNumber == clockNumber) {
				return pClass;
			}
		}
		return null;
	}
	
	public PitchName[] getEnharmonicPitches() {
		return enharmonicPitches;
	}
	
	public static PitchClass getPitchClass(PitchName pitch) {
		for (PitchClass pClass : PitchClass.values()) {
			PitchName[] enharmonicPitches = pClass.getEnharmonicPitches();
			for (int i = 0; i < enharmonicPitches.length; i++) {
				if (pitch.equals(enharmonicPitches[i])) {
					return pClass;
				}
			}
		}
		return null;
	}
	
	public boolean contains(PitchName pitch) {
		for (int i = 0; i < enharmonicPitches.length; i++) {
			if (pitch.equals(enharmonicPitches[i])) {
				return true;
			}
		}
		return false;
	}
}
