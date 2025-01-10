import java.io.File;

public class Main {
    public static void main(String[] args) {
        File carpetaWorkingdir = new File("Workingdir");
        File carpetaValid = new File("Valid");
        File carpetaInvalid = new File("Invalid");

        if (!carpetaValid.exists()) {
            carpetaValid.mkdir();
        }

        if (!carpetaInvalid.exists()) {
            carpetaInvalid.mkdir();
        }

        for (File archivo : carpetaWorkingdir.listFiles()) {
//            Float numeroRev = archivo.getName().replaceAll("[]", " ");
            System.out.println(archivo.getName());


        }
    }
}