package africa.semicolon.ofofo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Post {
    @Id
    private String id;
    private String title;
    private String body;
    private LocalDateTime creationTime = LocalDateTime.now();
    @DBRef
    private List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("""
                =================================================
                id: %d
                title: %s
                body: %s
                creationTime: %s
                comments: %s
                =================================================
                """, id, title, body, creationTime, comments);
    }
}
