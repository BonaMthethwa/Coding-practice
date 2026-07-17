
package za.ac.ui;


public class FrameClass {
    private String message;
    private String byts;
    private String punct;

    public FrameClass(String message, String byts, String punct) {
        this.message = message;
        this.byts = byts;
        this.punct = punct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getByts() {
        return byts;
    }

    public void setByts(String byts) {
        this.byts = byts;
    }

    public String getPunct() {
        return punct;
    }

    public void setPunct(String punct) {
        this.punct = punct;
    }
    
    
    
}
