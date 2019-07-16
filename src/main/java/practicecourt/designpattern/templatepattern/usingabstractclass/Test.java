package practicecourt.designpattern.templatepattern.usingabstractclass;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        MyEntity myEntity = new MyEntity();
        myEntity.setAddress("aaaa");
        myEntity.setName("mingzi");
        myEntity.setPhone("185544551");
        MyEntity myEntity2 = new MyEntity();
        myEntity2.setAddress("bbb");
        myEntity2.setName("mingzi2");
        myEntity2.setPhone("12323233");
        List<MyEntity> list = new ArrayList<>();
        list.add(myEntity);
        list.add(myEntity2);

        MyAssembler myAssembler = new MyAssembler();
        List<MyDTO> myDTOS = myAssembler.toDTOList(list);
        myDTOS.stream().forEach(System.out::println);
    }
}
