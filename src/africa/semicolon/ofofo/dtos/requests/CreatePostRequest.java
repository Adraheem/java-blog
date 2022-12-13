package africa.semicolon.ofofo.dtos.requests;

public class CreatePostRequest {
    private String title;
    private String body;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
