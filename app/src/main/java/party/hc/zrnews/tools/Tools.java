package party.hc.zrnews.tools;

import java.util.List;

/**
 * Created by ubuntu on 18-7-15.
 */

public class Tools {
    public static <T>  T listGet(List<T> list,int number){
        return list.get(list.size()-number-1);
    }
}
