package net.reamtech.tests;

import static org.junit.Assert.*;

import net.reamtech.composer.Chord;
import net.reamtech.composer.Interval;
import net.reamtech.composer.PitchClass;
import net.reamtech.composer.PitchName;

import org.junit.Test;

public class ChordTest {

	@Test
	public void testGetNotesInChord() {
		assertArrayEquals("I based on C", Chord.getNotesInChord(Chord.I, PitchName.C), new String[] {"C","E","G"});
		assertArrayEquals("i based on C", Chord.getNotesInChord(Chord.i, PitchName.C), new String[] {"C","Eb","G"});
		assertArrayEquals("II based on D", Chord.getNotesInChord(Chord.II, PitchName.D), new String[] {"D","Fs","A"});
		assertArrayEquals("ii based on D", Chord.getNotesInChord(Chord.ii, PitchName.D), new String[] {"D","F","A"});
		assertArrayEquals("III based on E", Chord.getNotesInChord(Chord.III, PitchName.E), new String[] {"E","Gs","B"});
		assertArrayEquals("iii based on E", Chord.getNotesInChord(Chord.iii, PitchName.E), new String[] {"E","G","B"});
		assertArrayEquals("IV based on F", Chord.getNotesInChord(Chord.IV, PitchName.F), new String[] {"F","A","C"});
		assertArrayEquals("iv based on F", Chord.getNotesInChord(Chord.iv, PitchName.F), new String[] {"F","Ab","C"});
		assertArrayEquals("V based on G", Chord.getNotesInChord(Chord.V, PitchName.G), new String[] {"G","B","D"});
		assertArrayEquals("v based on G", Chord.getNotesInChord(Chord.v, PitchName.G), new String[] {"G","Bb","D"});
		assertArrayEquals("VI based on A", Chord.getNotesInChord(Chord.VI, PitchName.A), new String[] {"A","Cs","E"});
		assertArrayEquals("vi based on A", Chord.getNotesInChord(Chord.vi, PitchName.A), new String[] {"A","C","E"});
		assertArrayEquals("VII based on B", Chord.getNotesInChord(Chord.VII, PitchName.B), new String[] {"B","Ds","Fs"});
		assertArrayEquals("vii based on B", Chord.getNotesInChord(Chord.vii, PitchName.B), new String[] {"B","D","Fs"});
	}

	@Test
	public void testCanFollowWith() {
		assertFalse("III follows i", Chord.I.canFollowWith(Chord.III));
		assertFalse("ii follow i", Chord.I.canFollowWith(Chord.ii));
		Chord.I.setFollowWith(new Chord[] {Chord.ii});
		assertFalse("III follows i", Chord.I.canFollowWith(Chord.III));
		assertTrue("ii follow i", Chord.I.canFollowWith(Chord.ii));
	}
}
