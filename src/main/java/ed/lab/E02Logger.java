package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private final Map<String, Integer> messageTimestamps;

    public E02Logger() {
        this.messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message) || timestamp >= messageTimestamps.get(message)) {
            messageTimestamps.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}

//Hashmap, como descarte,