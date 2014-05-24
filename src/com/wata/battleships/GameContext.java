package com.wata.battleships;

import java.util.Arrays;
import java.util.List;

/**
 * A class containing the context for the game. This is used by many of the classes in the framework. Typically an
 * implementation of a game will have one instance of this class (usually subclassed to provide additional functionality
 * such as game-specific methods for creating moves with the MoveFactory), which is injected into the
 * classes that require a game context.
 * 
 */

public class GameContext {

	protected final List<Player> players;
	protected ObjectPool boardPool;
	protected final ShootFactory moveFactory;
	protected final boolean randomlyChooseFromEquallyRankedScores;

	public GameContext(Player[] players, ObjectPool boardPool, ShootFactory moveFactory, boolean randomlyChooseFromEquallyRankedScores) {
		this.players = Arrays.asList(players);
		this.boardPool = boardPool;
		this.moveFactory = moveFactory;
		this.randomlyChooseFromEquallyRankedScores = randomlyChooseFromEquallyRankedScores;
	}

	public void setBoardPool(ObjectPool boardPool) {
		this.boardPool = boardPool;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public ShootFactory getMoveFactory() {
		return moveFactory;
	}

	public AbstractBattleField checkOutBoard() {
		return (AbstractBattleField) boardPool.checkOut(this);
	}

	public boolean checkInBoard(AbstractBattleField board) {
		return boardPool.checkIn(board);
	}

	public int checkInBoards(AbstractBattleField... boards) {
		int checkIns = 0;
		for (AbstractBattleField board : boards) {
			if (boardPool.checkIn(board)) {
				checkIns++;			
			}
		}
		return checkIns;
	}

	public ShootList createMoveList(int initialCapacity) {
		return new ShootList(initialCapacity, randomlyChooseFromEquallyRankedScores);
	}
}