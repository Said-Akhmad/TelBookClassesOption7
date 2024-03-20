public class Gender extends PersonalInfo {

    private String type; //w, m

    private final String MALE = "m";
    private final String FEMALE = "f";

    public String getType() {
        return type;
    }

    public OperationResult setType(String type) {

        if (type.equalsIgnoreCase(MALE) || type.equalsIgnoreCase(FEMALE)) {
            this.type = type;
        } else {
            return new OperationResult(false, "Incorrect input, should be either " + MALE + " or " + FEMALE);
        }

        return new OperationResult(true, null);
    }

    @Override
    public String getPersonInfoAsString() {
        return type;
    }
}
