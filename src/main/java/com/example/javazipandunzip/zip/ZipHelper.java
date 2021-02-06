package com.example.javazipandunzip.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipHelper {

    public void zip(File path) throws IOException {
        File[] files = path.listFiles();
        if (files.length == 0)
            throw new IllegalArgumentException("No files in path " + path.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream("result/myzipfile.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (File zipThis : files) {
            FileInputStream fis = new FileInputStream(zipThis);
            ZipEntry zipEntry = new ZipEntry(zipThis.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[2048];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }
}
