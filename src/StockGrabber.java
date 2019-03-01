import java.util.ArrayList;

public class StockGrabber implements Subject{

	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	public StockGrabber() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void register(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void unregister(Observer observer) {
		int observerIndex = observers.indexOf(observer);
		observers.remove(observerIndex);
		
		System.out.println("Observer " + (observerIndex + 1) + " deleted");
		
		
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
		
	}
	
	public void setIBMPrice(double newIBMPrice) {
		this.ibmPrice = newIBMPrice;
		notifyObserver();
	}
	
	public void setGoogPrice(double newGoogPrice) {
		this.googPrice = newGoogPrice;
		notifyObserver();
	}
	
	public void setAaplPrice(double newAaplPrice) {
		this.aaplPrice = newAaplPrice;
		notifyObserver();
	}
	
	public double getIBMPrice(){
		return this.ibmPrice;
	}
	
	public double getGoogPrice(){
		return this.googPrice;
	}
	
	public double getAaplPrice(){
		return this.aaplPrice;
	}

}
