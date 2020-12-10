package dev.dankom.hoc.file;

import dev.dankom.hoc.file.json.JsonFile;
import dev.dankom.hoc.file.json.JsonObjectBuilder;

public class FileManager {
    public Directory root = new Directory("./HOC");
    public JsonFile privateFile = new JsonFile(root, "private", new JsonObjectBuilder().addKeyValuePair("token", "").build());
}
