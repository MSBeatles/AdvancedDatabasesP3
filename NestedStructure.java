import java.utils.ArrayList;


public class NestedStructure{
    String title;
    ArrayList<KeyValuePair> properties;


    public NestedStructure(_title){
        this.title = _title;
    }

    public void addKeyValuePair(String _key, String _value){
        KeyValuePair kvp = new KeyValuePair(_key, _value);
        properties.add(kvp);
    }
}