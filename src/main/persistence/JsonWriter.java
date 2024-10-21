package persistence;

import java.io.FileNotFoundException;

import model.ParticipatingSwimmers;

// Represents a writer that writes JSON representation of ParticipatingSwimmers to file
public class JsonWriter {

    //EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {

    }

    //MODIFIES: this
    //EFFECTS: opens writer, thrwos FileNotFoundException if destination file
    //         cannot be opened for writing
    public void open() throws FileNotFoundException {

    }

    //MODIFIES: this
    //EFFECTS: writes JSON representation of ParticipatingSwimmers to file
    public void write(ParticipatingSwimmers ps) {

    }  

    //MODIFIES: this
    //EFFECTS: closes writer
    public void close() {

    }

}
