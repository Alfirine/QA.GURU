package api.endpoints;

import lombok.Getter;

public enum CourseUrls {
    CREATE_BY_TEMPLATE("/course/createByTemplate/%d"),
    COURSE_REMINDERS("/courses/%s/reminders"),
    COURSE_SETTING("/courses/sync"),
    COURSE_PUBLISH("/courses/%s/publish"),
    COURSE_UNPUBLISH("/courses/%s/unpublish"),
    COURSE("/courses/%s"),
    STUDENTS_JOURNAL("/courses/%s/students/all"),
    LESSONS("/courses/%s/parts/lessons"),
    ONLINE_LESSON("/course/%s/lesson/%s/tabs/webinar"),
    LESSON_OFFLINE("/course/%s/lesson/%s/tabs/lessonOffline"),
    INVITE_MODERATOR("/courses/%s/invite/moderation/email"),
    MODERATORS_JOURNAL("/courses/%s/moderators/all"),
    EMAIL_QUESTIONS("/courses/%s/emailquestions"),
    ADD_PRESENTER("/courses/%s/lecturers"),
    EDIT_PRESENTER("/courses/%s/lecturers/%s"),
    ADD_NEWS("/courses/%s/news/createPost"),
    ADD_COURSE_NEWS("/courses/%s/news/feed"),
    DELETE_COURSE_NEWS("/courses/news/%s/deletePost"),
    ADD_COMMENT_FOR_NEWS("/courses/news/%s/comments/createPostParentComment"),
    DELETE_COMMENT_FOR_NEWS("/courses/news/comments/%s/delete"),
    CREATE_PART("/courses/%s/parts"),
    APPROVEMENTS("/course/%s/students/approvements"),
    TEST_FILES("/course/testFiles"),
    VISIT_COURSE("/courses/%s/logVisit"),
    COURSE_ATTACHMENTS("/courses/%s/attachments"),
    COURSE_INSTANCES("/courses/%s/courseInstances/active");

    @Getter
    private final String url;

    CourseUrls(String url) {
        this.url = url;
    }
}
