package basicLogic;

import animals.animal;
import animals.packAnimals;
import animals.pets;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static basicLogic.basicLogic.*;

public class app {

    public static void App() throws IOException, DateTimeParseException, InputMismatchException {
        ArrayList<pets> arrayListPets = InitialFileVerificationPets();
        ArrayList<packAnimals> arrayListPackAnimals = InitialFileVerificationPackAnimals();
        System.out.println("Вот список доступных команд:");
        System.out.println("Посмотреть список всех животных, нажмите - a");
        System.out.println("Добавить новое животное, нажмите - s");
        System.out.println("Посмотреть список команд, которое может выполнять животное, нажмите - d");
        System.out.println("Обучить животное новым командам, нажмите - w");
        System.out.println("Вывести список животных по дате рождения, нажмите - e");
        System.out.println("Вывести количество всех животных, нажмите - z");
        System.out.println("Чтобы завершить работу программы, нажмите - x");
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        if (command.length() != 1){
            System.out.println("Либо вы специально ввели много символов, либо  специально ничего не ввели" +
                    " либо случайно нажали пробел в конце, " +
                    "попробуйте еще раз.");
            App();
        }
        switch (command){

            case "x":
                in.close();
                System.exit(1);
                break;
            case "a":
                CheckAllAnimal(arrayListPets, arrayListPackAnimals);
                break;
            case "s":
                AddAnimals();
                App();
                break;
            case "d":
                GetCommandsAnimal(arrayListPets, arrayListPackAnimals);
                App();
                break;
            case "w":
                OverWritingCommand0(arrayListPets, arrayListPackAnimals);
                App();
                break;
            case "e":
                GetAnimalForDate(arrayListPets, arrayListPackAnimals);
                App();
                break;
            case "z":
                GetCount(arrayListPets, arrayListPackAnimals);
                App();
                break;
            default:
                System.out.println("Такой команды нет!");
                App();
        }
    }
    private static void CheckAllAnimal(ArrayList<pets> arrayListPets,
                                       ArrayList<packAnimals> arrayListPackAnimals) throws IOException {
        animal animal;
        System.out.println("Это домашние животные:");
        for (int i = 0; i < arrayListPets.size(); i++) {
            animal = arrayListPets.get(i);
            System.out.println("№" + (i + 1) + " " + animal.toString());
        }
        System.out.println("Это вьючные животные:");
        for (int i = 0; i < arrayListPackAnimals.size(); i++) {
            animal = arrayListPackAnimals.get(i);
            System.out.println("№" + (i + 1) + " " + animal.toString());
        }
        App();
    }

    private static void GetCommandsAnimal(ArrayList<pets> arrayListPets,
                                          ArrayList<packAnimals> arrayListPackAnimals) throws IOException {
        System.out.println("Введите 0 если хотите посмотреть команду домашнего животного, либо" +
                " введите 1 если хотите посмотреть команду вьючного животного:");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.println("Введите номер под которым указано ваше животное, его можно посмотреть в списках" +
                " всех животных");
        int j = in.nextInt();
        ArrayList<String> arrayList = null;
        if (i == 0){
            if (j > arrayListPets.size() || j < 1){
                System.out.println("Вы ввели номер животного которого не существует.");
                App();
            }
            else {
                arrayList = GetCommandsPets(arrayListPets, j - 1);
            }
        }
        else {
            if (j > arrayListPackAnimals.size() || j < 1){
                System.out.println("Вы ввели номер животного которого не существует.");
                App();
            }
            else {
                arrayList = GetCommandsPackAnimals(arrayListPackAnimals, j - 1);
            }
        }
        for (String s : arrayList) {
            System.out.println(s);
        }
        App();
    }
    private static void OverWritingCommand0(ArrayList<pets> arrayListPets,
                                           ArrayList<packAnimals> arrayListPackAnimals) throws IOException {
        System.out.println("Введите 0 если хотите изменить команду домашнего животного, либо" +
                " введите 1 если хотите изменить команду вьючного животного:");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.println("Введите номер под которым указано ваше животное, его можно посмотреть в списках" +
                " всех животных");
        int j = in.nextInt();
        if (i == 0){
            if (j > arrayListPets.size() || j < 1){
                System.out.println("Вы ввели номер животного которого не существует.");
                App();
            }
            else {
                OverWritingComm(0, j -1, arrayListPets.get(j-1));
            }
        }
        else {
            if (j > arrayListPackAnimals.size() || j < 1){
                System.out.println("Вы ввели номер животного которого не существует.");
                App();
            }
            else {
                OverWritingComm(1, j -1, arrayListPackAnimals.get(j-1));
            }
        }
    }
}


