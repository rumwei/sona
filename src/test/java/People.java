import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
    private String name;
    private int age;
    public People(){}
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
}
