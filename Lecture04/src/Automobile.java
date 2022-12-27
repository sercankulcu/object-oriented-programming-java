public class Automobile {
	private Gear gear;
	private Engine engine;
	private Wheel[] wheels;

	public Automobile(int numWheels) {
		this.gear = new Gear();
		this.engine = new Engine();
		this.wheels = new Wheel[numWheels];
		for (int i = 0; i < numWheels; i++) {
			this.wheels[i] = new Wheel();
		}
	}

	public void shiftGear(int gearNumber) {
		this.gear.setGearNumber(gearNumber);
	}

	public void startEngine() {
		this.engine.start();
	}

	public void stopEngine() {
		this.engine.stop();
	}

	public void accelerate() {
		// Increase speed of the automobile using the engine and gear
	}

	public void brake() {
		// Decrease speed of the automobile
	}

	public void inflateTires() {
		for (Wheel wheel : this.wheels) {
			wheel.inflate();
		}
	}

	private class Gear {
		private int gearNumber;

		public void setGearNumber(int gearNumber) {
			this.gearNumber = gearNumber;
		}

		public void shiftUp() {
			// Shift the gear to a higher number
		}

		public void shiftDown() {
			// Shift the gear to a lower number
		}
	}

	private class Engine {
		private boolean isRunning;

		public void start() {
			this.isRunning = true;
		}

		public void stop() {
			this.isRunning = false;
		}

		public void increasePower() {
			// Increase the horsepower of the engine
		}

		public void decreasePower() {
			// Decrease the horsepower of the engine
		}
	}

	private class Wheel {
		private int tirePressure;

		public void inflate() {
			this.tirePressure = 30;
		}

		public void deflate() {
			// Decrease the tire pressure
		}
	}
}
