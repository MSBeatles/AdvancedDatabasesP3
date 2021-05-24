import java.utils.ArrayList;


public class Database{
    String name;
    ArrayList<Collection> collections = new ArrayList<Collection>();

    public Database(String _name){
        this.name = _name;
    }


    public Collection createCollection(String collectionName){
        Collection coll = new Collection (collectionName);
        collections.add(coll);
        return coll;
    }
}