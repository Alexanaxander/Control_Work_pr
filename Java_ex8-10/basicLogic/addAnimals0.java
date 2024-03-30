package basicLogic;

import animals.*;
import exceptions.writeException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static addAnimals.writeFile.writeToFile;
import static basicLogic.stringConversion.StringConversion;

public class addAnimals0 {
    public static String WorkingWithUser(Scanner in){
        String s = "";
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Введите имя животного:");
        s = in.nextLine();
        stringBuilder.append(s).append(" ");
        System.out.println("Введите дату рождения животного в формате гггг-мм-дд:");
        s = in.nextLine();
        LocalDate localDate = LocalDate.parse(s);
        stringBuilder.append(s).append(" ");
        System.out.println("Введите список команд, которые знает животное через пробел:");
        stringBuilder.append(in.nextLine()).append(" ");
        System.out.println("Введите породу животного:");
        stringBuilder.append(in.nextLine()).append(" ");
        System.out.println("Введите характер животного:");
        stringBuilder.append(in.nextLine()).append(" ");

        return stringBuilder.toString();
    }

    public static animal AddAnimals00() throws writeException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название животного (\"собака\" или \"верблюд\"):");
        String nameAn = in.nextLine();
        String string = WorkingWithUser(in);
        in.close();
        nameAn = nameAn.toLowerCase();
        if (nameAn.equals("собака") || nameAn.equals("пес") || nameAn.equals("кошка")
                || nameAn.equals("кот") || nameAn.equals("хомяк")){
            writeToFile(string, 0);
        } else if (nameAn.equals("верблюд") || nameAn.equals("конь") || nameAn.equals("лошадь")
                || nameAn.equals("осел") || nameAn.equals("ослиха")) {
            writeToFile(string, 1);
        }else {
            System.out.println("Программа не знает такого животного(");
            System.exit(1);
        }
        ArrayList<String> newStringArr = StringConversion(string);
        String name = newStringArr.get(0);
        LocalDate dateOfBirth = LocalDate.parse(newStringArr.get(1));
        ArrayList<String> executedCommands = StringConversion(newStringArr.get(2));
        String breed = newStringArr.get(3);
        String character = newStringArr.get(4);
        return switch (nameAn) {
            case "собака", "пес" -> new dogs(name, dateOfBirth, executedCommands, breed, character);
            case "кот", "кошка" -> new cats(name, dateOfBirth, executedCommands, breed, character);
            case "хомяк" -> new hamsres(name, dateOfBirth, executedCommands, breed, character);
            case "лошадь", "конь" -> new horses(name, dateOfBirth, executedCommands, breed, character);
            case "ослиха", "осел" -> new donkeys(name, dateOfBirth, executedCommands, breed, character);
            case "верблюд" -> new camels(name, dateOfBirth, executedCommands, breed, character);
            default -> new dogs("0", dateOfBirth, executedCommands, "2",
                    "3");
        };
    }
}