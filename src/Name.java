public class Name extends PersonalInfo {

    private String firstname;
    private String surname;
    private String paternal;
    private String maternal;
    private String prefix; //Mr, Mrs, Bey, Aga, Professor

    public String getFirstname() {
        return firstname;
    }

    public OperationResult setFirstname(String firstname) throws OperationException{
        if (firstname.matches("[A-Z][a-z]+")){
            this.firstname = firstname;

        }
        throw new OperationException("Not correct name");
    }

    public String getSurname() {
        return surname;
    }

    public OperationResult setSurname(String surname) throws OperationException{
        if (surname.matches("[A-Z][a-z]+")){
            this.surname = surname;
        }
        throw new OperationException("Not correct name");
    }

    public String getPaternal() {
        return paternal;
    }

    public OperationResult setPaternal(String paternal) throws OperationException{
        if (firstname.matches("[A-Z][a-z]+")){
            this.paternal = paternal;

        }
        throw new OperationException("Not correct name");
    }

    public String getMaternal() {
        return maternal;
    }

    public OperationResult setMaternal(String maternal) throws OperationException{
        if (firstname.matches("[A-Z][a-z]+")){
            this.maternal = maternal;
        }
        throw new OperationException("Not correct name");
    }

    public String getPrefix() {
        return prefix;
    }

    public OperationResult setPrefix(String prefix) throws OperationException{
        if (firstname.matches("[A-Z][a-z]+")){
            this.prefix = prefix;

        }
        throw new OperationException("Not correct name");
    }

    @Override
    public String getPersonInfoAsString() {
        return prefix  + " " + firstname + " " + surname + " " + paternal + " (" + maternal  + ")";
    }
}
