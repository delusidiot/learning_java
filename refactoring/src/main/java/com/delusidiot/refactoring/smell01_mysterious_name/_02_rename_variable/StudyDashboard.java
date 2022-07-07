package com.delusidiot.refactoring.smell01_mysterious_name._02_rename_variable;

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
     * List<GHIssueComment> comments = issue.getComments();
     * 에서 review를 읽어오는 함수인데 review가 없습니다. 사실상 comments가 review였기 때문에 이것을 변경하면 좋을 것 같다는 생각이 듭니다.
     * @param issue
     * @throws IOException
     */
    private void loadReviews(GHIssue issue) throws IOException {
        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            username.add(review.getUser().getName());
            this.reviews.add(review.getBody());
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
        /*
        studyDashboard.getUsername().forEach(n -> System.out.println(n));
        studyDashboard.getReviews().forEach(r -> System.out.println(r));

        Lambda의 경우 내부 데이터가 어떤건지 알고있는 상태이며 스코프가 작기 때문에 n, r과 같이 간추려서 변수명을 정하기도 합니다.
        또는 아래처럼 method reference로 변경하기도 합니다.
         */
        studyDashboard.getUsername().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
