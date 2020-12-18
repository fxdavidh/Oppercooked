
public class Dessert extends Goods {

	private String topping;
	private Float calories;

	public Dessert(String name, Integer price, String topping, Float calories, Integer timer, String date) {
		super();
		this.name = name;
		this.price = price;
		this.topping = topping;
		this.calories = calories;
		this.timer = new Time(timer);
		this.date = date;
	}

	void cook() {
		time = new Thread(timer);
		time.start();
	}

	@Override
	String getDate() {
		return this.date;
	}

	@Override
	void setDate(String date) {
		this.date = date;
	}

	@Override
	String getName() {
		return this.name;
	}

	@Override
	void setName(String name) {
		this.name = name;
	}

	@Override
	Integer getPrice() {
		return this.price;
	}

	@Override
	void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	Time getTimer() {
		return this.timer;
	}

	@Override
	void setTimer(Time timer) {
		this.timer = timer;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public Float getCalories() {
		return calories;
	}

	public void setCalories(Float calories) {
		this.calories = calories;
	}

}
