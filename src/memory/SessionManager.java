package memory;


import java.util.HashMap;
import java.util.Map;


/*
* SessionManager:
* - Simple in-memory session store to demonstrate Sessions & Memory feature.
* - Design: A minimal key-value store. In production you might use a DB or a MemoryBank.
* - Behavior: Stores small contextual pieces like last email snippet, last draft, final reply.
*/


public class SessionManager {
private Map<String, String> store;


public SessionManager() {
this.store = new HashMap<>();
}


public void put(String key, String value) {
store.put(key, value);
}


public String get(String key) {
return store.get(key);
}


public String debugSnapshot() {
// Return a human-readable snapshot of stored keys for demo/observability
StringBuilder sb = new StringBuilder();
for (Map.Entry<String, String> e : store.entrySet()) {
sb.append(e.getKey()).append(" => ").append(e.getValue()).append("\n");
}
return sb.toString();
}
}
