package info.itkd;

public class Counter2 implements IActionDispatcher {

    private int start, finish, step, count;
    private ActionDispatcher actionDispatcher;

    public static final String COUNTER_START = "counterStart";
    public static final String COUNTER_CHANGE = "counterChange";
    public static final String COUNTER_FINISH = "counterFinish";



    public Counter2(int start, int finish, int step) {
        actionDispatcher = new ActionDispatcher();
        this.reset(start, finish, step);
    }

    public Counter2(int start, int finish) {
        this(start, finish, 1);
    }

    public Counter2(int start) {
        this(start, 10, 1);
    }

    public Counter2() {
        this(0, 10, 1);
    }



    @Override
    public Boolean hasListener(String type) {
        return actionDispatcher.hasListener(type);
    }

    @Override
    public Boolean addListener(String type, IAction action) {
        return actionDispatcher.addListener(type, action);
    }

    @Override
    public Boolean removeListener(String type) {
        return actionDispatcher.removeListener(type);
    }

    @Override
    public void dispatchAction(String type, Object src) {
        actionDispatcher.dispatchAction(type, src);
    }


    public int getCount() {
        return this.count;
    }


    public void run() {
        this.count = this.start;
        this.dispatchAction(COUNTER_START, this);
        for(; this.count < this.finish; this.count += this.step) {
            this.dispatchAction(COUNTER_CHANGE, this);
        }
        this.dispatchAction(COUNTER_FINISH, this);
    }

    public void reset(int start, int finish, int step) {
        this.start = start;
        this.finish = finish;
        this.step = step;
        this.count = this.start;
    }

}
