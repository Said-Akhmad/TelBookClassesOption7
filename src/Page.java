public class Page {

    private int pageNumber;
    private Person person;

    public Page(Person person) throws OperationException{
            this.setPerson(person);

    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) throws OperationException{

        if (pageNumber < 0) {
            throw  new OperationException("Page number less than 0");
        }

        this.pageNumber = pageNumber;

    }

    public Person getPerson() {
        return person;
    }

    public  void setPerson(Person person) throws OperationException{

        if (person.getPersonalInfos() == null || person.getPersonalInfos().size() == 0 || person.getContacts() == null||
        person.getContacts().size()==0) {
            throw  new OperationException("personal info or contact cannot be null  ");
        }

        this.person = person;

    }
}
