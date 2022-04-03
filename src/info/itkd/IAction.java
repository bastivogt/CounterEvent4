package info.itkd;

@FunctionalInterface
public interface IAction {
    void update(String type, Object src);
}
