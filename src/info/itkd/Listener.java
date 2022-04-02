package info.itkd;

public class Listener {


    private String type;
    private Action action;
    public Listener(String type, Action action) {
        this.type = type;
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public Action getAction() {
        return action;
    }
}
