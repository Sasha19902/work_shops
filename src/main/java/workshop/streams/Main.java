package workshop.streams;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String path = scanner.nextLine();
        String filePath = scanner.nextLine();

        FileService.createFile(name, path);
        FileService.update(filePath, path + "/" + name + ".txt");
    }
}
