package workshop.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    private static final String TXT = ".txt";

    public static void createFile(String name, String path) throws IOException {
        File file = new File(path + "/" + name + TXT);
        file.createNewFile();
    }

    public static void update(String path, String writeInto) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeInto), "UTF-8"))) {
            Stream<Path> files = Files.walk(Paths.get(path));

            List<File> filesStream = files.map(Path::toFile)
                                          .collect(Collectors.toList());


            StringBuilder stringBuilder = new StringBuilder();

            int iteration = 0;
            for(File current : filesStream) {
                stringBuilder.append("Имя файла - ").append(current.getName()).append("\n");

                if(current.isDirectory()) {
                    stringBuilder.append("Это папка").append("\n");
                } else {
                    stringBuilder.append("Это файл").append("\n");
                }
                stringBuilder.append("r " ).append(current.canRead()).append(" ");
                stringBuilder.append("w " ).append(current.canWrite()).append(" ");
                stringBuilder.append("x " ).append(current.canExecute()).append(" ");
                stringBuilder.append("\n");
                stringBuilder.append("Абсолютный путь: ").append(current.getAbsolutePath());
                stringBuilder.append("\n").append("\n");
                iteration++;

                writer.write(stringBuilder.toString());
                stringBuilder.setLength(0);

                if(iteration % 5 == 0) {
                    writer.flush();
                }
            }
        }
    }
}
