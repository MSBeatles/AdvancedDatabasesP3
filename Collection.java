import java.utils.Arraylist;


public class Collection {
    ArrayList<Document> documents = new ArrayList<Document>();
    int last_id;
    ArrayList<int> freeIds = new ArrayList<int>();
    int name;


    public Collection(String _name){
        last_id = -1;
        name = _name;
    }

    public Document addDocument(){
        if (freeIds.size() == 0) {
            Document doc = new Document(last_id + 1);
            last_id++;
        }
        else{
            int current_id = freeIds.get(0);
            Document doc = new Document(current_id);
            freeIds.remove(Integer.valueOf(current_id));
        }
        documents.add(doc);
        return doc;
    }


    public void deleteById(int id){
        documents.remove(id);
    }
}