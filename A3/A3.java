package A3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class A3 {

    static String file = "/home/users/inf/wiam2/iam43580903/foo.txt";

    public A3() {

    }

    public static void score () throws IOException {
        BufferedReader br =  Files.newBufferedReader(Paths.get(file));
        List<Player> players = new ArrayList<>();
        Player player = new Player();

        if (emptyFile(file)){
            procesData(players,player);
        }else {
            players = readPlayers(br);
            player.createPlayer();
            players.add(player);
            writePlayers(file,players);
            procesData(players,player);
        }
    }

    private static void procesData(List<Player> players, Player player) throws IOException {
        System.out.println("Hi han " + players.size() + " jugadors");
        for (int i = Integer.parseInt(String.valueOf(players.size())); i <= 5; i++) {
            Player player1 = new Player();
            player1.createPlayer();
            players.add(player1);
        }
        players.sort((t2, t1) -> {
            return Integer.compare(t1.getPlayerPoint(), t2.getPlayerPoint());
        });
        writePlayers(file,players);
        top5(players);
    }

    private static List<Player> readPlayers (BufferedReader br) throws IOException {
        String line = null;
        List<Player> players = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");   //  line="nombre,898"   values = {"nombre", "898" }   values[0] values[1]
            String name = values[0];
            String point = values[1];
            Player player = new Player(name, Integer.parseInt(point));
            players.add(player);
        }
        br.close();
        return players;
    }

    private static boolean emptyFile(String file){
        long lines = 0;

        try (BufferedReader foo = Files.newBufferedReader(Paths.get(file))){
            while (foo.readLine() != null){
                lines ++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        if (lines == 0){
            return true;
        }
        return false;
    }

    private static void writePlayers (String file, List<Player> players) throws IOException {
        List<String> lineas = new ArrayList<>();
        Player player;

        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            String linea = player.getPlayerName() + "," + player.playerPoint;
            lineas.add(linea);
        }
        Files.write(Paths.get(file), lineas);
    }

    private static void top5 (List<Player> players){
        System.out.println("---------- TOP 5 ------------");
        for (int i = 1; i <= 5; i++) {
            System.out.println(players.get(i));
        }
    }
}
