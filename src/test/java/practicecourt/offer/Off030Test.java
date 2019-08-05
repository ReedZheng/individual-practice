package practicecourt.offer;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Off030Test {

    @Test
    public void permutation() {
        ArrayList<String> list = new Off030().permutation("abcd");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}

