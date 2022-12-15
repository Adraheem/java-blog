package africa.semicolon.ofofo;

import africa.semicolon.ofofo.controllers.PostController;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequestDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.*;
import java.util.Scanner;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static final PostController postController = new PostController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        displayMainMenu();
    }

    private static void displayMainMenu() {
        String mainMenu = """
                Press 1 to create post
                Press 2 to view post
                Press 3 to view all posts
                Press 4 to exit
                """;
        String userInput = input(mainMenu);
        switch (Integer.parseInt(String.valueOf(userInput.charAt(0)))) {
            case 1 -> createPost();
            case 2 -> viewPost();
            case 3 -> viewAllPosts();
            case 4 -> exitFromApp();
        }
    }

    private static void viewAllPosts() {
        print(postController.viewAllPosts().toString());
        displayMainMenu();
    }

    private static void exitFromApp() {
        print("Thank you for using our app");
        System.exit(0);
    }

    private static void viewPost() {
        String userInput = input("Enter post id");
        print(postController.viewPost(
                        String.valueOf(userInput.charAt(0))
        ).toString());
        displayMainMenu();
    }

    private static void createPost() {
        String title = input("Enter post title");
        String body = input("Enter post body");
        CreatePostRequestDTO createPostRequestDTO = new CreatePostRequestDTO(title, body);
        print(postController.createPost(createPostRequestDTO));
        displayMainMenu();
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(null, prompt);
//        print(prompt);
//        return keyboardInput.nextLine();
    }

    private static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
//        System.out.println(prompt);
    }
}
