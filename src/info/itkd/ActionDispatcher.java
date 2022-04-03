package info.itkd;

import java.util.ArrayList;

public class ActionDispatcher {

    protected ArrayList<Listener> listeners;

    public ActionDispatcher() {
        listeners = new ArrayList<Listener>();
    }

    public Boolean hasListener(String type) {
        for (Listener listener : listeners) {
            if (listener.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public Boolean addListener(String type, Action action) {
        if (!hasListener(type)) {
            listeners.add(new Listener(type, action));
            return true;
        }
        return false;
    }

    public Boolean removeListener(String type) {
        for (Listener listener : listeners) {
            if (listener.getType() == type) {
                listeners.remove(listener);
                return true;
            }
        }
        return false;
    }

    public void dispatch(String type, Object src) {
        for (Listener listener : listeners) {
            if (listener.getType() == type) {
                listener.getAction().update(type, src);
            }
        }
    }
}
