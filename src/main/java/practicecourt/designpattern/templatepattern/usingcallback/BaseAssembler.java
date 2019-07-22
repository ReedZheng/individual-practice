package practicecourt.designpattern.templatepattern.usingcallback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Date: 2018/12/11
 */
public class BaseAssembler {

    public List<MyDTO> toDTOList(List<MyEntity> myEntityList, MyCallBack myCallBack) {
        List<MyDTO> targetList = new ArrayList<>();

        if (myEntityList != null && myEntityList.size() > 0) {
            targetList = myEntityList.stream().map(i -> myCallBack.toDTO(i)).collect(Collectors.toList());
        }

        return targetList;
    }
}
