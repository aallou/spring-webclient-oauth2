package spring.webflux.oauth2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReachFiveUser {
    public String id;
}
