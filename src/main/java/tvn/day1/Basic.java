package tvn.day1;

public class Basic {
    public static boolean isVowels(String letter) {
        if (letter.length() == 1) {
            return "ueoai".contains(letter.toLowerCase());
        } else throw new IllegalArgumentException("Please input a single letter only!");
    }

    /*public static boolean checkPasswordPolicy(String password){
        String pattern = "(?=.*[^a-zA-Z0-9])(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=\\S+$).{8,}";
        Pattern re = Pattern.compile(pattern);
        return re.matcher(password).find();
    }*/

    public static boolean checkPasswordPolicy(String password) {
        boolean isLongerThan8 = password.length() >= 8;
        boolean isContainsSpecialChar = false;
        boolean isContainsNumber = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean noWhiteSpace = !password.contains(" ");

        for (int i = 0; i < password.length(); i++) {
            if ("@$!%*?&".indexOf(password.charAt(i)) != -1) {
                isContainsSpecialChar = true;
                break;
            }
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                isContainsNumber = true;
                break;
            }
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                isLowerCase = true;
                break;
            }
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                isUpperCase = true;
                break;
            }
        }

        if (isLongerThan8 && isContainsSpecialChar && isContainsNumber && isLowerCase && isUpperCase && noWhiteSpace) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String password = "P@ssw0rd";

        boolean isValidPassword = checkPasswordPolicy(password);

        if (isValidPassword) {
            System.out.println("Password accepted");
        } else {
            System.out.println("Password not accepted");
        }
    }

    public static boolean isPalindrome(String input) {
        for (int i = 0; i <= input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
