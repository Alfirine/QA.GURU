package testdata.course;

import models.User;

import java.util.Objects;

public class NewCourse {
    private final User user;

    NewCourse(User user) {
        this.user = user;
    }

    public User user() {
        return user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (NewCourse) obj;
        return Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        return "NewCourse[" +
                "user=" + user + ']';
    }
}
