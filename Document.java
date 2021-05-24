import java.utils.ArrayList;


public class Document{
    ArrayList<KeyValuePair> properties = new ArrayList<KeyValuePair>();
    ArrayList<NestedStructure> nested_properties = new ArrayList<NestedStructure>();
    int id;

    public Document (int _id){
        this.id = _id;
    }
    public void addKeyValuePair(String _key, String _value){
        KeyValuePair kvp = new KeyValuePair(_key, _value);
        properties.add(kvp);
    }

    public NestedStructure addNestedStructure(String name){
        NestedStructure nest = new NestedStructure(name);
        return nest;
    }


    public int getLength(){
        return properties.size() + nested_properties.size();
    }
}