import java.util.Scanner;

public class TelephoneBookApplication {

    public static void main(String[] args) {

        System.out.println("Hello this is my phonebook");

        Scanner scanner = new Scanner(System.in);

        TelBook telBook = new TelBook();

        try {

            while (true) {

                System.out.println("Menu: ");
                System.out.println("1 - Add page;");
                System.out.println("2 - Show all pages;");
                System.out.println("3 - Update page;");
                System.out.println("4 - Delete page;");
                System.out.println("5 - Search page;");

                System.out.println("Enter option: ");

                int optionSelected = Integer.parseInt(scanner.nextLine());

                if (optionSelected == 1) {
                    Page page = createPage(scanner);

                    try {
                        telBook.add(page);
                    } catch (OperationException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (optionSelected == 2) {

                    printPages(telBook.getPages());

                } else if (optionSelected == 3) {

                    System.out.println("Enter page number to replace: ");
                    int pageIndex = Integer.parseInt(scanner.nextLine());

                    try {
                        telBook.update(createPage(scanner), pageIndex);
                    } catch (OperationException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (optionSelected == 4) {

                    System.out.println("Enter page number to delete: ");
                    int pageIndex = Integer.parseInt(scanner.nextLine());

                    telBook.delete(pageIndex);

                } else if (optionSelected == 5) {

                    System.out.println("Enter search keyWord:");
                    String keyWord = scanner.nextLine();

                    ListOfPages foundPages = telBook.search(keyWord);

                    printPages(foundPages);

                }
            }

        } catch (ClientWantsToExitException e) {
            System.out.println("Thank you for using our software! See you later!");
            System.out.println("Exiting TelBook...");
        }

    }

    private static Page createPage(Scanner scanner) throws ClientWantsToExitException {

        Person person = new Person();

        while (true) {

            System.out.println("Select info to fill: ");

            System.out.println("(tel) Fill mobile phone");
            System.out.println("(name) Fill name");
            System.out.println("(birthday) Fill birthday");
            System.out.println("(twitter) Fill twitter account");
            System.out.println("(done) Exit this menu");

            String infoType = scanner.nextLine();

            if (infoType.equals("tel")) {

                while (true) {
                    MobilePhone mobilePhone = new MobilePhone();
                    try {

                        System.out.println("-Mobile phone-");
                        System.out.println("country code:");
                        mobilePhone.setCountryCode(scanLineOrThrowException(scanner));
                        System.out.println("msisdn:");
                        mobilePhone.setMsisdn(scanLineOrThrowException(scanner));
                        person.addContact(mobilePhone);

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue; //retry while loop from the start
                        } else {
                            break; //breaking while loop without calling person.addPersonalInfo(birthday)
                        }
                    }


                    person.addContact(mobilePhone);
                    break;
                }

            } else if (infoType.equals("name")) {
                while (true) {
                    Name name = new Name();
                    try {

                        System.out.println("-Name-");
                        System.out.println("firstname:");
                        name.setFirstname(scanLineOrThrowException(scanner));
                        System.out.println("surname:");
                        name.setSurname(scanLineOrThrowException(scanner));
                        System.out.println("paternalname:");
                        name.setPaternal(scanLineOrThrowException(scanner));
                        System.out.println("maternalname:");
                        name.setMaternal(scanLineOrThrowException(scanner));
                        System.out.println("prefix:");
                        name.setPrefix(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue; //retry while loop from the start
                        } else {
                            break; //breaking while loop without calling person.addPersonalInfo(birthday)
                        }
                    }


                    person.addPersonalInfo(name);
                    break;
                }





            } else if (infoType.equals("birthday")) {


                while (true) {

                    Birthday birthday = new Birthday();

                    try {

                        System.out.println("-Birthday-");
                        System.out.println("day:");
                        birthday.setDay(Integer.parseInt(scanLineOrThrowException(scanner)));
                        System.out.println("month:");
                        birthday.setMonth(Integer.parseInt(scanLineOrThrowException(scanner)));
                        System.out.println("year:");
                        birthday.setYear(Integer.parseInt(scanLineOrThrowException(scanner)));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue; //retry while loop from the start
                        } else {
                            break; //breaking while loop without calling person.addPersonalInfo(birthday)
                        }
                    }

                    person.addPersonalInfo(birthday);
                    break;
                }


            } else if (infoType.equals("twitter")) {

                TwitterAccount twitter = new TwitterAccount();

                System.out.println("-Twitter-");
                System.out.println("username:");
                twitter.setUsername(scanLineOrThrowException(scanner));

                person.addContact(twitter);

            } else if (infoType.equals("email")) {

                Email email = new Email();

                System.out.println("-Email-");
                System.out.println("username:");
                email.setUsername(scanLineOrThrowException(scanner));
                System.out.println("mailProvider:");
                email.setMailProvider(scanLineOrThrowException(scanner));

                person.addContact(email);

            } else if (infoType.equals("education")) {

                Education education = new Education();

                System.out.println("-Education-");
                System.out.println("city:");
                education.setCity(scanLineOrThrowException(scanner));
                System.out.println("country:");
                education.setCountry(scanLineOrThrowException(scanner));
                System.out.println("institution:");
                education.setInstitution(scanLineOrThrowException(scanner));
                System.out.println("level:");
                education.setLevel(scanLineOrThrowException(scanner));

                person.addPersonalInfo(education);

            } else if (infoType.equals("facebook")) {

                FacebookAccount facebookAccount = new FacebookAccount();

                System.out.println("-Facebook Account-");
                System.out.println("username:");
                facebookAccount.setUsername(scanLineOrThrowException(scanner));

                person.addContact(facebookAccount);

            } else if (infoType.equals("gender")) {

                Gender gender = new Gender();

                System.out.println("-Gender-");
                System.out.println("(m)ale/(f)emale:");
                gender.setType(scanLineOrThrowException(scanner));

                person.addPersonalInfo(gender);

            } else if (infoType.equals("instagram_account")) {

                InstagramAccount instagramAccount = new InstagramAccount();

                System.out.println("-Instagram Account-");
                System.out.println("account:");
                instagramAccount.setAccount(scanLineOrThrowException(scanner));

                person.addContact(instagramAccount);

            } else if (infoType.equals("profession")) {

                Profession profession = new Profession();

                System.out.println("-Profession-");
                System.out.println("profession group:");
                profession.setProfessionGroup(scanLineOrThrowException(scanner));
                System.out.println("profession name:");
                profession.setProfessionName(scanLineOrThrowException(scanner));

                person.addPersonalInfo(profession);

            } else if (infoType.equals("done")) {
                break;
            }
        }


        Page page = null;
        try {
            page = new Page(person);
        } catch (OperationException e) {
            System.out.println(e.getMessage());
        }

        return page;


    }

    private static String scanLineOrThrowException(Scanner scanner) throws ClientWantsToExitException {

        String val = scanner.nextLine();

        if (val.equals(":exit")) {
            throw new ClientWantsToExitException();
        }

        return val;
    }

    private static void printPages(ListOfPages pages) {

        int i = 0;

        while (i < pages.size()) {

            Page page = pages.get(i);
            Person person = page.getPerson();

            ListOfPersonalInfos personalInfos = person.getPersonalInfos();
            ListOfContacts contacts = person.getContacts();

            System.out.println("Page# " + page.getPageNumber());

            for (int j = 0; j < personalInfos.size(); j++) {
                System.out.println(personalInfos.get(j).getPersonInfoAsString());
            }

            for (int j = 0; j < contacts.size(); j++) {
                System.out.println(contacts.get(j).getContactAsString());
            }

            System.out.println();

            i++;
        }
    }


}
