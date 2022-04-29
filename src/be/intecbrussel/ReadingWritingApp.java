package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadingWritingApp {
    public static void main(String[] args) {
        Path messagePath = Paths.get("../../FromAvivaToPearl/message.txt");
        Path animalPath = Paths.get("../../FromAvivaToPearl/animal.txt");

        try{
            Files.createDirectories(messagePath.getParent());
            if(Files.notExists(messagePath)){
                Files.createFile(messagePath);
                System.out.println("Message file created.");
            } else {
                System.out.println("Message file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            Files.createDirectories(animalPath.getParent());
            if(Files.notExists(animalPath)){
                Files.createFile(animalPath);
                System.out.println("Animal file created.");
            } else {
                System.out.println("Animal file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(messagePath)))){
            bufferedWriter.write("Mushroom walks into a bar. Bartender says to him 'We don't serve your kind in here.' ");
            bufferedWriter.write("Mushroom responds 'Aww, why not? I'm a fun-gi!'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(messagePath)))){
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FavoriteAnimal favoriteAnimal = new FavoriteAnimal("cat", false);
        FavoriteAnimal favoriteAnimal1 = new FavoriteAnimal("chocolate bunny", true);
        //System.out.println(favoriteAnimal);
        //System.out.println(favoriteAnimal1);
        try(FileOutputStream file = new FileOutputStream(String.valueOf(animalPath));
        ObjectOutputStream out = new ObjectOutputStream(file);){
            out.writeObject(favoriteAnimal);
            out.writeObject(favoriteAnimal1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream file = new FileInputStream(String.valueOf(animalPath));
             ObjectInputStream in = new ObjectInputStream(file)) {
            favoriteAnimal = (FavoriteAnimal) in.readObject();
            System.out.println(favoriteAnimal);
            favoriteAnimal1 = (FavoriteAnimal) in.readObject();
            System.out.println(favoriteAnimal1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        }

    }


