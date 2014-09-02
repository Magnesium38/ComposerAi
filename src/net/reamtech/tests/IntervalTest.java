package net.reamtech.tests;

import static org.junit.Assert.*;

import net.reamtech.composer.Interval;
import net.reamtech.composer.PitchClass;

import org.junit.Test;


public class IntervalTest {
	@Test
	public void testDistance() {
		assertEquals("C up to F", Interval.distance(PitchClass.C, PitchClass.F, true), Interval.P4);
		assertEquals("D up to G", Interval.distance(PitchClass.D, PitchClass.G, true), Interval.P4);
		assertEquals("E up to A", Interval.distance(PitchClass.E, PitchClass.A, true), Interval.P4);
		assertEquals("F up to Bb", Interval.distance(PitchClass.F, PitchClass.As, true), Interval.P4);
		assertEquals("G up to C", Interval.distance(PitchClass.G, PitchClass.C, true), Interval.P4);
		assertEquals("A up to D", Interval.distance(PitchClass.A, PitchClass.D, true), Interval.P4);
		assertEquals("B up to E", Interval.distance(PitchClass.B, PitchClass.E, true), Interval.P4);
		

		assertEquals("C up to C", Interval.distance(PitchClass.C, PitchClass.C, true), Interval.P1);
		assertEquals("C up to D", Interval.distance(PitchClass.C, PitchClass.D, true), Interval.M2);
		assertEquals("C up to E", Interval.distance(PitchClass.C, PitchClass.E, true), Interval.M3);
		assertEquals("C up to F", Interval.distance(PitchClass.C, PitchClass.G, true), Interval.P5);
		assertEquals("C up to A", Interval.distance(PitchClass.C, PitchClass.A, true), Interval.M6);
		assertEquals("C up to B", Interval.distance(PitchClass.C, PitchClass.B, true), Interval.M7);
		
		assertEquals("C down to C", Interval.distance(PitchClass.C, PitchClass.C, false), Interval.P1);
		assertEquals("C down to D", Interval.distance(PitchClass.C, PitchClass.D, false), Interval.m7);
		assertEquals("C down to E", Interval.distance(PitchClass.C, PitchClass.E, false), Interval.m6);
		assertEquals("C down to F", Interval.distance(PitchClass.C, PitchClass.G, false), Interval.P4);
		assertEquals("C down to A", Interval.distance(PitchClass.C, PitchClass.A, false), Interval.m3);
		assertEquals("C down to B", Interval.distance(PitchClass.C, PitchClass.B, false), Interval.m2);
	}

}
