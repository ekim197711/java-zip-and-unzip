package com.example.javazipandunzip.zip;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ZipHelperTest {

    @Test
    public void zip() throws IOException {
        new ZipHelper().zip(new File("filestozip"));
    }
}