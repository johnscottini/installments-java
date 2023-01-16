package model.entities;

public class Vehicle {

		public Vehicle(String model) {
		super();
		this.model = model;
	}

		private String model;

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}
		
}
