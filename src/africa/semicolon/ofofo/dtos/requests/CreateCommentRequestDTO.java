package africa.semicolon.ofofo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentRequestDTO {
    private String postId;
    private String commenterName;
    private String comment;
}
