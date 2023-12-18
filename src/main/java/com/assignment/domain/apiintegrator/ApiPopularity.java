package com.assignment.domain.apiintegrator;

import com.assignment.domain.apiintegrator.model.Score;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface ApiPopularity {
    Score getPopularityScore(String name) throws IOException;
}
