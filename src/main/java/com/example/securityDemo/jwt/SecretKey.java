package com.example.securityDemo.jwt;

public class SecretKey {
  private static final String key = "sakdfhvouhcxknaowej123i4ejrzcmvp293up49";

  public static byte[] getKey() {
    return key.getBytes();
  }
}
