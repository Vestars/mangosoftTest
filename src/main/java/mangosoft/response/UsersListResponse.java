package mangosoft.response;

import mangosoft.model.User;

import java.util.List;

public class UsersListResponse {

    private int count;

    private List<User> usersList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
