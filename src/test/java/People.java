import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
    private String name;
    private int age;
    private Hobby hobby;
    public People(){}
    public People(String name, int age, Hobby hobby){
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
}
