
public abstract class Goods {

	protected String name;
	protected Integer price;
	protected Time timer;
	protected Thread time;
	protected String date;

	abstract String getDate();

	abstract void setDate(String date);

	abstract String getName();

	abstract void setName(String name);

	abstract Integer getPrice();

	abstract void setPrice(Integer price);

	abstract Time getTimer();

	abstract void setTimer(Time timer);

}
