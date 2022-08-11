package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl;
        double sum = 0;
        double count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        rsl = sum / count;
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            score /= pupil.subjects().size();
            rsl.add(new Label(pupil.name(), score));
            score = 0;
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> sumOfScoresBySubjects = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (sumOfScoresBySubjects.containsKey(subject.name())) {
                    int score = sumOfScoresBySubjects.get(subject.name()) + subject.score();
                    sumOfScoresBySubjects.put(subject.name(), score);
                    score = 0;
                } else {
                    sumOfScoresBySubjects.put(subject.name(), subject.score());
                }
            }
        }
        for (String key : sumOfScoresBySubjects.keySet()) {
            double sum = sumOfScoresBySubjects.get(key);
            double amountOfPupils = pupils.size();
            double avg = sum / amountOfPupils;
            rsl.add(new Label(key, avg));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            rsl.add(new Label(pupil.name(), score));
            score = 0;
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> sumOfScoresBySubjects = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (sumOfScoresBySubjects.containsKey(subject.name())) {
                    int score = sumOfScoresBySubjects.get(subject.name()) + subject.score();
                    sumOfScoresBySubjects.put(subject.name(), score);
                    score = 0;
                } else {
                    sumOfScoresBySubjects.put(subject.name(), subject.score());
                }
            }
        }
        for (String key : sumOfScoresBySubjects.keySet()) {
            rsl.add(new Label(key, sumOfScoresBySubjects.get(key)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
