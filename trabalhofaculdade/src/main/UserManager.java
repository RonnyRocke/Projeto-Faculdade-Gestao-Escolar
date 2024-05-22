package src.main;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class UserManager {
    private String filePath;
    private Map<String, String> users;

    public UserManager(String filePath) {
        this.filePath = filePath;
        this.users = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        try {
            if (Files.exists(Paths.get(filePath))) {
                List<String> lines = Files.readAllLines(Paths.get(filePath));
                for (String line : lines) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        users.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public void addUser(String username, String password) {
        users.put(username, password);
        saveUsers();
    }

    public boolean validateUser(String username, String password) {
        return password.equals(users.get(username));
    }

    private void saveUsers() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
