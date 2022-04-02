package info.itkd;

public class Main {

    public static void main(String[] args) {
	    Counter counter = new Counter();

        counter.addListener(Counter.COUNTER_START, new Action() {
            @Override
            public void update(String type, Object src) {
                Counter c = (Counter) src;
                System.out.println(Counter.COUNTER_START + ": " + c.getCount());
            }
        });


        counter.addListener(Counter.COUNTER_CHANGE, (String type, Object src) -> {
            Counter c = (Counter) src;
            System.out.println(Counter.COUNTER_CHANGE + ": " + c.getCount());
        });

        //counter.removeListener(Counter.COUNTER_CHANGE);

        counter.addListener(Counter.COUNTER_FINISH, Main::counterFinishAction);

        counter.run();
    }

    public static void counterFinishAction(String type, Object src) {
        Counter c = (Counter) src;
        System.out.println(Counter.COUNTER_FINISH + ": " + c.getCount());
    }
}
