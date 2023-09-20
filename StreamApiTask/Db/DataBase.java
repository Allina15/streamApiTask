package StreamApiTask.Db;

import StreamApiTask.Model.Contact;
import StreamApiTask.Model.Phone;

import java.util.Collection;
import java.util.List;

public class DataBase {
    private List<Phone>phoneList;
    private List<Contact>contacts;

    public DataBase(List<Phone> phoneList,List<Contact>contacts) {
        this.phoneList = phoneList;
        this.contacts = contacts;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "phoneList=" + phoneList +
                '}';
    }
}
