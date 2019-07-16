package practicecourt.designpattern.templatepattern.usingabstractclass;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class BaseAssembler {

    public abstract MyDTO toDTO(MyEntity myEntity);

    public List<MyDTO> toDTOList(List<MyEntity> list) {
        List<MyDTO> targetList = new ArrayList<>();

        if (list != null && list.size() > 0) {
            targetList = list.stream().map(i -> toDTO(i)).collect(toList());
        }

        return targetList;
    }
}
