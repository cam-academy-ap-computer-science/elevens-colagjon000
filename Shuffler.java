import java.util.ArrayList;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");
		int[] values2 = {1, 2, 3, 4};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		//counter for shuffledDeck location later
		int k = 0;
		int [] shuffledDeck = new int [values.length];
		for (int i = 0; i < values.length; i++) {
			shuffledDeck[i] = values[i];
		}
		//placing first half of values numbers in even slots
		for (int i = 0; i < values.length / 2; i++) {
			//set even slots to the first half of the copied deck
			values[k] = shuffledDeck[i];
			k = k+2;
		}
		//other half of the deck
		//set k to first odd number
		k = 1;
		for (int i = values.length / 2; i < values.length; i++) {
			//set odd slots to the last half of the copied deck
			values[k] = shuffledDeck[i];
			k = k + 2;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		//copy shuffledDeck to keep a template
		ArrayList <Integer> remainingCards = new ArrayList<>();
		for (int i = 0; i < values.length; i++) {
			remainingCards.add(values[i]);
		}
		//begin overwriting values
		int k = 0; //simple counter for progressing through values array
		for (int i = values.length - 1; i >= 0; i--) { //start from the top index and move downwards
			int pulledCard = (int) (Math.random() * i); //grabs a random index from the virtual deck
			values[k] = remainingCards.get(pulledCard);
			remainingCards.remove(pulledCard); //remove accessed card from queue stack
			k++; //move to next index in values
		}
		
	}
	
	//weighted coin
	public static String flipCoin() {
		int result = (int) Math.random() * 3;
		if (result == 0 || result == 1) {
			return "Heads!";
		} else {
			return "Tails!";
		}
	}
	//arePremutations
	// @param arrays are the same size and do not contain duplicates
	public static boolean arePremuatations(int a [], int b []) {
		for (int i : a) {
			boolean located = false;
			for (int j : b) {
				if (b[j] == a[i]) {
					located = true;
				}
			}
			if (located == false) {
				return false;
			}
		}
		return true;
	}
	
	
}
