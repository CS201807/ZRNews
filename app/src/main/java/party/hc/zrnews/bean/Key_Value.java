package party.hc.zrnews.bean;

/**
 * Created by ubuntu on 18-7-16.
 */

public class Key_Value {
    private String key;
    private String value;

    public Key_Value(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
