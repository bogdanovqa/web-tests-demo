package exceptions;

public class PathEmptyException extends Exception {
    public PathEmptyException() {
        super("Path is empty for page");
    }
}
