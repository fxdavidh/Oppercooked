
public class Time implements Runnable {
	Integer secs;

	public Time(Integer start) {
		this.secs = start;
	}

	@Override
	public void run() {
		while (this.secs > 0) {
			try {
				secs--;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}