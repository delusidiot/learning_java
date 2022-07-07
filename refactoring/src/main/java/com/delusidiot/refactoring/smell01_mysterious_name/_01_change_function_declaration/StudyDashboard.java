package com.delusidiot.refactoring.smell01_mysterious_name._01_change_function_declaration;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class StudyDashboard {

    private Set<String> username = new HashSet<>();
    private Set<String> reviews = new HashSet<>();

    /**
     * 스터디 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어옵니다.
     * 함수 이름 변경 => Shift + F6
     * 함수 매개변수 및 이름 변경 => Ctrl + F6
     * @param issue
     * @throws IOException
     */
    private void loadReviews(GHIssue issue) throws IOException {
        List<GHIssueComment> comments = issue.getComments();
        for (GHIssueComment comment : comments) {
            username.add(comment.getUser().getName());
            reviews.add(comment.getBody());
        }
    }

    public Set<String> getUsername() {
        return username;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("delusidiot/learning_java");
        GHIssue issue = repository.getIssue(1);

        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews(issue);
        studyDashboard.getUsername().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
