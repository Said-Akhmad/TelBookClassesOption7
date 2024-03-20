public class Email extends Contact {

    private String username; //maxim.semenov
    private String mailProvider; //gmail.com

    public String getUsername() {
        return username;
    }

    public OperationResult setUsername(String username) {
        this.username = username;
        return new OperationResult(true, null);
    }

    public String getMailProvider() {
        return mailProvider;
    }

    public OperationResult setMailProvider(String mailProvider) {

        final String validInputFormat = "[a-zA-Z0-9-_]*";

        if (mailProvider.matches(validInputFormat)) {
            this.mailProvider = mailProvider;
        } else {
            return new OperationResult(false, "mailProvider format is incorrect should be "+validInputFormat);
        }

        return new OperationResult(true, null);
    }

    @Override
    public String getContactAsString() {
        return username + "@" + mailProvider;
    }
}
