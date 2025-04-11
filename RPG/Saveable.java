package RPG;

import java.io.IOException;

public interface Saveable {
    void saveToFile(String filename) throws IOException;
    Character loadFromFile(String filename) throws IOException, ClassNotFoundException;
}