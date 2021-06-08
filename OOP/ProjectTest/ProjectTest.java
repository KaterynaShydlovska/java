public class ProjectTest {
    public static void main(String[] args) {
        Project project = new Project();
        project.setName("MyFirstProject");
        project.setDescription("First Java project");
        System.out.println(project.getName());
        System.out.println(project.getDescription());
        project.elevatorPitch();
    }
    
}
