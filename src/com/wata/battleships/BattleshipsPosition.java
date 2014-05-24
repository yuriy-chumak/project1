package com.wata.battleships;

public class BattleshipsPosition implements Position {
	
	private final int value;
	private transient int animationFrame = 0;

	public BattleshipsPosition(int x, int y) {
		value = (x - 1) + ((y - 1) << 3);
	}

	public BattleshipsPosition(BattleshipsPosition position) {
		this.value = position.value;
		this.animationFrame = position.animationFrame;
	}

	public int getX() {
		return (value & 7) + 1;
	}

	public int getY() {
		return (value >> 3) + 1;
	}	

	public int getAnimationFrame() {
		return animationFrame;
	}

	public void setAnimationFrame(int animationFrame) {
		this.animationFrame = animationFrame;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final BattleshipsPosition other = (BattleshipsPosition) obj;
		if (value != other.value) return false;
		return true;
	}

	@Override
	public String toString() {
		return (char) (getX() + 96) + "" + getY();
	}

}
