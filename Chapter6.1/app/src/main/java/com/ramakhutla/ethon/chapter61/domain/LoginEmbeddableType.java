package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;

/**
 * Created by Dillin on 4/19/2016.
 */
public class LoginEmbeddableType implements Serializable {

    private String username;
    private String password;

    //constructors
    private LoginEmbeddableType()
    {

    }

    public LoginEmbeddableType(Builder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
    }

    //getters
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public static class Builder
    {
        private String username;
        private String password;

        public Builder username(String username)
        {
            this.username = username;
            return this;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder copy(LoginEmbeddableType loginEmbedabletype)
        {
            this.username = loginEmbedabletype.username;
            this.password = loginEmbedabletype.password;
            return this;
        }

        public LoginEmbeddableType build()
        {
            return new LoginEmbeddableType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEmbeddableType that = (LoginEmbeddableType) o;

        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        return password != null ? password.equals(that.password) : that.password == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
