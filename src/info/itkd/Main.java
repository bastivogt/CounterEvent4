package info.itkd;

public class Main {

    public static void main(String[] args) {
	    Counter counter = new Counter();

        counter.addListener(Counter.COUNTER_START, new IAction() {
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


        System.out.println("------------------------------------------------------------------");



        // Counter2
        Counter2 counter2 = new Counter2(10, 20, 1);

        counter2.addListener(Counter2.COUNTER_START, (String type, Object src) -> {
            Counter2 c = (Counter2) src;
            System.out.println(Counter.COUNTER_START + ": " + c.getCount());
        });

        counter2.addListener(Counter2.COUNTER_CHANGE, (String type, Object src) -> {
            Counter2 c = (Counter2) src;
            System.out.println(Counter.COUNTER_CHANGE + ": " + c.getCount());
        });

        counter2.addListener(Counter2.COUNTER_FINISH, (String type, Object src) -> {
            Counter2 c = (Counter2) src;
            System.out.println(Counter.COUNTER_FINISH + ": " + c.getCount());
        });

        counter2.run();
    }

    public static void counterFinishAction(String type, Object src) {
        Counter c = (Counter) src;
        System.out.println(Counter.COUNTER_FINISH + ": " + c.getCount());
    }
}
