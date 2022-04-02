package info.itkd;

@FunctionalInterface
public interface Action {
    void update(String type, Object src);
}
