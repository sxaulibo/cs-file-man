package com.sxau.cs.file.provide;

public interface RestController {
    String nameLogin(String json);
    String logout(String json);
    String download(String json);
    String upload(String json);
}
