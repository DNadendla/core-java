package streams.model;

public class City {
    private int id;
    private String name;
    private String code;
    private State state;

    // Constructor
    public City(int id, String name, String code, State state) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.state = state;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", state=" + state +
                '}';
    }
}