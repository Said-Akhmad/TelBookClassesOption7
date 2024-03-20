public class FacebookAccount extends Contact {

    private String username;

    public String getUsername() {
        return username;
    }

    public OperationResult setUsername(String username) {

        final String validInputFormat = "[a-zA-Z0-9-_]*";

        if (username.matches(validInputFormat)) {
            this.username = username;
        } else {
            return new OperationResult(false, "Not a valid format of username, should be "+validInputFormat);
        }

        return new OperationResult(true, null);
    }

    @Override
    public String getContactAsString() {
        return "www.facebook.com/people/"+username;
    }
}
