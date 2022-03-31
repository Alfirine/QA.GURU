package testdata;

import api.QaFeaturesApi;
import config.Project;
import io.qameta.allure.Step;
import models.User;
import models.qaFeatures.CreateUserResponse;
import org.apache.commons.lang3.RandomStringUtils;

import static java.lang.String.format;

public class UserProvider {

    private static final int randomValueLength = 9;
    private static final int phoneNumberLength = 12;
    private static final int randomPartLength = 9;

    public static User getCompleteUserRegistration() {
        User user = new User();
        user.setFirstName(generateRandomString(randomValueLength));
        user.setLastName(generateRandomString(randomValueLength));
        user.setCompany(generateRandomString(randomValueLength));
        user.setPhone(generateRandomNumber(phoneNumberLength));
        user.setPassword(generateRandomString(randomValueLength));
        user.setEmailName("coursestest" + generateRandomString(randomPartLength));
        user.setEmail(format(Project.config.emailTemplate(), user.getEmailName()));
        user.setProject("webinar");
        user.setConfirmEmail(true);
        user.setLocale(Project.config.language());
        return user;
    }

    public static User getCompleteStudentRegistration() {
        User user = new User();
        user.setFirstName(generateRandomString(randomValueLength));
        user.setLastName(generateRandomString(randomValueLength));
        user.setPassword(generateRandomString(randomValueLength));
        user.setEmailName("coursesteststudent" + generateRandomString(randomPartLength));
        user.setEmail(format(Project.config.emailTemplate(), user.getEmailName()));
        user.setConfirmEmail(true);
        user.setLocale(Project.config.language());
        return user;
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }

    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length).toLowerCase();
    }

    @Step("Регистрация нового админа")
    public static User getNewUser() {
        User newUser = getCompleteUserRegistration();
        CreateUserResponse createUserResponse = QaFeaturesApi.completeUserRegistration(newUser);
        newUser.setId(createUserResponse.getId());
        return newUser;
    }

    @Step("Регистрация нового студента")
    public static User getNewStudent() {
        User newStudent = getCompleteStudentRegistration();
        CreateUserResponse createUserResponse = QaFeaturesApi.completeStudentRegistration(newStudent);
        newStudent.setId(createUserResponse.getId());
        return newStudent;
    }
}
