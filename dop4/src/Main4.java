import java.lang.reflect.*;

public class Main4 {
    public static void main(String[] args) {
        ClassSelector loader = new ClassSelector("", "Dog");
        Class obj;
        try {
            obj = loader.load();

            System.out.println("NAME: " + obj.getName());

            System.out.println(PrintClass.printFields(obj));

            System.out.println(PrintClass.printCostructors(obj));

            System.out.println(PrintClass.printMethods(obj));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}