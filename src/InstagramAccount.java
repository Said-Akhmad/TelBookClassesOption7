public class InstagramAccount extends Contact {

    private String account;

    public String getAccount() {
        return account;
    }

    public OperationResult setAccount(String account) {

        final String validInputFormat = "[a-zA-Z0-9-_]*";

        if (account.matches(validInputFormat)) {
            this.account = account;
        } else {
            return new OperationResult(false, "Not a valid format of account, should be "+validInputFormat);
        }

        return new OperationResult(true, null);
    }

    @Override
    public String getContactAsString() {
        return "www.instagram.com/"+account;
    }
}
