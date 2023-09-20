package StreamApiTask.Service;

import StreamApiTask.Db.DataBase;
import StreamApiTask.Model.Contact;
import StreamApiTask.Model.Phone;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        for (int i = 0; i < dataBase.getPhoneList().size(); i++) {
            if (dataBase.getPhoneList().get(i).getId() == phoneId) {
                dataBase.getPhoneList().get(i).getContact().add(contact);
            }
        }
        return "Contact saved";
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        return dataBase.getPhoneList().stream()
                .filter(phone -> phone.getId() == phoneId)
                .flatMap(phone -> phone.getContact().stream())
                .filter(contact -> contact.getName().toLowerCase().contains(contactName.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, int phoneNumber) {
         dataBase.getPhoneList().stream()
                .filter(phone -> phone.getId() == phoneId)
                .flatMap(phone -> phone.getContact().stream())
                .filter(contact -> contact.getPhoneNumber()==phoneNumber)
                .forEach(System.out::println);
         return null;
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        return dataBase.getPhoneList().stream()
                .filter(phone -> phone.getId()==phoneId)
                .flatMap(phone -> phone.getContact().stream())
                .sorted((x1, x2) -> x1.getName().compareTo(x2.getName())).collect(Collectors.toList());
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Phone phone=dataBase.getPhoneList().get(phoneId);
        if(phone!=null) {
            System.out.println(phone.getContact().removeIf(contact -> contact.getName().equals(contactName)));
        }
    }
}
