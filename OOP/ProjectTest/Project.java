import java.util.HashMap;

public class Project {
    private String name;
    private String description;

public Project() {}

public Project(String name) {
    this.name = name;
}

public Project(String name, String description) {
    this.name = name;
    this.description = description;
}

public String getName(){
    return name;
}

public String getDescription(){
    return description;
}

public void setName(String name){
    this.name = name;
}

public void setDescription(String description){
    this.description = description;
}

public void elevatorPitch(){
    HashMap<String, String> info = new HashMap<String, String>();
    info.put(this.getName(), this.getDescription());
    info.forEach((k, v) -> System.out.println(k + ": " + v));
}
    
}
