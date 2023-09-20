package StreamApiTask;

import StreamApiTask.Db.DataBase;
import StreamApiTask.Model.Contact;
import StreamApiTask.Model.Phone;
import StreamApiTask.Service.ContactServiceImpl;
import StreamApiTask.Service.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contact contact1 = new Contact("John Doe", 1234567890);
        Contact contact2 = new Contact("Jane Smith", 987654321);
        Contact contact3 = new Contact("Alice Johnson", 555555555);
        Contact contact4 = new Contact("Bob Brown", 333333333);
        Contact contact5 = new Contact("Eve Wilson", 666666666);
        Contact contact6 = new Contact("Charlie Davis", 111111111);
        Contact contact7 = new Contact("Katy Grey",123456789);
        List<Contact> contactList1 = new ArrayList<>(Arrays.asList(contact1,contact2,contact3));
        List<Contact> contactList2 = new ArrayList<>(Arrays.asList(contact4,contact5,contact6));
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(contactList1);
        contacts.addAll(contactList2);

        Phone phone1 = new Phone("Iphone X", "Apple",contactList1);
        Phone phone2 = new Phone("Samsung", "Android",contactList2);
        Phone phone3 = new Phone("Redmi", "Android",null);

        List<Phone>phoneList = new ArrayList<>(Arrays.asList(phone1,phone2));
        DataBase dataBase = new DataBase(phoneList,contacts);

        Scanner scanner = new Scanner(System.in);
        ContactServiceImpl service = new ContactServiceImpl(dataBase);
        PhoneServiceImpl phoneService = new PhoneServiceImpl(dataBase);
        while (true) {
            System.out.println("Выберите действие:\n1.Add new contact\n2.Find contact by name\n3.Find contact by phone number\n4.Sort contacts by name\n5.Delete contact by name from phone" +
                    "\n6.Add phone\n7.Get phone by id\n8.Update phone name by id\n9.Get all phones\n10.Get all phones by brand\n11.Delete phone by id");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите айди телефона ");
                    System.out.println(service.addContactToPhone(scanner.nextInt(), contact7));
                    break;
                case 2:
                    System.out.println("Введите айди телефона");
                    int id = scanner.nextInt();
                    System.out.println("Введите имя контакта");
                    String name = scanner.next();
                    System.out.println(service.findContactByName(id, name));
                    break;
                case 3:
                    System.out.println("Введите айди телефона");
                    int idd = scanner.nextInt();
                    System.out.println("Введите number контакта");
                    int number = scanner.nextInt();
                    service.findContactByPhoneNumber(idd,number);
                    break;
                case 4:
                    System.out.println("Введите айди телефона");
                    int idd1 = scanner.nextInt();
                    System.out.println(service.sortContactsByName(idd1));
                    break;
                case 5:
                    System.out.println("Введите айди телефона");
                    int idd2 = scanner.nextInt();
                    System.out.println("Введите имя контакта");
                    String name2 = scanner.next();
                    service.deleteContactByNameFromPhone(idd2,name2);
                    break;
                case 6:
                    System.out.println(phoneService.addPhone(phone3));
                    break;
                case 7:
                    System.out.println("Введите айди телефона");
                    int idd3 = scanner.nextInt();
                    System.out.println(phoneService.getPhoneById(idd3));
                    break;
                case 8:
                    System.out.println("Введите айди телефона");
                    int idd4 = scanner.nextInt();
                    System.out.println("Введите новое имя ");
                    String name3 = scanner.next();
                    System.out.println(phoneService.updatePhoneNameById(idd4, name3));
                    break;
                case 9:
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 10:
                    System.out.println("Введите brand");
                    String brand = scanner.next();
                    System.out.println(phoneService.getAllPhonesByBrand(brand));
                    break;
                case 11:
                    System.out.println("Введите айди телефона");
                    int idd5 = scanner.nextInt();
                    phoneService.deletePhoneById(idd5);
            }
        }
    }
}
