package africa.semicolon.ofofo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequestDTO {
    private String id;
    private String title;
    private String body;
}
