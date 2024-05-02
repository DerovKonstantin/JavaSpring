package task_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import task_1.Contro.*;
import task_1.Mode.*;

/**
 * Hello world!
 *
 */
public class AppTask1 {
    
    /* 
    - Созаем Maven проект

        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  14.989 s
        [INFO] Finished at: 2024-05-01T23:59:24+07:00
        [INFO] ------------------------------------------------------------------------
        * Terminal will be reused by tasks, press any key to close it. 
        
    - Добавляем зависимости

        - Apache Commons Lang » 3.14.0
            <dependency>
                <groupId>org.apache.commons</groupId>
                <artifactId>commons-lang3</artifactId>
                <version>3.14.0</version>
            </dependency>
        
        - Gson » 2.10.1
            <dependency>
                <groupId>com.google.code.gson</groupId>
                <artifactId>gson</artifactId>
                <version>2.10.1</version>
            </dependency>

        */

    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
         // Создаем список студентов
        List<Student> studList = new ArrayList<Student>(Arrays.asList(
            new Student("Иван", "Иванов", 25, 121),
            new Student("Игорь", "Петров", 23, 301),
            new Student("Иван", "Сиоров", 22, 121),
            new Student("Игорь", "Ильйн", 23, 444),
            new Student("Даша", "Морозова", 23, 171),
            new Student("Лена", "Ленина", 23, 104)
        ));

        // Создаем группу
        StudentGroup group = new StudentGroup(studList, 1);
        studList.stream().forEach(System.out::println);   

        /*  станартная серриализация объектов
        // Сохраняем полученные данные
        DataContro.save("student_group_data_1.bin", group);
        
        // Загружаем полученные данные
        StudentGroup loadedGroup = (StudentGroup) DataContro.load("student_group_data_1.bin");
        loadedGroup.getGroup().stream().forEach(System.out::println);
        */
        
        // Используем gson для сериализации и десериализации объектов 
        Gson gson = new Gson();
        String jsonString = gson.toJson(group);
        System.out.println(jsonString);

        StudentGroup loadedGroup = gson.fromJson(jsonString, StudentGroup.class);
        loadedGroup.getGroup().stream().forEach(System.out::println);

    }
}
