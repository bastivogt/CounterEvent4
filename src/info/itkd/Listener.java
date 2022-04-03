package info.itkd;

public class Listener {


    private String type;
    private IAction action;
    public Listener(String type, IAction action) {
        this.type = type;
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public IAction getAction() {
        return action;
    }
}
