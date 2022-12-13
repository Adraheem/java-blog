package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void updatedPost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);

    List<Post> viewAllPosts();
}
