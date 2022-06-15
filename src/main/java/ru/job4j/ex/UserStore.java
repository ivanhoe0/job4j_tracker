package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean isFound = false;
        User result = users[0];
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                isFound = true;
                result = user;
                break;
            }
        }
        if (isFound) {
            return result;
        } else {
            throw new UserNotFoundException("There is no such user in the list of users");
        }

    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 2) {
            return true;
        } else {
            throw new UserInvalidException("User is invalid");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException inv) {
            inv.printStackTrace();
        } catch (UserNotFoundException nfd) {
            nfd.printStackTrace();
        }
    }
}
