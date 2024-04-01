package basicLogic;

import animals.*;
import exceptions.writeException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static addAnimals.writeFile.writeToFile;
import static basicLogic.app.App;
import static basicLogic.stringConversion.StringConversion;
import static basicLogic.stringConversion.StringConversionCommands;

public class addAnimals0 {
    public static String WorkingWithUser() throws DateTimeParseException{
        String s = "";
        StringBuilder stringBuilder = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название животного (\"собака\" или \"верблюд\"):");
        s = in.nextLine().toLowerCase();
        stringBuilder.append(s).append(" ");
        System.out.println("Введите имя животного:");
        s = in.nextLine();
        stringBuilder.append(s).append(" ");
        System.out.println("Введите дату рождения животного в формате гггг-мм-дд:");
        s = in.nextLine();
        LocalDate localDate = LocalDate.parse(s);
        stringBuilder.append(s);
        System.out.println("Введите список команд, которые знает животное через запятую" +
                " БЕЗ ПРОБЕЛА, если их нет напишите -:");
        stringBuilder.append(" ").append(in.nextLine()).append(" ");
        System.out.println("Введите породу животного:");
        stringBuilder.append(in.nextLine()).append(" ");
        System.out.println("Введите характер животного:");
        stringBuilder.append(in.nextLine()).append(" \n");
//        in.close();

        return stringBuilder.toString();
    }

    public static animal AddAnimals00() throws writeException, IOException {
        String string = WorkingWithUser();
        ArrayList<String> newStringArr = StringConversion(string);
        String nameAn = newStringArr.get(0);
        nameAn = nameAn.toLowerCase();
        if (nameAn.equals("собака") || nameAn.equals("пес") || nameAn.equals("кошка")
                || nameAn.equals("кот") || nameAn.equals("хомяк")){
            writeToFile(string, 0);
        } else if (nameAn.equals("верблюд") || nameAn.equals("конь") || nameAn.equals("лошадь")
                || nameAn.equals("осел") || nameAn.equals("ослиха")) {
            writeToFile(string, 1);
        }else {
            System.out.println("Программа не знает такого животного(");
            App();
        }
        String name = newStringArr.get(1);
        LocalDate dateOfBirth = LocalDate.parse(newStringArr.get(2));
        ArrayList<String> executedCommands = StringConversionCommands(newStringArr.get(3));
        String breed = newStringArr.get(4);
        String character = newStringArr.get(5);
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
