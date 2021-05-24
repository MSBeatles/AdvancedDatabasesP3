public class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String command = "";
        Database current_db;
        Collection current_collection;
        while (!command.equals("exit")){
            System.out.println("Welcome to our database. Please choose your action. Type 'help' for help");
            command = sc.nextLine();
            }
            switch(command){
                case "help":
                    getHelp();
                    break;
                case "createDB":
                    current_db = createDB();
                    break;
                case "createCollection":
                    current_collection = createCollection(current_db);
                    break;
                case "createDocument":
                    createDocument(current_collection);
                    break;
                case "query":
                    analyseQuery(command);
                    break;
            }
        }
    }

    /**
     * Prints the commands available for the user
     *
     */
    public void getHelp(){
        System.out.println("These are the available commands");
        System.out.println("createDB: Opens the prompt to create a database");
        System.out.println("createCollection: Opens the prompt to create a collection to store documents");
        System.out.println("createDocument: Opens the prompt to create a new document in our collection");
        System.out.println("query: Opens the prompt to type queries");
    }

    /**
     * Asks the user for a Database name and creates it.
     * @return the Database created
     */
    public Database createDB(){
        System.out.println("Select a name for your database");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Database db = new Database(name);
        return db;
    }

    /**
     * Asks the user for a Collection name and creates it.
     * @param db The Database we're currently working with
     * @return The Collection created
     */
    public Collection createCollection(Database db){
        System.out.println("Select a name for your collection");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        collection = db.createCollection(name);
        return collection;
    }

    /**
     * Prints instructions for the user to create a Document.
     * The Document will have a JSON-like structure where we work with Key-Value Pairs.
     * @param currentCollection the Collection we're currently working with.
     */
    public void createDocument(Collection currentCollection){
        System.out.println("Now you will create your document with the following structure:");
        System.out.println("<property1> = <value1>");
        System.out.println("<property2> = <value2>");
        System.out.println("<property3> = <value3>");
        System.out.println("Type 'exit' to finish adding properties to the document");
        System.out.println("You can add Nested structures by typing only <property>");
        Scanner sc = new Scanner(System.in);
        String command = "";
        Document doc = currentCollection.addDocument();
        while (!command.equals("exit")) {
            System.out.println("Please input <property>=<value>, <property> or exit");
            String command = sc.nextLine();
            if (!command.equals("exit")){
                if (command.indexOf("=") == -1) {
                    NestedStructure nest = doc.addNestedStructure(command);
                    System.out.println("Nested Structure created");
                    String command2 = "";
                    while(command2 != "end"){
                        System.out.println ("Now you can type <property>=<value> to create properties inside the nested structure");
                        System.out.println ("or end to go back and add more tuples to your document");
                        command2 = sc.nextLine();
                        if (!command2.equals("end")){
                            String parts = command.split("=");
                            String key = parts[0];
                            String value = parts[1];
                            nest.addKeyValuePair(key, value);
                        }
                    }
                }
                else {
                    //Read the input
                    String parts = command.split("=");
                    String key = parts[0];
                    String value = parts[1];
                    doc.addKeyValuePair(key, value);
                }
            }
            else{
                if (doc.getLength() == 0){
                    currentCollection.deleteById(doc.getId);
                }
            }
        }
    }


    /**
     * It should process the Query but I'm gonna take a break.
     * @param command
     */
    public void analyseQuery(String command){
        //Processem la query
        System.out.println("Please input your query with the following structure: ");
        System.out.println("First you can either type SELECT, DELETE, or CHANGE");
        System.out.println("Then you must say on which <key> you want to do the action (type * to delete an entire Document)");
        System.out.println("After that you must type FROM and the Collection where the <key> is stored");
        System.out.println("Finally, you can filter the results. To do this, you must type WHERE and an operator");
        System.out.println("An operator can be, for example, age > 40, name has p or deceased = false");
        Scanner sc = new Scanner(System.in);
        
    }
}