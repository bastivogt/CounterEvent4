package info.itkd;

public class Counter extends ActionDispatcher {

    private int start, finish, step, count;

    public static final String COUNTER_START = "counterStart";
    public static final String COUNTER_CHANGE = "counterChange";
    public static final String COUNTER_FINISH = "counterFinish";



    public Counter(int start, int finish, int step) {
        super();
        this.reset(start, finish, step);
    }

    public Counter(int start, int finish) {
        this(start, finish, 1);
    }

    public Counter(int start) {
        this(start, 10, 1);
    }

    public Counter() {
        this(0, 10, 1);
    }


    public int getCount() {
        return this.count;
    }











    public void run() {
        this.count = this.start;
        this.broadcast(COUNTER_START, this);
        for(; this.count < this.finish; this.count += this.step) {
            this.broadcast(COUNTER_CHANGE, this);
        }
        this.broadcast(COUNTER_FINISH, this);
    }

    public void reset(int start, int finish, int step) {
        this.start = start;
        this.finish = finish;
        this.step = step;
        this.count = this.start;
    }


}
