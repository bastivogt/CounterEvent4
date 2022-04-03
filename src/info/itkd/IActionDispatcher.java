package info.itkd;

public interface IActionDispatcher {
    Boolean hasListener(String type);
    Boolean addListener(String type, IAction action);
    Boolean removeListener(String type);
    void dispatchAction(String type, Object src);
}
