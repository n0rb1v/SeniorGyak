package w5d3;

import java.util.List;

public class UserValidator {
    public boolean validate(List<User> userList) {
        if (userList == null) {
            throw new IllegalArgumentException("userlist error");
        }
        for (User item: userList){
            if (item == null || item.getName() == null) {
                throw new IllegalArgumentException("user error");
            }
            if (item.getAge() < 0 || item.getAge()>120){
                throw new IllegalArgumentException("age error");
            }
        }
        return true;
    }
}
