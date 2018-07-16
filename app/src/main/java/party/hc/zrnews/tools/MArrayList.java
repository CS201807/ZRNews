package party.hc.zrnews.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 18-7-15.
 */

public class MArrayList<T> extends ArrayList<T> {
    @Override
    public T get(int index) {
        return super.get(size()-index-1);
    }
}
