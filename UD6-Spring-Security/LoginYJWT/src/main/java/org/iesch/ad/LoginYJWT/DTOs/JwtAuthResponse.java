package org.iesch.ad.LoginYJWT.DTOs;

public class JwtAuthResponse {
    private String accesToken;
    private String tokenType;

    public JwtAuthResponse(String accesToken, String tokenType) {
        this.accesToken = accesToken;
        this.tokenType = tokenType;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
