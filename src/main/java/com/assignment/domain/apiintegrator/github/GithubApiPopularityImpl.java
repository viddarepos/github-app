package com.assignment.domain.apiintegrator.github;

import com.assignment.domain.apiintegrator.ApiPopularity;
import com.assignment.domain.apiintegrator.model.Score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GithubApiPopularityImpl implements ApiPopularity {
    static String API_URL = "https://api.github.com/search/issues?q=";
    @Override
    public Score getPopularityScore(String word) throws IOException {
        Integer countRocks = this.getCountFromResponse(new URL(API_URL+word+"+rocks")).get();
        Integer countSucks = this.getCountFromResponse(new URL(API_URL+word+"+sucks")).get();

        Integer totalResults = countSucks + countRocks;

        //skaliramo kolicnik na 0-10
        Double score = 10* countRocks.doubleValue()/totalResults.doubleValue();
        return new Score(
                word,
                score,
                countSucks.longValue(),
                countRocks.longValue()
        );
    }
    protected Optional<Integer> getCountFromResponse(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();
            JsonParser jp = new JsonParser();
            JsonObject jsonResponse = jp.parse(responseContent.toString()).getAsJsonObject();

            // Extract the "total_count" field
            return Optional.of(jsonResponse.get("total_count").getAsInt());
        } else {
            return Optional.empty();
        }
    }
}
