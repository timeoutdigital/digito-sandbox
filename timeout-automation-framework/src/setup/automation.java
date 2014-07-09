package setup;

class ThreadMethod {
	  private int countDown = 5;

	  private Thread t;

	  private String name;

	  public ThreadMethod(String name) {
	    this.name = name;
	  }

	  public void runThread() {
	    if (t == null) {
	      t = new Thread(name) {
	        public void run() {
	          while (true) {
	            System.out.println(this);
	            if (--countDown == 0)
	              return;
	            try {
	              sleep(10);
	            } catch (InterruptedException e) {
	              throw new RuntimeException(e);
	            }
	          }
	        }

	        public String toString() {
	          return getName() + ": " + countDown;
	        }
	      };
	      t.start();
	    }
	  }
	}