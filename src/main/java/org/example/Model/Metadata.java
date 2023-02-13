package org.example.Model;

import com.fasterxml.jackson.databind.JsonNode;

public class Metadata {

    private JsonNode _id;

    private String firstName;
    private String lastName;
    private String signupDate;
    private boolean userVerified;

    private JsonNode metadata;

    public Metadata() {
    }


    @Override
    public String toString() {
        return "Metadata{" +
                "_id=" + _id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", signupDate='" + signupDate + '\'' +
                ", userVerified=" + userVerified +
                ", metadata=" + metadata +
                '}';
    }

    public JsonNode get_id() {
        return _id;
    }

    public void set_id(JsonNode _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(String signupDate) {
        this.signupDate = signupDate;
    }

    public boolean isUserVerified() {
        return userVerified;
    }

    public void setUserVerified(boolean userVerified) {
        this.userVerified = userVerified;
    }

    public JsonNode getMetadata() {
        return metadata;
    }

    public void setMetadata(JsonNode metadata) {
        this.metadata = metadata;
    }
}
