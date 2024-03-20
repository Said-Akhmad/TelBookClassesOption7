public class TwitterAccount extends Contact {

    private String username;

    public String getUsername() {
        return username;
    }

    public OperationResult setUsername(String username) {
        this.username = username;
        return new OperationResult(true,null);
    }

    @Override
    public String getContactAsString() {
        return "www.twitter.com/"+username;
    }
}
