package practicecourt.designpattern.templatepattern.usingcallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2018/12/11
 */
public class Test {

    public static void main(String[] args) {
        MyEntity myEntity = new MyEntity();
        myEntity.setAddress("华夏路100号");
        myEntity.setName("mapin");
        myEntity.setPhone("185544551");
        MyEntity myEntity2 = new MyEntity();
        myEntity2.setAddress("查令十字街80号");
        myEntity2.setName("kin");
        myEntity2.setPhone("12323233");
        List<MyEntity> list = new ArrayList<>();
        list.add(myEntity);
        list.add(myEntity2);

        BaseAssembler baseAssembler = new BaseAssembler();
        // List<MyDTO> myDTOS = baseAssembler.toDTOList(list, new MyCallBack() {
        //     @Override
        //     public MyDTO toDTO(MyEntity entity) {
        //         MyDTO myDTO = new MyDTO();
        //         myDTO.setName(entity.getName() + " -*-");
        //         return myDTO;
        //     }
        // });
        List<MyDTO> myDTOS = baseAssembler.toDTOList(list, (MyEntity entity) -> {
            MyDTO myDTO = new MyDTO();
            myDTO.setName(entity.getName() + " -*-");
            return myDTO;
        });
        myDTOS.stream().forEach(System.out::println);
    }
}
