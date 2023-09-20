package StreamApiTask.Service;

import StreamApiTask.Db.DataBase;
import StreamApiTask.Model.Phone;

import java.util.List;
import java.util.Optional;

public class PhoneServiceImpl implements PhoneService{
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(Phone phone) {
        dataBase.getPhoneList().add(phone);
        return "Phone saved";
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        return dataBase.getPhoneList().stream()
                .filter(phone -> phone.getId()==phoneId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        Optional<Phone> updateName=dataBase.getPhoneList()
                .stream()
                .filter(pp->pp.getId()==phoneId)
                .findFirst();
        updateName.ifPresent(phone -> phone.setName(newName));
        return updateName.orElse(null);
    }

    @Override
    public List<Phone> getAllPhones() {
        return dataBase.getPhoneList();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return dataBase.getPhoneList().stream()
                .filter(phone -> phone.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    @Override
    public void deletePhoneById(int phoneId) {
        System.out.println(dataBase.getPhoneList().removeIf(phone -> phone.getId() == phoneId));
        System.out.println("Телефон удален");
    }
}
