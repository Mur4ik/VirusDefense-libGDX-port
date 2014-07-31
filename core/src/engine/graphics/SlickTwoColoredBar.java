package engine.graphics;

import org.newdawn.slick.Color;

public class SlickTwoColoredBar extends RenderObject {
	private LibGDXRectangle base;
	private LibGDXRectangle health;
	private float length;
	private float height;
	private float length2;

	private boolean bordered = false;

	public SlickTwoColoredBar(float length, float height) {
		this.length = length;
		this.height = height;

		this.base = new LibGDXRectangle((int) this.length, (int) this.height, Color.red);
		this.health = new LibGDXRectangle((int) this.length, (int) this.height, Color.green);

		this.length2 = length;
	}

	@Override
	public void draw(float x, float y, float globalScale) {
		this.base.draw(x, y, globalScale);
		this.health.setWidth(this.length2);
		this.health.draw(x, y, globalScale);
		if (this.bordered) {
			new LibGDXUnfilledRectangle(this.length, this.height, Color.black).draw(x, y, globalScale);
			;
		}

	}

	public void setBordered(boolean bordered) {
		this.bordered = bordered;
	}

	public void setFractionLeft(float fraction) {
		this.length2 = this.length * fraction;
	}
}
