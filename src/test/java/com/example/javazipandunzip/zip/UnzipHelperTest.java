package com.example.javazipandunzip.zip;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UnzipHelperTest {

    @Test
    void unzip() throws IOException {
        new UnzipHelper().unzip(new File("result/myzipfile.zip"));
    }
}