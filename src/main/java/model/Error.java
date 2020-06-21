package model;

public class Error {

    private int code;
    private String type;
    private String info;

    public Error() {
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
