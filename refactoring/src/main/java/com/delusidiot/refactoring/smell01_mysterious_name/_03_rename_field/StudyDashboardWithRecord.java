package com.delusidiot.refactoring.smell01_mysterious_name._03_rename_field;

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
public class StudyDashboardWithRecord {

    private Set<StudyReview> studyReviews = new HashSet<>();

    /**
     * 스터디 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어옵니다.
     * @param issue
     * @throws IOException
     */
    private void loadReviews(GHIssue issue) throws IOException {
        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            studyReviews.add(new StudyReview(review.getUser().getName(), review.getBody()));
        }
    }

    public Set<StudyReview> getStudyReviews() {
        return studyReviews;
    }

    public static void main(String[] args) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("delusidiot/learning_java");
        GHIssue issue = repository.getIssue(1);

        StudyDashboardWithRecord studyDashboard = new StudyDashboardWithRecord();
        studyDashboard.loadReviews(issue);
        studyDashboard.getStudyReviews().forEach(System.out::println);

    }
}
