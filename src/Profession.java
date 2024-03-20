public class Profession extends PersonalInfo {

    private String professionGroup; //medical
    private String professionName; //dentist

    public String getProfessionGroup() {
        return professionGroup;
    }

    public OperationResult setProfessionGroup(String professionGroup) {

        final String validFormat = "[a-zA-Z- ]*";

        if (professionGroup.matches(validFormat)) {
            this.professionGroup = professionGroup;
        } else {
            return new OperationResult(false, "Not a valid profession group format, should be " + validFormat);
        }

        return new OperationResult(true, null);
    }

    public String getProfessionName() {
        return professionName;
    }

    public OperationResult setProfessionName(String professionName) {

        final String validFormat = "[a-zA-Z0-9- ]*";

        if (professionName.matches(validFormat)) {
            this.professionName = professionName;
        } else {
            return new OperationResult(false, "Incorrect format of input data, should be " + validFormat);
        }

        return new OperationResult(true, null);
    }

    @Override
    public String getPersonInfoAsString() {
        return professionName + "(" + professionGroup + ")";
    }
}
