package ru.ylabs.crosszero.component;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import ru.ylabs.crosszero.model.Player;

public class LoggerFile implements LoggerPoint {

    private final Path path;

    private final List<String> lines;

    public LoggerFile(final String path) throws IOException {
        this.path = Path.of(path);
        this.lines = Collections.unmodifiableList(Files.readAllLines(this.path));
    }


    @Override
    public void logg(final Player player) {
        UserInfo user = findUserFromFile(player);
        user.setPoint(user.getPoint() + 10);
        List<UserInfo> newList = lines.stream()
            .map(this::parseLine)
            .filter(u -> !u.getUsername().equals(user.getUsername()))
            .collect(Collectors.toList());
        newList.add(user);
        writeUserToFile(newList);
    }

    private void writeUserToFile(List<UserInfo> userList) {
//        List<String> writeList = userList.stream().map(user -> user.getUsername() + " " + user.getPoint()).collect(
//            Collectors.toList());
//        try {
//            Files.write(path, writeList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File fileName = new File(path.toString());
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        ) {
            for (final UserInfo user : userList) {
                String line = user.getUsername() + " " + user.getPoint();
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private UserInfo findUserFromFile(final Player player) {
        return lines
            .stream()
            .map(this::parseLine)
            .filter(p -> p.getUsername().equals(player.getUsername()))
            .findAny()
            .orElse(new UserInfo(player.getUsername(), 0));
    }

    private UserInfo parseLine(String line) {
        List<String> parseLine = Arrays.asList(line.split(" "));
        int score;
        try {
            score = Integer.parseInt(parseLine.get(1));
        } catch (Exception e) {
            score = 0;
        }
        return new UserInfo(parseLine.get(0), score);
    }

    private static class UserInfo {
        private final String username;

        private int point;

        private UserInfo(final String username, final int point) {
            this.username = username;
            this.point = point;
        }

        public String getUsername() {
            return username;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(final int point) {
            this.point = point;
        }
    }
}
