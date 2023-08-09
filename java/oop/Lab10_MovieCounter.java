package pack10_CSMovie;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab10_MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();
    public Lab10_MovieCounter() {
        String row;
        int rowCount = 1;
        int incompleteCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        String skipped_released;
        Double score;
        Integer votes;
        String director;
        String skipped_writer;
        String star;
        String country;
        Integer budget;
        Integer gross;
        String company;
        Integer runtime;

        try(Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine(); //skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + " is incompleted");
                    continue; //skip this row
                } 
                title = tokens[0];   
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
                gross = (int) (Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = Integer.parseInt(tokens[14]);
                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre, 
                    year, score, votes, 
                    director, star, country, 
                    budget, gross, company, 
                    runtime));
                }   
                uniqueTitle.add(title);
            }
            System.out.print("There are " + incompleteCount + " rows of incompleted data ");
            System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size()+ ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }
    private static String parseDouble(String str) {
        if (str.isEmpty())
            return ".0";
        return str;
    }

    public Double q1() {
        Double average = mList.stream().mapToDouble(CSMovie::getScore).average().orElse(0);
        System.out.println("Average score is " + average);
        return average;
    }
    
    public List<CSMovie> q2() {
        List<CSMovie> result = mList.stream()
                .filter(movie -> movie.getVotes() > 1900000)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }
    
    public CSMovie q3() {
        CSMovie result = mList.stream()
                .max(Comparator.comparing(CSMovie::getGross))
                .orElse(null);
        System.out.println("Movie with the highest gross is: " + result);
        return result;
    }
       
    public List<String> q4() {
        List<String> genres = mList.stream()
                .flatMap(movie -> Arrays.stream(movie.getGenre().split(",")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        genres.forEach(System.out::println);
        return genres;
    }
    
    public List<String> q5() {
        List<String> result = mList.stream()
                .sorted(Comparator.comparing(CSMovie::getRuntime))
                .map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime()))
                .limit(5)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }    

    public CSMovie[] q6() {
        CSMovie[] result = new CSMovie[2];
        Comparator<CSMovie> comparator = Comparator.comparing(CSMovie::getBudget);
        result[0] = mList.stream()
                .max(comparator)
                .orElse(null);
        result[1] = mList.stream()
                .min(comparator)
                .orElse(null);
        System.out.println("Movie with the highest budget is: " + result[0]);
        System.out.println("Movie with the lowest budget is: " + result[1]);
        return result;
    }
    
    public List<CSMovie> q7(String genre) {
        List<CSMovie> result = mList.stream()
                .filter(movie -> movie.getGenre().contains(genre))
                .sorted(Comparator.comparing(CSMovie::getScore).reversed())
                .limit(3)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }
    
    public List<CSMovie> q8() {
        List<CSMovie> actionMovies = mList.stream()
                .filter(m -> m.getGenre().contains("Action"))
                .collect(Collectors.toList());
    
        Comparator<CSMovie> scoreThenTitle = Comparator.comparing(CSMovie::getScore)
                .reversed()
                .thenComparing(CSMovie::getTitle);
    
        List<CSMovie> top3ActionMovies = actionMovies.stream()
                .sorted(scoreThenTitle)
                .limit(3)
                .collect(Collectors.toList());
    
        return top3ActionMovies;
    }
    
    public Map<String,Long> q9() {
        return mList.stream()
                .filter(movie -> movie.getGross() != null)
                .collect(Collectors.groupingBy(CSMovie::getGenre, Collectors.summingLong(CSMovie::getGross)));
    }
    
    public Map<String, Long> q10() {
        Map<String, Long> result = mList.stream()
                .collect(Collectors.groupingBy(CSMovie::getCompany, Collectors.counting()));
    
        result = result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    
        return result;
    }
    
    public CSMovie q11() {
        Function<CSMovie, Integer> countVowel = m -> {
            int cnt = 0;
            for (int i = 0; i < m.getTitle().length(); i++) {
                if (m.getTitle().charAt(i) == 'a') {
                    cnt++;
                }
            }
            return cnt;
        };
    
        Optional<CSMovie> m = mList.stream()
                .max(Comparator.comparing(countVowel));
        return m.get();
    }
    
}
// https://www.baeldung.com/java-split-string-commas