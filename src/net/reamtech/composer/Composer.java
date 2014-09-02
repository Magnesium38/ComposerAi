package net.reamtech.composer;

import java.util.Random;

public class Composer {
	public static void main(String[] args) {
		Chord.I.setFollowWith(new Chord[] {Chord.I, Chord.ii, Chord.iii, Chord.IV, Chord.V, Chord.vi, Chord.viio});
		Chord.ii.setFollowWith(new Chord[] {Chord.V, Chord.viio});
		Chord.iii.setFollowWith(new Chord[] {Chord.vi});
		Chord.IV.setFollowWith(new Chord[] {Chord.V, Chord.viio});
		Chord.V.setFollowWith(new Chord[] {Chord.I});
		Chord.vi.setFollowWith(new Chord[] {Chord.ii, Chord.IV});
		Chord.viio.setFollowWith(new Chord[] {Chord.I, Chord.iii});
		
		String seed = "Second";
		Random random = new Random(seed.hashCode());
		
		Chord current = Chord.I;
		int count = 1;
		Chord prev1 = Chord.I;
		System.out.println("Starting:\t" + current.getName());
		
		while (count < 8 || !((prev1.equals(Chord.V)) && (current.equals(Chord.I)))) {
			prev1 = current;
			current = getRandomFollowingChord(current, random);
			count += 1;
			System.out.println("Next:\t\t" + current.getName());
		}
		
		
		
		
		
		System.out.println("Finished.");
	}
	
	public static Chord getRandomFollowingChord(Chord current, Random random) {
		Chord[] possibleChords = current.getFollowWith();
		return possibleChords[random.nextInt(possibleChords.length)];
	}
}