
public class Beverage extends Goods {

	private String flavor;
	private String size;

	public Beverage(String name, Integer price, String flavor, String size, Integer timer, String date) {
		super();
		this.name = name;
		this.price = price;
		this.flavor = flavor;
		this.size = size;
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

	public String getFlavor() {
		return flavor;
	}

	public void SetFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
