package practicecourt.designpattern.templatepattern.usingabstractclass;

public class MyAssembler extends BaseAssembler {

    @Override
    public MyDTO toDTO(MyEntity myEntity) {
        MyDTO myDTO = new MyDTO();
        myDTO.setName(myEntity.getName());
        myDTO.setPhone(myEntity.getPhone());
        return myDTO;
    }
}
