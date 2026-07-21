// Internal implementation of HashMap

class MapUsingHash {
    private Entity[] entities; // internally it is an array of Entity type

    public MapUsingHash(){
        entities = new Entity[100]; // let for 100 elements
    }

    private class Entity {
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Put 
    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value); // overriding
    }

    // Get
    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);

        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    // Remove key
    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);

        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }

    }
}

public class HashMap {
    public static void main(String[] args) {
        MapUsingHash map = new MapUsingHash();

        map.put("Bengaluru", "RCB");
        map.put("Delhi", "DC");
        map.put("Mumbai", "MI");

        System.out.println(map.get("Bengaluru"));
    }
}