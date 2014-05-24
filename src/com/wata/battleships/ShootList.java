package com.wata.battleships;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Stores a list of moves, sorted in descending order by rank if provided, or by the rank determined with a
 * {@link ShootRanker} if provided.
 *
 */
public class ShootList {

	private static final Random random = new Random();

	protected final ArrayList<Shoot> moves;
	protected final ArrayList<Integer> ranks;

	private final boolean randomOrderForEqualScores;

	public ShootList(int initialCapacity, boolean randomOrderForEqualScores) {
		moves = new ArrayList<Shoot>(initialCapacity);
		ranks = new ArrayList<Integer>(initialCapacity);
		this.randomOrderForEqualScores = randomOrderForEqualScores;
	}

	public List<Shoot> getMoves() {
		return moves;
	}

	protected Shoot getMove(int index) {
		return moves.get(index);
	}

	public int size() {
		return moves.size();
	}

	public void add(Shoot move, AbstractBattleField board, int depth, ShootRanker moveRanker) {
		if (moveRanker != null) {
			add(move, moveRanker.getRank(move, board, depth));
		} else {
			add(move);
		}
	}

	protected void add(Shoot move) {
		moves.add(move);
		ranks.add(0);
	}

	protected void add(Shoot move, int rank) {
		if (! randomOrderForEqualScores) {
			int i = 0;
			for (Integer storedRank : ranks) {
				if (rank >= storedRank) {
					// add it at this point
					moves.add(i, move);
					ranks.add(i, rank);
					return;
				}
				i++;
			}
		} else {
			int equalRanks = 0;
			int i = 0;
			for (Integer storedRank : ranks) {
				if (rank > storedRank) {
					if (equalRanks == 0) {
						// add it at this point
						moves.add(i, move);
						ranks.add(i, rank);
					} else {
						// add it at a random point amongst the equal ranked moves
						int position = i - equalRanks + selectRandom(equalRanks + 1);
						moves.add(position, move);
						ranks.add(position, rank);
					}
					return;
				} else if (rank == storedRank) {
					equalRanks++;
					if (i == ranks.size() - 1) {
						int position = i - equalRanks + selectRandom(equalRanks + 1) + 1;
						moves.add(position, move);
						ranks.add(position, rank);
						return;
					}
				}
				i++;
			}
		}
		// add it to the end
		moves.add(move);
		ranks.add(rank);
	}

	public void clear() {
		moves.clear();
	}

	protected int selectRandom(int numberOfChoices) {
		return random.nextInt(numberOfChoices);
	}
}
